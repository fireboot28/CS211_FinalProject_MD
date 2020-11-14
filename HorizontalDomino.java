//HorizontalDomino class - represents a sideways domino on the board (for already played dominos)

import javax.swing.*; //needed for GUI
import java.awt.*; //needed for Point class

public class HorizontalDomino extends JButton{ /*not needed to be JButton, but better that it is so that it looks like
 * the other dominos of class Domino */
   private static final int length = 60;
   private static final int width = 30;
   private int num1, num2;
   private Point p;
   private static final int dotSize = 7;
   
   public HorizontalDomino(int num1, int num2, int x, int y){ //similar to Domino's constructor
     this.num1 = num1;
     this.num2 = num2;
     this.p = new Point(x, y);
     setBounds((int)p.getX(), (int)p.getY(), length, width);
     setBackground(Color.WHITE);
   }
   
   public HorizontalDomino(int num1, int num2, Point p){ //similar to Domino's constructor
     this.num1 = num1;
     this.num2 = num2;
     this.p = p;
     setBounds((int)p.getX(), (int)p.getY(), length, width);
   }
   
   public void paintComponent(Graphics g){
     super.paintComponent(g);
     g.setColor(Color.BLACK);
     g.drawRect(0, 0, length, width); 
     g.drawLine(30, 0, 30, width);
     if(this.num1 == 1){
       g.fillOval(11, 12, dotSize, dotSize);
     }
     else if(this.num1 == 2){
       g.fillOval(2, 2, dotSize, dotSize);
       g.fillOval(20, 20, dotSize, dotSize);
     }
     else if(this.num1 == 3){
       g.fillOval(2, 2, dotSize, dotSize);
       g.fillOval(11, 12, dotSize, dotSize);
       g.fillOval(20, 20, dotSize, dotSize);
     }
     else if(this.num1 == 4){
       g.fillOval(2, 2, dotSize, dotSize);
       g.fillOval(20, 20, dotSize, dotSize);
       g.fillOval(2, 20, dotSize, dotSize);
       g.fillOval(20, 2, dotSize, dotSize);
     }
     else if(this.num1 == 5){
       g.fillOval(2, 2, dotSize, dotSize);
       g.fillOval(20, 20, dotSize, dotSize);
       g.fillOval(2, 20, dotSize, dotSize);
       g.fillOval(20, 2, dotSize, dotSize);
       g.fillOval(11, 12, dotSize, dotSize);
     }
     else if(this.num1 == 6){
       g.fillOval(2, 2, dotSize, dotSize);
       g.fillOval(20, 20, dotSize, dotSize);
       g.fillOval(2, 20, dotSize, dotSize);
       g.fillOval(20, 2, dotSize, dotSize);
       g.fillOval(11, 2, dotSize, dotSize);
       g.fillOval(11, 20, dotSize, dotSize);
     }
     if(this.num2 == 1){
       g.fillOval(41, 12, dotSize, dotSize);
     }
     else if(this.num2 == 2){
       g.fillOval(32, 2, dotSize, dotSize);
       g.fillOval(50, 20, dotSize, dotSize);
     }
     else if(this.num2 == 3){
       g.fillOval(32, 2, dotSize, dotSize);
       g.fillOval(41, 12, dotSize, dotSize);
       g.fillOval(50, 20, dotSize, dotSize);
     }
     else if(this.num2 == 4){
       g.fillOval(32, 2, dotSize, dotSize);
       g.fillOval(50, 20, dotSize, dotSize);
       g.fillOval(32, 20, dotSize, dotSize);
       g.fillOval(50, 2, dotSize, dotSize);
     }
     else if(this.num2 == 5){
       g.fillOval(32, 2, dotSize, dotSize);
       g.fillOval(50, 20, dotSize, dotSize);
       g.fillOval(32, 20, dotSize, dotSize);
       g.fillOval(50, 2, dotSize, dotSize);
       g.fillOval(41, 12, dotSize, dotSize);
     }
     else if(this.num2 == 6){
       g.fillOval(32, 2, dotSize, dotSize);
       g.fillOval(50, 20, dotSize, dotSize);
       g.fillOval(32, 20, dotSize, dotSize);
       g.fillOval(50, 2, dotSize, dotSize);
       g.fillOval(41, 2, dotSize, dotSize);
       g.fillOval(41, 20, dotSize, dotSize);
     }
   }
   
   public int getX(){
     return (int)this.p.getX();
   }
   
   public int getY(){
     return (int)this.p.getY();
   }
   
   public int getNum1(){
    return this.num1;
  }
  
  public int getNum2(){
    return this.num2;
  }
  
}