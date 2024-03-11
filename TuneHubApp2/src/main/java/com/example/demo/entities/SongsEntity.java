package com.example.demo.entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class SongsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	@ManyToMany
	List<PlayListEntity> playlist;
	@ManyToMany
	List<CustomerPlayListEntity> customerPlayListEntities;
	public SongsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SongsEntity(int id, String name, String artist, String genre, String link, List<PlayListEntity> playlist,
			List<CustomerPlayListEntity> customerPlayListEntities) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlist = playlist;
		this.customerPlayListEntities = customerPlayListEntities;
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
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<PlayListEntity> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<PlayListEntity> playlist) {
		this.playlist = playlist;
	}
	public List<CustomerPlayListEntity> getCustomerPlayListEntities() {
		return customerPlayListEntities;
	}
	public void setCustomerPlayListEntities(List<CustomerPlayListEntity> customerPlayListEntities) {
		this.customerPlayListEntities = customerPlayListEntities;
	}
	@Override
	public String toString() {
		return "SongsEntity [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link;
//				+ ", playlist=" + playlist + ", customerPlayListEntities=" + customerPlayListEntities + "]";
	}
		
	
}
