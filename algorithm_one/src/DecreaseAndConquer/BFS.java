package DecreaseAndConquer;

import java.util.ArrayList;

public class BFS {
	public void Bfs(constructGraphicsMatrix con) {
		ArrayList a = new ArrayList();
		a.add("V3");
		con.setFlag(2, true);
		while (a.isEmpty() == false) {
			// ��ס����ɾ���Ľڵ�
			String re = a.remove(0).toString();
			// ���ڵ�����ת��Ϊ������
			int aa = Integer.parseInt(re.substring(1, 2));
			// ����ڵ�
			System.out.println(re);
			for (int i = 0; i < 4; i++) {
				// �ж��Ƿ��бߵ�ͬʱ�жϽڵ��Ƿ��Ѿ���������
				if (con.getEdge(aa - 1, i) > 0 && con.getFlag(i) == false) {
					a.add(con.getNode(i));
				}
			}
		}

	}
}
