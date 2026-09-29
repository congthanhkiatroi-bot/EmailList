package com.webprogramming.emaillist.util;

public class TestEmail {

    public static void main(String[] args) {

        boolean result =
                EmailUtil.sendConfirmationEmail(
                        "fortthanhtiktok@gmail.com",
                        "Thanh",
                        "Nguyen"
                );

        if (result) {
            System.out.println("Email sent successfully!");
        } else {
            System.out.println("Failed to send email.");
        }
    }
}