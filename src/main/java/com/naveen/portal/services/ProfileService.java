package com.naveen.portal.services;

import com.naveen.portal.models.Profile;

public interface ProfileService {
	public Profile save(Profile profile);
	public Profile findByUsername(String username);
}
