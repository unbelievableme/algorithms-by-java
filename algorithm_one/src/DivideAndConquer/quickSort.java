package DivideAndConquer;

public class quickSort {
	// 交换两个数字的值
	public void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 快速排序
	public int[] QuickSort(int a[], int l, int r) {
		if (l < r) {
			int s = Partition(a, l, r);
			QuickSort(a, l, s - 1);
			QuickSort(a, s + 1, r);
		}
		return a;
	}

	public int Partition(int a[], int l, int r) {
		int p = a[l];
		int i = l;
		int j = r + 1;// 记住数组的上下标
		while (i < j) {
			// 从左向右扫描找出大于p的数
			while (a[++i] > p) {
				// 判断是否越界
				if (i == r) {
					break;
				}
			}
			// 从右向右扫描找出小于p的数
			while (a[--j] < p) {
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
