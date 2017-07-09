package DivideAndConquer;

public class quickSort {
	// �����������ֵ�ֵ
	public void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// ��������
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
		int j = r + 1;// ��ס��������±�
		while (i < j) {
			// ��������ɨ���ҳ�����p����
			while (a[++i] > p) {
				// �ж��Ƿ�Խ��
				if (i == r) {
					break;
				}
			}
			// ��������ɨ���ҳ�С��p����
			while (a[--j] < p) {
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
