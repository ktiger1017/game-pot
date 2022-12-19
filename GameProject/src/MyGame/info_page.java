package MyGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class info_page {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new information());
	}
}

class information extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image backImage, BossImage, playerImage, title;
	Image playerImg_right, playerImg_left, player_rightA, player_leftA;
	int playerX, playerY;
	JButton btn_In;

	public information() {
		initialize();
	}

	private void initialize() {
		playerImg_right = new ImageIcon("src/img/player_right.png").getImage();
		playerImg_left = new ImageIcon("src/img/player_left.png").getImage();
		player_rightA = new ImageIcon("src/img/player_rightA.png").getImage();
		player_leftA = new ImageIcon("src/img/player_leftA.png").getImage();

		setSize(1290, 720);

		MyImagePanel panel = new MyImagePanel();
		panel.setLayout(null);
		panel.addKeyListener(new movingPlayer());
		panel.setFocusable(true);
		panel.requestFocus(false);

		playerX = 200;
		playerY = 530;

		getContentPane().add(panel);

		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class movingPlayer extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				playerX += 0.155 * 20 * 5;
				playerImage = playerImg_right;
				if (playerX > 1160) {
					playerX = 1150;
				}
				repaint();
				break;

			case KeyEvent.VK_LEFT:
				playerX -= 0.155 * 20 * 5;
				playerImage = playerImg_left;
				if (playerX < 20) {
					playerX = 10;
				}
				repaint();
				break;

			case KeyEvent.VK_A:

				if (playerImage == playerImg_right) {
					playerImage = player_rightA;
				} else if (playerImage == playerImg_left) {
					playerImage = player_leftA;
				}
				repaint();
				break;

			case KeyEvent.VK_SPACE:

				playerY -= 50;
				playerX -= 20;

				if (playerY < 500) {
					playerY = 400;
				}
				repaint();
				break;

			}
			super.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				playerY += 130;
				repaint();
			case KeyEvent.VK_A:
				if (playerImage == player_rightA) {
					playerImage = playerImg_right;
				} else if (playerImage == player_leftA) {
					playerImage = playerImg_left;
				}
				repaint();
				break;

			}
		}

	}

	public class MyImagePanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyImagePanel() {

			backImage = new ImageIcon("src\\img\\back2.jpg").getImage();
			BossImage = new ImageIcon("src\\img\\boss.gif").getImage();
			playerImage = new ImageIcon("src\\img\\player_right.png").getImage();
			title = new ImageIcon("src\\img\\title.png").getImage();
			btn_In = new JButton("게임 시작!");
			btn_In.setBounds(900, 300, 160, 70);
			btn_In.setOpaque(true);
			btn_In.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					BossPage.main(null);
					dispose();
				}
			});
			add(btn_In);

		}

		public void paint(Graphics g) {

			g.drawImage(backImage, 0, 0, 1280, 720, this);
			g.drawImage(BossImage, 200, 50, 600, 600, this);
			g.drawImage(playerImage, playerX, playerY, 120, 120, this);
			g.drawImage(title, 500, 30, 330, 120, this);
			g.setColor(Color.white);
			g.setFont(new Font("Gothic", Font.BOLD, 40));
			g.drawString("방향키로 이동", 900, 480);
			g.drawString("space bar로 점프", 900, 530);
			g.drawString("a키로 공격", 900, 580);
			g.drawString("포션 end키(포션 먹으면 hp 회복)", 640, 630);

			btn_In.repaint();

		}
	}
}