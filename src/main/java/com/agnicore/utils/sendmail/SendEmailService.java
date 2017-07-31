package com.agnicore.utils.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Erlan Ibraev on 29.07.2017.
 */
@Component
public class SendEmailService implements ISendEmailService {

    private JavaMailSender mailSender;

    @Override
    public void send(String to, String fileName) throws MessagingException {
        if(to != null && !to.isEmpty() && fileName != null && !fileName.isEmpty() ) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("Backup " + fileName);
            helper.setText("Backup " + fileName);

            FileSystemResource file = new FileSystemResource(new File(fileName));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
        }

    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
