package com.kh.example.practice5.model.vo;

import java.util.Arrays;

public class Lotto {
	private int[] lotto;
	{
		lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1);
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	public Lotto() {
		
	}
	
	public void information() {
		System.out.print("로또번호: ");
		for(int i=0; i<lotto.length; i++) {
			Arrays.sort(lotto);
			System.out.print(lotto[i] + " ");
		}
	}
}
