package MyGame;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class path1 {
	public static void main(String[] args) {
		new BossPath2();
	}
}

class BossPath2 extends JFrame {
	private static final long serialVersionUID = 1L;
	Image backImg, bossImg, playerImg, potionImg, heartImg, back_Img;
	int count = 0;
	private JFrame frame;

	public BossPath2() {
		initialize();

		Thread thread = new Thread(new Runnable() { //=====2페이즈 진입시 나오는 움짤=====

			public void run() {
				while (true) {
					count++;
					if (count == 6) { //=====6초 유지 후 2페이즈 입장=====

						BossPage2.main(null);
						frame.dispose();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setTitle("2페이즈");
		imagePanel panel = new imagePanel();// 이미지 패널 객체 생성
		panel.setLayout(null);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setFocusable(true);
		panel.requestFocus(false);
		frame.getContentPane().add(panel, null);// 콘텐트패인에 이미지 패널 넣기
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class imagePanel extends JPanel { /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	// 이미지 패널

		public imagePanel() {
			backImg = new ImageIcon("src/img/back gif.gif").getImage();

		}

		public void paint(Graphics g) {
			g.drawImage(backImg, 0, 0, frame.getWidth(), frame.getHeight(), this);

			this.repaint();
		}
	}
}
