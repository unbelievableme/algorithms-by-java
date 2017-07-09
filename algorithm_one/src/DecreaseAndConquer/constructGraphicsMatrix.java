package DecreaseAndConquer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class constructGraphicsMatrix {
	// 顶点集合
	private ArrayList array;
	// 矩阵边的权值集合
	private int matrix[][];
	// 用于记录节点是否被访问过
	private boolean flag[];

	public void initMatrixSize(int length) {
		// 初始化节点数组
		array = new ArrayList(length);
		// 初始化节点访问flag
		flag = new boolean[length];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
		}
		// 初始化邻接矩阵
		matrix = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public int getLength() {
		return flag.length;
	}

	public void insertNode(Object o) {
		array.add(o);
	}

	// 获得节点i的数据
	public Object getNode(int index) {
		return array.get(index);
	}

	// 在a与b之间插入权值为c的边
	public void insertEdge(int a, int b, int c) {
		// 相当与是无向图
		matrix[a][b] = c;
		matrix[b][a] = c;
	}

	// 获得权值
	public int getEdge(int a, int b) {
		return matrix[a][b];
	}

	// 删除边
	public void deleteEdege(int a, int b) {
		matrix[a][b] = 0;
		matrix[b][a] = 0;
	}

	// 设置flag值
	public void setFlag(int index, boolean b) {
		flag[index] = b;
	}

	// 获得某个节点的flag数值
	public boolean getFlag(int index) {
		return flag[index];
	}

	// 读文件初始化Graphics
	public constructGraphicsMatrix readFile() {
		try {
			// InputStream-Reader-BufferedReader读取文件
			FileInputStream fi = new FileInputStream(new File("initGraphics.txt"));
			InputStreamReader reader = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(reader);
			// 分析出节点
			String str[] = br.readLine().split("：");
			String Node = str[1];
			String node[] = Node.split(",");
			this.initMatrixSize(node.length);
			for (int i = 0; i < node.length; i++) {
				this.insertNode(node[i]);
			}
			// 分析出边
			String str1[] = br.readLine().split("：");
			String bian = str1[1];
			String[] bianb = bian.split(",");
			for (int i = 0; i < bianb.length; i++) {
				String strr[] = bianb[i].split("-");
				// 分别获取a，b，c三个参数
				int a = Integer.parseInt(strr[0].substring(1, 2));
				int b = Integer.parseInt(strr[1].substring(1, 2));
				int c = Integer.parseInt(strr[2]);
				this.insertEdge(a - 1, b - 1, c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public static void main(String[] args) {
		constructGraphicsMatrix con = new constructGraphicsMatrix().readFile();
		int a = new DFS().traverse(con);
		System.out.println(a);
	}
}
