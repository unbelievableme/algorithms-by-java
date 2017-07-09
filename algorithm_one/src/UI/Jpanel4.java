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

import Listener.BackTrackintMethodListener;

public class Jpanel4 {
	public static ArrayList<JButton> JBlist = new ArrayList<JButton>();
	public static ArrayList<JTextField> JTlist = new ArrayList<JTextField>();
	public static JTextArea jta = new JTextArea(8, 50);

	public static JPanel getBackJPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1));
		jp.add(get1());
		jp.add(getD5());
		BackTrackintMethodListener btml = new BackTrackintMethodListener();
		for (int i = 0; i < JBlist.size(); i++) {
			JBlist.get(i).addActionListener(btml);
		}
		return jp;
	}

	public static JPanel get1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("回溯法解决八皇后问题"));
		JLabel jl = new JLabel("求解");
		jp.add(jl);
		JTextField jt = new JTextField(4);
		jp.add(jt);
		JTlist.add(jt);
		JLabel jl1 = new JLabel("皇后问题");
		jp.add(jl1);
		String str[] = new String[] { "计算", "清空" };
		for (int i = 0; i < str.length; i++) {
			JButton jb = new JButton(str[i]);
			jp.add(jb);
			JBlist.add(jb);
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
}
