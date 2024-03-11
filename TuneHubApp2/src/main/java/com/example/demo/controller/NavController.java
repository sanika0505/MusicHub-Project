package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController
{
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "index";
	}
	
	@GetMapping("/map-songs")
	public String songMapping()
	{
		return "addsongs";
	}
	
	@GetMapping ("/makepayment")
	public String OrderMapping()
	{
		return "samplePayment";
	}
	@GetMapping ("paticularCustomerPlayListViews")
	public String paticularCustomerPlayListViews()
	{
		return "searchCustomerPlayList";
	}
	

	
	
}
