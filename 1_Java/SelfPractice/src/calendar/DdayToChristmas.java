package calendar;

import java.util.Calendar;

public class DdayToChristmas {

	public static void main(String[] args) {
		//���� : 12/20
		//ũ�������� : 12/25
		//D-5
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal2.get(Calendar.MONTH);
		cal2.set(Calendar.DATE, 25);
		
		int today = cal1.get(Calendar.DAY_OF_YEAR);
		int christmas = cal2.get(Calendar.DAY_OF_YEAR);
		
		int d_Day= christmas - today;
		
		System.out.println("ũ������������ " + d_Day + "�� ���ҽ��ϴ�");
		
	}

}
