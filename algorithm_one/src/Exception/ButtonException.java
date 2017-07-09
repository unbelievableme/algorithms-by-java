package Exception;

import javax.swing.JOptionPane;

public class ButtonException {
	public ButtonException() {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(null, "尚未初始化随机数");
	}

	public ButtonException(String str) {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(null, "尚未初始化随机" + str);
	}
}
