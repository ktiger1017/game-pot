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

public class BossPage {
   public static void main(String[] args) {
      new BossP1();
   }
}
class BossP1 extends JFrame {
   private static final long serialVersionUID = 1L;
   Image backImg, bossImg, playerImg, potionImg, heartImg, back_Img,path_msg;
   Image nextPage = new ImageIcon("src\\img\\path2.png").getImage();
   Image none_damage = new ImageIcon("src\\img\\back_1.png").getImage();
   Image damageImg = new ImageIcon("src\\img\\damage.png").getImage();
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
   Image Img_Ba1;
   int hp_count = 0;
   int potion_count=3;
   int playerX, playerY;
   int play_width = 120;
   int play_height = 120;
   int attack_width = 350;
   int attack_X1, attack_X2;
   int attack_Y1, attack_Y2;
   int attack_speed = 21;
   int speed = 8;
   int jump = 10;
   int bossHP = 100;
   int playerAttack = 0;
   boolean leftCheck, rightCheck, jump_upCheck, attackCheck; //플레이어 이동 및 공격 체크
   private JFrame frame;
   
   public BossP1() {
      leftCheck = rightCheck = jump_upCheck = attackCheck = false;// 방향키
      initialize();
      
      Thread nextPage=new Thread(new Runnable() { //===== 보스 처치 시 다음페이지로 가는 쓰레드=====
		public void run() {
			while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if( bossHp1_Img == bossHp5_Img) {
				dispose();
				path1.main(null);
				break;
			}
			}
		}
	});
      nextPage.start();
      Thread thread = new Thread(new Runnable() { // =====플레이어 이동 쓰레드=====
         public void run() {
            while (true) {
               try {
                  Thread.sleep(10);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               keyPressCheck();
               hitCheck();
               if(playerImg==dieImg) { //=====플레이어가 사망할시 시작페이지로 이동=====
              	 if(playerAttack<20) {
              	JOptionPane.showMessageDialog(frame,"Game Over");
              	info_page.main(null);
             	 frame.dispose();

             	 break;
              	 }
             }
            }
         }
      });
      thread.start();
     
      Thread attack_UP1 = new Thread(new Runnable() {// =====보스의 천장 칼날 공격1=====
         public void run() {
            while (true) {
               attack_X1 = (new Random()).nextInt(backImg.getWidth(null) - 150);
               try {
                  Thread.sleep(2315);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      });
      attack_UP1.start();
      Thread attack_UP2 = new Thread(new Runnable() {// =====보스의 천장 칼날 공격1의 y좌표 랜덤 thread=====
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
      Thread attack_UP3 = new Thread(new Runnable() {// =====보스의 천장 칼날 공격2=====
         public void run() {
            while (true) {
               attack_X2 = (new Random()).nextInt(backImg.getWidth(null) - 100);
               try {
                  Thread.sleep(1277);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      });
      attack_UP3.start();
      Thread attack_UP4 = new Thread(new Runnable() {// =====보스의 천장 칼날 공격2의 y좌표 랜덤 thread=====
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
   }
   private void keyPressCheck() { //=====플레이어 이동 메소드=====
      if (jump_upCheck && playerY - speed > 0) {
         playerY -= jump;
         if (playerY < 250) {
            playerY = 530;
         }
      }
      if (leftCheck && playerX - speed > 0) {
         playerX -= speed;
      }
      if (rightCheck && playerX + playerImg.getWidth(null) + speed < backImg.getWidth(null)) {
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
   private void hitCheck() { //=====보스 공격 피격시 체크=====
      if (playerX + play_width > attack_X1+30 && attack_X1 + attack_width > playerX+30 && playerY + play_height > -30
            && -30 + attack_Y1 > playerY) {
         hp_count++; 	//===== hit check 될 때 마다 hp_count 1씩 더함=====
         
         if (hp_count == 30) { //=====hp_count 가 30이 되면 하트 이미지 변경=====
            heartImg = heartImg2;
         } else if (hp_count == 50) { //=====hp_count 가 50이 되면 하트 이미지 변경=====
            heartImg = heartImg3;
         } else if (hp_count == 70) { //=====hp_count 가 70이 되면 하트 이미지 변경=====
            heartImg = heartImg4;
         }
         if (heartImg == heartImg4) { //=====하트이미지가 없어지면 플레이어 이미지 사망이미지로 변경=====
             playerImg = dieImg;
             playerImg_right = dieImg;
             playerImg_left = dieImg;
             player_leftA = dieImg;
             player_rightA = dieImg;
         }
         }
   }
   class movingPlayer extends KeyAdapter {//=====플레이어 키어뎁터=====
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
         case KeyEvent.VK_A: //===== A키 누를 떄 효과=====
            if (playerImg == playerImg_right) {
               playerImg = player_rightA;
            } else if (playerImg == playerImg_left) {
               playerImg = player_leftA;
            }
            playerAttack++; //===== A키 누를 때마다 playerAttack이 1씩 올라감=====
            switch (playerAttack) {
            case 5:					//===== A키 5번 누르면 보스 hp 이미지 변경=====	 
               bossHp1_Img = bossHp2_Img;
               break;				//===== A키 10번 누르면 보스 hp 이미지 변경=====	 
            case 10:
               bossHp1_Img = bossHp3_Img;
               break;				//===== A키 15번 누르면 보스 hp 이미지 변경=====	 
            case 15:
               bossHp1_Img = bossHp4_Img;
               break;				//===== A키 20번 누르면 보스 hp 이미지 변경=====	 
            case 20:
               bossHp1_Img = bossHp5_Img;
          
            }
            back_Img = damageImg;  //===== A키를 누를때마다 데미지 표시=====
            break;
         case KeyEvent.VK_SPACE:
            jump_upCheck = true;
            break;
         case KeyEvent.VK_END:
        	 potion_count--; //=====포션 키를 누르면 하트이미지 회복=====
            if (heartImg == heartImg2) {
               heartImg = heartImg1;
            } else if (heartImg == heartImg3) {
               heartImg = heartImg2;
            } else if (heartImg == heartImg4) {
               heartImg = heartImg3;
            }
            
         }
      }
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

            back_Img = none_damage;
            break;

         case KeyEvent.VK_END:

         }
         super.keyReleased(e);
      }

   }

   class imagePanel extends JPanel { //이미지 패널

      public imagePanel() {
         backImg = new ImageIcon("src\\img\\back.jpg").getImage();
         bossImg = new ImageIcon("src\\img\\boss_mini.png").getImage();
         playerImg = new ImageIcon("src\\img\\player_right.png").getImage();
         bossHp1_Img = new ImageIcon("src\\img\\Hp1.png").getImage();
         potionImg = new ImageIcon("src\\img\\potion.png").getImage();
         heartImg = heartImg1;
         back_Img = new ImageIcon("src\\img\\back_1.png").getImage();
         Img_Ba1 = new ImageIcon("src\\img\\ba1.png").getImage();
         path_msg=new ImageIcon("src\\img\\path_msg.png").getImage();
      }

      public void paint(Graphics g) {
         g.drawImage(backImg, 0, 0, this);
         g.drawImage(back_Img, 529, 100, 309, 80, this);
         g.drawImage(bossImg, backImg.getWidth(null) / 2 - 235, backImg.getHeight(null) - 600, 500, 500, this);
         g.drawImage(playerImg, playerX, playerY, 120, 120, this);
         g.drawImage(bossHp1_Img, 320, 25, this);
         g.drawImage(heartImg, 5, 40, 180, 45, this);
         g.drawImage(Img_Ba1, attack_X1, -30, 350, attack_Y1, this);
         g.drawImage(Img_Ba1, attack_X2, -30, 350, attack_Y2, this);
         g.setColor(Color.white);
         g.setFont(new Font("Gothic", Font.BOLD, 40));
         g.drawString("HP : ", 240, 50);
         g.setFont(new Font("Gothic", Font.BOLD, 20));
         g.drawString("포션" , 1180, 430);
         g.drawImage(potionImg, 1140, 430, 120, 80, this);
         g.drawString("END 키", 1170, 520);
         if(playerAttack>=20) {
        	 g.drawImage(path_msg, 390, 50, 550,70, this);
        	 
         }
         this.repaint();
      }
   }
}