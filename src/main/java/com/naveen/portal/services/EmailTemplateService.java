package com.naveen.portal.services;

import com.naveen.portal.models.EmailTemplate;

public interface EmailTemplateService {
	EmailTemplate save(EmailTemplate template);
	EmailTemplate findByNotificationtype(String notificationtype);
}
