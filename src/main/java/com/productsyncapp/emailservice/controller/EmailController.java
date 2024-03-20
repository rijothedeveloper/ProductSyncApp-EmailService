package com.productsyncapp.emailservice.controller;

import com.productsyncapp.emailservice.dto.RegisterationEmailRequest;
import com.productsyncapp.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody RegisterationEmailRequest registerationEmailRequest)
    {
        return emailService.sendVerificationEMail(registerationEmailRequest);

    }
}
