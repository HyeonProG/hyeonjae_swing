package bubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.BubbleFrame;
import bubble.interfaces.Moveable;
import bubble.service.BackgroundEnemyService;
import bubble.state.EnemyWay;

public class Enemy extends JLabel implements Moveable {

	BubbleFrame mContext;

	// 살아있는 상태 0, 물방울에 갇힌 상태 1;
	private int state;

	// 적군의 좌표값
	private int x;
	private int y;
	private ImageIcon enemyR, enemyL;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	// 적군 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 1;

	// enum 타입의 활용 - 적군 방향 상태
	private EnemyWay enemyWay;

	public Enemy(BubbleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		new Thread(new BackgroundEnemyService(this)).start();
		left();
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}

	private void initData() {
		enemyR = new ImageIcon("img/enemyR.png");
		enemyL = new ImageIcon("img/enemyL.png");

		state = 0;

		// 처음 실행 시 적군 위치
		x = 720;
		y = 175;

		// 적군 방향 상태
		left = false;
		right = false;
		up = false;
		down = false;

		enemyWay = EnemyWay.LEFT;

	}

	private void setInitLayout() {
		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		left = true;
		// 왼쪽 방향키 이벤트 발생 시
		// 이미지를 왼쪽으로 보는 이미지로 세팅
		setIcon(enemyL);

		// 왼쪽으로 가는 반복문
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	} // end of left

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;
		right = true;
		setIcon(enemyR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	} // end of right

	@Override
	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y -= JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 객체의 상태값을 잘 조절해야 한다.
				up = false;
				down();

			}
		}).start();
	}

	@Override
	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();

	} // end of down

}
