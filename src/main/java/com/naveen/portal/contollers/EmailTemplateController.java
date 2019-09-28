package com.naveen.portal.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.portal.models.EmailTemplate;
import com.naveen.portal.models.Register;
import com.naveen.portal.models.Response;
import com.naveen.portal.services.EmailTemplateService;

@RestController
public class EmailTemplateController {
	
	@Autowired
	EmailTemplateService emailTemplateServce;
	
	@RequestMapping(value = "/emailtemplate", method = RequestMethod.POST)
	public ResponseEntity<?> createTemplate(@RequestBody EmailTemplate tempalte){
		return ResponseEntity.ok(emailTemplateServce.save(tempalte));
	}
}
