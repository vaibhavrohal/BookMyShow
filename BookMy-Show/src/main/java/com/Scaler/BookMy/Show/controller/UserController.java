package com.Scaler.BookMy.Show.controller;

import com.Scaler.BookMy.Show.controller.utils.UserControllerUtils;
import com.Scaler.BookMy.Show.dto.UserRequestdto;
import com.Scaler.BookMy.Show.dto.UserResponsedto;
import com.Scaler.BookMy.Show.mapper.UsertoUserResponseMapper;
import com.Scaler.BookMy.Show.model.User;
import com.Scaler.BookMy.Show.service.UserService;
import com.Scaler.BookMy.Show.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    UsertoUserResponseMapper usertoUserResponseMapper;

    UserResponsedto login(UserRequestdto userRequestdto){
        User user=userService.login(userRequestdto.getEmail(),userRequestdto.getPassword());

        return usertoUserResponseMapper.convertUserToUserResponsedto(user);
    }
   UserResponsedto signUp(UserRequestdto userRequestdto){
        User user;
        UserResponsedto userResponsedto=new UserResponsedto();
        try {
            UserControllerUtils.validate(userRequestdto);

            user = userService.signUp(userRequestdto.getEmail(), userRequestdto.getPassword(), userRequestdto.getName());
            return usertoUserResponseMapper.convertUserToUserResponsedto(user);
        }
        catch (Exception e){
             userResponsedto.setResponsemessage("Internal server error");
             return userResponsedto;
        }
    }


}
