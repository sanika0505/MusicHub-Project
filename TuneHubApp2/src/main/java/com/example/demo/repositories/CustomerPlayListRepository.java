package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CustomerPlayListEntity;

public interface CustomerPlayListRepository extends JpaRepository<CustomerPlayListEntity, Integer> {

}
