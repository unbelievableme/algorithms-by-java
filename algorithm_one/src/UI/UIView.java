package UI;

/**
 * д������ĵã�1.����һ����������Ҫ˼�����������Էֳɶ��ٸ��飬
 *              2.����ÿһ������Բ���ʲô���֣���Ҫ���ʲô���
 *              3.��������Ĺ����Ƿ�����ظ��ԣ������һ������
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class UIView extends JFrame {
	public JToolBar toolBar;
	public ArrayList<JButton> ar1 = new ArrayList<JButton>();
	public PanelAction panelAction = new PanelAction(); // �ڲ��࣬ʵ���¼���Ӧ
	public JPanel panel;

	// ����һ��JFrame
	public UIView(String title) {
		this.setTitle(title);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null); // ���ô�������Ļ������ʾ
		this.add(buildToolBar(), BorderLayout.NORTH);
		this.add(buildPanel(null), BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// �����˵���
	public JToolBar buildToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setLayout(new GridLayout(1, 5));
			String str[] = new String[] { "���η�", "���η�", "��̬�滮", "̰�Ĳ���", "���ݷ�" };
			for (int i = 0; i < str.length; i++) {
				toolBar.add(buildButton(str[i]));
			}
			toolBar.setEnabled(false); // ����toolBar�Ŀ��ƶ���
		}
		return toolBar;
	}

	// �������
	public JPanel buildPanel(String title) {
		if (panel == null) {
			panel = new JPanel();
			JLabel j = new JLabel("�㷨ʵ��");
			j.setFont(new java.awt.Font(null, ABORT, 100));
			panel.add(j, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createTitledBorder(title));
		}
		return panel;
	}

	// �����˵����ϵ�ÿһ����ť
	public JButton buildButton(String name) {
		JButton btn = new JButton(name);
		ar1.add(btn);
		btn.addActionListener(panelAction);
		return btn;
	}

	public static void main(String[] args) {
		UIView cut = new UIView("�㷨ʵ��");
		cut.setVisible(true);
	}

	// Ϊ�˵���������ת��������
	private class PanelAction implements ActionListener {
		// ���ڽ���ת�������һ����
		public void changeTemp(JPanel jp) {
			UIView cp = UIView.this;
			// cp.panel.removeAll();
			cp.panel.removeAll();
			// ����Ҫ�������ֵܣ���������ˢ�����
			cp.panel.updateUI();
			cp.panel.add(jp);

		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ar1.get(0)) {
				changeTemp(Jpanel.getDivideJPanel());
			}
			if (e.getSource() == ar1.get(1)) {
				changeTemp(Jpanel1.getDecreaseJPanel());
			}
			if (e.getSource() == ar1.get(2)) {
				changeTemp(Jpanel2.getDynamicJPanel());
			}
			if (e.getSource() == ar1.get(3)) {
				changeTemp(Jpanel3.getGreedyJPanel());
			}
			if (e.getSource() == ar1.get(4)) {
				changeTemp(Jpanel4.getBackJPanel());
				UIView cp = UIView.this;
			}
		}
	}
}
