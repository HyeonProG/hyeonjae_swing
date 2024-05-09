package ch01;

import java.awt.BorderLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 ctrl + shift + s, f, o(안쓰는 임포트 삭제)
public class BorderLayoutEx2 extends JFrame {
	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER };

	// 생성자
	public BorderLayoutEx2() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borerLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];

	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout 은 컴포넌트들을 동서남북가운데로 배치시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해서 코드를 완성하세요.
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}

	}

	public static void main(String[] args) {
		new BorderLayoutEx2();

	} // end of main

}