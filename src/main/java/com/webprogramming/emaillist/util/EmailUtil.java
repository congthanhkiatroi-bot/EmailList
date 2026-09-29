package com.webprogramming.emaillist.util;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailUtil {

    private static final String FROM_EMAIL =
            System.getenv("GMAIL_USERNAME");

    private static final String APP_PASSWORD =
            System.getenv("GMAIL_APP_PASSWORD");

    public static boolean sendConfirmationEmail(
            String toEmail,
            String firstName,
            String lastName) {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                FROM_EMAIL,
                                APP_PASSWORD
                        );
                    }
                }
        );

        try {

            Message message = new MimeMessage(session);

            message.setFrom(
                    new InternetAddress(FROM_EMAIL)
            );

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );

            message.setSubject(
                    "Welcome to our Email List!"
            );

            String emailContent =
                    "<!DOCTYPE html>" +
                            "<html>" +

                            "<body style=\"" +
                            "margin:0;" +
                            "padding:0;" +
                            "background-color:#f1f5f9;" +
                            "font-family:Arial,Helvetica,sans-serif;" +
                            "color:#0f172a;" +
                            "\">" +


                            "<div style=\"" +
                            "padding:40px 15px;" +
                            "\">" +


                            "<div style=\"" +
                            "max-width:600px;" +
                            "margin:0 auto;" +
                            "background-color:#ffffff;" +
                            "border:1px solid #e2e8f0;" +
                            "border-radius:16px;" +
                            "overflow:hidden;" +
                            "\">" +


                            // =========================
                            // HEADER
                            // =========================

                            "<div style=\"" +
                            "padding:36px 35px;" +
                            "background-color:#172554;" +
                            "color:#ffffff;" +
                            "\">" +

                            "<div style=\"" +
                            "font-size:28px;" +
                            "margin-bottom:16px;" +
                            "\">" +
                            "&#9993;" +
                            "</div>" +

                            "<h1 style=\"" +
                            "margin:0 0 10px;" +
                            "font-size:27px;" +
                            "line-height:1.3;" +
                            "\">" +
                            "Welcome to our Email List!" +
                            "</h1>" +

                            "<p style=\"" +
                            "margin:0;" +
                            "font-size:15px;" +
                            "line-height:1.6;" +
                            "color:#cbd5e1;" +
                            "\">" +
                            "Your registration has been completed successfully." +
                            "</p>" +

                            "</div>" +


                            // =========================
                            // BODY
                            // =========================

                            "<div style=\"" +
                            "padding:35px;" +
                            "\">" +


                            "<h2 style=\"" +
                            "margin:0 0 15px;" +
                            "font-size:22px;" +
                            "color:#0f172a;" +
                            "\">" +

                            "Hello " + firstName + " " + lastName + "!" +

                            "</h2>" +


                            "<p style=\"" +
                            "margin:0 0 20px;" +
                            "font-size:15px;" +
                            "line-height:1.7;" +
                            "color:#475569;" +
                            "\">" +

                            "Thank you for joining our email list. " +
                            "We're happy to have you with us. " +
                            "Your information has been registered successfully." +

                            "</p>" +


                            // =========================
                            // SUCCESS MESSAGE
                            // =========================

                            "<div style=\"" +
                            "margin:25px 0;" +
                            "padding:17px 20px;" +
                            "background-color:#ecfdf5;" +
                            "border:1px solid #bbf7d0;" +
                            "border-radius:10px;" +
                            "color:#166534;" +
                            "\">" +

                            "<strong>" +
                            "&#10003; Registration confirmed" +
                            "</strong>" +

                            "<br>" +

                            "<span style=\"" +
                            "font-size:14px;" +
                            "line-height:1.6;" +
                            "\">" +

                            "Your email subscription is now active." +

                            "</span>" +

                            "</div>" +


                            // =========================
                            // INFORMATION
                            // =========================

                            "<div style=\"" +
                            "margin:25px 0;" +
                            "padding:22px;" +
                            "background-color:#f8fafc;" +
                            "border:1px solid #e2e8f0;" +
                            "border-radius:12px;" +
                            "\">" +


                            "<h3 style=\"" +
                            "margin:0 0 18px;" +
                            "font-size:16px;" +
                            "color:#0f172a;" +
                            "\">" +

                            "Registration details" +

                            "</h3>" +


                            "<p style=\"" +
                            "margin:9px 0;" +
                            "font-size:14px;" +
                            "color:#64748b;" +
                            "\">" +

                            "<strong style=\"color:#334155;\">" +
                            "Email:" +
                            "</strong> " +

                            toEmail +

                            "</p>" +


                            "<p style=\"" +
                            "margin:9px 0;" +
                            "font-size:14px;" +
                            "color:#64748b;" +
                            "\">" +

                            "<strong style=\"color:#334155;\">" +
                            "First Name:" +
                            "</strong> " +

                            firstName +

                            "</p>" +


                            "<p style=\"" +
                            "margin:9px 0;" +
                            "font-size:14px;" +
                            "color:#64748b;" +
                            "\">" +

                            "<strong style=\"color:#334155;\">" +
                            "Last Name:" +
                            "</strong> " +

                            lastName +

                            "</p>" +

                            "</div>" +


                            "<p style=\"" +
                            "margin:25px 0 5px;" +
                            "font-size:15px;" +
                            "line-height:1.7;" +
                            "color:#475569;" +
                            "\">" +

                            "We'll keep you connected with our latest updates." +

                            "</p>" +


                            "<p style=\"" +
                            "margin:22px 0 0;" +
                            "font-size:15px;" +
                            "line-height:1.7;" +
                            "color:#475569;" +
                            "\">" +

                            "Best regards,<br>" +

                            "<strong style=\"color:#0f172a;\">" +
                            "Email List Team" +
                            "</strong>" +

                            "</p>" +


                            "</div>" +


                            // =========================
                            // FOOTER
                            // =========================

                            "<div style=\"" +
                            "padding:20px 35px;" +
                            "background-color:#f8fafc;" +
                            "border-top:1px solid #e2e8f0;" +
                            "text-align:center;" +
                            "font-size:12px;" +
                            "line-height:1.6;" +
                            "color:#94a3b8;" +
                            "\">" +

                            "This is an automated confirmation email.<br>" +
                            "Thank you for joining our email list." +

                            "</div>" +


                            "</div>" +
                            "</div>" +

                            "</body>" +
                            "</html>";


            message.setContent(
                    emailContent,
                    "text/html; charset=UTF-8"
            );

            Transport.send(message);

            return true;

        } catch (MessagingException e) {

            e.printStackTrace();
            return false;
        }
    }
}