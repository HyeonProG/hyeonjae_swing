package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스를 활용해서 코드를 완성해 주세요.
public class PaintFrame extends JFrame {

	PaintPanel paintPanel;
	
	public PaintFrame() {
		initData();
		setInitData();
	}
	
	private void initData() {
		setTitle("집 짓기");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		paintPanel = new PaintPanel();
	}
	
	private void setInitData() {
		add(paintPanel);
		setVisible(true);
		
	}
	
	class PaintPanel extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(400, 500, 350, 300); // 집 몸체
			g.drawLine(300, 500, 850, 500); // 집 천장
			g.drawLine(300, 500, 600, 200); // 집 왼쪽 대각선
			g.drawLine(850, 500, 600, 200); // 집 오른쪽 대각선
			g.drawOval(410, 550, 150, 150); // 집 창문
			g.drawLine(485, 550, 485, 700); // 집 창문 가로
			g.drawLine(410, 625, 560, 625); // 집 창문 세로
			g.drawRect(600, 600, 125, 200); // 집 문
			g.drawOval(700, 700, 10, 10); // 집 문고리
			g.drawLine(700, 320, 700, 230); // 집 굴뚝
			g.drawLine(780, 415, 780, 230); // 집 굴뚝
			g.drawLine(700, 230, 780, 230); // 집 굴뚝
			g.drawOval(700, 210, 80, 15); // 연기
			g.drawOval(730, 175, 100, 20); // 연기
			g.drawOval(750, 130, 120, 30); // 연기
		}
	}
	
}
