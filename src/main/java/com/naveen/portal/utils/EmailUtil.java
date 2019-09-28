package com.naveen.portal.utils;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.naveen.portal.models.EmailTemplate;
import com.naveen.portal.models.Profile;
import com.naveen.portal.models.User;
import com.naveen.portal.services.EmailTemplateService;

public class EmailUtil{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	EmailTemplateService emailTemplateService;
	
	
	public void sendActivationEmail(Profile profile, User user) throws MessagingException, IOException {
		System.out.println("In Email UTIL");
		EmailTemplate template = emailTemplateService.findByNotificationtype("ACTIVATION_EMAIL");
		if (template == null){
			return;
		}
		String subject = template.getSubject().replaceAll("#NAME#", profile.getFirstname());
		String body = template.getBody().replaceAll("#NAME#", profile.getFirstname());
		body = body.replaceAll("#ID#", user.getActivationid());
		
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        helper.setTo(profile.getEmail());
        helper.setSubject(subject);
        helper.setText(body, true);
        
        System.out.println(subject +"\n"+body+"\n"+user.getActivationid()+"\n"+profile.getEmail());
        
        javaMailSender.send(msg);

    }
}
