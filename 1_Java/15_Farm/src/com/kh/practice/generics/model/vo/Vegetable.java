package com.kh.practice.generics.model.vo;

import java.util.Objects;

public class Vegetable extends Farm{
	private String name;
	
	
	public Vegetable() {
		
	}
	
	public Vegetable(String kind, String name) {
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
		return super.toString()+": "+name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vegetable) {
			return this.name.equals(((Vegetable)obj).name);
		}
		return false;
	}

}
