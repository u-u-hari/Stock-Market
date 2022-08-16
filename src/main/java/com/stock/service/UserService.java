package com.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.models.User;
import com.stock.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository urepo;
	
	public void AddUser(User user) {
		urepo.save(user);
	}
	
	public User findUser(String userid) {
		return urepo.getById(userid);
	}
	
	public User validate(String userid,String pwd) {
		Optional<User> user=urepo.findById(userid);
		if(user.isPresent()) {
			if(user.get().getPwd().equals(pwd)) {
				return user.get();
			}else
				return null;
		}
		else
			return null;
	}
}
