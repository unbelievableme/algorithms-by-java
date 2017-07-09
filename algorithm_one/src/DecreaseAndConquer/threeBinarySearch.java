package DecreaseAndConquer;

public class threeBinarySearch {
	public int search(int a[], int b, int c, int d) {
		// µÝ¹éÖÕÖ¹Ìõ¼þ
		if (b > c) {
			return -1;
		}
		int t1 = b + (c - b) / 3;
		int t2 = b + 2 * (c - b) / 3;
		if (a[t1] == d) {
			return t1;
		} else if (a[t2] == d) {
			return t2;
		} else if (d > a[t1]) {
			return search(a, b, t1 - 1, d);
		} else if (d > a[t2]) {
			return search(a, t1 + 1, t2 - 1, d);
		} else
			return search(a, t2 + 1, c, d);
	}

	public static void main(String[] args) {
		int a[] = new int[] { 3, 2, 1 };
		int aa = new threeBinarySearch().search(a, 0, 2, 1);
		System.out.println(aa);
	}

}
