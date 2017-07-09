package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JTextArea;

import DynamicProgramming.BST;
import DynamicProgramming.bagProblem;
import UI.Jpanel2;

public class DynamicProgramming implements ActionListener {
	private JTextArea jt = Jpanel2.jta;
	private bagProblem b;
	private BST bst;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (JButton) Jpanel2.Blist.get(0)) {
			b = new bagProblem();
			b.initBag();
			jt.append("��ʼ���ɹ�!" + "\r\n");
		} else if (e.getSource() == (JButton) Jpanel2.Blist.get(1)) {
			int max_weight = Integer.parseInt(Jpanel2.Tlist.get(0).getText());
			b.solveProblem(max_weight);
			int array[][] = b.getMax_value_Table();
			int result = array[bagProblem.WItemList.size() - 1][max_weight];
			try {
				PrintStream ps = new PrintStream(new FileOutputStream("bagSolveResult.txt"));
				StringBuffer sb = new StringBuffer(2 * max_weight);
				jt.append(String.valueOf("   " + "����" + "   " + "   " + "   "));
				for (int m = 1; m <= max_weight; m++) {
					jt.append(String.valueOf(m + "   "));
					sb.append(String.valueOf(m + "   "));
				}
				jt.append(String.valueOf("\r\n"));
				sb.append(String.valueOf("\r\n"));
				for (int i = 0; i < bagProblem.WItemList.size(); i++) {
					jt.append("ǰ" + (i + 1) + "����Ʒ" + "   ");
					sb.append("ǰ" + (i + 1) + "����Ʒ" + "   ");
					for (int j = 1; j <= max_weight; j++) {
						jt.append(String.valueOf(array[i][j]) + "   ");
						sb.append(String.valueOf(array[i][j]) + "   ");
					}
					jt.append("\r\n");
					sb.append("\r\n");
				}
				jt.append("������װ����Ʒ������ֵΪ��" + String.valueOf(result) + "\r\n");
				ps.append("������װ����Ʒ������ֵΪ��" + String.valueOf(result) + "\r\n");
				// ������ļ�
				ps.print(sb.toString());
			} catch (Exception ew) {

			}
		} else if (e.getSource() == (JButton) Jpanel2.Blist.get(2)) {
			jt.setText("");
		} else if (e.getSource() == (JButton) Jpanel2.Blist.get(3)) {
			bst = new BST();
			bst.initTable();
			jt.append("��ʼ�����" + "\r\n");
		} else if (e.getSource() == (JButton) Jpanel2.Blist.get(4)) {
			String str = bst.generateTable();
			try {
				FileOutputStream fl = new FileOutputStream(new File("BSTOutput.txt"));
				PrintStream ps = new PrintStream(fl);
				ps.println(str);
			} catch (Exception ee) {
			}
			jt.append(str);
		}
	}
}
