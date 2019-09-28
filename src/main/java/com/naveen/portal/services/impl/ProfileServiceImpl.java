package com.naveen.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.portal.models.Profile;
import com.naveen.portal.repository.ProfileRepository;
import com.naveen.portal.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Override
	public Profile findByUsername(String username) {
		return profileRepository.findByUsername(username);
	}

	@Override
	public Profile save(Profile profile) {
		return profileRepository.save(profile);
	}

}
