package it.objectmethod.webappsakilaspring.model;


public class Film {

	private int film_id;
	private String title;
	private double rental_rate;
	private int length;
	
	
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
