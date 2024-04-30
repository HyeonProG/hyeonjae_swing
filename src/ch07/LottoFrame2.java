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

public class LottoFrame2 extends JFrame implements ActionListener {

	private JButton button;
	private JLabel background;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private final int NUMBER_DISTANCE = 80;

	public LottoFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Icon icon = new ImageIcon("images/lotto.jpg");
		background = new JLabel(icon);
		background.setSize(600, 400);
		
		button = new JButton("Game Start");
		lottoRandomNumber = new LottoRandomNumber();
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
		System.out.println("그림을 그려라!");
		// 이벤트가 일어나면 그림을 (다시)그려라
		isStart = false;
		repaint(); // 다시 그림을 그려라 요청하는 명령어 == F5 같은 개념
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font font = new Font("플레인", Font.PLAIN, 20);
		g.setFont(font);

		if (isStart) {
			g.drawString("GameStart 를 눌러주세요!", 200, 350);
		} else {
			int[] getNumbers = lottoRandomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + " ", 80 + (i * NUMBER_DISTANCE), 350);
			}

		}
	}

	// 메인 함수
	public static void main(String[] args) {
		new LottoFrame2();
	} // end of main

} // end of class
