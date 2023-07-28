package com.ecodeup.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecodeup.apirest.entity.User;
import com.ecodeup.apirest.service.UserService;

@RestController
@RequestMapping("/apirest")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody  User user){
		return new ResponseEntity<>( userService.save(user), HttpStatus.CREATED) ;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
	}
	@PostMapping("/user")
	public ResponseEntity<Integer> findByName(@RequestBody  User user){
		return new ResponseEntity<>(userService.findByName(user), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		userService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}	

}
