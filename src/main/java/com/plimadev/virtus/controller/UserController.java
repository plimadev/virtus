package com.plimadev.virtus.controller;

import com.plimadev.virtus.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;


}
