package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.User;

public interface UserService 
{

	User getUser(User user);

	List<User> getAll();

	User getById(Long id);

	User updatedUser(Long id, User updatedUser);

	User updatePartialUser(Long id, User partialUser);

	boolean existsById(Long id);

	void deleteUser(Long id);

}
