package com.Scaler.BookMy.Show.service;

import com.Scaler.BookMy.Show.model.Payment;
import com.Scaler.BookMy.Show.model.Show;
import com.Scaler.BookMy.Show.model.Ticket;
import com.Scaler.BookMy.Show.model.User;

import java.util.Optional;

public interface UserService {
    User login(String email,String password);

    User signUp(String email,String password,String name);
}
