package com.kh.generic.practice1;
// class �����ϴ� ��. ���� �� Ŭ���� ������ �� ctrl+c, ���� �� ��Ű�� ������ �� ctrl+v�ϸ� Ŭ���� �̸� �����ϸ鼭 ���� ����.
// ���׸� Ŭ����
public class ThreeDPrinterG<T> {		// <T> : Ÿ�ԸŰ�����
	// �ʵ�
	// � Ŭ������ Ÿ���̵� �ν��Ͻ� ����
	private T material;		// T: Ÿ�ԸŰ�����

	//getter/setter
	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
}
