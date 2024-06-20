package com.healthtech.demo.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    public void enviarConsultaPorMail(String para, String asunto, String contenido) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(para);
        mail.setSubject(asunto);
        mail.setText(contenido);
        mail.setFrom("vitalmindapp@protonmail.com");

        mailSender.send(mail);
    }
}
