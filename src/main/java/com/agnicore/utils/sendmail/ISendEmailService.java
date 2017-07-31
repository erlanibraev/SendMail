package com.agnicore.utils.sendmail;

import javax.mail.MessagingException;

/**
 * Created by Erlan Ibraev on 29.07.2017.
 */
public interface ISendEmailService {

    public void send(String to, String fileName) throws MessagingException;
}
