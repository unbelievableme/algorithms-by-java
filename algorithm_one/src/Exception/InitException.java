package Exception;

import javax.swing.JOptionPane;

public class InitException extends Exception {
	public InitException() {
		JOptionPane.showMessageDialog(null, "ͼ��δ��ʼ����");
	}
}
