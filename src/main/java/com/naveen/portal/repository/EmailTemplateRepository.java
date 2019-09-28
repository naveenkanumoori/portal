package com.naveen.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.portal.models.EmailTemplate;

@Repository
public interface EmailTemplateRepository extends CrudRepository<EmailTemplate, Integer>  {
	EmailTemplate findByNotificationtype(String notificationtype);
}
