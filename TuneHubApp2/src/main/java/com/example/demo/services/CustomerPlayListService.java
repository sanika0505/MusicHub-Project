package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.CustomerPlayListEntity;

public interface CustomerPlayListService {
	public void addPlayList(CustomerPlayListEntity customerPlayListEntity);
	public List<CustomerPlayListEntity> fetchPlayList();

}
