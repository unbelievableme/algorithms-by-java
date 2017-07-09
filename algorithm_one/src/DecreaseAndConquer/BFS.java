package DecreaseAndConquer;

import java.util.ArrayList;

public class BFS {
	public void Bfs(constructGraphicsMatrix con) {
		ArrayList a = new ArrayList();
		a.add("V3");
		con.setFlag(2, true);
		while (a.isEmpty() == false) {
			// 记住即将删除的节点
			String re = a.remove(0).toString();
			// 将节点名称转化为矩阵编号
			int aa = Integer.parseInt(re.substring(1, 2));
			// 输出节点
			System.out.println(re);
			for (int i = 0; i < 4; i++) {
				// 判断是否有边的同时判断节点是否已经被访问了
				if (con.getEdge(aa - 1, i) > 0 && con.getFlag(i) == false) {
					a.add(con.getNode(i));
				}
			}
		}

	}
}
