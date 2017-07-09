package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JTextArea;

import UI.Jpanel4;
import backTrackingMethod.EightQuenesProblem;

public class BackTrackintMethodListener implements ActionListener {
	private JTextArea jta = Jpanel4.jta;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == (JButton) Jpanel4.JBlist.get(0)) {
			int solveNum = 0;
			int column = Integer.parseInt(Jpanel4.JTlist.get(0).getText().toString());
			EightQuenesProblem eightq = new EightQuenesProblem(column);
			StringBuffer str = eightq.testing(1);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					solveNum++;
				}
			}
			str.append("解决方案共有" + solveNum / 2 + "种！");
			jta.append(str.toString());
			try {
				FileOutputStream outp = new FileOutputStream(new File("EightQueensResult.txt"));
				PrintStream ps = new PrintStream(outp);
				ps.print(str.toString());
			} catch (Exception ww) {
			}
		} else if (e.getSource() == (JButton) Jpanel4.JBlist.get(1)) {
			jta.setText("");
		}
	}

}
