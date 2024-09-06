package com.example.Reports.Services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendFileCreatedNotification(String username, String message) {

        System.out.println("Send message for " + username + ": " + message + " ");

        //TODO
    }

    public void sendFileCreationFailedNotification(String username, String message) {

        System.out.println("Send message for " + username + ": " + message + " ");

        //TODO
    }

}
