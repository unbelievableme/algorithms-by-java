package DivideAndConquer;

import java.util.ArrayList;

public class PointProblem {

	// �Ե㰴�պ������������
	public point[] pointsortX(point p[]) {
		point p1[] = new PointquickSort().QuickSort(p, 0, p.length - 1);
		return p1;
	}

	// ����԰����������������
	public static point[] pointsortY(ArrayList<point> ar) {
		point p[] = new point[ar.size()];
		for (int i = 0; i < ar.size(); i++) {
			p[i] = ar.get(i);
		}
		point p1[] = new PointquickSortY().QuickSort(p, 0, p.length - 1);
		return p1;
	}

	// ����̾���
	public static double minDistance(point[] ps, int l, int r) {
		// һ�����ʱ��ȥ�����
		if (l == r) {
			return Double.MAX_VALUE;
		}
		// �������ʱ�򷵻ؾ���ֵ
		if (l + 1 == r) {
			return point.getDistance(ps[l], ps[r]);
		}
		// ���м仮��
		int center = l + (r - l) / 2;
		// ���Σ��ֱ�����ߺ��ұߵ���Сֵ
		double dis1 = minDistance(ps, l, center);
		double dis2 = minDistance(ps, center + 1, r);
		// ������Ҿ�����Сֵ
		double minDis = Math.min(dis1, dis2);
		ArrayList<point> nearPoints = new ArrayList<>();
		// ѡ����2d��ȴ�����ĵ�
		for (point p : ps) {
			// ѡ����2d��ȴ�����ĵ�
			if (Math.abs(ps[center].x - p.x) <= minDis) {
				nearPoints.add(p);
			}
		}
		// ����Щ�㰴��Y��������
		point p1[] = pointsortY(nearPoints);
		for (int i = 0; i < p1.length; i++) {
			for (int j = i + 1; j < p1.length; j++) {
				if (p1[j].getY() - p1[i].getY() > minDis) {
					break;// Ԫ��y+1��Ԫ��i��Զ,û��Ҫ�����Ƚ�
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

// �Ե�԰���X�����������ڲ���
class PointquickSort {
	// �����������ֵ�ֵ
	public void swap(point a[], int i, int j) {
		point t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// ��������
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
		int j = r + 1;// ��ס��������±�
		while (i < j) {
			// ��������ɨ���ҳ�����p����
			while (a[++i].getX() < p) {
				// �ж��Ƿ�Խ��
				if (i == r) {
					break;
				}
			}
			// ��������ɨ���ҳ�С��p����
			while (a[--j].getX() > p) {
				// �ж��Ƿ�Խ��
				if (j == 0) {
					break;
				}
			}
			swap(a, i, j);

		}
		// �������һ�ν���
		swap(a, i, j);
		swap(a, l, j);
		return j;
	}

}

// �Ե�԰���Y���������
class PointquickSortY {
	// �����������ֵ�ֵ
	public void swap(point a[], int i, int j) {
		point t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// ��������
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
		int j = r + 1;// ��ס��������±�
		while (i < j) {
			// ��������ɨ���ҳ�����p����
			while (a[++i].getY() < p) {
				// �ж��Ƿ�Խ��
				if (i == r) {
					break;
				}
			}
			// ��������ɨ���ҳ�С��p����
			while (a[--j].getY() > p) {
				// �ж��Ƿ�Խ��
				if (j == 0) {
					break;
				}
			}
			swap(a, i, j);

		}
		// �������һ�ν���
		swap(a, i, j);
		swap(a, l, j);
		return j;
	}

}