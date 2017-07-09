package DynamicProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

public class BST {
	// ���ĸ���
	private int num;
	// ����hashmap
	private HashMap<Object, Double> keyMap = new HashMap<Object, Double>();
	// ��������
	private Object[] pArray;
	// ���ɵĶ�ά��
	private double keyTable[][];
	// ����
	private int rootTable[][];

	// ��ȡ�ļ����ݳ�ʼ��num����keymap����
	private void readFile() {
		try {
			// ��ȡ�ļ�
			FileInputStream in = new FileInputStream(new File("BST.txt"));
			InputStreamReader is = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(is);
			String str[] = br.readLine().split(" ");
			String strr[] = br.readLine().split(" ");
			// ��ʼ��keyMap
			for (int i = 1; i < str.length; i++) {
				keyMap.put(str[i], Double.parseDouble(strr[i]));
				// System.out.println(keyMap.get(str[i]));
			}
			num = str.length - 1;
		} catch (Exception e) {
		}
	}

	public String generateTable() {
		addTable();
		// ��ʽ��
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.0");
		sb.append("**����**" + "\r\n");
		for (int p = 0; p < num + 1; p++) {
			sb.append("  " + String.valueOf(p) + "  ");
		}
		for (int i = 1; i < keyTable.length; i++) {
			sb.append("\r\n");
			sb.append(String.valueOf(i));
			for (int j = 0; j < num + 1; j++) {
				if (j + 1 >= i) {
					sb.append((df.format(keyTable[i][j]) + "  "));
				} else
					sb.append("     ");
			}
		}
		sb.append("\r\n");
		sb.append("**����**" + "\r\n");
		for (int p = 0; p < num + 1; p++) {
			sb.append(" " + String.valueOf(p) + "  ");
		}
		for (int i = 1; i < rootTable.length; i++) {
			sb.append("\r\n");
			sb.append(String.valueOf(i));
			for (int j = 0; j < num + 1; j++) {
				if (j >= i) {
					sb.append(rootTable[i][j] + "   ");
				} else
					sb.append("    ");
			}
		}
		return sb.toString();
	}

	public void addTable() {
		initTable();
		// ��һ��forѭ�����ƶԽ��ߵĸ���
		for (int j = 2; j <= num; j++) {
			// �ڶ���forѭ����������һ���Խ����ϵ���ֵ
			for (int i = 1; i <= num - j + 1; i++) {
				double min = Double.MAX_VALUE;
				// �������͵��ĸ�forѭ�����ڶ�̬�滮���ɾ������ֵ
				for (int k = i; k <= i + j - 1; k++) {
					double diagonal = 0.0;
					int f = i - 1;
					for (int p = i; p <= i + j - 1; p++) {
						diagonal += (double) pArray[f++];
					}
					double present = keyTable[i][k - 1] + keyTable[k + 1][i + j - 1] + diagonal;
					// �����������ŵĹ���
					if (present <= min) {
						min = present;
						keyTable[i][i + j - 1] = min;
						rootTable[i][i + j - 1] = k;
					}
				}
			}
		}
	}

	public void initTable() {
		readFile();
		// ��ø�������
		pArray = keyMap.values().toArray();
		keyTable = new double[num + 2][num + 1];
		rootTable = new int[num + 2][num + 1];
		// ��ʼ����ά��
		for (int i = 0; i < num + 1; i++) {
			keyTable[i + 1][i] = 0;
			if (i < num) {
				rootTable[i + 1][i + 1] = i + 1;
				keyTable[i + 1][i + 1] = (double) pArray[i];
			}
		}
	}

	public static void main(String[] args) {
		// new BST().readFile();
		System.out.println(new BST().generateTable());
	}
}
