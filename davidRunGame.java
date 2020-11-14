import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class davidRunGame{
  public static Domino dominoCenter, dominoRight, dominoLeft;
  public static int numDominosPlayed = 0;
  public static HorizontalDomino hDominoLeft, hDominoRight;
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  
  JFrame frame = new JFrame("Dominos");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  frame.setSize(800, 800);;
  frame.setResizable(false);
  
  JPanel uiLayout = new JPanel((new BorderLayout()));
  JPanel board = new JPanel(new GridBagLayout());
  JPanel hand = new JPanel(new GridBagLayout());
  //hand.setPreferredSize(new Dimension( 200, 200));
  
  
  JPanel above = new JPanel();
  JLabel testTitle = new JLabel("Domino Game", JLabel.CENTER);
  above.add(testTitle);
  
  JPanel menuPanel = new JPanel();
  JLabel testInfo = new JLabel("Information", JLabel.CENTER);
  menuPanel.add(testInfo);
  
  uiLayout.add(above, BorderLayout.NORTH);
  uiLayout.add(menuPanel, BorderLayout.EAST);//holds instructions, static score, possibly other buttons. unrelated note, popups when game end
  uiLayout.add(board, BorderLayout.CENTER);
  uiLayout.add(hand, BorderLayout.SOUTH);
  
  frame.add(uiLayout);
  //frame created, panel added to frame, items added to panel
  //FlowLayout show = new FlowLayout();
  
  
  /*
  GridBagLayout show = new GridBagLayout();
  hand.setLayout(show);*/  
  //we need a layout manager; to display components or
  Deck bone = new Deck(2);
 // System.out.println(a); 
  
 // Deck deck = new Deck(2);
  Domino domino = new Domino(6, 6, 200, 100 );
  Domino domino2 = new Domino(1, 2, 200, 100 );
  Domino domino3 = new Domino(2, 3, 200, 100 );
  Domino domino4 = new Domino(4, 5, 200, 100 );
  Domino domino5 = new Domino(1, 3, 200, 100 );
  HorizontalDomino domino6 = new HorizontalDomino(2,4,200, 100);

  //Player a = new Player();
 // draw(a, bone, 7);
  //for(int i = 0; i< a.getHand().size(); i++) {
 /* 
  for(int i = 0; i < bone.getBoneyard().size(); i++) {
   frame.add(a.getHand().get(i));
  }*/
  
  //HAND constraint
  GridBagConstraints sizeInHand = new GridBagConstraints();
  sizeInHand.fill = GridBagConstraints.HORIZONTAL;
  sizeInHand.ipadx = 25;      //make this sizeInHandomponent tall
  sizeInHand.ipady = 110;
  sizeInHand.weightx = 0; //spesizeInHandify ssizeInHandaling as window size insizeInHandreases
  //sizeInHand.gridwidth = 4; //spesizeInHandifies num of sizeInHandells
  sizeInHand.gridheight = 8;
  sizeInHand.anchor = GridBagConstraints.PAGE_END;
  sizeInHand.gridy = sizeInHand.gridheight;
  int count = 0;
  sizeInHand.gridy = 8;
  
  //temporary
  GridBagConstraints sizeOnBoard = new GridBagConstraints();
  sizeOnBoard.fill = GridBagConstraints.HORIZONTAL;
 /* sizeOnBoard.gridx = 0;
  sizeOnBoard.gridy = 0;*/
  sizeOnBoard.ipadx = 11;      //make this sizeOnBoardomponent tall
  sizeOnBoard.ipady = 85;
  sizeOnBoard.weightx = 0; //spesizeOnBoardify ssizeOnBoardaling as window size insizeOnBoardreases
  //sizeOnBoard.gridwidth = 4; //spesizeOnBoardifies num of sizeOnBoardells
  sizeOnBoard.gridheight = 8;
  sizeOnBoard.anchor = GridBagConstraints.PAGE_END;
  sizeOnBoard.gridy = sizeOnBoard.gridheight;
  //int count = 0;
  sizeOnBoard.gridy = 8;
  
  GridBagConstraints sizeOnBoard2 = new GridBagConstraints();
  sizeOnBoard2.fill = GridBagConstraints.HORIZONTAL;
  sizeOnBoard2.ipadx = 60;      //make this sizeOnBoardomponent tall
  sizeOnBoard2.ipady = 39;
  sizeOnBoard2.weightx = 0; //spesizeOnBoardify ssizeOnBoardaling as window size insizeOnBoardreases
  //sizeOnBoard.gridwidth = 4; //spesizeOnBoardifies num of sizeOnBoardells
  sizeOnBoard2.gridheight = 8;
  sizeOnBoard2.insets = new Insets(20,0,0,0);
  sizeOnBoard2.anchor = GridBagConstraints.PAGE_END;
  sizeOnBoard2.gridy = sizeOnBoard.gridheight;
  //int count = 0;
  sizeOnBoard2.gridy = 7;
 
  
 /* ActionListener click = new ActionListener() {
   public void actionPerformed(ActionEvent e){
          domino.resize();//domino is resized (dots and rectangle only, not button with current code)
          
        //  domino.removeActionListener(e);//use if statement later .... ONLY IF Domino is to be placed on the board and finalized
          board.add(domino, sizeOnBoard);//board gets the domino with new constraints;
          hand.remove(domino);//hand loses the domino
          
        //refresh visuals and recalculate layout with the domino moved from hand to board(resized)
          hand.revalidate();
          hand.repaint();
        }
      };*/
/*  addHandDomino(domino, hand, board, sizeInHand, sizeOnBoard);
  addHandDomino(domino2, hand, board, sizeInHand, sizeOnBoard);
  addHandDomino(domino3, hand, board, sizeInHand, sizeOnBoard);
  addHandDomino(domino4, hand, board, sizeInHand, sizeOnBoard);
  addHandDomino(domino5, hand, board, sizeInHand, sizeOnBoard);*/
  board.add(domino6, sizeOnBoard2);
  //addHandDomino(domino2, hand, c);
  
 Domino d2 = new Domino(0, 6, 200, 100);
   // hand.add(d2, c);
   // hand.add(domino, c);
  /*  domino.addActionListener(new ActionListener(){ //attaches and action listener to the domino
      public void actionPerformed(ActionEvent e){
        domino.resize();
      }
    });*/
}

 public static Point newCoord(Domino domino){
    if(canBePlayed(domino) == false){
      return null;
    }
    else{
      if(numDominosPlayed == 0 && domino.isDouble() == true){
        numDominosPlayed++;
        dominoCenter = domino;
        return new Point(185, 170);
      }
      else{
        if(dominoLeft != null){ //domino played must be horizontal
          if(domino.getNum1() == dominoLeft.getNum1() || domino.getNum2() == dominoLeft.getNum1()){
            dominoLeft = null;
            return new Point(dominoLeft.getX() - 60, dominoLeft.getY() + 15);
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
              hDominoRight = null;
              return new Point(hDominoRight.getX() + 60, hDominoRight.getY() - 15);
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
              hDominoLeft = null;
              return new Point(hDominoLeft.getX() - 60, hDominoLeft.getY() - 15);
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
  
  public static void playDomino(Domino domino, JPanel board){
    System.out.println(canBePlayed(domino));
    if(canBePlayed(domino) == true){
     System.out.println(canBePlayed(domino));
     domino.addActionListener(new ActionListener(){ //attaches and action listener to the domino  
     public void actionPerformed(ActionEvent e){
       if(domino.isDouble() == true){
          domino.resize(newCoord(domino));//domino is resized (dots and rectangle only, not button with current code)
       }
       else{
         domino.setVisible(false);
         Point p = newCoord(domino);
         HorizontalDomino d = new HorizontalDomino(domino.getNum1(), domino.getNum2(), (int)p.getX(), (int)p.getY());
         board.add(d);
         board.remove(domino);
       }
     }
     });
    }
    else{
      return;
    }
  }

 //would be in deckgame
 public void draw(ArrayList<Domino> hand, Deck boneyard, int amount) {
  for (int i = 0; i < amount; i++) {
   hand.add(boneyard.getPiece());
  }
 }
 

 
}



