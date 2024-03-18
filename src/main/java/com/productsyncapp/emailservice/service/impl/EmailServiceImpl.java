package com.productsyncapp.emailservice.service.impl;

import com.productsyncapp.emailservice.dto.EmailDetails;
import com.productsyncapp.emailservice.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setRecipients(MimeMessage.RecipientType.TO, details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setContent(details.getMsgBody(), "text/html; charset=utf-8");
            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
