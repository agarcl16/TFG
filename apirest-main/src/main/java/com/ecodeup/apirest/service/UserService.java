package com.ecodeup.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodeup.apirest.entity.User;
import com.ecodeup.apirest.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User get(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	public Integer findByName(User usua){
		User usuario = userRepository.findByName(usua.getName());
		if(usuario!=null && usuario.getPassword().equals(usua.getPassword())){
			return usuario.getId();
		}
		return null;

	}

}
