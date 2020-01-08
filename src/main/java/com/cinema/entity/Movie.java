package com.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Movie {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
	    private String name;
	    private String description;
		private String url_video;
	    private int length;

	    public Movie() {}



	public Movie(String name, String description, int length, String url_video) {
			this.name = name;
			this.description = description;
			this.length = length;
			this.url_video = url_video;
		}


	public String getUrl_video() {
		return url_video;
	}

	public void setUrl_video(String url_video) {
		this.url_video = url_video;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
	    
	    

		   @Override
		public String toString() {
			return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", length=" + length + "]";
		}	

	
}
