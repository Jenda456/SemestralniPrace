package com.cinema.service;


import com.cinema.dao.UserRepository;

import com.cinema.entity.User;
import com.cinema.entity.UserDto;
import com.cinema.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private  PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

		if (emailExists(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email address:  + accountDto.getEmail()");
		}
		User user = new User();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		user.setEmail(accountDto.getEmail());
		user.setRole("USER");
		return userRepository.save(user);
	}
	private boolean emailExists(String email) {
		String emailA = userRepository.findEmail(email);
		if (emailA != null) {
			return true;
		}
		return false;
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);

		User theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}

}






