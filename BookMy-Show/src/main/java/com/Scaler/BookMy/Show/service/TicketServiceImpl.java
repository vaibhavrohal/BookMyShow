package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.exceptions.ShowNotFoundException;
import com.Scaler.BookMy.Show.exceptions.ShowSeatNotFoundException;
import com.Scaler.BookMy.Show.exceptions.TicketNotFoundException;
import com.Scaler.BookMy.Show.exceptions.UserNotFoundException;
import com.Scaler.BookMy.Show.model.*;
import com.Scaler.BookMy.Show.repository.ShowRepository;
import com.Scaler.BookMy.Show.repository.ShowSeatRepository;
import com.Scaler.BookMy.Show.repository.TicketRepository;
import com.Scaler.BookMy.Show.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> ShowSeatIds, Long showId) {
              Optional<User> optionalUser=userRepository.findById(userId);
              if (optionalUser.isEmpty()){
                  throw new UserNotFoundException("user not found with id "+userId);
              }
              User user=optionalUser.get();
              ShowSeatService showSeatService=new ShowSeatServiceImpl();
              List<ShowSeat> showSeatList=showSeatService.getshowSeats(ShowSeatIds);

              for (ShowSeat showSeat:showSeatList){
                  if (showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                      showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                  }
                  else {
                      throw new ShowSeatNotFoundException("seat not available with seat No "+showSeat.getSeat().getSeatNumber());
                  }
                  showSeatRepository.save(showSeat);
              }
              boolean paymentcheck=checkPayment();
              double amount=0;

              while (paymentcheck){
                  for (ShowSeat showSeat:showSeatList){
                      showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                      amount+=showSeat.getPrice();
                      showSeatRepository.save(showSeat);
                  }
                  paymentcheck=false;
              }
              Optional<Show> optionalShow =showRepository.findById(showId);
              if (optionalShow.isEmpty()){
                  throw new ShowNotFoundException("show not found with id "+showId);
              }
              Show show=optionalShow.get();
        return generateTicket(user,showSeatList,show,amount);

    }

    @Override
    public Ticket cancelTicket(Long ticketId) {
        Optional<Ticket> ticketOptional=ticketRepository.findById(ticketId);
        if (ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket not available with ticket -id "+ticketId);
        }
        Ticket ticket=ticketOptional.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for (ShowSeat showSeat:ticket.getShowSeats()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
        ticketRepository.save(ticket);

        for (Payment p:ticket.getPayments()){
            p.setPaymentStatus(PaymentStatus.REFUND);
            //send message for refund to 3rd party.
        }
        return ticket;
    }

    @Override
    public Ticket transferTicket(Long fromUserId, Long toUserId, Long ticketId) {
        Optional<Ticket> ticketOptional=ticketRepository.findById(ticketId);
        if (ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket not available with ticket -id "+ticketId);
        }
        Ticket ticket=ticketOptional.get();
        Optional<User> optionalFromUser=userRepository.findById(fromUserId);
        if (optionalFromUser.isEmpty()){
            throw new UserNotFoundException("user is not available with user id "+fromUserId);
        }
        User fromuser=optionalFromUser.get();

        Optional<User> optionalToUser=userRepository.findById(toUserId);
        if (optionalToUser.isEmpty()){
            throw new UserNotFoundException("user not present with user id "+toUserId);
        }
        User toUser=optionalToUser.get();

        List<Ticket> user1TicketList=fromuser.getTicketsList();
        user1TicketList.remove(ticket);
        //toUser.setTicketsList(user1TicketList); ticket list address is copied in userTicketList.so removal from it means ,removal from original.
        userRepository.save(toUser);

        ticket.setUser(toUser);
        Ticket updatedTicket=ticketRepository.save(ticket);

        List<Ticket> toUserTicketlist=toUser.getTicketsList();
        toUserTicketlist.add(updatedTicket);
       // toUser.setTicketsList(toUserTicketlist);
        userRepository.save(toUser);


        return updatedTicket;
    }
    boolean checkPayment(){
        return true;
    }
    Ticket generateTicket(User user,List<ShowSeat> showSeatList,Show show,double amount){
        Ticket ticket=new Ticket();

        ticket.setUser(user);
        ticket.setShowSeats(showSeatList);
        ticket.setShow(show);
        ticket.setBookingStatus(BookingStatus.BOOKED);
        ticket.setAmount(amount);
        ticket.setBookedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);

    }
}
