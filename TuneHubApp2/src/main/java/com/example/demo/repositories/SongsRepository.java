package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.SongsEntity;

public interface SongsRepository extends JpaRepository<SongsEntity, Integer>
{
	public SongsEntity findByName(String name);
}
