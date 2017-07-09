package UI;

/**
 * 写界面的心得：1.对于一个界面首先要思考清楚界面可以分成多少个块，
 *              2.对于每一个块可以采用什么布局，需要添加什么组件
 *              3.对于组件的构建是否具有重复性，抽象成一个函数
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
	public PanelAction panelAction = new PanelAction(); // 内部类，实现事件响应
	public JPanel panel;

	// 创建一个JFrame
	public UIView(String title) {
		this.setTitle(title);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null); // 设置窗体在屏幕中央显示
		this.add(buildToolBar(), BorderLayout.NORTH);
		this.add(buildPanel(null), BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 创建菜单栏
	public JToolBar buildToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setLayout(new GridLayout(1, 5));
			String str[] = new String[] { "分治法", "降治法", "动态规划", "贪心策略", "回溯法" };
			for (int i = 0; i < str.length; i++) {
				toolBar.add(buildButton(str[i]));
			}
			toolBar.setEnabled(false); // 设置toolBar的可移动性
		}
		return toolBar;
	}

	// 创建面板
	public JPanel buildPanel(String title) {
		if (panel == null) {
			panel = new JPanel();
			JLabel j = new JLabel("算法实验");
			j.setFont(new java.awt.Font(null, ABORT, 100));
			panel.add(j, BorderLayout.CENTER);
			panel.setBorder(BorderFactory.createTitledBorder(title));
		}
		return panel;
	}

	// 创建菜单栏上的每一个按钮
	public JButton buildButton(String name) {
		JButton btn = new JButton(name);
		ar1.add(btn);
		btn.addActionListener(panelAction);
		return btn;
	}

	public static void main(String[] args) {
		UIView cut = new UIView("算法实验");
		cut.setVisible(true);
	}

	// 为菜单栏添加面板转换监听器
	private class PanelAction implements ActionListener {
		// 对于界面转换抽象成一个类
		public void changeTemp(JPanel jp) {
			UIView cp = UIView.this;
			// cp.panel.removeAll();
			cp.panel.removeAll();
			// 很重要！！！兄弟！！！必须刷新面板
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
