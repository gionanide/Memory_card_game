/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import javax.swing.ImageIcon;

/**
 *
 * @author MANOS
 */
public class Card {
    private ImageIcon eikona; //to imageicon arxeio
    private int id; // monadikos ari8mos mias kartas, 2 idies kartes exoun to idio id
    
    public Card(ImageIcon eikona,int id){
        this.eikona=eikona;
        this.id=id;
    }
    
   /**
    * sugrish 2 card me bash to id
    * @param card
    * @return 
    */
   boolean compare(Card card){
       return card.id==this.id;
   }
    
    public Card getCard(){
        return this;
    }
    public ImageIcon getPicture(){
        return eikona;
    }
    public int getId(){
        return id;
    }
   
}
