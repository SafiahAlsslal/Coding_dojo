package com.codingdojo.blackbelt.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.blackbelt.models.Idea;
import com.codingdojo.blackbelt.models.User;
import com.codingdojo.blackbelt.services.IdeaService;
import com.codingdojo.blackbelt.services.UserService;
import com.codingdojo.blackbelt.validator.UserValidator;

@Controller

public class Users {
    
	 private UserValidator userValidator;
	 private UserService userService;
	 private IdeaService IdeaService;

	    public Users(UserService userService, UserValidator userValidator, IdeaService IdeaService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.IdeaService =IdeaService;
	    }
	    
	    @RequestMapping("/login")
	    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model , @Valid @ModelAttribute("user") User user) {
	        if(error != null) {
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successful!");
	        }
	        return "loginPage.jsp";
	    }
	    
	    @RequestMapping(value = {"/","/home"})
	    public String home(Principal principal, Model model) {
	        String email = principal.getName();
	        model.addAttribute("currentUser", userService.getUserByEmail(email));
	        List<Idea> ideas = IdeaService.all();
	        model.addAttribute("ideas", ideas);
	        return "homePage.jsp";
	    }
	    
	    @RequestMapping(value = {"/homea"})
	    public String asc(Principal principal, Model model) {
	        String email = principal.getName();
	        model.addAttribute("currentUser", userService.getUserByEmail(email));
	        List<Idea> ideas = IdeaService.allasc();
	        model.addAttribute("ideas", ideas);
	        return "homePage.jsp";
	    }
	    
	    @RequestMapping(value = {"/homed"})
	    public String desc(Principal principal, Model model) {
	        String email = principal.getName();
	        model.addAttribute("currentUser", userService.getUserByEmail(email));
	        List<Idea> ideas = IdeaService.alldesc();
	        model.addAttribute("ideas", ideas);
	        return "homePage.jsp";
	    }
	    
	      
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "loginPage.jsp";
        }
    		userService.saveWithUserRole(user);
    		return "redirect:/home";
    }
    
    @RequestMapping("/ideas/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
    	IdeaService.delete(id);
		return "redirect:/home";
		
	}
    
    @RequestMapping("/ideas/new")
	public String showForm(@ModelAttribute("idea") Idea idea,Principal principal, Model model) {
    	 String email = principal.getName();
	      model.addAttribute("currentUser", userService.getUserByEmail(email));
		return "new.jsp";
	}
	 
	 @RequestMapping(value="/ideas/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("idea") Idea idea , BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	        	IdeaService.create_new(idea);
	            return "redirect:/home";
	        }
	    }
 
	  @RequestMapping("/ideas/{id}/edit")
	    public String edit(@PathVariable("id") Long id,@ModelAttribute("idea") Idea idea, Model model , Principal principal) {
	    	Idea i = IdeaService.find_one(id);
	        model.addAttribute("idea", i);
	        model.addAttribute("ideas", new Idea());
	        String Email = principal.getName();
			  User u = userService.getUserByEmail(Email);
			  String name = u.getname();
			  String name2 = i.getUser().getname();
			  System.out.print(name + "dsdsdsd");
			  System.out.print(name2 + "dwdwdwddd");
			  if (name.equals(name2))
				  	return "edit.jsp";
			  else {
			  return "redirect:/home"; }
			  
	    }
	  @RequestMapping(value="/ideas/{id}", method=RequestMethod.POST)
	    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	Idea i = IdeaService.find_one(id);
		        ArrayList<String> users = i.getUsers_likes();
		        idea.setUsers_likes(users);
	        	IdeaService.update(idea);
	        	 return "redirect:/home";
	        }
	    }
	  
	  @RequestMapping(value="/likes/{id}", method=RequestMethod.GET)
	    public String likes(@PathVariable("id") Long id,Principal principal) {
		  String Email = principal.getName();
		  User u = userService.getUserByEmail(Email);
		  String name = u.getname();
		  		Idea i = IdeaService.find_one(id);
		  		int likes = i.getLikes();
		  		likes= likes +1;
		  		i.setLikes(likes);
		  		ArrayList<String> users = new ArrayList<String>(100);
		  		if ( likes >1 ) {
		  		for(int j = 0; j< i.getUsers_likes().size() ; j++) {
					 users.add ( i.getUsers_likes().get(j));}}
		  		users.add(name);
		  		i.setUsers_likes(users);
	        	IdeaService.update(i);
	            return "redirect:/home";
	    }
	  
	  @RequestMapping(value="/unlike/{id}", method=RequestMethod.GET)
	    public String unlike(@PathVariable("id") Long id,Principal principal) {
		  String Email = principal.getName();
		  User u = userService.getUserByEmail(Email);
		  String name = u.getname();
		  		Idea i = IdeaService.find_one(id);
		  		int likes = i.getLikes();
		  		likes= likes -1;
		  		i.setLikes(likes);
		  		ArrayList<String> users = new ArrayList<String>(100);
		  		if ( likes >9 ) {
		  		for(int j = 0; j< i.getUsers_likes().size() ; j++) {
					 users.add ( i.getUsers_likes().get(j));}}
		  		users.remove(name);
		  		i.setUsers_likes(users);
	        	IdeaService.update(i);
	            return "redirect:/home";
	    }
	  
	  @RequestMapping("/ideas/{id}")
	    public String show(@PathVariable("id") Long id , Model model,Principal principal) {
	    	Idea i = IdeaService.find_one(id);
	        model.addAttribute("idea", i);
	        String Email = principal.getName();
			  User u = userService.getUserByEmail(Email);
			  String name = u.getname();
			  model.addAttribute("name", name);
	       ArrayList<String> users = i.getUsers_likes();
	       model.addAttribute("users", users);
	        return "show.jsp";
	    }
	    
}