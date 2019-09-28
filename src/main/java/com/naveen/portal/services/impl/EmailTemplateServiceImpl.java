package com.naveen.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.portal.models.EmailTemplate;
import com.naveen.portal.repository.EmailTemplateRepository;
import com.naveen.portal.services.EmailTemplateService;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService{

	@Autowired
	EmailTemplateRepository emailTemplateRepository;
	
	@Override
	public EmailTemplate save(EmailTemplate template) {
		return emailTemplateRepository.save(template);
	}

	@Override
	public EmailTemplate findByNotificationtype(String notificationtype) {
		return emailTemplateRepository.findByNotificationtype(notificationtype);
	}

}
