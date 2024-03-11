package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PlayListEntity;
import com.example.demo.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService
{
	@Autowired
	PlayListRepository prepo;

	@Override
	public void addPlaylist(PlayListEntity playlist) 
	{
		prepo.save(playlist);
		
	}

	@Override
	public List<PlayListEntity> fetchPlayList() 
	{
		
		return prepo.findAll();
	}
	
}
