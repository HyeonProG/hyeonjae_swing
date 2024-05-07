package bubble.test.ex10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	// 컨텍스트를 생성 하는 방법(셀프 참조)
	BubbleFrame mContext = this;
	
	private JLabel backgroundMap;
	// 포함 관계 - composition
	private Player player;
	private Enemy enemy1;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		// Todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 전체 Frame 안에 root Panel 이 있다.
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		// mContext --> 참조 타입 --> 주소값의 크기는 기본 4byte 이다.
		player = new Player(mContext);
		
		enemy1 = new Enemy(mContext);

	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame 을 모니터 가운데 자동 배치
		setVisible(true);

		add(player);
		add(enemy1);

	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 방향키를 누르고 있다면
					// 키 이벤트가 계속 왼쪽
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌 한게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				case KeyEvent.VK_SPACE:
					// add(new Bubble(player));
					player.attack();
					// 프레임에 컴포넌트를 add 하는 동작은 JFrame --> add() 메서드
					// 버블 실행 시 끊김 현상이 발생하는 이유는 ?
					break;
				default:
					break;
				}

			} // end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;
				}
			} // end of keyReleased

		});

	}
	
	// getter
	public Player getPlayer() {
		return player;
	}
	
	public Enemy getEnemy() {
		return enemy1;
	}

	// 코드 테스트
	public static void main(String[] args) {
		// main 함수를 가지고 있는 클래스는 하위에 생성된
		// 모든 객체들의 주소값을 알고 있다.(중요!)
		new BubbleFrame();
	} // end of main

}
