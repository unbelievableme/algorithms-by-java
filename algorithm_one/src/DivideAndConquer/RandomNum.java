package DivideAndConquer;

import java.util.Random;

public class RandomNum {
	public static int[] getRandomNumber(int n, int min, int max) {
		// 产生长度为10-15长度的随机数
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Random().nextInt(min + new Random().nextInt(max - min));
		}
		return a;
	}

	// 获得n个最小横坐标为MinX，最大为MaxX，纵坐标最小为MinY，最大为MaxY的点
	public static point[] getRandomPoint(int n, int MinX, int MaxX, int MinY, int MaxY) {
		// 通过下面的方式初始化注意point类要有一个无参的构造函数
		point p[] = new point[n];
		Random r = new Random();
		int m = MaxX - MinX;
		int q = MaxY - MinY;
		for (int i = 0; i < n; i++) {
			// 尽管在定义数组的时候已经new了，此处的初始化必须还要new
			p[i] = new point(MinX + r.nextInt(m), MinY + r.nextInt(q));
		}
		return p;
	}

}