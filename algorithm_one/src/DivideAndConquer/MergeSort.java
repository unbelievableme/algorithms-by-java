package DivideAndConquer;

public class MergeSort {
	public void Mergesort(int a[], int n) {
		// 将n与1进行比较，递归的出口
		if (n > 1) {
			int b[] = new int[getxiajieN(n)];
			for (int i = 0; i < b.length; i++) {
				b[i] = a[i];
			}
			int c[] = new int[getshangjieN(n)];
			for (int i = 0; i < c.length; i++) {
				c[i] = a[getxiajieN(n) + i];
			}
			// 进行递归
			Mergesort(b, getxiajieN(n));
			Mergesort(c, getshangjieN(n));
			int p = b.length;
			int q = c.length;
			int m = p + q;
			Merge(b, c, a, p, q, m);
		}
	}

	// 获得不大于n/2的数值
	public int getxiajieN(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else
			return (n - 1) / 2;
	}

	// 获得不小于n/2的数值
	public int getshangjieN(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return (n + 1) / 2;
		}
	}

	// p q m分别是b c a 数组的长度
	public void Merge(int b[], int c[], int a[], int p, int q, int m) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < p && j < q) {
			if (b[i] >= c[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = c[j++];
			}
		}
		if (i == p) {
			// 将c数组其他数字写入a，attention：j<q 而不是j<q-1
			for (; j < q; j++) {
				a[k++] = c[j];
			}
		} else {
			// 将b数组其他数字写入a
			for (; i < p; i++) {
				a[k++] = b[i];
			}
		}

	}

}
