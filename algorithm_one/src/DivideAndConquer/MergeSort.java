package DivideAndConquer;

public class MergeSort {
	public void Mergesort(int a[], int n) {
		// ��n��1���бȽϣ��ݹ�ĳ���
		if (n > 1) {
			int b[] = new int[getxiajieN(n)];
			for (int i = 0; i < b.length; i++) {
				b[i] = a[i];
			}
			int c[] = new int[getshangjieN(n)];
			for (int i = 0; i < c.length; i++) {
				c[i] = a[getxiajieN(n) + i];
			}
			// ���еݹ�
			Mergesort(b, getxiajieN(n));
			Mergesort(c, getshangjieN(n));
			int p = b.length;
			int q = c.length;
			int m = p + q;
			Merge(b, c, a, p, q, m);
		}
	}

	// ��ò�����n/2����ֵ
	public int getxiajieN(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else
			return (n - 1) / 2;
	}

	// ��ò�С��n/2����ֵ
	public int getshangjieN(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return (n + 1) / 2;
		}
	}

	// p q m�ֱ���b c a ����ĳ���
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
			// ��c������������д��a��attention��j<q ������j<q-1
			for (; j < q; j++) {
				a[k++] = c[j];
			}
		} else {
			// ��b������������д��a
			for (; i < p; i++) {
				a[k++] = b[i];
			}
		}

	}

}
