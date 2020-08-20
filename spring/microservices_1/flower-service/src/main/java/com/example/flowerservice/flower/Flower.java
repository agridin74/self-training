package com.example.flowerservice.flower;
/**
 * простой POJO класс цветок
 * @author agridin74
 *
 */
public class Flower {
	private Long id;
	private String owner;
	private String title;
	
	
	
	public Flower() {
		
	}
	
	
	public Flower(Long id, String owner, String title) {
		super();
		this.id = id;
		this.owner = owner;
		this.title = title;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flower [id=" + id + ", owner=" + owner + ", title=" + title + "]";
	}
	
	
}
