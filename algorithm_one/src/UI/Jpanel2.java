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
		jp.setBorder(BorderFactory.createTitledBorder("��������"));
		jp.add(getD3());
		// Ϊÿ����ť�����ͬ�ļ�����������Ҫ��������ť�Լ�����������ı�������ʵ���������ã����������
		DynamicProgramming n = new DynamicProgramming();
		for (int i = 0; i < Blist.size(); i++) {
			Blist.get(i).addActionListener(n);
		}
		return jp;
	}

	public static JPanel getD6() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("���Ŷ��������"));
		JButton jb = new JButton("�� : ���ʳ�ʼ��");
		Blist.add(jb);
		JButton jb1 = new JButton("��������͸���");
		Blist.add(jb1);
		jp.add(jb);
		jp.add(jb1);
		return jp;
	}

	public static JPanel getD1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("��ʼ��"));
		JLabel jl = new JLabel("��������Ϊ��");
		JTextField jt = new JTextField(4);
		jp.add(jl);
		jp.add(jt);
		Tlist.add(jt);
		String str[] = new String[] { "��ʼ��������Ʒ", "���ɶ�̬��", "���" };
		for (int i = 0; i < str.length; i++) {
			JButton jb = new JButton(str[i]);
			jp.add(jb);
			Blist.add(jb);
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
