package com.example.ratingservice.rating;

public class Rating {
	
	private Long id;
	private Long flowerId;
	private int stars;
	
	public Rating() {
	}

	public Rating(Long id, Long flowerId, int stars) {
		
		this.id = id;
		this.flowerId = flowerId;
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(Long flowerId) {
		this.flowerId = flowerId;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
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
		Rating other = (Rating) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", flowerId=" + flowerId + ", stars=" + stars + "]";
	}
	
	
	

}
