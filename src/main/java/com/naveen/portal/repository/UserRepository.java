package com.naveen.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naveen.portal.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}
