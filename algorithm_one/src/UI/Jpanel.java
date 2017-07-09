package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Listener.DivideAndConquerListener;

public class Jpanel {
	public static ArrayList<JButton> JBlist = new ArrayList<JButton>();
	public static ArrayList<JTextField> JTlist = new ArrayList<JTextField>();
	public static JTextArea jta = new JTextArea(8, 50);

	// 分治法面板
	public static JPanel getDivideJPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1, 10, 30));
		jp.add(getD4());
		jp.add(getD5());
		for (int i = 0; i < JBlist.size(); i++) {
			JBlist.get(i).addActionListener(new DivideAndConquerListener());
		}
		return jp;
	}

	public static JPanel getD5() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("输出结果"));
		jta.setLineWrap(true);// 自动换行
		JScrollPane jsp = new JScrollPane(jta);// 加上滚动条，这样的话jta就会固定大小
		jp.add(jsp);
		return jp;
	}

	public static JPanel getD4() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1, 5, 5));
		jp.add(getD1());
		jp.add(getD2());
		jp.add(getD3());
		return jp;
	}

	// 第一行
	public static JPanel getD1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("生成随机数"));
		jp.setLayout(new FlowLayout());
		String str[] = new String[] { "个数", "最小值", "最大值" };
		for (int i = 0; i < str.length; i++) {
			JLabel j = new JLabel(str[i]);
			JTextField jt = new JTextField(4);
			JTlist.add(jt);
			jp.add(j);
			jp.add(jt);
		}
		JButton jb = new JButton("生成随机数");
		JBlist.add(jb);
		jp.add(jb);
		return jp;
	}

	// 第二行
	public static JPanel getD2() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("生成随机点对"));
		jp.setLayout(new FlowLayout());
		String str[] = new String[] { "个数", "X最小值", "X最大值", "Y最小值", "Y最大值" };
		for (int i = 0; i < str.length; i++) {
			JLabel j = new JLabel(str[i]);
			JTextField jt = new JTextField(4);
			JTlist.add(jt);
			jp.add(j);
			jp.add(jt);
		}
		JButton jb = new JButton("生成随机点对");
		JBlist.add(jb);
		jp.add(jb);
		return jp;
	}

	// 第三行
	public static JPanel getD3() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("随机数操作"));
		jp.setLayout(new GridLayout(1, 4));
		String str[] = new String[] { "快速排序", "归并排序", "最近点对", "二分检索", "清空" };
		for (int i = 0; i < str.length; i++) {
			JButton jb = new JButton(str[i]);
			JBlist.add(jb);
			jp.add(jb);

		}
		return jp;
	}

	public static JPanel getBackJPanel() {
		return null;
	}

}
