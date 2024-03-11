package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.SongsEntity;
import com.example.demo.entities.Users;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;
import com.example.demo.services.UsersServiceImplementation;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	SongsService songserv;
	
	@Autowired
	UsersServiceImplementation uservimpl;
	
	@Autowired
	//Register page
	UsersService userv;
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) 
	{
		boolean userstatus = userv.emailExits(user.getEmail());
		if(userstatus == false)
		{
			userv.addUser(user);
			return "registersucess";
//			System.out.println("User is added");
		}
		else
		{
			return "registerfail";
//			System.out.println("User is olready exist");
		}
//		return "home";
	}
	
	
	//Login page
	@PostMapping("/index")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
		if(uservimpl.userExist(email))
		{
			return "loginfail";
		}
		else
		{
			
		//invoking validateuser() in service
		if(userv.validateUser(email,password) == true)
		{
			session.setAttribute("email" ,email);
			//checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{	
				String useremail=(String) session.getAttribute("email");
				Users users=userv.getUser(useremail);
				boolean userStstus=users.isPremium();
				if(userStstus==true)
				{
				return "customerhome";
				}else {
					return "samplePayment";
				}
			}
		}
		else
		{
			return "loginfail";
		}
	}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model)
	{
		String email = (String) session.getAttribute("email");
		Users user = userv.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true)
		{

			List<SongsEntity> songlist = songserv.fetchSongs();
			model.addAttribute("songList", songlist);
			return "viewSongs";
		}
		else
		{
			return "samplePayment";
		}
	}
	
	
	//logout button
	@GetMapping("Logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "LogoutSuccessfully";
	}
}
