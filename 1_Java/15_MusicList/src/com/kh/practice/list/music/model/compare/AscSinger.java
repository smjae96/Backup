package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscSinger implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		o1 = new Music();
		o2 = new Music();
		
	return ((Music)o1).getSinger().compareTo(((Music)o2).getSinger());
		
	}

}
