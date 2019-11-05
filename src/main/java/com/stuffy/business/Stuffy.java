package com.stuffy.business;

import javax.persistence.*;

@Entity
public class Stuffy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Type;
	String color;
	String size;
	int limbs;
	
	public Stuffy() {
		super();
	}

	public Stuffy(int id, String type, String color, String size, int limbs) {
		super();
		this.id = id;
		Type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;
	}

	public Stuffy(String type, String color, String size, int limbs) {
		Type = type;
		this.color = color;
		this.size = size;
		this.limbs = limbs;	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getLimbs() {
		return limbs;
	}

	public void setLimbs(int limbs) {
		this.limbs = limbs;
	}

	@Override
	public String toString() {
		return "stuffy [id=" + id + ", Type=" + Type + ", color=" + color + ", size=" + size + ", limbs=" + limbs + "]";
	}
	

}
