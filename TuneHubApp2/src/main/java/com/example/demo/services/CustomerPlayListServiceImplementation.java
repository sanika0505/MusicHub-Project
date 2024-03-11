package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CustomerPlayListEntity;
import com.example.demo.repositories.CustomerPlayListRepository;

@Service
public class CustomerPlayListServiceImplementation implements CustomerPlayListService {
	
	@Autowired
	CustomerPlayListRepository customerPlayListRepository;

	@Override
	public void addPlayList(CustomerPlayListEntity customerPlayListEntity) {
		customerPlayListRepository.save(customerPlayListEntity);
		
	}

	@Override
	public List<CustomerPlayListEntity> fetchPlayList() {
		return customerPlayListRepository.findAll();
	}

}
