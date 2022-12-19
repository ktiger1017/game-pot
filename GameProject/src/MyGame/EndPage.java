package MyGame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EndPage {
   public static void main(String[] args) {
      new BossPath3();
   }
}
class BossPath3 extends JFrame {
   private static final long serialVersionUID = 1L;
   Image backImg, bossImg, playerImg, potionImg, heartImg, back_Img;
   int count=0;
   private JFrame frame;
   
   public BossPath3() {
      initialize();
      
      Thread thread=new Thread(new Runnable() { //=====클리어 시 나오는 이미지=====
    	  
		public void run() {
			while(true) {
				count++;
				if(count==4) { //=====4초 유지=====
					
					info_page.main(null);
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
  
    class imagePanel extends JPanel { //이미지 패널

      public imagePanel() {
         backImg = new ImageIcon("src/img/endimg.png").getImage();
   
      }


	public void paint(Graphics g) {
        g.drawImage(backImg, 0, 0,frame.getWidth(),frame.getHeight(), this);

         this.repaint();
      }
    }
}
  