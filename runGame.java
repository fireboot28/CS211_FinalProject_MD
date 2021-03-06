//Class with main method that runs/tests the game.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //needed to implement an actionListener for each button
public class runGame{
  public static int numDominosPlayed = 0;
  public static Domino dominoCenter, dominoLeft, dominoRight;
  public static HorizontalDomino hDominoLeft, hDominoRight;
  public static void main(String[] args){
    JFrame frame = new JFrame("Dominos");
    JPanel board = new JPanel();
    JTextField output = new JTextField(15);
   // JPanel hand = new JPanel(new GridBagLayout());
    frame.setVisible(true);
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes panel on exit button
    frame.add(board);
   // frame.add(hand, BorderLayout.CENTER);
  //  board.setLayout(new GirdBagLayout); //allows for dominos buttons to appear with the proper width/height
    GridBagConstraints gc = new GridBagConstraints();
    gc.gridx = 5;
    gc.gridy = 0;
    gc.insets = new Insets(10, 10, 10, 10);
   // gc.
    Deck deck = new Deck(2);
    int count = 0;
    
 /*   for(int i = 0; i < deck.getBoneyard().size(); i++){
      count++;
      hand.add(deck.getPiece(), gc);
      if(count % 7 == 0){
        gc.gridy--; //creates new row (7 dominos per row)
      }
    }  */
    
    
    
    Domino domino = new Domino(3, 3, 200, 100); //shows with 6 dots
    Domino d2 = new Domino(3, 4, 300, 100);
    Domino d3 = new Domino(4, 5, 200, 300);
    Domino d4 = new Domino(5, 5, 300, 300);
    Domino d5 = new Domino(3, 0, 100, 0);
    Domino d6 = new Domino(0, 0, 50, 250);
    Domino d7 = new Domino(0, 6, 10, 0);
    board.add(d7);
    board.add(d6);
    board.add(d5);
    board.add(d4);
    board.add(d3);
    board.add(d2);
    board.add(domino);
    runGame.playDomino(domino, board);
    try{
    while(numDominosPlayed < 5){
   //   try{
      //runGame.playDomino(domino, board);
      runGame.playDomino(d2, board);
      runGame.playDomino(d3, board);
      runGame.playDomino(d4, board);
      runGame.playDomino(d5, board);
      runGame.playDomino(d6, board);
      runGame.playDomino(d7, board);
      System.out.println(canBePlayed(d6));
     
  //    }
  /*    catch(NullPointerException n){
        System.out.println("Can't play that domino yet");
        continue;
      }*/
    } 
    System.out.println("Finished");
    }
    catch(Exception n){
      System.out.println("Can't play this domino yet");
      return;
    }
  //  System.out.println(domino.getY());
 /*   domino.addActionListener(new ActionListener(){ //attaches and action listener to the domino
      public void actionPerformed(ActionEvent e){
        if(domino.getNum1() == domino.getNum2()){
          domino.resize(newCoord(domino));
          if(numDominosPlayed == 1){
            dominoCenter = domino;
          }
        }
        else{
          domino.setVisible(false);
          HorizontalDomino d = new HorizontalDomino(domino.getNum1(), domino.getNum2(), 200, 100);
          board.add(d);
          board.remove(domino);
        }
      }
    }); */
    frame.pack(); //makes dominos appear immediately
  }
  
  public static Point newCoord(Domino domino){
    if(canBePlayed(domino) == false){
      return null;
    }
    else{
      if(numDominosPlayed == 0 && domino.isDouble() == true){
        dominoCenter = domino;
        return new Point(185, 170);
      }
      else{
        if(centerRightOpen() == true){
          if(domino.getNum1() == dominoCenter.getNum1() || domino.getNum2() == dominoCenter.getNum1()){
            return new Point(dominoCenter.getX() + 30, dominoCenter.getY() + 15);
          }
        }
        if(centerLeftOpen() == true){
          if(domino.getNum1() == dominoCenter.getNum1() || domino.getNum2() == dominoCenter.getNum1()){
            return new Point(dominoCenter.getX() - 60, dominoCenter.getY() + 15);
          }
        }
        if(dominoLeft != null){ //domino played must be horizontal
          if(domino.getNum1() == dominoLeft.getNum1() || domino.getNum2() == dominoLeft.getNum1()){
            Point p = new Point(dominoLeft.getX() - 60, dominoLeft.getY() + 15);
            dominoLeft = null;
            return p;
          }
        }
        if(dominoRight != null){ //domino played must be horiztonal
         if(domino.getNum1() == dominoRight.getNum1() || domino.getNum2() == dominoRight.getNum1()){
            dominoRight = null;
            return new Point(dominoRight.getX() + 60, dominoRight.getY() + 15);
          } 
        }
        if(hDominoRight != null){
          if(domino.getNum1() == hDominoRight.getNum2() || domino.getNum2() == hDominoRight.getNum2()){
            if(domino.isDouble() == true){
              dominoRight = domino;
              Point p = new Point(hDominoRight.getX() + 60, hDominoRight.getY() - 15);
              hDominoRight = null;
              return p;
            }
            else{
              return new Point(hDominoRight.getX() + 60, hDominoRight.getY());
            }
          }
        }
        if(hDominoLeft != null){
          if(domino.getNum1() == hDominoLeft.getNum1() || domino.getNum2() == hDominoLeft.getNum1()){
            if(domino.isDouble() == true){
              dominoLeft = domino;
              Point p = new Point(hDominoLeft.getX() - 30, hDominoLeft.getY() - 15);
              hDominoLeft = null;
              return p;
            }
            else{
              return new Point(hDominoLeft.getX() - 60, hDominoLeft.getY());
            }
          }
        }
        return null;
      }
    }
  }
  
  public static boolean canBePlayed(Domino domino){
    if(numDominosPlayed == 0){
      if(domino.isDouble() == true){
        return true;
      }
    }
    if(numDominosPlayed == 1){
      if(domino.getNum1() == dominoCenter.getNum1() || domino.getNum2() == dominoCenter.getNum2()){
        return true;
      }
      return false;
    }
    else{
      if(numDominosPlayed >= 1){
        if(runGame.centerRightOpen() == true){
          if(domino.getNum1() == dominoCenter.getNum1() || domino.getNum2() == dominoCenter.getNum1()){
            return true;
          }
        }
        if(runGame.centerLeftOpen() == true){
          if(domino.getNum1() == dominoCenter.getNum1() || domino.getNum2() == dominoCenter.getNum1()){
            return true;
          }
        }
      }
      if(dominoLeft != null){
        if(domino.getNum1() == dominoLeft.getNum1() || domino.getNum2() == dominoLeft.getNum1()){
          return true;
        }
      }
      if(dominoRight != null){
       if(domino.getNum1() == dominoRight.getNum1() || domino.getNum2() == dominoRight.getNum1()){
          return true;
        } 
      }
      if(hDominoRight != null){
        if(domino.getNum1() == hDominoRight.getNum2() || domino.getNum2() == hDominoRight.getNum2()){
          return true;
        }
      }
      if(hDominoLeft != null){
        if(domino.getNum1() == hDominoLeft.getNum1() || domino.getNum2() == hDominoLeft.getNum1()){
          return true;
        }
      }
      return false;
    }
   }
  
  public static void setHDomino(HorizontalDomino hd){
    if((hd.getX() > dominoCenter.getX()) && (hd.getY() == 185)){
      hDominoRight = hd;
    }
    else if((hd.getX() < dominoCenter.getX()) && (hd.getY() == 185)){
      hDominoLeft = hd;
    } 
  }
  
  public static void setVDomino(Domino d){
    if(d.getX() < dominoCenter.getX()){
      dominoLeft = d;
    }
    else if(d.getX() > dominoCenter.getX()){
      dominoRight = d;
    }
  }
  //if domino center == null, check values for center domino
  public static void playDomino(Domino domino, JPanel board){
    if((canBePlayed(domino) == true)) {
     domino.addActionListener(new ActionListener(){ //attaches and action listener to the domino  
     public void actionPerformed(ActionEvent e){
       try{
       if(domino.isDouble() == true && domino.getIsPlayed() == false && canBePlayed(domino) == true){
         System.err.println(domino.getX());
          domino.resize(newCoord(domino));//domino is resized (dots and rectangle only, not button with current code)
          if(dominoCenter != domino){
            runGame.setVDomino(domino);
          }
          domino.setIsPlayed();
          numDominosPlayed++;
          return;
       }
       else{
         if(domino.getIsPlayed() == false){
           Point p = newCoord(domino);
           HorizontalDomino d;
           if((p.getX() > dominoCenter.getX()) && (p.getY() == 185)){
             d = new HorizontalDomino(domino.getNum1(), domino.getNum2(), p);
             d.setBackground(Color.WHITE);
           }
           else{
             d = new HorizontalDomino(domino.getNum2(), domino.getNum1(), p);
             d.setBackground(Color.WHITE);
           }
           runGame.setHDomino(d);
           board.add(d);
           domino.setVisible(false);
           board.remove(domino);
           domino.setIsPlayed();
           numDominosPlayed++;
           return;
         }
       }
       }
       catch(NullPointerException n){
       //  System.err.println("Can't play this domino yet!");
         return;
       } 
     }
     });
    }
  }
  
  public static boolean centerRightOpen(){
    if(dominoRight == null && hDominoRight == null){
      return true;
    }
    else{
      return false;
    }
  }
  
  public static boolean centerLeftOpen(){
    if(dominoLeft == null && hDominoLeft == null){
      return true;
    }
    else{
      return false;
    }
  }
}