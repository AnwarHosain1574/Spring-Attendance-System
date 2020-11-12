package com.csl.bmsri.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.csl.bmsri.Models.Role;
import com.csl.bmsri.Models.User;
import com.csl.bmsri.Repository.RoleRepository;
import com.csl.bmsri.Repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImp implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Autowired
 private RoleRepository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }

 @Override
 public void saveUser(User user) {
	 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  //user.setRole_id(2);
  Role userRole =null;
  
  user.setSs_facty_id(3);
  
  userRole = roleRespository.findByRole("Customer");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  user.setRole_id(userRole.getId());
  userRepository.save(user); userRepository.flush();
 }

}