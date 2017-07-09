package DivideAndConquer;

import java.util.Random;

public class RandomNum {
	public static int[] getRandomNumber(int n, int min, int max) {
		// ��������Ϊ10-15���ȵ������
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Random().nextInt(min + new Random().nextInt(max - min));
		}
		return a;
	}

	// ���n����С������ΪMinX�����ΪMaxX����������СΪMinY�����ΪMaxY�ĵ�
	public static point[] getRandomPoint(int n, int MinX, int MaxX, int MinY, int MaxY) {
		// ͨ������ķ�ʽ��ʼ��ע��point��Ҫ��һ���޲εĹ��캯��
		point p[] = new point[n];
		Random r = new Random();
		int m = MaxX - MinX;
		int q = MaxY - MinY;
		for (int i = 0; i < n; i++) {
			// �����ڶ��������ʱ���Ѿ�new�ˣ��˴��ĳ�ʼ�����뻹Ҫnew
			p[i] = new point(MinX + r.nextInt(m), MinY + r.nextInt(q));
		}
		return p;
	}

}