package com.starwars.dto;

public class FilmDto {

	public FilmDto() {
		super();
	}

	private String title;
   
	private String releaseDate;

    // Constructor
    public FilmDto(String name, String releaseDate) {
        this.setTitle(name);
        this.setReleaseDate(releaseDate);
    }


	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

}
