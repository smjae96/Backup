package com.kh.practice.generics.model.vo;

import java.util.Objects;

public class Fruit extends Farm{
	private String name;
	
	
	public Fruit() {
		
	}
	
	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() +": " +name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fruit) {
			return this.name.equals(((Fruit)obj).name);
		}
		return false;
	}

}
