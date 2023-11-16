package com.Scaler.BookMy.Show.mapper;

import com.Scaler.BookMy.Show.dto.UserResponsedto;
import com.Scaler.BookMy.Show.model.User;
import org.springframework.stereotype.Component;

@Component
public class UsertoUserResponseMapper {
    public UserResponsedto convertUserToUserResponsedto(User user){
        UserResponsedto userResponsedto=new UserResponsedto();
        userResponsedto.setID(user.getId());
        userResponsedto.setName(user.getName());
        userResponsedto.setEmail(user.getEmail());
        userResponsedto.setResponsemessage("Success");
        userResponsedto.setTicketList(user.getTicketsList());

        return userResponsedto;
    }
}
