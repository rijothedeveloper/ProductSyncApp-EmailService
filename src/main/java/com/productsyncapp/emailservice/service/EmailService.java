package com.productsyncapp.emailservice.service;

import com.productsyncapp.emailservice.dto.EmailDetails;
import com.productsyncapp.emailservice.dto.RegisterationEmailDetails;

public interface EmailService {
    String sendVerificationEMail(RegisterationEmailDetails registerationEmailDetails);
}
