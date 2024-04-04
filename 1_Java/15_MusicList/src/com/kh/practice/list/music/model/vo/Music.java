package com.kh.practice.list.music.model.vo;

import java.util.Objects;

import com.kh.practice.list.music.model.compare.AscTitle;

public class Music implements Comparable<Music> {
	private String title;
	private String singer;
	
	public Music() {}
	public Music(String title, String singer) {
		this.title=title;
		this.singer=singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String toString() {
		return singer+ "-" + title;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(singer, other.singer) && Objects.equals(title, other.title);
	}
	
	@Override
	public int compareTo(Music o) {
		// TODO Auto-generated method stub
		return this.getSinger().compareTo(o.getSinger());
	}
}
