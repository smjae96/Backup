package com.kh.list.practice;

import java.util.ArrayList;	// import : �ٸ� ��ο� �ִ� Ŭ���� ��� �� ��ġ�� �˷��ش�.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListPractice {

	/*
	 * List Ư¡
	 * : ������ �ְ�, �ߺ��� ���Ǵ� �÷��� 
	 * 
	 * *ArrayList
	 * 	- �迭 ����
	 * 	- ������ ��ȸ�� ��������� ������.
	 * 	- ������ �߰�/���� �� �����Ͽ� ���� �ɸ���.
	 * 
	 * 	- ǥ���� : List<E> ���������� = new ArrayList<[E]>();
	 * 			 ArrayList<E> ���������� = new ArrayList<[E]>();
	 * 
	 * *LinkedList
	 * 	- ����Ʈ ����
	 * 	- ������ �߰�/������ ������.
	 * 	- ������ ��ȸ�� ������.
	 * 
	 * 	- ǥ���� : List<E> ���������� = new LinkedList<[E]>();		// [E] : E Ÿ�� ���� ����.
	 * 			 LinkedList<E> ���������� = new LinkedList<[E]>();
	 * 
	 * * List ���� �޼ҵ�	=> ArrayList, LinkedList Ŭ�������� ���ǵǾ� ����
	 * 	- ������ �߰� : add(������)		// E Ÿ���� ������ �߰�
	 * 	- ������ ���� : remove(�ε���)	// �ε��� ��ġ�� ������ ����
	 * 	- ������ ��ȸ : get(�ε���)		// �ε����� ��ġ�� ������ ��ȸ
	 * 	- ����� ������ ���� : size()
	 */
	
	public static void main(String[] args) {
		arrayListTest();
		//ť(Queue) 	: ó�� ����� �����Ͱ� ���� ó������ ������ �� �ִ� ���� (FIFO: First In First Out)
		
		// ������ �߰� : ������� �߰�
		
		// ������ ���� : ó������ ����
		MyQueue mq = new MyQueue();
		mq.enQueue("������");
		mq.enQueue("����");
		mq.enQueue("���̵�");
		
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		
		char ch = 'a';
		String result = Character.valueOf(ch).isUpperCase(ch) ? "�빮��" : "�빮�� �ƴ�";
		System.out.println(result);
		
		
	}
	
	
	public static void StackTest() {	
		// ����(Stack): ���� �������� ����� �����Ͱ� ���� ó������ ������ �� �ִ� ���� (LIFO: Last In First Out)
		
		// ������ �߰�	 : ������� �߰�
		
		// ������ ����	 : ������ ��ġ���� ����
		MyStack mStack = new MyStack();
		mStack.push("������");
		mStack.push("����");
		mStack.push("���̵�");
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
	
	}
	public static void linkedListTest() {
		// [2] LinkedList<E>
		List<Integer> list = new LinkedList<>();
		
		// ����ڿ��� ������ ������ ���̸� �Է� �޾� 
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������ ���̸� �Է��ϼ��� : ");
		int size = sc.nextInt();
		
		// �� ���̸�ŭ ���� ���� ����
		for(int i=0; i<size; i++) {
			// (int)(Math.random()*size+1)	// ���� ������ : ���� ����� 1��, (type) => ���׿����� (�켱 ������ �� ������!)
											// Math.random() => 0 <= n <1 (0.000000xxx1 ~ 0.999999xx)
			int num= (int)(Math.random()*size)+1;
			list.add(num);		// int -> Integer
		}
		
		// ����� �����͸� ���
		printItem(list);
		System.out.println("=".repeat(10));
		System.out.println("list�� ����: " +list.size());
	}
	
	
	
	public static void arrayListTest() {
		// [1] ArrayList<E>
		ArrayList<String> arr = new ArrayList<>();
		
		//	������ �߰�: add
		arr.add("�ѽ�(����â��)");		// ���� �迭���� ������ �߰� ��: arr2[i] = "�ѽ�(����â��)"
		arr.add("������");
		arr.add("�����");
		
		//	������ ��ȸ: get
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		//	������ ����: remove
		arr.remove(1);		// �ι�° ��ġ�� ������("������") ����
		System.out.println("-".repeat(10)); 	// ���ڿ�.repeat(int count) : �ش� ���ڿ��� count��ŭ �ݺ��Ͽ� ���ڿ� ��ȯ
		for(String item : arr) {
			System.out.println(item);
		}
		
		// ������ �߰� (���ϴ� ��ġ��) : add(int index, E element)
		arr.add(1, "���");	 		// �ι�° ��ġ�� ������ �߰�
		
		System.out.println("-".repeat(10));
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		System.out.println("-".repeat(10));
		Iterator<String> iterator = arr.iterator();		// Iterator<E> ���������� = List�� Set�� ����������.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-".repeat(10));
		printItem(arr);
		
		//	������ ���� (������ ��ġ��) : set(int index, E element)
		System.out.println("-".repeat(10));
		arr.set(1, "�����");
		printItem(arr);
	}

		
	
	
	// printItem �޼ҵ� : �ߺ� �����ϱ� ���� ����. ����Ʈ �� ������ ���
	public static <E> void printItem(List<E> list) {	// ���׸� �޼ҵ� ����
			// �������̽��� ������ Ŭ������ �ν��Ͻ��� �Ű������� ���� ����!
			// List<E> list = new ArrayList<>();
			// List<E> list = new LinkedList<>();
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+"��°: "+list.get(i));
		}
			
	}
}
