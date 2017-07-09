package backTrackingMethod;

public class EightQuenesProblem {
	private int solvenum = 0;
	// 皇后的个数
	private int queensNum = 8;
	private StringBuffer sb = new StringBuffer(1000);
	// column[i] = j 表示第 i 列的第 j 行放置一个皇后
	private int[] queens;

	// rowExists[i] = true 表示第 i 行有皇后
	private boolean[] rowExists;

	// a[i] = true 表示右高左低的第 i 条斜线有皇后
	private boolean[] a;

	// b[i] = true 表示左高右低的第 i 条斜线有皇后
	private boolean[] b;

	public EightQuenesProblem(int i) {
		// TODO Auto-generated constructor stub
		init(i);
	}

	private void setqueenSize(int i) {
		this.queensNum = i;
	}

	// 初始化变量
	private void init(int ii) {
		setqueenSize(ii);
		// 第i行没皇后
		queens = new int[queensNum + 1];
		rowExists = new boolean[queensNum + 1];
		a = new boolean[queensNum * 2];
		b = new boolean[queensNum * 2];
		for (int i = 0; i < queensNum + 1; i++) {
			rowExists[i] = false;
		}

		// 对角线上没有皇后
		for (int i = 0; i < queensNum * 2; i++) {
			a[i] = b[i] = false;
		}
	}

	// 判断该位置是否已经存在一个皇后,存在则返回 true
	private boolean isExists(int row, int col) {
		return (rowExists[row] || a[row + col - 1] || b[queensNum + col - row]);
	}

	// 主方法：测试放置皇后
	public StringBuffer testing(int column) {
		// 遍历每一行
		for (int row = 1; row < queensNum + 1; row++) {
			// 如果第 row 行第 column 列可以放置皇后
			if (!isExists(row, column)) {
				// 设置第 row 行第 column 列有皇后
				queens[column] = row;
				// 设置以第 row 行第 column 列为交叉点的斜线不可放置皇后
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = true;

				// 全部尝试过，打印
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
					// 放置下一列的皇后
					testing(column + 1);
				}
				// 撤销上一步所放置的皇后，即回溯
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = false;
			}
		}
		return sb;
	}

	// 测试
	public static void main(String[] args) {
		EightQuenesProblem queen = new EightQuenesProblem(4);
		// queen.init();
		// 从第 1 列开始求解
		System.out.println(queen.testing(1));
	}
}
