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

public class BossPage2 {
	public static void main(String[] args) {
		new BossP2();
	}
}

class BossP2 extends JFrame {
	private static final long serialVersionUID = 1L;
	Image backImg, bossImg, playerImg, potionImg, heartImg, back_Img;
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
	Image bossImg1 = new ImageIcon("src\\img\\boss.gif").getImage();
	Image bossImg2 = new ImageIcon("src\\img\\boss1.gif").getImage();
	Image bossImg3 = new ImageIcon("src\\img\\boss2.gif").getImage();
	Image bossImg4 = new ImageIcon("src\\img\\boss3.gif").getImage();
	Image Img_Ba1, Img_Ba2, Img_Ba3,Img_Ba4;
	Image damage;
	long time_count = 0;
	int attack_count = 0;
	int hp_count = 0;
	int playerX, playerY;
	int play_width = 120;
	int play_height = 120;
	int attack_width = 350;
	int attack_X1, attack_X2, attack_X3, attack_X4, attack_X5, attack_X6,attack_X7, attack_X;
	int attack_Y1, attack_Y2, attack_Y3, attack_Y4,attack_Y5, attack_Y;
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

	public BossP2() {
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
					hitCheck();
					
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

		Thread attack_UP1 = new Thread(new Runnable() {// =====보스 천장 칼날 공격1=====
			public void run() {
				while (true) {
					attack_X1 = (new Random()).nextInt(backImg.getWidth(null) - 150);

					try {
						Thread.sleep(2200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		attack_UP1.start();
		Thread attack_UP2 = new Thread(new Runnable() {// =====보스 천장칼날 공격 1 y좌표 랜덤 thread=====

			public void run() {
				while (true) {
					attack_Y1 += attack_speed;
					if (attack_Y1 > backImg.getHeight(null) + 130) {
						attack_Y1 = 0;
					}
					try {
						Thread.sleep(53);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		attack_UP2.start();
		Thread attack_UP3 = new Thread(new Runnable() {// =====보스 천장 칼날 공격2=====
			public void run() {
				while (true) {
					System.out.println(hp_count);
					attack_X2 = (new Random()).nextInt(backImg.getWidth(null) - 100);
					try {
						Thread.sleep(1220);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hitCheck2();
					hitCheck3();
					hitCheck4();
					hitCheck6();
				}
			}
		});
		attack_UP3.start();

		Thread attack_UP4 = new Thread(new Runnable() {// =====보스 천장칼날 공격 2 y좌표 랜덤 thread=====
			public void run() {
				while (true) {
					attack_Y2 += attack_speed;
					if (attack_Y2 > backImg.getHeight(null) + 100) {
						attack_Y2 = 0;
					}
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		attack_UP4.start();
		
		Thread attack_UP5 = new Thread(new Runnable() {// =====보스 마법공격 thread=====
			public void run() {
				
				while (true) {
					attack_count++;
					if(attack_count>66 & attack_count<150) { //===== attack_count가 66이 되면 바닥공격=====
						attack_X3 += attack_speed2;
						attack_X4 += attack_speed;
						if(attack_X3>1300) {
							attack_X3=-200;
						}
						
					}
					if(attack_count>210 & attack_count<220) { //===== attack_count가 210이 되면 바닥공격 사라짐=====
						attack_X3 =0;
						attack_X4 =0;
					}
					if(attack_count>220 & attack_count<270) { //===== attack_count가 220이 되면 똥 공격=====
						attack_Y5+=attack_speed;
					}
					if(attack_count>280 & attack_count<290) { //===== attack_count가 280이 되면 똥 공격 사라짐=====
						attack_Y5=0;
					}
					if(attack_count>380 & attack_count<440) { //===== attack_count가 380이 동시에 공격=====
						attack_Y5+=attack_speed;
						attack_X3 += attack_speed2;
						attack_X4 += attack_speed;
						if(attack_X3>1300) {
							attack_X3=-200;
						}
					}
					if(attack_count>450 & attack_count<460) { //===== attack_count가 450이 동시에 사라지기=====
						attack_Y5=0;
						attack_X3=0;
						attack_X4=0;
					}
					if(attack_count>450) {
						attack_count=0;
					}
					if(attack_Y5>800) { //=====똥 공격 화면 넘어갈시 Y좌표 초기화=====
						attack_Y5=-4800;
					}
					if(attack_X3>1500) { //=====바닥 공격 화면 넘어갈시 X좌표 초기화1=====
						attack_X3=-400;
					}
					if(attack_X4>1500) {//=====바닥 공격 화면 넘어갈시 X좌표 초기화2===== 
						attack_X4=-400;
					}
					
					try {
						Thread.sleep(80);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		attack_UP5.start();

		Thread attack_DN2 = new Thread(new Runnable() { // ===== 입장 시 보라색 공 공격=====
			public void run() {
				while (true) {
					attack_X6 -= attack_speed;
					attack_X5 += attack_speed;
					attack_X = attack_X5;
					attack_Y3 += attack_speed;
					attack_Y4 -= attack_speed;
					attack_Y = attack_Y3;
					if (attack_X > backImg.getWidth(null) - 155) {
						attack_X = attack_X6 + 2100;
					}
					if (attack_X < 115) {
						attack_X = attack_X5 - 2000;
						if (attack_X < 0) {
							attack_X = attack_X5 - 2000;

						}
					}
					if (attack_Y > backImg.getHeight(null) - 200) {
						attack_Y = attack_Y4 + 1000;
						if (attack_Y < 0) {
							attack_Y = attack_Y3 - 2000;

						}
					}
					if (attack_Y < 0) {
						attack_Y = attack_Y3 - 900;
						if (attack_Y > 550) {
							attack_Y = attack_Y4 + 2000;
						} else if (attack_Y > 0) {
							attack_Y = attack_Y3 - 1000;

						}
					}
					try {
						Thread.sleep(80);
					} catch (InterruptedException e) {
						e.printStackTrace();

					}
					hitCheck5();
				}
			}

		});
		attack_DN2.start();
		
		Thread attack_Boss = new Thread(new Runnable() {

			public void run() {
				while (true) {		//=====time_count 1씩 증가=====
					time_count++;
					if (time_count == 5) { //=====보스 마법 공격 중 바닥 공격 시전 이미지=====
						bossImg = bossImg2;

					}
					if (time_count == 8) { //=====보스 이미지 원래대로=====
						bossImg = bossImg1;
					}
					if (time_count == 17) { //=====보스 마법 공격 중 똥 공격 시전 이미지=====
						bossImg = bossImg3;
						
					}
					if (time_count == 20) { //=====보스 이미지 원래대로=====
						bossImg = bossImg1;
						
					}
					if (time_count == 30) {	//=====보스 마법 공격 중 동시에 공격 시전 이미지=====
						bossImg = bossImg4;
					}
					if (time_count == 33) { //=====보스 이미지 원래대로=====
						bossImg = bossImg1;
					}
					if (time_count > 40) { //=====time_count가 40넘어갈시 0으로 초기화=====
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

	private void keyPressCheck() { //=====플레이어 이동 =====

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

	private void initialize() { //=====프레임 생성=====

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

	private void hitCheck() {  //=====보스 천장 칼날공격 1에 대한 히트체크=====
		if (playerX + play_width > attack_X1 && attack_X1 + attack_width - 30 > playerX
				&& playerY + play_height - 30 > -30 && -30 + attack_Y1 > playerY) {
			hp_count++;
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
	private void hitCheck2() { ////=====보스 천장 칼날공격 2에 대한 히트체크=====
		if (playerX + play_width > attack_X2 && attack_X2 + attack_width > playerX && playerY + play_height > -30
				&& -30 + attack_Y2 > playerY) {
			hp_count++;
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
	private void hitCheck3() { ////=====보스 바닥공격 1에 대한 히트체크=====
		if (playerX + play_width > attack_X3 && attack_X3 + 200 > playerX && playerY + play_height > 570
				&& 570 + 150 > playerY) {
			hp_count++;

			if (hp_count == 10) {
				speed = speed - 2;
			} else if (hp_count == 20) {
				speed = speed - 2;
			} else if (hp_count == 30) {
				speed = speed - 2;
			}

		}

	}

	private void hitCheck4() { ////=====보스 바닥공격 2에 대한 히트체크=====
		if (playerX + play_width > attack_X4 && attack_X4 + 200 > playerX && playerY + play_height > 570
				&& 570 + 150 > playerY) {
			hp_count++;
			if (hp_count == 100) {
				speed = speed - 2;
			} else if (hp_count == 200) {
				speed = speed - 2;
			} else if (hp_count == 300) {
				speed = speed - 2;
			}
		}
	}

	private void hitCheck5() { //=====보스 입장시 보라색 공 공격에 대한 hitCheck=====
		if (playerX + play_width > attack_X && attack_X + attack_width > playerX && playerY + play_height > -30
				&& -30 + attack_Y > playerY) {
			hp_count++;
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
	private void hitCheck6() { //=====보스 똥 공격에 대한 hitCheck=====
		if (playerX + play_width > 100 && 100 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 350 && 350 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 550 && 550 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 750 && 750 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 950 && 950 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 1100 && 1100 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY
				&&playerX + play_width > 1300 && 1300 + 100 > playerX && playerY + play_height > 100
				&& 100 + attack_Y5 > playerY) {
			hp_count++; 			//=====플레이어 하트 이미지=====
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
				playerAttack++; //===== A키를 누를 때 마다 playerAttack이 1씩 오름=====
				switch (playerAttack) {
				case 30: 	 	
					bossHp1_Img = bossHp2_Img;	//===== A키를 30번 누를 때 마다 bossHp1_Img가 변경=====
					break;
				case 60:
					bossHp1_Img = bossHp3_Img;	//===== A키를 60번 누를 때 마다 bossHp1_Img가 변경=====
					break;
				case 90:
					bossHp1_Img = bossHp4_Img;	//===== A키를 90번 누를 때 마다 bossHp1_Img가 변경=====
					break;
				case 120:
					bossHp1_Img = bossHp5_Img;	//===== A키를 120번 누를 때 마다 bossHp1_Img가 변경=====
					JOptionPane.showMessageDialog(null, "Clear!"); //===== 보스 클리어시 클리어 메세지 ===== 
					path2.main(null);			//===== 보스 클리어시 EndPage로 이동 ===== 		
					frame.dispose();
					break;
				}
				break;

			case KeyEvent.VK_SPACE:
				jump_upCheck = true;
				break;
			case KeyEvent.VK_END:			//=====End 키 누를시 포션 사용=====
				if (heartImg == heartImg2) {
					heartImg = heartImg1;
				} else if (heartImg == heartImg3) {
					heartImg = heartImg2;
				} else if (heartImg == heartImg4) {
					heartImg = heartImg3;
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

			case KeyEvent.VK_END:

			}
			super.keyReleased(e);
		}

	}

	class imagePanel extends JPanel {

		public imagePanel() {
			backImg = new ImageIcon("src\\img\\back2.jpg").getImage();
			bossImg = bossImg1;
			playerImg = new ImageIcon("src\\img\\player_right.png").getImage();
			bossHp1_Img = new ImageIcon("src\\img\\Hp1.png").getImage();
			potionImg = new ImageIcon("src\\img\\potion.png").getImage();
			heartImg = heartImg1;
			back_Img = new ImageIcon("src\\img\\back_1.png").getImage();
			Img_Ba1 = new ImageIcon("src\\img\\ba2.png").getImage();
			Img_Ba2 = new ImageIcon("src\\img\\ba3.gif").getImage();
			Img_Ba3 = new ImageIcon("src\\img\\ba4.png").getImage();
			Img_Ba4 = new ImageIcon("src\\img\\ba6.gif").getImage();
			damage=new ImageIcon("src\\img\\dam.png").getImage();
		}

		@Override
		public void paint(Graphics g) {
			g.drawImage(backImg, 0, 0, this);
			g.drawImage(bossImg, backImg.getWidth(null) / 2 - 370, backImg.getHeight(null) - 760, 700, 700, this);
			g.drawImage(playerImg, playerX, playerY, 120, 120, this);
			g.drawImage(bossHp1_Img, 320, 25, this);
			g.drawImage(heartImg, 5, 40, 180, 45, this);
			g.drawImage(Img_Ba1, attack_X1, -30, 350, attack_Y1, this);//=====보스 천장공격1 이미지=====
			g.drawImage(Img_Ba1, attack_X2, -30, 350, attack_Y2, this);//=====보스 천장공격2 이미지=====
			g.drawImage(Img_Ba2, attack_X3-200, 570, 200, 150, this);//=====보스 바닥공격1 이미지=====
			g.drawImage(Img_Ba2, attack_X4-200, 570, 200, 150, this);//=====보스 바닥공격2 이미지=====
			g.drawImage(Img_Ba3, attack_X, attack_Y, 200, 150, this);//=====보스 보라색 공 공격 이미지=====
			g.drawImage(Img_Ba4, 100, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지1=====
			g.drawImage(Img_Ba4, 350, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지2=====
			g.drawImage(Img_Ba4, 550, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지3=====
			g.drawImage(Img_Ba4, 750, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지4=====
			g.drawImage(Img_Ba4, 950, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지5=====
			g.drawImage(Img_Ba4, 1100, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지6=====
			g.drawImage(Img_Ba4, 1300, attack_Y5-150,100, 100, this);//=====보스 똥 공격 이미지7=====
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
