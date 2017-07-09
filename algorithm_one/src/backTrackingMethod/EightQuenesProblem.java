package backTrackingMethod;

public class EightQuenesProblem {
	private int solvenum = 0;
	// �ʺ�ĸ���
	private int queensNum = 8;
	private StringBuffer sb = new StringBuffer(1000);
	// column[i] = j ��ʾ�� i �еĵ� j �з���һ���ʺ�
	private int[] queens;

	// rowExists[i] = true ��ʾ�� i ���лʺ�
	private boolean[] rowExists;

	// a[i] = true ��ʾ�Ҹ���͵ĵ� i ��б���лʺ�
	private boolean[] a;

	// b[i] = true ��ʾ����ҵ͵ĵ� i ��б���лʺ�
	private boolean[] b;

	public EightQuenesProblem(int i) {
		// TODO Auto-generated constructor stub
		init(i);
	}

	private void setqueenSize(int i) {
		this.queensNum = i;
	}

	// ��ʼ������
	private void init(int ii) {
		setqueenSize(ii);
		// ��i��û�ʺ�
		queens = new int[queensNum + 1];
		rowExists = new boolean[queensNum + 1];
		a = new boolean[queensNum * 2];
		b = new boolean[queensNum * 2];
		for (int i = 0; i < queensNum + 1; i++) {
			rowExists[i] = false;
		}

		// �Խ�����û�лʺ�
		for (int i = 0; i < queensNum * 2; i++) {
			a[i] = b[i] = false;
		}
	}

	// �жϸ�λ���Ƿ��Ѿ�����һ���ʺ�,�����򷵻� true
	private boolean isExists(int row, int col) {
		return (rowExists[row] || a[row + col - 1] || b[queensNum + col - row]);
	}

	// �����������Է��ûʺ�
	public StringBuffer testing(int column) {
		// ����ÿһ��
		for (int row = 1; row < queensNum + 1; row++) {
			// ����� row �е� column �п��Է��ûʺ�
			if (!isExists(row, column)) {
				// ���õ� row �е� column ���лʺ�
				queens[column] = row;
				// �����Ե� row �е� column ��Ϊ������б�߲��ɷ��ûʺ�
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = true;

				// ȫ�����Թ�����ӡ
				if (column == queensNum) {
					for (int col = 1; col <= queensNum; col++) {
						// System.out.print("(" + col + "," + queens[col] + ")
						// ");
						sb.append(("(" + col + "," + queens[col] + ")  "));
						solvenum++;
					}
					// System.out.println();
					sb.append("\r\n");
				} else {
					// ������һ�еĻʺ�
					testing(column + 1);
				}
				// ������һ�������õĻʺ󣬼�����
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = false;
			}
		}
		return sb;
	}

	// ����
	public static void main(String[] args) {
		EightQuenesProblem queen = new EightQuenesProblem(4);
		// queen.init();
		// �ӵ� 1 �п�ʼ���
		System.out.println(queen.testing(1));
	}
}
