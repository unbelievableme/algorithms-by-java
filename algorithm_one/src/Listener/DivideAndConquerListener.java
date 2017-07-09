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
				Jpanel.jta.append("产生的随机数为：");
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
				Jpanel.jta.append("产生的随机点对为：");
				for (int i = 0; i < p.length; i++) {
					Jpanel.jta.append("(" + p[i].getX() + "," + p[i].getY() + ")" + "  ");
				}
			} catch (Exception e1) {
				e1 = new InputException();
			}
			try {
				// 文件一定要放在项目的根目录下面呢
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("随机点对结果为：");
				for (int i = 0; i < p.length; i++) {
					pp.print("(" + p[i].getX() + "," + p[i].getY() + ")" + "  ");
					if ((i + 1) % 10 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("异常");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(2)) {
			// 对尚未初始化随机数的异常处理
			if (a == null) {
				ButtonException a = new ButtonException();
				// return可以终止程序的执行
				return;
			}
			int b[] = new quickSort().QuickSort(a, 0, a.length - 1);
			Jpanel.jta.append("\r\n" + "快速排序结果为：");
			for (int i = 0; i < b.length; i++) {
				Jpanel.jta.append(b[i] + "  ");
			}
			try {
				// 文件一定要放在项目的根目录下面呢
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("快速排序结果为：");
				for (int i = 0; i < b.length; i++) {
					pp.print(b[i] + "   ");
					if ((i + 1) % 12 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("异常");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(3)) {
			// 对尚未初始化随机数的异常处理
			if (a == null) {
				ButtonException a = new ButtonException();
				// return可以终止程序的执行
				return;
			}
			int b[] = a;
			new MergeSort().Mergesort(b, b.length);
			Jpanel.jta.append("\r\n" + "归并排序结果为：");
			for (int i = 0; i < b.length; i++) {
				Jpanel.jta.append(b[i] + "  ");
			}
			try {
				// 文件一定要放在项目的根目录下面呢
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("归并排序结果为：");
				for (int i = 0; i < b.length; i++) {
					pp.print(b[i] + "   ");
					if ((i + 1) % 12 == 0) {
						pp.println(" ");
					}
				}
				aa.close();
				pp.close();
			} catch (Exception e1) {
				System.out.println("异常");
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(4)) {
			// 对尚未初始化随机数的异常处理
			if (a == null) {
				ButtonException a = new ButtonException("点对");
				// return可以终止程序的执行
				return;
			}
			Jpanel.jta.append("\r\n" + "最近点对结果为：");
			Jpanel.jta.append(PointProblem.minDistance(p, 0, p.length - 1) + "  ");
			try {
				// 文件一定要放在项目的根目录下面呢
				FileOutputStream aa = new FileOutputStream(new File("output.txt"));
				PrintStream pp = new PrintStream(aa);
				pp.print("最近点对结果为：");
				pp.print(PointProblem.minDistance(p, 0, p.length - 1) + "  ");
				aa.close();
				pp.close();
			} catch (Exception e1) {
			}
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(6)) {
			Jpanel.jta.setText("");
		} else if (e.getSource() == (JButton) Jpanel.JBlist.get(5)) {
			// 对尚未初始化随机数的异常处理
			if (a == null) {
				ButtonException a = new ButtonException();
				// return可以终止程序的执行
				return;
			}
			int b[] = new quickSort().QuickSort(a, 0, a.length - 1);
			String str = JOptionPane.showInputDialog("请输入需要查找的数值：");
			try {
				int aa = Integer.parseInt(str);
				int bb = new BinarySearch().BinarySearch1(b, aa);
				if (bb == -1) {
					Jpanel.jta.append("\r\n" + "二分检索的结果为：未找到该数值");
				} else
					Jpanel.jta.append("\r\n" + "二分检索的结果为：" + bb);
			} catch (Exception ee) {
				InputException a = new InputException();
			}
		}
	}
}
