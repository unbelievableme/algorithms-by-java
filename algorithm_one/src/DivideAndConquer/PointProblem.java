package DivideAndConquer;

import java.util.ArrayList;

public class PointProblem {

	// 对点按照横坐标进行排序
	public point[] pointsortX(point p[]) {
		point p1[] = new PointquickSort().QuickSort(p, 0, p.length - 1);
		return p1;
	}

	// 将点对按照纵坐标进行排序
	public static point[] pointsortY(ArrayList<point> ar) {
		point p[] = new point[ar.size()];
		for (int i = 0; i < ar.size(); i++) {
			p[i] = ar.get(i);
		}
		point p1[] = new PointquickSortY().QuickSort(p, 0, p.length - 1);
		return p1;
	}

	// 求最短距离
	public static double minDistance(point[] ps, int l, int r) {
		// 一个点的时候去无穷大
		if (l == r) {
			return Double.MAX_VALUE;
		}
		// 两个点的时候返回距离值
		if (l + 1 == r) {
			return point.getDistance(ps[l], ps[r]);
		}
		// 从中间划分
		int center = l + (r - l) / 2;
		// 分治，分别获得左边和右边的最小值
		double dis1 = minDistance(ps, l, center);
		double dis2 = minDistance(ps, center + 1, r);
		// 获得左右距离最小值
		double minDis = Math.min(dis1, dis2);
		ArrayList<point> nearPoints = new ArrayList<>();
		// 选出在2d宽度带里面的点
		for (point p : ps) {
			// 选择在2d宽度带里面的点
			if (Math.abs(ps[center].x - p.x) <= minDis) {
				nearPoints.add(p);
			}
		}
		// 将这些点按照Y坐标排序
		point p1[] = pointsortY(nearPoints);
		for (int i = 0; i < p1.length; i++) {
			for (int j = i + 1; j < p1.length; j++) {
				if (p1[j].getY() - p1[i].getY() > minDis) {
					break;// 元素y+1离元素i更远,没必要继续比较
				}
				double d = point.getDistance(p1[j], p1[i]);
				if (d < minDis) {
					minDis = d;
				}
			}
		}
		return minDis;
	}

}

// 对点对按照X轴进行排序的内部类
class PointquickSort {
	// 交换两个数字的值
	public void swap(point a[], int i, int j) {
		point t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 快速排序
	public point[] QuickSort(point a[], int l, int r) {
		if (l < r) {
			int s = Partition(a, l, r);
			QuickSort(a, l, s - 1);
			QuickSort(a, s + 1, r);
		}
		return a;
	}

	public int Partition(point a[], int l, int r) {
		int p = a[l].getX();
		int i = l;
		int j = r + 1;// 记住数组的上下标
		while (i < j) {
			// 从左向右扫描找出大于p的数
			while (a[++i].getX() < p) {
				// 判断是否越界
				if (i == r) {
					break;
				}
			}
			// 从右向右扫描找出小于p的数
			while (a[--j].getX() > p) {
				// 判断是否越界
				if (j == 0) {
					break;
				}
			}
			swap(a, i, j);

		}
		// 撤销最后一次交换
		swap(a, i, j);
		swap(a, l, j);
		return j;
	}

}

// 对点对按照Y轴进行排序
class PointquickSortY {
	// 交换两个数字的值
	public void swap(point a[], int i, int j) {
		point t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 快速排序
	public point[] QuickSort(point a[], int l, int r) {
		if (l < r) {
			int s = Partition(a, l, r);
			QuickSort(a, l, s - 1);
			QuickSort(a, s + 1, r);
		}
		return a;
	}

	public int Partition(point a[], int l, int r) {
		int p = a[l].getY();
		int i = l;
		int j = r + 1;// 记住数组的上下标
		while (i < j) {
			// 从左向右扫描找出大于p的数
			while (a[++i].getY() < p) {
				// 判断是否越界
				if (i == r) {
					break;
				}
			}
			// 从右向右扫描找出小于p的数
			while (a[--j].getY() > p) {
				// 判断是否越界
				if (j == 0) {
					break;
				}
			}
			swap(a, i, j);

		}
		// 撤销最后一次交换
		swap(a, i, j);
		swap(a, l, j);
		return j;
	}

}