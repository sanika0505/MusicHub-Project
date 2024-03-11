package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PlayListEntity;

public interface PlayListRepository extends JpaRepository<PlayListEntity, Integer>
{

}
