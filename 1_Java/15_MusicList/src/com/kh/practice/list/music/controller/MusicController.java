package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscSinger;
import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	public List printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		Music m = null;
		for(int i=0; i<list.size(); i++) {
			m = list.get(i);
			if(m.getTitle().equals(title)) {
				return m;
			} 
		} 
		return null;
	}
	
	public Music removeMusic(String title) {
		Music m = null;
		for(int i=0; i<list.size(); i++) {
			m = list.get(i);
			if(m.getTitle().equals(title)) {
				m = list.remove(i);
				return m;
			} 
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		Music m = null;
		for(int i=0; i<list.size(); i++) {
			m = list.get(i);
			if(m.getTitle().equals(title)) {
				m = list.set(i, music);
				return m;
			} else {
				m = null;
			}
		}
		return m;
	}
	
	public int ascTitle() {
		AscTitle at = new AscTitle();
		Collections.sort(list, at.reversed());
		return 1;
	}
	
	public int descSinger() {
		Collections.sort(list);
		return 1;
	}
}
