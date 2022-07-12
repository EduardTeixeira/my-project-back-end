package com.projectname.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectname.backend.models.User;
import com.projectname.backend.repository.UserRepository;
import com.projectname.backend.util.BCryptPasswordEncoderUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public @ResponseBody Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public @ResponseBody String create(User request) {

		userRepository.save(request);

		return "Saved";

	}

	@Transactional(rollbackFor = Exception.class)
	public Long saveDto(User userDto) {

		userDto.setPassword(BCryptPasswordEncoderUtil.bCryptPasswordEncoder().encode(userDto.getPassword()));

		return userRepository.save(userDto).getId();

	}

}
