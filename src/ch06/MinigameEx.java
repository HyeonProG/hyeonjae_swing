package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MinigameEx extends JFrame {

	private JLabel player;
	private JLabel background;
	// 플레이어
	private int playerX = 80;
	private int playerY = 180;
	private final int player_WIDTH = 50;
	private final int player_HEIGHT = 50;
	private final int MOVE_DISTANCE = 10;
	// 배경
	private final int BACKGROUND_WIDTH = 1000;
	private final int BACKGROUND_HEIGHT = 600;
	// 창크기
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 645;

	public MinigameEx() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 플레이어
		player = new JLabel(new ImageIcon("images/playerR.png"));
		player.setSize(player_WIDTH, player_HEIGHT);
		// 배경
		Icon icon = new ImageIcon("images/backgroundMap.png");
		background = new JLabel(icon);
		background.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
	}

	private void setInitLayout() {
		setLayout(null);
		setVisible(true);
		// 배경 추가
		add(background);
		// 배경안에 플레이어 넣기
		background.add(player);
		player.setLocation(playerX, playerY);
	}

	private void addEventListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					playerX -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					playerY -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					playerX += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					playerY += MOVE_DISTANCE;
				}
				player.setLocation(playerX, playerY);
			}
		});
	}

	public static void main(String[] args) {
		new MinigameEx();
	} // end of main

} // end of class
