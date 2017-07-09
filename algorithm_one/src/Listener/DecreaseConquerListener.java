package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DecreaseAndConquer.DFS;
import DecreaseAndConquer.constructGraphicsMatrix;
import DecreaseAndConquer.threeBinarySearch;
import DivideAndConquer.RandomNum;
import DivideAndConquer.quickSort;
import Exception.InitException;
import UI.Jpanel1;

public class DecreaseConquerListener implements ActionListener {
	// ��ʼ����ͼ
	static constructGraphicsMatrix con = null;
	// �������
	static int a[];
	// �ź��������
	static int b[];
	// ��ͨ��ͼ��Ŀ
	static int an;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Jpanel1.JBlist.get(0)) {
			con = new constructGraphicsMatrix().readFile();
			// int ad = new DFS().traverse(con);
			// System.out.println(ad);
			Jpanel1.jta.append("ͼ��ʼ���ɹ���");
		} else if (e.getSource() == Jpanel1.JBlist.get(1)) {
			try {
				DFS d = new DFS();
				an = d.traverse(con);
				ArrayList str = d.str;
				Jpanel1.jta.append("\r\n");
				Jpanel1.jta.append("ͼ�ı������Ϊ��");
				for (int i = 0; i < str.size(); i++) {
					Jpanel1.jta.append(str.get(i).toString() + "    ");
				}
				if (an == 1) {
					Jpanel1.jta.append("\r\n");
					Jpanel1.jta.append("��ͼ����ͨ��!");
				} else {
					Jpanel1.jta.append("\r\n");
					Jpanel1.jta.append("��ͼ�ǲ���ͨ��!");
				}
			} catch (Exception ee) {
				InitException in = new InitException();
			}
		} else if (e.getSource() == Jpanel1.JBlist.get(2)) {
			try {
				Jpanel1.jta.append("\r\n");
				Jpanel1.jta.append("ͼ����ͨ��ͼ����Ϊ��" + an);
			} catch (Exception ee) {
				InitException i = new InitException();
			}
		} else if (e.getSource() == Jpanel1.JBlist.get(3)) {
			int n = Integer.parseInt(Jpanel1.JTlist.get(0).getText());
			int min = Integer.parseInt(Jpanel1.JTlist.get(1).getText());
			int max = Integer.parseInt(Jpanel1.JTlist.get(2).getText());
			a = RandomNum.getRandomNumber(n, min, max);
			Jpanel1.jta.append("\r\n");
			Jpanel1.jta.append("�����������Ϊ��");
			for (int i = 0; i < a.length; i++) {
				Jpanel1.jta.append(a[i] + "  ");
			}

		} else if (e.getSource() == Jpanel1.JBlist.get(4)) {
			b = new quickSort().QuickSort(a, 0, a.length - 1);
			Jpanel1.jta.append("\r\n" + "������Ϊ��");
			for (int i = 0; i < b.length; i++) {
				Jpanel1.jta.append(b[i] + "  ");
			}
		} else {
			String str = JOptionPane.showInputDialog("��Ҫ����������");
			int aa = Integer.parseInt(str);
			Jpanel1.jta.append("\r\n");
			if (aa == -1) {
				Jpanel1.jta.append("δ������������");
			} else {
				Jpanel1.jta.append("����λ��Ϊ��" + new threeBinarySearch().search(b, 0, b.length - 1, aa));
			}
		}
	}

}
