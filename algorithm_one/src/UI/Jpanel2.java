package UI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Listener.DynamicProgramming;

public class Jpanel2 {
	public static ArrayList<JButton> Blist = new ArrayList<JButton>();
	public static ArrayList<JTextField> Tlist = new ArrayList<JTextField>();
	public static JTextArea jta = new JTextArea(8, 50);

	public static JPanel getDynamicJPanel() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("背包问题"));
		jp.add(getD3());
		// 为每个按钮添加相同的监听器，很重要！！！按钮对监听器类里面的变量就有实例化的作用，上下问相关
		DynamicProgramming n = new DynamicProgramming();
		for (int i = 0; i < Blist.size(); i++) {
			Blist.get(i).addActionListener(n);
		}
		return jp;
	}

	public static JPanel getD6() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("最优二叉查找树"));
		JButton jb = new JButton("键 : 概率初始化");
		Blist.add(jb);
		JButton jb1 = new JButton("生成主表和根表");
		Blist.add(jb1);
		jp.add(jb);
		jp.add(jb1);
		return jp;
	}

	public static JPanel getD1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("初始化"));
		JLabel jl = new JLabel("背包载重为：");
		JTextField jt = new JTextField(4);
		jp.add(jl);
		jp.add(jt);
		Tlist.add(jt);
		String str[] = new String[] { "初始化背包物品", "生成动态表", "清空" };
		for (int i = 0; i < str.length; i++) {
			JButton jb = new JButton(str[i]);
			jp.add(jb);
			Blist.add(jb);
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

	public static JPanel get2() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1));
		jp.add(getD1());
		jp.add(getD6());
		return jp;
	}

	public static JPanel getD3() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1));
		jp.add(get2());
		jp.add(getD5());
		return jp;
	}
}
