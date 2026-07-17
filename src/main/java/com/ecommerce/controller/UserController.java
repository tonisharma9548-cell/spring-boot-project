package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

@Controller
@RequestMapping("/ecommerce/users")
public class UserController
{
     private final UserService userService;

	 public UserController(UserService userService) {
	
		this.userService = userService;
	 }
	 
	 @PostMapping
	 public ResponseEntity<User> createUser(@RequestBody User user)
	 {
		 User userSaved = userService.getUser(user);
		 return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<User>> getAllUser()
	 {
		 List<User> users = userService.getAll();
		 return ResponseEntity.ok(users);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<User> getById(@PathVariable Long id)
	 {
		User user = userService.getById(id); 
		if(user == null)
			ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User updatedUser)
	 {
		 User updated = userService.updatedUser(id ,updatedUser );
			if(updated == null)
				ResponseEntity.notFound().build();
           return ResponseEntity.ok(updated);
	 }
	 
	 @PatchMapping("/{id}")
	 public ResponseEntity<User> patchUser(@PathVariable Long id , @RequestBody User partialUser)
	 {
		 User updated = userService.updatePartialUser(id ,partialUser );
		 if(updated == null)
				ResponseEntity.notFound().build();
			return ResponseEntity.ok(updated);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<User> deleteUser(@PathVariable Long id)
	 {
		 if(userService.existsById(id))
			 return ResponseEntity.notFound().build();
		 
		 userService.deleteUser(id);
		 return ResponseEntity.noContent().build();
	 }
     
     
}
