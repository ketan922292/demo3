package com.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.AppUser;
import com.web.repo.UserRepository;

@Controller
public class JspController {

	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username, @RequestParam String password) {
		AppUser user = repo.findByUsernameAndPassword(username, password);
		if (user != null) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	
	@PostConstruct
	public void addUser() {
		AppUser appuser = new AppUser();
		appuser.setUsername("admin");
		appuser.setPassword("admin");
		repo.save(appuser);

		appuser = new AppUser();
		appuser.setUsername("user");
		appuser.setPassword("user");
		repo.save(appuser);

		appuser = new AppUser();
		appuser.setUsername("guest");
		appuser.setPassword("guest");
		repo.save(appuser);
		
		appuser = new AppUser();
		appuser.setUsername("ketan");
		appuser.setPassword("ketan");
		repo.save(appuser);
		
		System.out.println("Users added successfully .");

	}		


	
}
