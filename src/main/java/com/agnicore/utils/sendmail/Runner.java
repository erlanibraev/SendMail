package com.agnicore.utils.sendmail;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Erlan Ibraev on 29.07.2017.
 */
@Component
@Log
public class Runner implements CommandLineRunner {

    private ISendEmailService sendEmailService;
    private String[] toList;

    @Override
    public void run(String... args) throws Exception {
        log.info("Send message");
        System.out.println("Send mail");
        if (args.length > 0) {
            String fileName = args[0];
            for (String to: toList) {
                sendEmailService.send(to, fileName);
            }
            log.info("Send sucessfull");
        } else {
            System.out.println("Usage: java -jar SendMail.jar <attach File Name> <address>");
        }
    }

    @Autowired
    public void setSendEmailService(ISendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @Value("${mail.toList}")
    public void setToList(String[] toList) {
        this.toList = toList;
    }
}
