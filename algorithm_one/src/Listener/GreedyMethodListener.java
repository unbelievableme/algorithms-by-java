package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JTextArea;

import GreedyMethod.Dijkstra;
import UI.Jpanel3;

public class GreedyMethodListener implements ActionListener {
	private static JTextArea jta = Jpanel3.jta;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == (JButton) Jpanel3.JBlist.get(0)) {
			int a = Integer.parseInt(Jpanel3.JTlist.get(0).getText().toString());
			StringBuffer str = Dijkstra.excute(a);
			jta.append(str.toString());
			try {
				FileOutputStream outp = new FileOutputStream(new File("DijkstraResult.txt"));
				PrintStream ps = new PrintStream(outp);
				ps.print(str.toString());
			} catch (Exception ww) {
			}
		} else if (e.getSource() == (JButton) Jpanel3.JBlist.get(1)) {
			jta.setText("");
		}
	}
}
