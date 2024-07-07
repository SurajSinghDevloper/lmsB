package com.management.lmsB.mailServices;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.management.lmsB.modules.constants.Results;
import com.management.lmsB.utils.PasswordGenerator;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class RegistrationMails {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private PasswordGenerator pass;

	public String sendCompleteRegistrationEmail(String email,String userPassword) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			helper.setSubject("Complete Your Registration");

			String registrationLink = "http://localhost:5173/authentication"; 

			String htmlContent = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
					+ "    <title>Complete Your Registration</title>\r\n" + "    <style>\r\n"
					+ "        body { font-family: Arial, sans-serif; }\r\n"
					+ "        .container { margin: 0 auto; padding: 20px; max-width: 600px; }\r\n"
					+ "        h2 { color: #333; }\r\n" + "        p { font-size: 16px; color: #666; }\r\n"
					+ "        .password { font-size: 24px; font-weight: bold; color: #000; }\r\n"
					+ "        .button { display: inline-block; padding: 10px 20px; font-size: 16px; color: #fff; background-color: #007bff; text-decoration: none; border-radius: 5px; }\r\n"
					+ "        .button:hover { background-color: #0056b3; }\r\n" + "    </style>\r\n" + "</head>\r\n"
					+ "<body>\r\n" + "    <div class=\"container\">\r\n" + "        <p>Hello,</p>\r\n"
					+ "        <p>Thank you for registering with our service. To complete your registration process, please use the following password to log in:</p>\r\n"
					+ "        <p class=\"password\">" + userPassword + "</p>\r\n"
					+ "        <p>This password is only valid for a short period of time, so please log in and complete your registration promptly.</p>\r\n"
					+ "        <p>If you did not request this registration, please ignore this email.</p>\r\n"
					+ "        <a href=\"" + registrationLink + "\" class=\"button\">Complete Registration</a>\r\n"
					+ "        <p>Thank you for using our service.</p>\r\n" + "        <p>Best regards,</p>\r\n"
					+ "        <p>Your Company Name</p>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>";

			helper.setText(htmlContent, true);

			javaMailSender.send(message);

			return Results.SUCCESS.toString();

		} catch (MessagingException e) {
			e.printStackTrace();
			return Results.FAILED.toString();
		}
	}
}
