package MyGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BossPage3 {
	public static void main(String[] args) {
		new BossP3();
	}
}

class BossP3 extends JFrame {
	private static final long serialVersionUID = 1L;
	Image backImg, bossImg, playerImg, potionImg, heartImg, back_Img, gaugeImg;
	Image skill_Rgif = new ImageIcon("src\\img\\atk_3.gif").getImage();
	Image skill_Lgif = new ImageIcon("src\\img\\atk_2.gif").getImage();
	Image skill_rightA = new ImageIcon("src\\img\\atk_2.png").getImage();
	Image skill_leftA = new ImageIcon("src\\img\\atk_1.png").getImage();
	Image nextPage = new ImageIcon("src\\img\\path2.png").getImage();
	Image none_damage = new ImageIcon("src\\img\\back_1.png").getImage();
	Image bossHp1_Img = new ImageIcon("src\\img\\hp1.png").getImage();
	Image bossHp2_Img = new ImageIcon("src\\img\\hp2.png").getImage();
	Image bossHp3_Img = new ImageIcon("src\\img\\hp3.png").getImage();
	Image bossHp4_Img = new ImageIcon("src\\img\\hp4.png").getImage();
	Image bossHp5_Img = new ImageIcon("src\\img\\hp5.png").getImage();
	Image playerImg_right = new ImageIcon("src\\img\\player_right.png").getImage();
	Image playerImg_left = new ImageIcon("src\\img\\player_left.png").getImage();
	Image player_rightA = new ImageIcon("src\\img\\player_rightA.png").getImage();
	Image player_leftA = new ImageIcon("src\\img\\player_leftA.png").getImage();
	Image heartImg1 = new ImageIcon("src\\img\\heart3.png").getImage();
	Image heartImg2 = new ImageIcon("src\\img\\h1.png").getImage();
	Image heartImg3 = new ImageIcon("src\\img\\h2.png").getImage();
	Image heartImg4 = new ImageIcon("src\\img\\h3.png").getImage();
	Image dieImg = new ImageIcon("src\\img\\die.png").getImage();
	Image bossImg1 = new ImageIcon("src\\img\\boss4.gif").getImage();
	Image bossImg2 = new ImageIcon("src\\img\\boss5.gif").getImage();
	Image bossImg3 = new ImageIcon("src\\img\\boss6.gif").getImage();
	Image bossImg4 = new ImageIcon("src\\img\\boss7.gif").getImage();
	Image Img_Ba5, Img_Ba6_1, Img_Ba6, Img_Ba7_1, Img_Ba7_2, Img_Ba7_3, Img_Ba7_4, Img_Ba7_5, Img_Ba7_6, Img_Ba7_7;
	Image background1 = new ImageIcon("src\\img\\back10.gif").getImage();
	Image background2 = new ImageIcon("src\\img\\back10-1.gif").getImage();
	Image gauge0 = new ImageIcon("src\\img\\gage0.png").getImage();
	Image gauge1 = new ImageIcon("src\\img\\gage1.png").getImage();
	Image gauge2 = new ImageIcon("src\\img\\gage2.png").getImage();
	Image gauge3 = new ImageIcon("src\\img\\gage3.png").getImage();
	Image attack_skill = new ImageIcon("src\\img\\skill.png").getImage();
	long time_count = 0;
	int attack_count = 0;
	int skill_count = 0;
	int hp_count = 0;
	int playerX, playerY;
	int play_width = 120;
	int play_height = 120;
	int attack_width = 350;
	int attack_X1, attack_X2, attack_X3, attack_X4, attack_X5, attack_X6, attack_X7, attack_X;
	int attack_X8 = -150;
	int attack_X8_1 = -150;
	int attack_X9 = -150;
	int attack_X9_1 = -150;
	int attack_X10 = -150;
	int attack_X10_1 = -150;
	int attack_X11 = -150;
	int attack_X11_1 = -150;
	int attack_X12 = -150;
	int attack_X12_1 = -150;
	int attack_X13 = -150;
	int attack_X13_1 = -150;
	int attack_X14 = -150;
	int attack_X14_1 = -150;

	int attack_X15 = -3000;
	int attack_X16 = -3000;
	int attack_X17 = -3000;
	int attack_X18 = -3000;
	int attack_X19 = -3000;
	int attack_X20 = -3000;
	int attack_X21 = -3000;

	int attack_Y1, attack_Y2, attack_Y3, attack_Y4, attack_Y5, attack_Y;
	int attack_speed = 21;
	int attack_speed2 = 16;
	int attack_speed3 = 10;
	int speed = 10;
	int jump = 10;
	int bossHP = 100;
	int playerAttack = 0;
	boolean leftCheck, rightCheck, jump_upCheck, attackCheck;
	boolean flag;
	private JFrame frame;

	public BossP3() {
		leftCheck = rightCheck = jump_upCheck = attackCheck = false;// 방향키
		flag = false;
		initialize();
		Thread thread = new Thread(new Runnable() { // 플레이어 이동
			public void run() {
				while (true) {

					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					keyPressCheck();
					hitCheck1();
					hitCheck2();
					if (playerImg == dieImg) { // 플레이어가 사망할시 다른창으로 이동
						if (playerAttack < 20) {
							JOptionPane.showMessageDialog(frame, "Game Over");
							info_page.main(null);
							frame.dispose();

							break;
						}
					}
				}
			}
		});
		thread.start();

		Thread attack_UP5 = new Thread(new Runnable() {// =====보스 마법공격 thread=====
			public void run() {

				while (true) {
					attack_count++;
//					System.out.println(attack_count);
					if (attack_count > 66 & attack_count < 150) { // ===== attack_count가 66이 되면 바닥공격=====
						attack_Y5 += attack_speed;

					}
					if (attack_count > 180 & attack_count < 190) { // ===== attack_count가 220이 되면 똥 공격=====
						attack_Y5 = -300;
						attack_X8 = 150;
						attack_X9 = 350;
						attack_X10 = 550;
						attack_X11 = 750;
						attack_X12 = 950;
						attack_X13 = 1150;
						attack_X14 = 1300;
					}
					if (attack_count > 191 & attack_count < 194) { // ===== attack_count가 280이 되면 똥 공격 사라짐=====
						attack_X8 = -150;
						attack_X9 = -150;
						attack_X10 = -150;
						attack_X11 = -150;
						attack_X12 = -150;
						attack_X13 = -150;
						attack_X14 = -150;

						attack_X8_1 = 150;
						attack_X9_1 = 350;
						attack_X10_1 = 550;
						attack_X11_1 = 750;
						attack_X12_1 = 950;
						attack_X13_1 = 1150;
						attack_X14_1 = 1300;
					}
					if (attack_count > 200 & attack_count < 205) { // ===== attack_count가 280이 되면 똥 공격 사라짐=====
						attack_X8_1 = -150;
						attack_X9_1 = -350;
						attack_X10_1 = -550;
						attack_X11_1 = -750;
						attack_X12_1 = -950;
						attack_X13_1 = -1150;
						attack_X14_1 = -1300;
					}
					if (attack_count > 310 & attack_count < 320)
						attack_X15 = 100;
					if (attack_count > 312 & attack_count < 322)
						attack_X16 = -250;
					if (attack_count > 315 & attack_count < 318)
						attack_X17 = -250;
					if (attack_count > 317 & attack_count < 320)
						attack_X18 = -250;
					if (attack_count > 318 & attack_count < 321)
						attack_X18 = -250;
					
					
					if (attack_count > 325 & attack_count < 330)
						attack_X15 = 2000;
					if (attack_count > 325 & attack_count < 330)
						attack_X16 = +2250;
					if (attack_count > 325 & attack_count < 330)
						attack_X17 = +2250;
					if (attack_count > 325 & attack_count < 330)
						attack_X18 = +2250;
					if (attack_count > 325 & attack_count < 330)
						attack_X19 = +2250;
					if (attack_count > 500) {
						attack_count = 0;
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		attack_UP5.start();

		Thread attack_Boss = new Thread(new Runnable() {

			public void run() {
				while (true) { // =====time_count 1씩 증가=====
					time_count++;
					if (time_count == 5) { // =====보스 마법 공격 중 바닥 공격 시전 이미지=====
						bossImg = bossImg2;

					}
					if (time_count == 7) { // =====보스 이미지 원래대로=====
						bossImg = bossImg1;
					}
					if (time_count == 17) { // =====보스 마법 공격 중 똥 공격 시전 이미지=====
						bossImg = bossImg3;

					}
					if (time_count == 18) { // =====보스 이미지 원래대로=====
						bossImg = bossImg1;

					}
					if (time_count == 30) { // =====보스 마법 공격 중 동시에 공격 시전 이미지=====
						bossImg = bossImg4;
					}
					if (time_count == 32) { // =====보스 이미지 원래대로=====
						bossImg = bossImg1;
					}
					if (time_count > 40) { // =====time_count가 40넘어갈시 0으로 초기화=====
						time_count = 0;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					;

				}
			}
		});
		attack_Boss.start();
	}

	private void keyPressCheck() { // =====플레이어 이동 =====

		if (jump_upCheck && playerY - speed > 0) {
			playerY -= jump;
			if (playerY < 250) {
				playerY = 530;
			}
		}

		if (leftCheck && playerX - speed > 0) {
			playerX -= speed;
		}
		if (rightCheck && playerX + playerImg.getWidth(null) + speed < backImg.getWidth(null) + 200) {
			playerX += speed;
		}
	}

	private void initialize() { // =====프레임 생성=====

		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setTitle("Boss 1");

		imagePanel panel = new imagePanel();// =====이미지 패널 객체 생성=====
		panel.setLayout(null);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.addKeyListener(new movingPlayer());
		panel.setFocusable(true);
		panel.requestFocus(false);
		playerX = 200;
		playerY = 530;
		frame.getContentPane().add(panel, null);// =====콘텐트패인에 이미지 패널 넣기=====

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void hitCheck1() { // =====보스 번개 공격에 대한 hitCheck=====
		if (playerX + play_width > attack_X8_1 && 100 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY && playerX + play_width > 350 && 350 + 100 > playerX
				&& playerY + play_height > 100 && 100 + attack_Y5 > playerY && playerX + play_width > 550
				&& 550 + 100 > playerX && playerY + play_height > 100 && 100 + attack_Y5 > playerY
				&& playerX + play_width > 750 && 750 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY && playerX + play_width > 950 && 950 + 100 > playerX
				&& playerY + play_height > 100 && 100 + attack_Y5 > playerY && playerX + play_width > 1100
				&& 1100 + 100 > playerX && playerY + play_height > 100 && 100 + attack_Y5 > playerY
				&& playerX + play_width > 1300 && 1300 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY) {
			hp_count++; // =====플레이어 하트 이미지=====
			if (hp_count == 100) {
				heartImg = heartImg2;
			} else if (hp_count == 200) {
				heartImg = heartImg3;
			} else if (hp_count == 300) {
				heartImg = heartImg4;
			}
			if (heartImg == heartImg4) {
				playerImg = dieImg;
				playerImg_right = dieImg;
				playerImg_left = dieImg;
				player_leftA = dieImg;
				player_rightA = dieImg;
			}
		}
	}

	private void hitCheck2() { // =====보스 입장시 보라색 공 공격에 대한 hitCheck=====
		if (playerX + play_width > attack_X8_1 && attack_X8_1 + 150 > playerX && playerY + play_height > 500
				&& 500 + 800 > playerY && playerX + play_width > attack_X9_1 && attack_X8_1 + 150 > playerX
				&& playerY + play_height > 500 && 500 + 800 > playerY && playerX + play_width > attack_X10_1
				&& attack_X8_1 + 150 > playerX && playerY + play_height > 500 && 500 + 800 > playerY
				&& playerX + play_width > attack_X11_1 && attack_X8_1 + 150 > playerX && playerY + play_height > 500
				&& 500 + 800 > playerY && playerX + play_width > attack_X12_1 && attack_X8_1 + 150 > playerX
				&& playerY + play_height > 500 && 500 + 800 > playerY && playerX + play_width > attack_X13_1
				&& attack_X8_1 + 150 > playerX && playerY + play_height > 500 && 500 + 800 > playerY
				&& playerX + play_width > attack_X14_1 && attack_X8_1 + 150 > playerX && playerY + play_height > 500
				&& 500 + 800 > playerY) {
			hp_count++;
			System.out.println(hp_count);
			if (hp_count == 100) {
				heartImg = heartImg2;
			} else if (hp_count == 200) {
				heartImg = heartImg3;
			} else if (hp_count == 300) {
				heartImg = heartImg4;
			}
			if (heartImg == heartImg4) {
				playerImg = dieImg;
				playerImg_right = dieImg;
				playerImg_left = dieImg;
				player_leftA = dieImg;
				player_rightA = dieImg;
			}
		}
	}

	class movingPlayer extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				rightCheck = true;
				playerImg = playerImg_right;
				break;

			case KeyEvent.VK_LEFT:
				leftCheck = true;
				playerImg = playerImg_left;
				break;

			case KeyEvent.VK_A:
				if (playerImg == playerImg_right) {
					playerImg = player_rightA;
				} else if (playerImg == playerImg_left) {
					playerImg = player_leftA;
				}
				playerAttack++; // ===== A키를 누를 때 마다 playerAttack이 1씩 오름=====
				switch (playerAttack) {
				case 10:
					gaugeImg = gauge1;
					break;
				case 30:
					gaugeImg = gauge2;
					break;
				case 40:
					bossHp1_Img = bossHp2_Img;
					break;
				case 50:
					gaugeImg = gauge3;
					break;
				case 60:
					bossHp1_Img = bossHp3_Img; // ===== A키를 60번 누를 때 마다 bossHp1_Img가 변경=====
					break;
				case 90:
					bossHp1_Img = bossHp4_Img; // ===== A키를 90번 누를 때 마다 bossHp1_Img가 변경=====

					break;
				case 120:
					bossHp1_Img = bossHp5_Img; // ===== A키를 120번 누를 때 마다 bossHp1_Img가 변경=====
					JOptionPane.showMessageDialog(null, "Clear!"); // ===== 보스 클리어시 클리어 메세지 =====
					EndPage.main(null); // ===== 보스 클리어시 EndPage로 이동 =====
					frame.dispose();
					break;
				}
				break;

			case KeyEvent.VK_SPACE:
				jump_upCheck = true;
				break;
			case KeyEvent.VK_END: // =====End 키 누를시 포션 사용=====
				if (heartImg == heartImg2) {
					heartImg = heartImg1;
				} else if (heartImg == heartImg3) {
					heartImg = heartImg2;
				} else if (heartImg == heartImg4) {
					heartImg = heartImg3;
				}
			case KeyEvent.VK_DELETE:
				if (gaugeImg == gauge3) {
					backImg = background1;
				}

			}
			super.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				jump_upCheck = false;
				playerY = 530;

				break;
			case KeyEvent.VK_LEFT:
				leftCheck = false;
				break;
			case KeyEvent.VK_RIGHT:
				rightCheck = false;

				break;

			case KeyEvent.VK_A:
				if (playerImg == player_rightA) {
					playerImg = playerImg_right;
				} else if (playerImg == player_leftA) {
					playerImg = playerImg_left;
				}
				break;

			case KeyEvent.VK_DELETE:
				if (backImg == background1) {
					backImg = background2;
				}
				if (backImg == background2) {
					gaugeImg = gauge0;
				}

			}
			super.keyReleased(e);
		}

	}

	class imagePanel extends JPanel {

		public imagePanel() {

			backImg = new ImageIcon("src\\img\\back4.png").getImage();
			bossImg = bossImg1;
			playerImg = new ImageIcon("src\\img\\player_right.png").getImage();
			bossHp1_Img = new ImageIcon("src\\img\\Hp1.png").getImage();
			potionImg = new ImageIcon("src\\img\\potion.png").getImage();
			heartImg = heartImg1;
			gaugeImg = gauge0;
			back_Img = new ImageIcon("src\\img\\back_1.png").getImage();
			Img_Ba5 = new ImageIcon("src\\img\\ba7.gif").getImage();
			Img_Ba6_1 = new ImageIcon("src\\img\\ba8.gif").getImage();
			Img_Ba6 = new ImageIcon("src\\img\\ba8_1.gif").getImage();

			Img_Ba7_1 = new ImageIcon("src\\img\\ba10.gif").getImage();
			Img_Ba7_2 = new ImageIcon("src\\img\\ba10-1.gif").getImage();
			Img_Ba7_3 = new ImageIcon("src\\img\\ba10-2.gif").getImage();
			Img_Ba7_4 = new ImageIcon("src\\img\\ba10-3.gif").getImage();
			Img_Ba7_5 = new ImageIcon("src\\img\\ba10-4.gif").getImage();
			Img_Ba7_6 = new ImageIcon("src\\img\\ba10-5.gif").getImage();
			Img_Ba7_7 = new ImageIcon("src\\img\\ba10-6.gif").getImage();
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(backImg, 0, 0, frame.getWidth(), frame.getHeight(), frame);
			g.drawImage(bossImg, 300, -10, 700, 700, this);
			g.drawImage(playerImg, playerX, playerY, 120, 120, this);
			g.drawImage(bossHp1_Img, 320, 25, this);
			g.drawImage(heartImg, 5, 40, 180, 45, this);
			g.drawImage(Img_Ba5, 100, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지1=====
			g.drawImage(Img_Ba5, 350, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지2=====
			g.drawImage(Img_Ba5, 550, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지3=====
			g.drawImage(Img_Ba5, 750, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지4=====
			g.drawImage(Img_Ba5, 950, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지5=====
			g.drawImage(Img_Ba5, 1100, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지6=====
			g.drawImage(Img_Ba5, 1300, attack_Y5 - 150, 150, 150, this);// =====보스 똥 공격 이미지7=====
			g.drawImage(Img_Ba6_1, attack_X8, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X8_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X9, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X9_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X10, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X10_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X11, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X11_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X12, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X12_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X13, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X13_1, -50, 150, 800, this);
			g.drawImage(Img_Ba6_1, attack_X14, -50, 150, 800, this);
			g.drawImage(Img_Ba6, attack_X14_1, -50, 150, 800, this);
			
			g.drawImage(Img_Ba7_1, attack_X15, 400, 1300, 150, this);
			g.drawImage(Img_Ba7_2, 30, attack_X16,150,1300, this);
			g.drawImage(Img_Ba7_3, attack_X17, 250,1300, 150, this);
			g.drawImage(Img_Ba7_4, attack_X18, -150,1000, 1300, this);
			g.drawImage(Img_Ba7_5, attack_X19, 400,1300, 150, this);
			g.drawImage(Img_Ba7_6, attack_X20, 400,1300, 150, this);
			g.drawImage(Img_Ba7_7, attack_X21, 400,1300, 150, this);

			g.drawImage(gaugeImg, 1100, 600, 150, 30, this);
			if (gaugeImg == gauge3) {
				
				
				g.drawImage(attack_skill, 1100, 550, 50, 50, this);
				g.setFont(new Font("Gothic", Font.BOLD, 20));
				g.setColor(Color.white);
				g.drawString("Delete 키", 1160, 580);
			}
			if (backImg == background2) {
				if (playerImg == playerImg_left) {
					g.drawImage(skill_leftA, playerX - 230, playerY - 200, 400, 400, this);
				} else if (playerImg == playerImg_right) {
					g.drawImage(skill_rightA, playerX + 5, playerY - 200, 400, 400, this);
				} else if (playerImg == player_leftA) {
					g.drawImage(skill_Lgif, playerX - 230, playerY - 200, 400, 400, this);
				} else if (playerImg == player_rightA) {
					g.drawImage(skill_Rgif, playerX + 5, playerY - 200, 400, 400, this);
				}
			}
			g.setColor(Color.white);
			g.setFont(new Font("Gothic", Font.BOLD, 40));
			g.drawString("HP : ", 240, 50);
			g.setFont(new Font("Gothic", Font.BOLD, 20));
			g.drawString("포션", 1180, 430);
			g.drawImage(potionImg, 1140, 430, 120, 80, this);
			g.drawString("END 키", 1170, 520);

			this.repaint();
		}
	}
}
