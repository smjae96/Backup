package com.kh.collection;

import java.util.ArrayList;
import java.util.List;

class Food {
	String name;
	int kcal;
	//	��� : ������ Ÿ�� -> Set (��� ���), Map<���, �뷮> ( �� �� �ڼ���.. �����Ѵٸ�..)
	public Food() {}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
}

class Pizza extends Food {

	public Pizza() {
		super();
	}

	public Pizza(String name, int kcal) {
		super(name, kcal);
	}
	
}


public class CollectionPractice {
	/*
	 * �÷��� (Collection) : �ڹٿ��� �������ִ� �ڷᱸ�� ���� ���̺귯��(�⺻ Ŭ����)
	 * 	- ���� ���� �ڷᱸ�� ���� �������̽��� ���ǵǾ� �ְ�, 
	 * 			�� �������̽��� ������ Ŭ�������� �ִ�.
	 * 
	 * 	- Collection �������̽�	: �����͸� ��Ƽ� ����
	 * 
	 * 		* List �������̽� : ���� ��, �ߺ� ��� �� (�ּҷ�, to-do ����Ʈ)
	 * 			( * <E> : ���׸� -> �ϳ��� Ÿ���� �ƴ� ���� Ÿ���� ����� �� �ֵ��� ������ ��.)
	 * 			+ ArrayList<E>	:	������ ��ȸ �� �ӵ��� ����(�迭 ���, �ε����� �ٷ� ��ȸ)
	 * 			
	 * 			+ LinkedList<E>	:	������ �߰�/���� �� �ӵ��� ����(����Ʈ ���, ���� ������ ������ ó�� ����)
	 * 			
	 * 		* Set �������̽�  : ���� x, �ߺ� ��� x (����)
	 * 			+ HashSet<E>	:	�ؽ� �˰��� ������� ������ �ߺ� ó��
	 * 								 - equals(), hashCode() �޼ҵ带 ����Ͽ� �ߺ� üũ.
	 * 								 - 1)hashCode() �޼ҵ��� ��ȯ ���� �����ϰ�,
	 * 								   2)equals() �޼ҵ��� ��ȯ ���� true�� ��� ������ ��ü�� �Ǵ��Ѵ�.
	 * 
	 * 	- Map �������̽�			: Ű-������ �� ���� �����͸� ��Ƽ� ����
	 * 		* ���� x, Ű�� �ߺ� ��� x, ���� �ߺ� ��� o
	 * 		+ HashMap<K, V>	: Ű ���� �������� �ؽ� �˰����� �����Ͽ� �ߺ��� üũ
	 * 						  Ű ����� ��ȸ�ϸ� "Set" �����̴�. ( keySet() �޼ҵ�� ��ȸ ����. )
	 * 
	 * 	* �޼ҵ� ����
	 * 				List					Set									Map
	 * 	������ �߰�	add(������)				add(������)							put(Ű ������, �� ������)
	 * 
	 * 	������ ����	remove(�ε���)			remove(������)						remove(Ű ������)
	 * 				remove(������)
	 * 
	 * 	������ ��ȸ	get(�ε���)				* Iterator ��ü						get(Ű ������)	 // �ش� Ű�� ������ ����� ���� ��ȸ
	 * 									 1) Iterator ��ü ���� : 
	 * 									Iterator iterator = Set��ü_����������.iterator()
	 * 									 2) ���� ������ ���� ��/�� �Ǵ�
	 * 									 	iterator.hasNext() �޼ҵ� ȣ���Ͽ� Ȯ�� => ���ǽ�
	 * 									 3) �ش� �����͸� �������� �޼ҵ� : next()
	 * 										iterator.next()	 // ������ Ÿ���� Set<E> ���� �� ���� E Ÿ��
	 * 										
	 * 										* for-each ��
	 * 									for(E data : set��ü_����������) {	}		
	 * 
	 * ������ ����		size()					size()								size()	
	 */
	public static void main(String[] args) {
		// ArrayList ��...
		// ArrayList �÷������� ���� ���� Food�� �����ϱ� ���� ��ü ����
		List<Food> fList = new ArrayList<>();
		
		// Food ��ü�� ����Ʈ�� �߰�.
		// �� �Ѱ��� , 300...?
		// �ܹ���, 414...
		Food f1 = new Food("�� �Ѱ���", 300);
		fList.add(f1);
		
		// add(E e)
		// => add(Food e) => �Ű������� ��üŸ��(Food)�̸�, �޼ҵ� ȣ�� �� � ���� �����ؾ� �ұ�?
		//						** ��ü �ν��Ͻ�(��ü ����) ���� **
		// fList.add("����"); // ���� ������ Ÿ�Կ� �ش��ϴ� �ν��Ͻ��� �����ؾ� ��.
		
		fList.add(new Food("�ܹ���", 414));

		// ������ ����Ǿ�, �θ� Ÿ���� �÷����� ���������� �ڽ� Ÿ���� �����͵鵵 �߰� ����.
		// * Food e = new Pizza();
		fList.add(new Pizza("����", 600));
		System.out.println(fList.get(0).name);
		System.out.println(fList.get(2).name);
	}
}
