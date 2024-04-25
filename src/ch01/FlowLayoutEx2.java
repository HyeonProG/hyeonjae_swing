package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx2 extends JFrame {

	// 배열을 활용해서 코드 리팩토링
	// 하나의 변수로 여러개를 통으로 관리하고 싶다면 배열을 써보자.
	private JButton[] buttons;

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initData();
		setInitLayout();
	}

	public void initData() {

		buttons = new JButton[6]; // 공간만 선언

		// 반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("button" + (i + 1));
		}

	}

	public void setInitLayout() {

		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));

		// 반복문 활용
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}

	}

	// 코드 테스트
	public static void main(String[] args) {

		new FlowLayoutEx2();

	} // end of main

}
