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

	// ���η����
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
		jp.setBorder(BorderFactory.createTitledBorder("������"));
		jta.setLineWrap(true);// �Զ�����
		JScrollPane jsp = new JScrollPane(jta);// ���Ϲ������������Ļ�jta�ͻ�̶���С
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

	// ��һ��
	public static JPanel getD1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("���������"));
		jp.setLayout(new FlowLayout());
		String str[] = new String[] { "����", "��Сֵ", "���ֵ" };
		for (int i = 0; i < str.length; i++) {
			JLabel j = new JLabel(str[i]);
			JTextField jt = new JTextField(4);
			JTlist.add(jt);
			jp.add(j);
			jp.add(jt);
		}
		JButton jb = new JButton("���������");
		JBlist.add(jb);
		jp.add(jb);
		return jp;
	}

	// �ڶ���
	public static JPanel getD2() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("����������"));
		jp.setLayout(new FlowLayout());
		String str[] = new String[] { "����", "X��Сֵ", "X���ֵ", "Y��Сֵ", "Y���ֵ" };
		for (int i = 0; i < str.length; i++) {
			JLabel j = new JLabel(str[i]);
			JTextField jt = new JTextField(4);
			JTlist.add(jt);
			jp.add(j);
			jp.add(jt);
		}
		JButton jb = new JButton("����������");
		JBlist.add(jb);
		jp.add(jb);
		return jp;
	}

	// ������
	public static JPanel getD3() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("���������"));
		jp.setLayout(new GridLayout(1, 4));
		String str[] = new String[] { "��������", "�鲢����", "������", "���ּ���", "���" };
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
