package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService

{
    private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	}

	public User getUser(User user) {
		
		return userRepository.save(user);
	}

	
	public List<User> getAll() 
	{
      return userRepository.findAll();
	}

	public User getById(Long id)
	{
	    return userRepository.findById(id).orElse(null);
	}

	public User updatedUser(Long id, User updatedUser) {

            updatedUser.setId(id);
           return userRepository.save(updatedUser);
	}

	
	public User updatePartialUser(Long id, User partialUser)
	{
		User existing = getById(id);
		
		if(partialUser.getName()!=null)
			existing.setName(partialUser.getName());

		if(partialUser.getEmail()!=null)
			existing.setEmail(partialUser.getEmail());
		
		return userRepository.save(existing);
	}

	public boolean existsById(Long id) {
	
		return userRepository.existsById(id);
	}

	public void deleteUser(Long id) 
	{
	    userRepository.deleteById(id);
		
	}

	
    
}
