/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.Deck;
import java.util.Random;

/**
 *
 * @author manos
 */
public class MediumPlayer extends HardPlayer {
    
    
    public MediumPlayer(Deck deck) {
        super(deck);
        
    }
    /**
     * dexetai thn plhroforia oti uparxei to stoixeio y sth 8esh x. Thn apo8hkeuei me pi8anothta 50%
     * @param x
     * @param y 
     */
    @Override
    public void receiveKnowledge(int x, int y){
        Random r= new Random();
        if (r.nextBoolean()){
            knowledge.set(x,y);
        }
    }
    
    
}