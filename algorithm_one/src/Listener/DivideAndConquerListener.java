package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DivideAndConquer.BinarySearch;
import DivideAndConquer.MergeSort;
import DivideAndConquer.PointProblem;
import DivideAndConquer.RandomNum;
import DivideAndConquer.point;
import DivideAndConquer.quickSort;
import Exception.ButtonException;
import Exception.InputException;
import UI.Jpanel;

public class DivideAndConquerListener implements ActionListener {
	public static int a[];
	public static point p[];

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (JButton) Jpanel.JBlist.get(0)) {
			try {
				int n = Integer.parseInt(Jpanel.JTlist.get(0).getText());
				int min = Integer.parseInt(Jpanel.JTlist.get(1).getText());
				int max = Integer.parseInt(Jpanel.JTlist.get(2).getText());
				a = RandomNum.getRandomNumber(n, min, max);
				Jpanel.jta.append("�����������Ϊ��");
				for (int i = 0; i < a.length; i++) {
					Jpanel.jta.append(a[i] + "  ");
				}
			} catch (Exception e1) {
				e1 = new InputException();
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(1)) {
			try {
				int n = Integer.parseInt(Jpanel.JTlist.get(3).getText());
				int xmin = Integer.parseInt(Jpanel.JTlist.get(4).getText());
				int xmax = Integer.parseInt(Jpanel.JTlist.get(5).getText());
				int ymin = Integer.parseInt(Jpanel.JTlist.get(6).getText());
				int ymax = Integer.parseInt(Jpanel.JTlist.get(7).getText());
				p = RandomNum.getRandomPoint(n, xmin, xmax, ymin, ymax);
				Jpanel.jta.append("\r\n");
				Jpanel.jta.append("������������Ϊ��");
				for (int i = 0; i < p.length; i++) {
					Jpanel.jta.append("(" + p[i].getX() + "," + p[i].getY() + ")" + "  ");
				}
			} catch (Exception e1) {
				e1 = new InputException();
			}
			try {
				// �ļ�һ��Ҫ������Ŀ�ĸ�Ŀ¼������
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("�����Խ��Ϊ��");
				for (int i = 0; i < p.length; i++) {
					pp.print("(" + p[i].getX() + "," + p[i].getY() + ")" + "  ");
					if ((i + 1) % 10 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("�쳣");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(2)) {
			// ����δ��ʼ����������쳣����
			if (a == null) {
				ButtonException a = new ButtonException();
				// return������ֹ�����ִ��
				return;
			}
			int b[] = new quickSort().QuickSort(a, 0, a.length - 1);
			Jpanel.jta.append("\r\n" + "����������Ϊ��");
			for (int i = 0; i < b.length; i++) {
				Jpanel.jta.append(b[i] + "  ");
			}
			try {
				// �ļ�һ��Ҫ������Ŀ�ĸ�Ŀ¼������
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("����������Ϊ��");
				for (int i = 0; i < b.length; i++) {
					pp.print(b[i] + "   ");
					if ((i + 1) % 12 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("�쳣");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(3)) {
			// ����δ��ʼ����������쳣����
			if (a == null) {
				ButtonException a = new ButtonException();
				// return������ֹ�����ִ��
				return;
			}
			int b[] = a;
			new MergeSort().Mergesort(b, b.length);
			Jpanel.jta.append("\r\n" + "�鲢������Ϊ��");
			for (int i = 0; i < b.length; i++) {
				Jpanel.jta.append(b[i] + "  ");
			}
			try {
				// �ļ�һ��Ҫ������Ŀ�ĸ�Ŀ¼������
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("�鲢������Ϊ��");
				for (int i = 0; i < b.length; i++) {
					pp.print(b[i] + "   ");
					if ((i + 1) % 12 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("�쳣");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(4)) {
			// ����δ��ʼ����������쳣����
			if (a == null) {
				ButtonException a = new ButtonException("���");
				// return������ֹ�����ִ��
				return;
			}
			Jpanel.jta.append("\r\n" + "�����Խ��Ϊ��");
			Jpanel.jta.append(PointProblem.minDistance(p, 0, p.length - 1) + "  ");
			try {
				// �ļ�һ��Ҫ������Ŀ�ĸ�Ŀ¼������
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("�����Խ��Ϊ��");
				pp.print(PointProblem.minDistance(p, 0, p.length - 1) + "  ");
				aa.close();
				pp.close();
			} catch (Exception e1) {
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(6)) {
			Jpanel.jta.setText("");
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(5)) {
			// ����δ��ʼ����������쳣����
			if (a == null) {
				ButtonException a = new ButtonException();
				// return������ֹ�����ִ��
				return;
			}
			int b[] = new quickSort().QuickSort(a, 0, a.length - 1);
			String str = JOptionPane.showInputDialog("��������Ҫ���ҵ���ֵ��");
			try {
				int aa = Integer.parseInt(str);
				int bb = new BinarySearch().BinarySearch1(b, aa);
				if (bb == -1) {
					Jpanel.jta.append("\r\n" + "���ּ����Ľ��Ϊ��δ�ҵ�����ֵ");
				} else
					Jpanel.jta.append("\r\n" + "���ּ����Ľ��Ϊ��" + bb);
			} catch (Exception ee) {
				InputException a = new InputException();
			}
		}
	}
}
