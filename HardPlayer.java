/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.Deck;
import cardgame.players.CpuPlayer;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author manos
 */
public class HardPlayer extends CpuPlayer {
    protected ArrayList<Integer> knowledge;//ΟƒΞµ ΞΊΞ±ΞΈΞµ ΞΈΞµΟƒΞ· Ο„ΞΏΟ… Ο€ΞΉΞ½Ξ±ΞΊΞ± Ξ±Ξ½Ο„ΞΉΟƒΟ„ΞΏΞΉΟ‡ΞµΞΉ Ξ· ΞΈΞµΟƒΞ· ΞµΞ½ΞΏΟ‚ Ο‡Ξ±Ο�Ο„ΞΉΞΏΟ…
    //Ξ±Ξ½ Ο„ΞΏ ΟƒΟ„ΞΏΞΉΟ‡ΞµΞΉΞΏ ΞµΞΉΞ½Ξ±ΞΉ -1 ΟƒΞ·ΞΌΞ±ΞΉΞ½ΞµΞΉ Ξ΄ΞµΞ½ ΞΎΞµΟ�ΞµΞΉ Ο„ΞΉ Ο…Ο€Ξ±Ο�Ο‡ΞµΞΉ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ Ο€Ο�ΞΏΞΊΞµΞΉΟ„Ξ±ΞΉ Ξ³ΞΉΞ± Ο„ΞΏ id
    //Ο„Ξ·Ο‚ ΞΊΞ±Ο�Ο„Ξ±Ο‚ ΟƒΟ„Ξ·Ξ½ ΞΈΞµΟƒΞ· ΞµΞΊΞµΞΉΞ½Ξ·
    protected int turn;
    protected int holdUp;
    protected int holdUp2;
    protected int randomReturned2;
    protected int randomReturned;//mia xrhsimh metablhth gia thn choose

    public HardPlayer(Deck deck) {
        super(deck);
        holdUp=-1;
        holdUp2=-1;
        turn=1;
        randomReturned2=-1;
        randomReturned=-1;
        knowledge = new ArrayList<>();
        for (int i=0;i<deck.getSize();i++){
            knowledge.add(-1);
        }
    }
    
    @Override
    /**
     * epilegei 1 card . leitourgei se ola ta modes ektos apo to trio kai to monomaxia
     */
    public int choose(){
        
        if (turn==2 && holdUp!=-1){
            turn=1;
            int temp= holdUp;
            holdUp=-1;
            return temp;
        }
        else if (turn==1){
            for (int i=0;i<knowledge.size();i++){
                if ((!deck.isCardVisible(i))&&(knowledge.get(i)).intValue()!=-1){
                    for (int y=i+1;y<knowledge.size();y++){
                        if (knowledge.get(i).intValue()==knowledge.get(y).intValue() && deck.isCardVisible(y)==false){
                            turn=2;
                            holdUp=y;
                            return i;
                        }
                    }
                }
            }
            Random r= new Random();
            int x;
            do{
                x=r.nextInt(deck.getSize());
            }while (deck.isCardVisible(x)==true);
            turn=2;
            randomReturned=x;
            return x;   
        }
        else {
            for (int i=0;i<knowledge.size();i++){
                if (randomReturned!=i && knowledge.get(i)==deck.getCard(randomReturned).getId()) {
                    turn=1;
                    randomReturned=-1;
                    return i;
                }
            }
            Random r= new Random();
            int x;
            do{
                x=r.nextInt(deck.getSize());
            }while (deck.isCardVisible(x)==true);
            turn=1;
            randomReturned=-1;
            return x;
        }
    }   
    /**
     * epilegei 1 card. Leitourgei gia to modeTrio
     * @return 
     */
    @Override
    public int chooseThree(){
        if (turn==2 && holdUp!=-1 && holdUp2!=-1){
            turn++;
            int temp=holdUp;
            holdUp=-1;
            return temp;
        }
        else if (turn==3 && holdUp2!=-1){
            turn=1;
            int temp=holdUp2;
            holdUp2=-1;
            randomReturned=-1;
            randomReturned2=-1;
            
            return temp;
        }
        else if (turn==1){
            
             for (int i=0;i<knowledge.size();i++){
                 if ((!deck.isCardVisible(i))&&(knowledge.get(i)).intValue()!=-1){
                     for (int y=i+1;y<knowledge.size();y++){
                         if (knowledge.get(i).intValue()==knowledge.get(y).intValue() && deck.isCardVisible(y)==false){
                             for (int z=y+1;z<knowledge.size();z++){
                                 if (knowledge.get(z).intValue()==knowledge.get(y).intValue() && deck.isCardVisible(z)==false){
                                     turn=2;
                                     holdUp=y;
                                     holdUp2=z;
                                     return i;
                                 }
                             }
                             
                         }
                     }
                 }
             }
             Random r= new Random();
             int x;
             do{
                 x=r.nextInt(deck.getSize()-1);
             }while (deck.isCardVisible(x)==true);
             turn=2;
             randomReturned=x;
             return x; 
        }
        else if (turn==2){
            
            for (int i=0;i<knowledge.size();i++){
                if (randomReturned!=i && knowledge.get(i)==deck.getCard(randomReturned).getId()) {
                    for (int y=i+1;y<knowledge.size();y++){
                        if (knowledge.get(y)==deck.getCard(randomReturned).getId()&& randomReturned!=y){
                            turn=3;
                            holdUp2=y;
                            randomReturned=-1;
                            return i;
                        }
                    }
                } 
            }
            Random r= new Random();
            int x;
            do{
                x=r.nextInt(deck.getSize());
            }while (deck.isCardVisible(x)==true);
            turn=3;
            randomReturned2=x;
            return x;
        }
        else {
            if (deck.getCard(randomReturned).getId()==deck.getCard(randomReturned2).getId()){
                for (int i=0;i<knowledge.size();i++){
                    if (randomReturned!=i && randomReturned2!=i && knowledge.get(i)==deck.getCard(randomReturned).getId()){
                        turn=1;
                        randomReturned=-1;
                        randomReturned2=-1;
                        return i;
                    } 
                }
            }
            
            Random r= new Random();
            int x;
            do{
                x=r.nextInt(deck.getSize());
            }while (deck.isCardVisible(x)==true);
            turn=1;
            randomReturned=-1;
            randomReturned2=-1;
            return x;
            
        }
    }
   /**
    * 8etei sthn 8esh x tou arraylist Knowledge thn timh y
    * @param x
    * @param y 
    */         
    public void receiveKnowledge(int x, int y){
        knowledge.set(x,y);
    }  
    /**
     * 8etei sthn 8esh x tou arraylist Knowledge thn timh -1
     * @param x 
     */
    public void deleteKnowledge(int x){
        knowledge.set(x,-1);
    }
}

