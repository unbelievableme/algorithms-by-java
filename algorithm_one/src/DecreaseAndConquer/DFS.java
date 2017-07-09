package DecreaseAndConquer;

import java.util.ArrayList;

public class DFS {
	public static ArrayList<String> str = new ArrayList<String>();

	public void Dfs(constructGraphicsMatrix con, int j) {
		// 标记为已经访问的节点
		con.setFlag(j, true);
		int jj = j + 1;
		str.add(("V" + jj).toString());
		for (int i = 0; i < con.getLength(); i++) {
			if (con.getEdge(j, i) > 0 && con.getFlag(i) == false) {
				Dfs(con, i);
			}
		}
	}

	public int traverse(constructGraphicsMatrix con) {
		// 联通分支数
		int liantongshu = 0;
		for (int i = 0; i < con.getLength(); i++) {
			if (con.getFlag(i) == false) {
				liantongshu++;
				Dfs(con, i);
				System.out.println(" ");
			}
		}
		return liantongshu;
	}
}