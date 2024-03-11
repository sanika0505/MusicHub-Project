package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.SongsEntity;
import com.example.demo.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService
{
	@Autowired
	SongsRepository srepo;
	
	public String addSongs(SongsEntity song)
	{
		srepo.save(song);
		return "Song is Added";
	}

	@Override
	public boolean fetchSongs(String name) 
	{
		if(srepo.findByName(name) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public List<SongsEntity> fetchSongs() 
	{
		return srepo.findAll();
	}

	@Override
	public void updateSong(SongsEntity song)
	{
		srepo.save(song);
	}

	
}
