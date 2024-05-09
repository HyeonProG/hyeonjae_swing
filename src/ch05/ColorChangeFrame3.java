package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame3 extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	public ColorChangeFrame3() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panel1 = new JPanel();
		panel1.setBackground(Color.red);
		panel2 = new JPanel();
		panel2.setBackground(Color.blue);
		
		button1 = new JButton("button1");
		button1.setBackground(Color.CYAN);
		button2 = new JButton("button2");
		button2.setBackground(Color.GRAY);
		button3 = new JButton("button3");
		button3.setBackground(Color.GREEN);
	}
	
	private void setInitLayout() {
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		setVisible(true);
	}
	
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ((JButton)e.getSource() == this.button1) {
			System.out.println("버튼 1 작동");
			panel1.setBackground(Color.CYAN);
		} else if ((JButton)e.getSource() == this.button2) {
			System.out.println("버튼 2 작동");
			panel1.setBackground(Color.GRAY);
		} else {
			System.out.println("버튼 3 작동");
			panel1.setBackground(Color.GREEN);
		}
		
	}
	
	public static void main(String[] args) {
		new ColorChangeFrame3();
	} // end of main
	
	
} // end of class