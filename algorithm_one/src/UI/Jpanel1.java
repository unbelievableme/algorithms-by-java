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

import Listener.DecreaseConquerListener;

public class Jpanel1 {
	public static ArrayList<JButton> JBlist = new ArrayList<JButton>();
	public static ArrayList<JTextField> JTlist = new ArrayList<JTextField>();
	public static JTextArea jta = new JTextArea(8, 50);

	public static JPanel getDecreaseJPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1, 20, 30));
		jp.add(getD3());
		jp.add(getD4());
		for (int i = 0; i < JBlist.size(); i++) {
			JBlist.get(i).addActionListener(new DecreaseConquerListener());
		}
		return jp;
	}

	public static JPanel getD1() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("ͼ����"));
		// jp.setLayout(new GridLayout(1, 3, 30, 50));
		String str[] = new String[] { "��ʼ��ͼ", "ͼ����ͨ���ж�", "ͼ����ͨ��ͼ��" };
		for (int i = 0; i < str.length; i++) {
			JButton jb = new JButton(str[i]);
			jp.add(jb);
			JBlist.add(jb);
		}
		return jp;
	}

	public static JPanel getD2() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("���ּ���"));
		String str[] = new String[] { "����", "��С", "���" };
		for (int i = 0; i < str.length; i++) {
			JLabel jl = new JLabel(str[i]);
			JTextField jt = new JTextField(4);
			jp.add(jl);
			jp.add(jt);
			JTlist.add(jt);
		}
		JButton jb0 = new JButton("���������");
		JButton jb1 = new JButton("����");
		JButton jb2 = new JButton("���ּ���");
		JBlist.add(jb0);
		JBlist.add(jb1);
		JBlist.add(jb2);
		jp.add(jb0);
		jp.add(jb1);
		jp.add(jb2);
		return jp;
	}

	public static JPanel getD3() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2, 1, 20, 20));
		jp.add(getD1());
		jp.add(getD2());
		return jp;
	}

	public static JPanel getD4() {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createTitledBorder("������"));
		jta.setLineWrap(true);// �Զ�����
		JScrollPane jsp = new JScrollPane(jta);// ���Ϲ������������Ļ�jta�ͻ�̶���С
		jp.add(jsp);
		return jp;
	}
}
