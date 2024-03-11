package com.example.demo.services;
import java.util.List;

import com.example.demo.entities.SongsEntity;

public interface SongsService 
{
	public String addSongs(SongsEntity song);
	public boolean fetchSongs(String name);
	List <SongsEntity>fetchSongs();
	public void updateSong(SongsEntity song);
}
