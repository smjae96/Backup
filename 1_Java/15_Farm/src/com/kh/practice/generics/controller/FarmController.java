package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.practice.generics.model.vo.Farm;

public class FarmController {
	private HashMap<Farm, Integer> hMap = new HashMap<>();
	
	private ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		if(!hMap.containsKey(f)) {	// containsKey(Ű��) : �ش� Ű���� Map�� �����ϴ� �� üũ
			// hMap ���� f�� �ش��ϴ� Ű ���� ���� ���
			// hMap�� ������ �߰�
			hMap.put(f, amount);
			return true;
		}
		// if���� ���� ���� ��� hMap ���� f�� �ش��ϴ� Ű�� ���� ��� (������ ����)
		return false;
	}
	
	public boolean removeKind(Farm f) {
		if(hMap.containsKey(f)) {
			// hMap ���� f�� �ش��ϴ� Ű ���� �����ϴ� ��� ������ ����
			hMap.remove(f);
			return true;
		}
		// hMap ���� f�� �ش��ϴ� Ű ���� �������� ���� ���
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		if(hMap.containsKey(f)) {
			// hMap ���� f�� �ش��ϴ� Ű ���� �����ϴ� ���
			//	* Map ������ �߰� �� ���� Ű ���� �ִ� ��� �ش� �����͸� �����.
			hMap.put(f, amount);
			return true;
		}
		// hMap ���� f�� �ش��ϴ� Ű ���� �������� ���� ���
		return false;
	}
	
	public HashMap<Farm,Integer> printFarm() {
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		int amount = 0;
		
		if(hMap.containsKey(f)&&	// ���޹��� f�� hMap �ȿ� �����ϴ� ��
				hMap.get(f)>=0) {	//  f�� ���� => hMap ������ value�� �ǹ�(hMap.get(f)
									// f(key)�� �ش��ϴ� value�� ���� 0 �̻��� ��	
			list.add(f);		// list�� ������ �߰�(f)	
			amount = hMap.get(f)-1;	// Wrapper class : hMap.get(f) 
									// Integer -> int : ���� ��ڽ�
									// ���� �ڽ� : int -> Integer
			hMap.put(f, amount);	// hMap�� f�� ���� 1���� => 1 ���� �� �ٽ� ����.
			return true;
		}
		return false;
	}
	
	public boolean removeFarm(Farm f) {
		int amount = 0;
		if(list.contains(f)) {	// list�� f�� ���� �����Ͱ� �����ϴ� ���
			list.remove(f);		// ����Ʈ���� �ش� ������(f) ����
			amount = hMap.get(f)+1;	// hMap�� f�� ���� 1����.
			hMap.put(f, amount);
			return true;
		}
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm() {
		return list;
	}
}
