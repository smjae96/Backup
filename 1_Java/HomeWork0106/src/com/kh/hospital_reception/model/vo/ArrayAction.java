package com.kh.hospital_reception.model.vo;

public interface ArrayAction {

	void add(String element);
	void remove(String element);
	String get(int idx);
	int find(String element);
	void print();
}
