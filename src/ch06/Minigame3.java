package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Minigame3 extends JFrame {

	private JLabel jplayer;
	// 변수는 변하는 수
	private int jplayerX = 100;
	private int jplayerY = 100;
	// 움직임
	private final int MOVE_DISTANCE = 20;
	// 창 크기
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	// 플레이어
	private final String player_NAME = "야스오";
	private final int player_WIDTH = 100;
	private final int player_HEIGHT = 100;

	public Minigame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jplayer = new JLabel(player_NAME);
		jplayer.setSize(player_WIDTH, player_HEIGHT);
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치 관리자 변경
		setLayout(null);
		add(jplayer);
		jplayer.setLocation(jplayerX, jplayerY);
		setVisible(true);
	}

	private void addEventListener() {
		// jplayer 객체한테만 keyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 keyListener 인터페이스를 재정의할 수 있다.
		// jplayer.addKeyListener(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					// 변수는 변하는 수이기도 하다.
					jplayerY -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jplayerX -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jplayerX += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jplayerY += MOVE_DISTANCE;
				}
				jplayer.setLocation(jplayerX, jplayerY);
			}
		});

	}

	// 코드 테스트
	public static void main(String[] args) {
		new Minigame3();
	} // end of main

} // end of class
