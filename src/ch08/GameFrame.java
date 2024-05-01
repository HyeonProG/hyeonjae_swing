package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;
	int enemyX = 250;
	int enemyY = 420;

	boolean isMove = true;
	boolean isVisible = true;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스 안에 클래스를 작성하는 법 -> 중첩 클래스 -> 외부 클래스, 내부 클래스
	private class ImagePanel extends JPanel implements Runnable {
		// paintComponents X
		// paintComponent O
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 1. 스페이스바를 눌렀을 때 적군을 멈출 수 있도록 코드 수정
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			if (isVisible == true) {
				g.drawImage(player1, playerX, playerY, 50, 50, null);
			}
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);

			// Todo : 플레이어, 적군, 그림 그려야 한다.
			// 쓰레드를 활용할 예정
		}

		@Override
		public void run() {
			// true : 왼쪽으로 가는 상황
			// false : 오른쪽으로 가는 상황
			boolean direction = true;

			while (true) {
				// System.out.println("진행중");
				if (isMove) {
					if (direction) {
						enemyX -= 10;
					} else {
						enemyX += 10;
					}
					// 방향 바꾸는 개념은 적군 x 좌표값이
					if (enemyX <= 50) {
						// false -> 오른쪽으로
						direction = false;
					}
					if (enemyX >= 520) {
						// true -> 왼쪽으로
						direction = true;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (playerY - enemyY <= 50 && playerX - enemyX <= 50) {
						if (enemyY - playerY <= 50 && enemyX - playerX <= 50) {
							isVisible = false;
						}
					}

					repaint();
				} else {
					isMove = false;
				}

			}
		}
	}

	private void initData() {
		setTitle("Thread를 활용한 미니 예제");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();

		// 다른 작업자에게 일을 위임 시킨다.
		Thread thread = new Thread(imagePanel);
		thread.start();

	}

	private void setInitLayout() {

		// setLayout(null); // 배치 관리자를 좌표 기반
		// setResizable(false); // 프레임 크기 조절 불가 설정
		setVisible(true);

		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너를 등록 하는 방법
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("여기가 동작 합니다.");
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (code == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (code == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (code == KeyEvent.VK_SPACE) {
					// 1. 스페이스바를 눌렀을 때 적군을 멈출 수 있도록 코드 수정
					isMove = false;
					// 3. 스페이스바를 다시 눌렀을 때 적군이 다시 움직이게 해주세요.
					
				}
				// 2. 플레이어가 적군과 만났다면 플레이어 그림을 없애주세요.
				if (playerY - enemyY <= 50 && playerX - enemyX <= 50) {
					if (enemyY - playerY <= 50 && enemyX - playerX <= 50) {
						isVisible = false;
					}
				}
				repaint();
			} // end of keyPressed
		});
	}

}
