package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.CustomerPlayListEntity;
import com.example.demo.entities.PlayListEntity;
import com.example.demo.entities.SongsEntity;
import com.example.demo.entities.Users;
import com.example.demo.services.CustomerPlayListService;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class PlayListController 
{
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	SongsService songsService;
	
	@Autowired
	CustomerPlayListService customerPlayListService;
	
	@GetMapping("createPlayListAdmin")
	public String createPlayList(Model model)
	{
		//fetching the song using song service
		List<SongsEntity> songslist = sserv.fetchSongs();
		
		//adding the song in the model
		model.addAttribute("songslist", songslist);
		
		//sending create play list
		return "createPlaylist";
	}
	
	@PostMapping("addPlayListAdmin")
	public String addPlayList(@ModelAttribute PlayListEntity playlist)
	{
		//adding playlist
		pserv.addPlaylist(playlist);
		System.out.println(playlist);
		
		//update song table
		List <SongsEntity> songsList = playlist.getSongs();
		for(SongsEntity song : songsList)
		{
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playListSuccess";
	}
	
	
	@GetMapping("viewPlayListAdmin")
	public String viewPlaylist(Model model,HttpSession session)
	{
		String userEmail=(String) session.getAttribute("email");
		Users users=usersService.getUser(userEmail);
		boolean userStatus=users.isPremium();
		String role=users.getRole();
		if(userStatus==true||role.equals(role))
		{
			List <PlayListEntity>plist = pserv.fetchPlayList();
			model.addAttribute("plist", plist);
			return "viewPlaylistAdmin";
		}else {
			return "samplePayment";
		}
	}
	
	
//	=================================== Customer ==================================================== //
	
	@GetMapping("createPlayListCustomer")
	public String createPlayListCustomer(Model model ,HttpSession session) {
			String userEmail=(String) session.getAttribute("email");
			Users users=usersService.getUser(userEmail);
			boolean userStatus=users.isPremium();
			if(userStatus==true)
			{
				List<SongsEntity> songsEntities=songsService.fetchSongs();
				model.addAttribute("songslist",songsEntities);
				return "createPlayListCustomer";
			}else {
				return "samplepayment";
			}
		}
	
	@PostMapping("addPlayListCustomer")
	public String addPlayListCustomer(@ModelAttribute CustomerPlayListEntity customerPlayListEntity,HttpSession session, Model model)
	{
		String userEmail=(String) session.getAttribute("email");
		Users users=usersService.getUser(userEmail);
		customerPlayListEntity.setUsers(users);
		customerPlayListService.addPlayList(customerPlayListEntity);
		List<SongsEntity> songsEntities=customerPlayListEntity.getSongs();
		for(SongsEntity songsEntity:songsEntities)
		{
			songsEntity.getCustomerPlayListEntities().add(customerPlayListEntity);
		}
		
		List<CustomerPlayListEntity> customerPlayListEntities=users.getCustomerPlayListEntities();
		customerPlayListEntities.add(customerPlayListEntity);
		users.setCustomerPlayListEntities(customerPlayListEntities);
		usersService.updateUser(users);
		return "playListSuccess";
	}
	
	@GetMapping("viewPlayListCustomer")
	public String viewPlayListCustomer(Model model,HttpSession session)
	{
		String userEmail=(String) session.getAttribute("email");
		Users users=usersService.getUser(userEmail);
		boolean userStatus=users.isPremium();
		if(userStatus==true)
		{
			List<CustomerPlayListEntity> customerPlayListEntities=users.getCustomerPlayListEntities();
			model.addAttribute("plist",customerPlayListEntities);
			return "viewPlayListCustomer";
		}else {
			return "samplePayment";
		}
	}
	
	@GetMapping("viewPlayListParticularCustomer")
	public String viewPlayListParticularCustomer(@RequestParam String email,Model model) {
		Users users=usersService.getUser(email);
		List<CustomerPlayListEntity> customerPlayListEntities=users.getCustomerPlayListEntities();
		model.addAttribute("plist",customerPlayListEntities);
		return "viewPlayListCustomer";
	}
		
}
