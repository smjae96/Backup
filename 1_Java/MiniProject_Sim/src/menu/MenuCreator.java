package menu;

import java.util.ArrayList;

import food.*;

public class MenuCreator {

	public static ArrayList<Food> BurgerkingMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new Burgerking("��Ʈ�� ġ�����", 71.1, 57.7, 28.2));
		menu.add(new Burgerking("����� ����", 50.0, 33.3, 45.3));
		menu.add(new Burgerking("��ġŲ ����", 55.7, 58.5, 12.7));
		menu.add(new Burgerking("�ٻ�ŷ 4����", 8.2, 73.4, 24.2));
		menu.add(new Burgerking("����Ŀ4 ����",51.2,106.7,121.4));
		menu.add(new Burgerking("����",0,0,0));
		return menu;
	}
	public static ArrayList<Food> HansotMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new Hansot("ġŲ���䵤��", 79.6, 25.3, 29.6));
		menu.add(new Hansot("��� ���ô�", 69.0, 50.0, 30.0));
		menu.add(new Hansot("��� ī��", 95.3, 14.8, 10.7));
		menu.add(new Hansot("�ҺҰ�� ���ö�", 17.5, 118.3, 39.0));
		menu.add(new Hansot("��ġ��ä������",66.1,24.4,11.3));
		menu.add(new Hansot("����",0,0,0));
		return menu;
	}
	public static ArrayList<Food> HomeCookMenu() {
		ArrayList<Food> menu = new ArrayList<>();
		menu.add(new HomeCook("����� + �� �� ����", 84.1, 20.6, 6.5));
		menu.add(new HomeCook("����Ÿ ������", 21.3, 4.9, 15.1));
		menu.add(new HomeCook("���� ���� + �� �� ����", 70.0, 40.8, 26.0));
		menu.add(new HomeCook("�Ŷ�� + �� �� ����", 146.3, 15.6, 16.9));
		menu.add(new HomeCook("������ �߰�����",1.0,24.0,1.6));
		menu.add(new HomeCook("����",0,0,0));
		return menu;
	}
	
}
