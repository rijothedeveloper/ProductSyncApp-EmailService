package com.productsyncapp.emailservice.service;

import com.productsyncapp.emailservice.dto.RegisterationEmailRequest;

public interface EmailService {
    String sendVerificationEMail(RegisterationEmailRequest registerationEmailRequest);
}
