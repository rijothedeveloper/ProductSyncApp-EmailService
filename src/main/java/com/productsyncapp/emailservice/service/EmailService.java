package com.productsyncapp.emailservice.service;

import com.productsyncapp.emailservice.dto.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
