package GreedyMethod;

public class Dijkstra {
	private static int M = 10000; // 此路不通
	// 最短路径输出
	private static StringBuffer minPath = new StringBuffer(1000);
	// 最短路径
	private static StringBuffer mindistance = new StringBuffer(1000);

	public static StringBuffer excute(int ii) {
		constructGraphicsMatrix con = new constructGraphicsMatrix().readFile();
		int[][] weight1 = con.getMatrix();
		int start = ii;
		int[] shortPath = dijkstra(weight1, start);

		for (int i = 0; i < shortPath.length; i++) {
			if (shortPath[i] != 1000) {
				mindistance.append("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i] + "\r\n");
			}
		}
		StringBuffer str = new StringBuffer(1000);
		str.append(minPath.toString());
		str.append("=======================" + "\r\n");
		str.append(mindistance.toString());
		return str;
	}

	public static int[] dijkstra(int[][] weight, int start) {
		// 接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
		// 返回一个int[] 数组，表示从start到它的最短路径长度
		int n = weight.length; // 顶点个数
		int[] shortPath = new int[n]; // 保存start到其他各点的最短路径
		String[] path = new String[n]; // 保存start到其他各点最短路径的字符串表示
		for (int i = 0; i < n; i++)
			path[i] = new String(start + "-->" + i);
		int[] visited = new int[n]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出

		// 初始化，第一个顶点已经求出
		shortPath[start] = 0;
		visited[start] = 1;

		for (int count = 1; count < n; count++) { // 要加入n-1个顶点
			int k = -1; // 选出一个距离初始顶点start最近的未标记顶点
			int dmin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][i] < dmin) {
					dmin = weight[start][i];
					k = i;
				}
			}

			// 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
			shortPath[k] = dmin;
			visited[k] = 1;

			// 以k为中间点，修正从start到未访问各点的距离
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
					weight[start][i] = weight[start][k] + weight[k][i];
					path[i] = path[k] + "-->" + i;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (shortPath[i] != 1000) {
				minPath.append("从" + start + "出发到" + i + "的最短路径为：" + path[i] + "\r\n");
			}
		}
		return shortPath;
	}

}