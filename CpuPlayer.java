/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.Deck;
import cardgame.players.Player;
import java.util.Random;

/**
 *
 * @author manos
 */
public class CpuPlayer extends Player {
    protected Deck deck;
    
    public CpuPlayer(Deck deck){
        super();
        this.deck=deck;
    }
    /**
     * epistrefei random ena card apo to deck
     * @return 
     */
    @Override
    public int choose(){
        Random r = new Random();
        return (r.nextInt(deck.getSize()-1));
    }//ΞΊΞ±Ξ»ΞµΞΉ ΞΌΞΉΞ± ΟƒΟ…Ξ½Ξ±Ο�Ο„Ξ·ΟƒΞ· Ο�Ξ±Ξ½Ο„ΞΏΞΌ ΞΊΞ±ΞΉ Ξ΄ΞΉΞ±Ξ»ΞµΞ³ΞµΞΉ ΟƒΟ„Ξ·Ξ½ Ο„Ο…Ο‡Ξ· ΞµΞ½Ξ± Ο‡Ξ±Ο�Ο„ΞΉ Ξ±Ο€ΞΏ Ο„ΞΏ Ξ½Ο„ΞµΞΊ
    
    /**
    * epistrefei random ena card apo to deck 
    */
    @Override
    public int chooseThree(){
        return choose();
        
    }
}