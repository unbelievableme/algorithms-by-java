package GreedyMethod;

public class Dijkstra {
	private static int M = 10000; // ��·��ͨ
	// ���·�����
	private static StringBuffer minPath = new StringBuffer(1000);
	// ���·��
	private static StringBuffer mindistance = new StringBuffer(1000);

	public static StringBuffer excute(int ii) {
		constructGraphicsMatrix con = new constructGraphicsMatrix().readFile();
		int[][] weight1 = con.getMatrix();
		int start = ii;
		int[] shortPath = dijkstra(weight1, start);

		for (int i = 0; i < shortPath.length; i++) {
			if (shortPath[i] != 1000) {
				mindistance.append("��" + start + "������" + i + "����̾���Ϊ��" + shortPath[i] + "\r\n");
			}
		}
		StringBuffer str = new StringBuffer(1000);
		str.append(minPath.toString());
		str.append("=======================" + "\r\n");
		str.append(mindistance.toString());
		return str;
	}

	public static int[] dijkstra(int[][] weight, int start) {
		// ����һ������ͼ��Ȩ�ؾ��󣬺�һ�������start����0��ţ�������������У�
		// ����һ��int[] ���飬��ʾ��start���������·������
		int n = weight.length; // �������
		int[] shortPath = new int[n]; // ����start��������������·��
		String[] path = new String[n]; // ����start�������������·�����ַ�����ʾ
		for (int i = 0; i < n; i++)
			path[i] = new String(start + "-->" + i);
		int[] visited = new int[n]; // ��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,1��ʾ�����

		// ��ʼ������һ�������Ѿ����
		shortPath[start] = 0;
		visited[start] = 1;

		for (int count = 1; count < n; count++) { // Ҫ����n-1������
			int k = -1; // ѡ��һ�������ʼ����start�����δ��Ƕ���
			int dmin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][i] < dmin) {
					dmin = weight[start][i];
					k = i;
				}
			}

			// ����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·������dmin
			shortPath[k] = dmin;
			visited[k] = 1;

			// ��kΪ�м�㣬������start��δ���ʸ���ľ���
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
					weight[start][i] = weight[start][k] + weight[k][i];
					path[i] = path[k] + "-->" + i;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (shortPath[i] != 1000) {
				minPath.append("��" + start + "������" + i + "�����·��Ϊ��" + path[i] + "\r\n");
			}
		}
		return shortPath;
	}

}