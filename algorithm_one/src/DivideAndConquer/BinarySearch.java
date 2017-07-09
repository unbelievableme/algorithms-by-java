package DivideAndConquer;

public class BinarySearch {
	public int BinarySearch1(int a[], int k) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int m = getDivide(l + r);
			if (a[m] == k) {
				return m;
			} else if (a[m] > k) {
				l = m + 1;
				continue;
			} else {
				r = m - 1;
				continue;
			}
		}
		return -1;
	}

	public int getDivide(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return (n - 1) / 2;
		}
	}

}
