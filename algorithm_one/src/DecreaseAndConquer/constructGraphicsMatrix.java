package DecreaseAndConquer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class constructGraphicsMatrix {
	// ���㼯��
	private ArrayList array;
	// ����ߵ�Ȩֵ����
	private int matrix[][];
	// ���ڼ�¼�ڵ��Ƿ񱻷��ʹ�
	private boolean flag[];

	public void initMatrixSize(int length) {
		// ��ʼ���ڵ�����
		array = new ArrayList(length);
		// ��ʼ���ڵ����flag
		flag = new boolean[length];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
		}
		// ��ʼ���ڽӾ���
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

	// ��ýڵ�i������
	public Object getNode(int index) {
		return array.get(index);
	}

	// ��a��b֮�����ȨֵΪc�ı�
	public void insertEdge(int a, int b, int c) {
		// �൱��������ͼ
		matrix[a][b] = c;
		matrix[b][a] = c;
	}

	// ���Ȩֵ
	public int getEdge(int a, int b) {
		return matrix[a][b];
	}

	// ɾ����
	public void deleteEdege(int a, int b) {
		matrix[a][b] = 0;
		matrix[b][a] = 0;
	}

	// ����flagֵ
	public void setFlag(int index, boolean b) {
		flag[index] = b;
	}

	// ���ĳ���ڵ��flag��ֵ
	public boolean getFlag(int index) {
		return flag[index];
	}

	// ���ļ���ʼ��Graphics
	public constructGraphicsMatrix readFile() {
		try {
			// InputStream-Reader-BufferedReader��ȡ�ļ�
			FileInputStream fi = new FileInputStream(new File("initGraphics.txt"));
			InputStreamReader reader = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(reader);
			// �������ڵ�
			String str[] = br.readLine().split("��");
			String Node = str[1];
			String node[] = Node.split(",");
			this.initMatrixSize(node.length);
			for (int i = 0; i < node.length; i++) {
				this.insertNode(node[i]);
			}
			// ��������
			String str1[] = br.readLine().split("��");
			String bian = str1[1];
			String[] bianb = bian.split(",");
			for (int i = 0; i < bianb.length; i++) {
				String strr[] = bianb[i].split("-");
				// �ֱ��ȡa��b��c��������
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
