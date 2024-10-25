package com.technova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @RequestMapping(value="/users")
//    @ResponseBody
    public String usersList() {
        return "users";
    }

}
