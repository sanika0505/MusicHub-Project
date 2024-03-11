package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.SongsEntity;
import com.example.demo.services.SongsService;

@Controller
public class SongsController 
{
	@Autowired
	SongsService songserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute SongsEntity song)
	{
		if(songserv.fetchSongs(song.getName()) == false)
		{
			songserv.addSongs(song);
			return "songsuccess";
		}
		else
		{
			return "songUnsuccess";
		}
	}
	
	@GetMapping("/viewSongsAdminHome")
	public String fetchSongs(Model model)
	{
		List<SongsEntity> songlist = songserv.fetchSongs();
		model.addAttribute("songList", songlist);
		return "ViewSongs";
	}
	
//	@GetMapping("/viewSongsCustHome")
//	public String viewSongsCust(Model model)
//	{
//		boolean primestatus = true;
//		if(primestatus == true)
//		{
//			List<SongsEntity> songlist = songserv.fetchSongs();
//			model.addAttribute("songList", songlist);
//			return "ViewSongs";
//		}
//		else 
//		{
//			return "makepayment";
//		}
//	}
}
