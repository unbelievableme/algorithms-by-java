package DynamicProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bagProblem {
	// 物品链表
	public static ArrayList<Item> WItemList = new ArrayList<Item>();
	// 价值最大二位数组表,a[i][j]表示前i+1个物品总重量为j的最大价值
	private static int Max_value[][];
	// 默认定义背包能装的最大容量为10
	private static int Max_weight = 10;

	// 物品类
	static class Item {
		// 物品编号
		private int id;
		// 重量
		private int weight;
		// 价值
		private int value;

		public Item() {

		}

		public Item(int id, int weight, int value) {
			this.id = id;
			this.weight = weight;
			this.value = value;
			// 每实例化一个Item就在背包中添加一个项目
			bagProblem.addItem(this);
		}

		public int getWeight() {
			return this.weight;
		}

		public int getValue() {
			return this.value;
		}
	}

	// 动态规划生成二维表 过程
	static class PackBag {
		// 物品编号背包
		ArrayList<Item> ItemList = new ArrayList<Item>();
		// 用于记住二维表
		int a[][];

		public PackBag(int prior_id, int total_weight) {
			addItem(prior_id);
			// 记住二维表，方便函数中的应用
			a = bagProblem.Max_value;
		}

		// 获得前prior_id总重量为total_weight的物品的最大价值
		public int getMaxValue(int prior_id, int total_weight) {
			// 初始化表格项：只放入前一个物品
			if (prior_id == 1) {
				if (total_weight < WItemList.get(0).getWeight())
					return 0;
				else
					return WItemList.get(0).getValue();
			} else if (prior_id <= WItemList.size()) {
				int preV = 0;
				// 判断总重量是否大于第i个物品的重量
				if (total_weight >= ItemList.get(prior_id - 1).getWeight()) {
					// 假设包含第i个物品
					preV = ItemList.get(prior_id - 1).getValue()
							+ a[prior_id - 2][total_weight - ItemList.get(prior_id - 1).getWeight()];
				}
				// 不包含第i个物品的重量
				int not_preV = a[prior_id - 1][total_weight];
				// 返回preV和not_preV中的最大数
				return (preV > not_preV) ? preV : not_preV;
			}
			// 如果prior_id输入不合法返回-1
			return -1;
		}

		// 将packBag的maxvalue记录到二维表中去
		public void MaxValueToArray(int prior_id, int total_weight) {
			a[prior_id - 1][total_weight] = getMaxValue(prior_id, total_weight);
		}

		// 添加编号为前prior_id的物品到arrayList中去
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

	// 初始化二位数组
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
			// 读文件
			FileInputStream fl = new FileInputStream(new File("bag.txt"));
			InputStreamReader ir = new InputStreamReader(fl);
			BufferedReader bf = new BufferedReader(ir);
			String str = "";
			bf.readLine();
			// 初始化物品
			while ((str = bf.readLine()) != null) {
				String strr[] = str.split(" ");
				Item i = new Item(Integer.parseInt(strr[0]), Integer.parseInt(strr[1]), Integer.parseInt(strr[2]));
			}
			// 初始化二维表
		} catch (Exception e) {

		}
	}

	public void solveProblem(int max_weight) {
		bagProblem.initMax_value(max_weight);
		// 填充二维表
		for (int i = 0; i < WItemList.size(); i++) {
			for (int j = 1; j < Max_weight + 1; j++) {
				PackBag p = new PackBag(i + 1, j);
				p.MaxValueToArray(i + 1, j);
			}
		}
	}

	// 返回二维表
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
