package bubble.test.ex03;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	// 포함 관계 - composition
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
		
		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// Todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 전체 Frame 안에 root Panel 이 있다.
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		player = new Player();

	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame 을 모니터 가운데 자동 배치
		setVisible(true);

		add(player);

	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();
					break;
				case KeyEvent.VK_RIGHT:
					player.right();
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				}

			} // end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			} // end of keyReleased

		});

	}

	// 코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();
	} // end of main

}