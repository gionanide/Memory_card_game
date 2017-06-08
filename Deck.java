/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import cardgame.Card;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import cardgame.images.Resource;
import java.util.Random;

/**
 *
 * @author manos
 */
public class Deck {
    private ArrayList<Card> cards;
    private ArrayList<Boolean> visible; //Ξ΄Ξ·Ξ»Ο‰Ξ½ΞµΞΉ Ξ±Ξ½ ΞΌΞΉΞ± ΞΊΞ±Ο�Ο„Ξ± ΞµΞΉΞ½Ξ±ΞΉ ΞΏΟ�Ξ±Ο„Ξ· Ξ· ΞΏΟ‡ΞΉ(face up or facedown)
    private int size;//plh8os kartwn
    
    /**
     * Ξ΄ΞµΟ‡ΞµΟ„Ξ±ΞΉ Ο„ΞΏ Ο€Ξ»Ξ·ΞΈΞΏΟ‚ Ο„Ο‰Ξ½ Ξ΄ΞΉΞ±Ο†ΞΏΟ�ΞµΟ„ΞΉΞΊΟ‰Ξ½ ΞµΞΉΞΊΞΏΞ½Ο‰Ξ½
     * ΞΊΞ±ΞΈΟ‰Ο‚ ΞΊΞ±ΞΉ Ο„ΞΏ Ο€ΞΏΟƒΞ± Ξ±Ξ½Ο„ΞΉΞ³Ο�Ξ±Ο†Ξ± Ξ±Ο€ΞΏ ΞΊΞ±ΞΈΞµ ΞµΞΉΞΊΞΏΞ½Ξ± Ο€Ο�ΞµΟ€ΞµΞΉ Ξ½Ξ± ΞµΟ‡ΞµΞΉ Ο„ΞΏ Deck (Ο€Ο‡ 26,2)
     * Ξ�Ξ±Ξ»ΞµΞΉ Ο„Ξ·Ξ½ ΟƒΟ…Ξ½Ξ±Ο�Ο„Ξ·ΟƒΞ· Fill ΞΏΟƒΞµΟ‚ Ο†ΞΏΟ�ΞµΟ‚ Ο‡Ο�ΞµΞΉΞ±Ξ¶ΞµΟ„Ξ±ΞΉ ΞΊΞ±ΞΉ Ο„ΞµΞ»ΞΏΟ‚ Ο„Ξ·Ξ½ randomize
     * tis kanei ones not visible
     * @param size
     * @param multiply 
     */
    public Deck(int size,int multiply){
        this.size=size*multiply;
        cards=new ArrayList<>();
        visible=new ArrayList<>();
        for (int i=1;i<=size;i++){
            
            for (int y=1;y<=multiply;y++){
            String str= i + ".gif";
            
            cards.add(new Card(new ImageIcon(Resource.getURL(str)),i));
            visible.add(Boolean.FALSE);
            }
          
        }
        System.out.println("edw");
        randomize();   
     }
    /**
     * pros8etei sto arraylist mia karta me eikona kai id pou dinetai ws parametros
     * @param eikona
     * @param id 
     */     
    public void addCard(ImageIcon eikona,int id){
        cards.add(new Card (eikona,id));
    }
    
    /**
     * anakateuei ta stoixeia tou arraylist kanontas 500 tuxaies epanalhpseis
     */
    public void randomize(){
        Random r=new Random();
        for (int i=0;i<500;i++){//to 500 einai tuxaio noumero nomizw einai arketo
            int y = r.nextInt(size-1);
            Card temp= cards.get(0);
            cards.set(0,cards.get(y));
            cards.set(y,temp); 
            
        }
    }
    /**
     * antimeta8etei thn card sthn 8esh x me auth sth 8esh y
     * @param x
     * @param y 
     */
    public void swap(int x , int y){
        Card temp=cards.get(x);
        cards.set(x, cards.get(y));
        cards.set(y,temp);
    }
    /**
     * kanei visible thn card sthn 8esh pos
     * @param pos
     * @return to id ths card
     */
    public int showCard(int pos){
        visible.set(pos, Boolean.TRUE);
        return cards.get(pos).getId();
    }
    /**
     * allazei se not visible thn card sthn 8esh pos
     * @param pos 
     */
    public void hideCard(int pos){
        visible.set(pos, Boolean.FALSE);    
    }
    /**
     * kanei oles tis cards sto deck visible
     */
    public void setDeckVisible(){
        for (int i=0;i<size;i++){
            visible.set(i, Boolean.TRUE);
        }
    }
    /**
     * kanei oles tis cards sto deck not visible
     */
    public void hideDeck(){
    for (int i=0;i<size;i++){
          visible.set(i, Boolean.FALSE);
     }
    }
    /**
     * 
     * @return size 
     */
    public int getSize(){
        return size;
    }
    /**
     * 
     * @param pos
     * @return cards.get(pos)
     */
    public Card getCard(int pos){
        return cards.get(pos);
    }
    
    /**
     * 
     * @param pos
     * @return true if card.get(pos) is visible or else false
     */
    public boolean isCardVisible(int pos){
        if (visible.get(pos)==true){
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @return true if all cards are visible else false 
     */
    public boolean isAllVisible(){
        for(Boolean b:visible){
            if (b==false){
                return false;
            }
        }
        return true;
    }
}


