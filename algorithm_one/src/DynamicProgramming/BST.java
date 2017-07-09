package DynamicProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

public class BST {
	// 键的个数
	private int num;
	// 键的hashmap
	private HashMap<Object, Double> keyMap = new HashMap<Object, Double>();
	// 概率数组
	private Object[] pArray;
	// 生成的二维表
	private double keyTable[][];
	// 根表
	private int rootTable[][];

	// 读取文件内容初始化num，和keymap变量
	private void readFile() {
		try {
			// 读取文件
			FileInputStream in = new FileInputStream(new File("BST.txt"));
			InputStreamReader is = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(is);
			String str[] = br.readLine().split(" ");
			String strr[] = br.readLine().split(" ");
			// 初始化keyMap
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
		// 格式化
		StringBuffer sb = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.0");
		sb.append("**主表**" + "\r\n");
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
		sb.append("**根表**" + "\r\n");
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
		// 第一个for循环控制对角线的个数
		for (int j = 2; j <= num; j++) {
			// 第二个for循环用于生成一个对角线上的数值
			for (int i = 1; i <= num - j + 1; i++) {
				double min = Double.MAX_VALUE;
				// 第三个和第四个for循环用于动态规划生成具体的数值
				for (int k = i; k <= i + j - 1; k++) {
					double diagonal = 0.0;
					int f = i - 1;
					for (int p = i; p <= i + j - 1; p++) {
						diagonal += (double) pArray[f++];
					}
					double present = keyTable[i][k - 1] + keyTable[k + 1][i + j - 1] + diagonal;
					// 两个表逐渐求优的过程
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
		// 获得概率数组
		pArray = keyMap.values().toArray();
		keyTable = new double[num + 2][num + 1];
		rootTable = new int[num + 2][num + 1];
		// 初始化二维表
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
