package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerPlayListEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<SongsEntity> songs;
	@ManyToOne
	Users users;
	public CustomerPlayListEntity() {
		super();
	}
	public CustomerPlayListEntity(int id, String name, List<SongsEntity> songs, Users users) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SongsEntity> getSongs() {
		return songs;
	}
	public void setSongs(List<SongsEntity> songs) {
		this.songs = songs;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "CustomerPlayListEntity [id=" + id + ", name=" + name + ", songs=" + songs + ", users=" + users + "]";
	}
	
}
