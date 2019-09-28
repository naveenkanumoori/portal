package com.naveen.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.portal.models.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	Profile findByUsername(String username);
}
