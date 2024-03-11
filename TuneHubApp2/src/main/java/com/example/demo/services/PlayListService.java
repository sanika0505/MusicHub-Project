package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.PlayListEntity;

@Service
public interface PlayListService 
{
	public void addPlaylist(PlayListEntity palylist);

	public List<PlayListEntity> fetchPlayList();
}
