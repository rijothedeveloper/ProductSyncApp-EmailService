package com.productsyncapp.emailservice.service.impl;

import com.productsyncapp.emailservice.dto.EmailDetails;
import com.productsyncapp.emailservice.dto.RegisterationEmailRequest;
import com.productsyncapp.emailservice.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;
    private boolean sendEMail(EmailDetails details) {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setRecipients(MimeMessage.RecipientType.TO, details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setContent(details.getMsgBody(), "text/html; charset=utf-8");
            // Sending the mail
            mailSender.send(mailMessage);
            return true;
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public String sendVerificationEMail(RegisterationEmailRequest registerationEmailRequest) {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(registerationEmailRequest.recipient());
        emailDetails.setSubject("Verify your email for Product Sync App");
        emailDetails.setMsgBody("<Html>Please click this <a href='http://localhost:8080/api/v1/auth/verify_user_email?token="+ registerationEmailRequest.token()+"'>link to verify<a/> your account");
        boolean success = sendEMail(emailDetails);
        if(success){
            return "registeration mail send successfully";
        }else {
            return "error in sending registeration email";
        }
    }
}
