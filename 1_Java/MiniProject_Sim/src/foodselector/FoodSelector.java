package foodselector;

import java.util.ArrayList;
import java.util.Scanner;

import food.Food;
import restaurant.Restaurant;

public class FoodSelector {
	private static Scanner sc = new Scanner(System.in);
	
	
	public static ArrayList<Food> selectFoods(Restaurant burgerking, Restaurant hansot, Restaurant homeCook) {
		ArrayList<Food> selectedFoods = new ArrayList<>();
		System.out.println();
		System.out.println("===== ����ŷ �޴� =====");
		System.out.println("1. ��Ʈ�� ġ�� ����");
		System.out.println("2. ����� ����");
		System.out.println("3. ��ġŲ ����");
		System.out.println("4. �ٻ�ŷ 4����");
		System.out.println("5. ����Ŀ 4����");
		System.out.println("6. ����");
		System.out.print("�޴��� �����ϼ���(1~6) : ");
		int choice = sc.nextInt();
		Food selectedBurgerking = burgerking.selectMenu(choice);
		selectedFoods.add(selectedBurgerking);
		
		System.out.println();
		
		System.out.println("===== �Ѽ� �޴� =====");
		System.out.println("1. ġŲ���䵤��");
		System.out.println("2. ��� ���ô�");
		System.out.println("3. ��� ī��");
		System.out.println("4. �ҺҰ�� ���ö�");
		System.out.println("5. ��ġ��ä������");
		System.out.println("6. ����");
		System.out.print("�޴��� �����ϼ���(1~6) : ");
		choice = sc.nextInt();
		Food selectedHansot = hansot.selectMenu(choice);
		selectedFoods.add(selectedHansot);
		
		System.out.println();
		
		System.out.println("===== ���� �޴� =====");
		System.out.println("1. ����� + �� �� ����");
		System.out.println("2. ����Ÿ ������");
		System.out.println("3. ���� ���� + �� �� ����");
		System.out.println("4. �Ŷ�� + �� �� ����");
		System.out.println("5. ������ �߰�����");
		System.out.println("6. ����");
		System.out.print("�޴��� �����ϼ���(1~6) : ");
		choice = sc.nextInt();
		Food selectedHomeCook = homeCook.selectMenu(choice);
		selectedFoods.add(selectedHomeCook);
		
		return selectedFoods;
		
	}
}
