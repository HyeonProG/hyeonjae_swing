package ch07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LottoEX extends JFrame implements ActionListener {

	private JButton button;
	private JLabel background;
	private RandomNumber randomNumber;
	private boolean isOk = true;

	public LottoEX() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game Start");
		Icon icon = new ImageIcon("images/lotto.jpg");
		background = new JLabel(icon);
		background.setSize(600, 400);
		randomNumber = new RandomNumber();
	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		add(background);
		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		isOk = false;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Font font = new Font("플레인", Font.PLAIN, 20);
		g.setFont(font);
		if (isOk) {
			g.drawString("GameStart 를 눌러주세요!", 200, 350);
		} else {
			int[] getNumbers = randomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + "", 80 + (i * 80), 350);
			}
		}

	}

	// 메인 함수
	public static void main(String[] args) {
		new LottoEX();
	} // end of main

} // end of class
