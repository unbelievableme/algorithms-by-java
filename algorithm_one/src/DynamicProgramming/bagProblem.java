package DynamicProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bagProblem {
	// ��Ʒ����
	public static ArrayList<Item> WItemList = new ArrayList<Item>();
	// ��ֵ����λ�����,a[i][j]��ʾǰi+1����Ʒ������Ϊj������ֵ
	private static int Max_value[][];
	// Ĭ�϶��屳����װ���������Ϊ10
	private static int Max_weight = 10;

	// ��Ʒ��
	static class Item {
		// ��Ʒ���
		private int id;
		// ����
		private int weight;
		// ��ֵ
		private int value;

		public Item() {

		}

		public Item(int id, int weight, int value) {
			this.id = id;
			this.weight = weight;
			this.value = value;
			// ÿʵ����һ��Item���ڱ��������һ����Ŀ
			bagProblem.addItem(this);
		}

		public int getWeight() {
			return this.weight;
		}

		public int getValue() {
			return this.value;
		}
	}

	// ��̬�滮���ɶ�ά�� ����
	static class PackBag {
		// ��Ʒ��ű���
		ArrayList<Item> ItemList = new ArrayList<Item>();
		// ���ڼ�ס��ά��
		int a[][];

		public PackBag(int prior_id, int total_weight) {
			addItem(prior_id);
			// ��ס��ά�����㺯���е�Ӧ��
			a = bagProblem.Max_value;
		}

		// ���ǰprior_id������Ϊtotal_weight����Ʒ������ֵ
		public int getMaxValue(int prior_id, int total_weight) {
			// ��ʼ������ֻ����ǰһ����Ʒ
			if (prior_id == 1) {
				if (total_weight < WItemList.get(0).getWeight())
					return 0;
				else
					return WItemList.get(0).getValue();
			} else if (prior_id <= WItemList.size()) {
				int preV = 0;
				// �ж��������Ƿ���ڵ�i����Ʒ������
				if (total_weight >= ItemList.get(prior_id - 1).getWeight()) {
					// ���������i����Ʒ
					preV = ItemList.get(prior_id - 1).getValue()
							+ a[prior_id - 2][total_weight - ItemList.get(prior_id - 1).getWeight()];
				}
				// ��������i����Ʒ������
				int not_preV = a[prior_id - 1][total_weight];
				// ����preV��not_preV�е������
				return (preV > not_preV) ? preV : not_preV;
			}
			// ���prior_id���벻�Ϸ�����-1
			return -1;
		}

		// ��packBag��maxvalue��¼����ά����ȥ
		public void MaxValueToArray(int prior_id, int total_weight) {
			a[prior_id - 1][total_weight] = getMaxValue(prior_id, total_weight);
		}

		// ��ӱ��Ϊǰprior_id����Ʒ��arrayList��ȥ
		public void addItem(int prior_id) {
			if (prior_id <= WItemList.size()) {
				for (int i = 0; i < prior_id; i++) {
					ItemList.add(WItemList.get(i));
				}
			}
		}
	}

	public static void addItem(Item i) {
		WItemList.add(i);
	}

	private static void setMax_weight(int a) {
		Max_weight = a;
	}

	// ��ʼ����λ����
	public static void initMax_value(int max_weight) {
		if (max_weight == 0) {
			Max_value = new int[WItemList.size()][Max_weight + 1];
			return;
		}
		setMax_weight(max_weight);
		Max_value = new int[WItemList.size()][max_weight + 1];
	}

	public void initBag() {
		try {
			// ���ļ�
			FileInputStream fl = new FileInputStream(new File("bag.txt"));
			InputStreamReader ir = new InputStreamReader(fl);
			BufferedReader bf = new BufferedReader(ir);
			String str = "";
			bf.readLine();
			// ��ʼ����Ʒ
			while ((str = bf.readLine()) != null) {
				String strr[] = str.split(" ");
				Item i = new Item(Integer.parseInt(strr[0]), Integer.parseInt(strr[1]), Integer.parseInt(strr[2]));
			}
			// ��ʼ����ά��
		} catch (Exception e) {

		}
	}

	public void solveProblem(int max_weight) {
		bagProblem.initMax_value(max_weight);
		// ����ά��
		for (int i = 0; i < WItemList.size(); i++) {
			for (int j = 1; j < Max_weight + 1; j++) {
				PackBag p = new PackBag(i + 1, j);
				p.MaxValueToArray(i + 1, j);
			}
		}
	}

	// ���ض�ά��
	public int[][] getMax_value_Table() {
		return this.Max_value;
	}

	public static void main(String[] args) {
		bagProblem b = new bagProblem();
		b.initBag();
		b.solveProblem(10);
		System.out.println(Max_value[4][10]);
	}
}
