import java.util.ArrayList;
//TODO possibly impement stack , pop, etc
public class Deck {
 
 private ArrayList<Domino> boneyard;
 
 public Deck(int numPlayers) {
  
//if numPlayers = ?, than change size of deck
  //(if numPlayers <=2)   
  boneyard = new ArrayList<Domino>();
  //adds every standard domino: 28 pieces
  for (int i = 0; i < 7; i++) {    
   for (int j = i; j < 7; j++) {
    Domino piece = new Domino(i, j, 0, 0);
    boneyard.add(piece);

   }
  }
  
  this.shuffle();
   
 }
 
 
 public ArrayList<Domino> getBoneyard(){
  
     return boneyard;
    }
 
 public Domino getPiece(){
  
     Domino piece = boneyard.get(0);
     boneyard.remove(0);
     return piece;
    }
 
 public void shuffle() {
     
     ArrayList<Domino> shuffled = new ArrayList<Domino>();
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
  for(Domino a: boneyard) {
   s += a;
  }
  return s;
 }
}
