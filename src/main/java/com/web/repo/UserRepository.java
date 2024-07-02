
package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsernameAndPassword(String username, String password);
}
