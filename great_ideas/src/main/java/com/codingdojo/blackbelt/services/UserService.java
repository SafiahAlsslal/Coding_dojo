package com.codingdojo.blackbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.blackbelt.models.Role;
import com.codingdojo.blackbelt.models.User;
import com.codingdojo.blackbelt.repositories.*;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

	public void create(Role role){
		roleRepository.save(role);
	}
	public void update(Role role){
		roleRepository.save(role);
	}
	public void destroy(long id){
		roleRepository.deleteById(id);
	}
	
	 public void updateUser(User user){ 
 		userRepository.save(user);
 }
 
 public void createUser(User user) {
 		userRepository.save(user);
 }
 
 public Optional<User> getUserById(Long id) {
 		return userRepository.findById(id);
 }
 
 public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
}

 
 public List<User> getAll(){
 		return (List<User>) userRepository.findAll();
 }

 
 public void deleteUser(Long id) {
 		userRepository.deleteById(id);
 }
 
}