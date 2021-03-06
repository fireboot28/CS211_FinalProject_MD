import java.util.ArrayList;
//TODO possibly impement stack , pop, etc
public class DeckD {
 
 private ArrayList<DominoD> boneyard;
 
 public DeckD() {
  
//if numPlayers = ?, than change size of deck
  //(if numPlayers <=2)   
  boneyard = new ArrayList<DominoD>();
  //adds every standard domino: 28 pieces
  for (int i = 0; i < 7; i++) {    
   for (int j = i; j < 7; j++) {
    DominoD piece = new DominoD(i, j, 0, 0);
    boneyard.add(piece);

   }
  }
  
  this.shuffle();
   
 }
 
 public DeckD(boolean isDeck){
   boneyard = new ArrayList<DominoD>();
 }
 
 
 public ArrayList<DominoD> getBoneyard(){
  
     return boneyard;
    }
 
 public DominoD getPiece(){
  
     DominoD piece = boneyard.get(0);
     boneyard.remove(0);
     return piece;
    }
 
 public void remove(DominoD d){
   this.boneyard.remove(d);
 }
 
 public void shuffle() {
     
     ArrayList<DominoD> shuffled = new ArrayList<DominoD>();
     int rand;
    
     //shuffled takes dominoes from boneyard in random order
     while (boneyard.size() > 0){
        rand = (int)(Math.random()*boneyard.size());
        shuffled.add( boneyard.get(rand) );
        boneyard.remove(rand);
     }
       
     boneyard = shuffled;//now points to shuffled
 }
 
 public String toString(){
  String s = "";
  for(DominoD a: boneyard) {
   s += a;
  }
  return s;
 }
}