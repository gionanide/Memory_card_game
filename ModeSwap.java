/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import cardgame.Graphics.NormalAsker;
import cardgame.modes.Mode;
import cardgame.*;
import java.util.ArrayList;
import cardgame.players.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manos
 */
public class ModeSwap extends ModeNormal { //Ο€ΞΏΞ»Ξ»ΞΏΞΉ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚ , Ξ±Ξ½ Ξ²Ο�ΞµΞΉΟ‚ ΞΎΞ±Ξ½Ξ±Ο€Ξ±ΞΉΞ¶ΞµΞΉΟ‚
    
    /**Ο�Ο‰Ο„Ξ±ΞµΞΉ Ο€ΞΏΟƒΞΏΟ…Ο‚ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚ ΞΊΞ±ΞΉ Ο„ΞΉ Ξ΄Ο…ΟƒΞΊΞΏΞ»ΞΉΞ± , Ο„ΞΏΟ…Ο‚ Ο€ΞµΟ�Ξ½Ξ±ΞµΞΉ ΟƒΟ„ΞΏ players
        *Ξ΄Ξ·ΞΌΞΉΞΏΟ…Ο�Ξ³ΞµΞΉ ΞµΞ½Ξ± deck (26,2)
        */
    public ModeSwap() throws InterruptedException{
        super();
    }
        
            
    /** Ξ’Ξ±Ξ¶ΞµΞΉ Ο„ΞΏΞ½ Ο€Ξ±ΞΉΞΊΟ„Ξ· Ο€ΞΏΟ… ΞµΟ‡ΞµΞΉ ΟƒΞµΞΉΟ�Ξ± (step mod players) Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΌΞΉΞ± ΞΊΞ±Ο�Ο„Ξ± ΞΊΞ±ΞΉ ΟƒΟ„ΞµΞ»Ξ½ΞµΞΉ Ο„Ξ·Ξ½ Ξ³Ξ½Ο‰ΟƒΞ· ΟƒΞµ ΞΏΞ»ΞΏΟ…Ο‚ Ο„ΞΏΟ…Ο‚ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚
    *Ο„ΞΏΞ½ Ξ²Ξ±Ξ¶ΞµΞΉ Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΊΞ±ΞΉ 2Ξ· ΞΊΞ±ΞΉ ΟƒΟ„ΞµΞ»Ξ½ΞµΞΉ Ο€Ξ±Ξ»ΞΉ Ο„Ξ·Ξ½ Ξ³Ξ½Ο‰ΟƒΞ·. Ξ‘Ξ½ ΞµΞΉΞ½Ξ±ΞΉ ΞΉΞ΄ΞΉΞµΟ‚ Ο„ΞΉΟ‚ Ξ±Ο†Ξ·Ξ½ΞµΞΉ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ Ο„ΞΉΟ‚ ΞΎΞ±Ξ½Ξ±ΞΊΞ±Ξ½ΞµΞΉ swap kai hide
    *Ξ±Ξ½ ΞµΞΉΞ½Ξ±ΞΉ ΞΉΞ΄ΞΉΞµΟ‚ ΞΎΞ±Ξ½Ξ±Ξ΄ΞΉΞ½ΞµΞΉ ΟƒΟ„ΞΏΞ½ ΞΉΞ΄ΞΉΞΏ Ο€Ξ±ΞΉΞΊΟ„Ξ· Ξ½Ξ± Ο€Ξ±ΞΉΞΎΞµΞΉ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ Ξ±Ο…ΞΎΞ±Ξ½ΞµΞΉ Ο„ΞΏ step ΞΊΞ±Ο„Ξ± 1 ΞΊΞ±ΞΉ
    *Ξ΄ΞΉΞ½ΞµΞΉ ΞΎΞ±Ξ½Ξ± ΟƒΞµΞΉΟ�Ξ± ΟƒΞµ ΞΏΟ€ΞΏΞΉΞΏΞ½ Ο€Ο�ΞµΟ€ΞµΞΉ. Ξ¤ΞµΟ�ΞΌΞ±Ο„ΞΉΞ¶ΞµΞΉ ΞΏΟ„Ξ±Ξ½ ΞΏΞ»ΞµΟ‚ Ξ³ΞΉΞ½ΞΏΟ…Ξ½ visible
    */
    @Override
    public void run(){
        int ch1 , ch2;
        gui.showDeckForSecs(3);
        while (deck.isAllVisible()==false){
            ch1= players.get(step % nOfPlayers).choose();
            
            gui.showCard(ch1);
            giveKnowledge(ch1,deck.getCard(ch1).getId());

            do{
                ch2=players.get(step%nOfPlayers).choose();
            }while (deck.isCardVisible(ch2));
            gui.showCard(ch2);
            
            giveKnowledge(ch2,deck.getCard(ch2).getId());
            if (deck.getCard(ch1).getId()==deck.getCard(ch2).getId()){
                givePoints(1,step%nOfPlayers);
                gui.changePointsText(step%nOfPlayers,players.get(step%nOfPlayers).getPoints());
            }
            else{
                deck.swap(ch1, ch2);
                deleteKnowledge(ch1);
                deleteKnowledge(ch2);
                giveKnowledge(ch1,deck.getCard(ch1).getId());
                giveKnowledge(ch2,deck.getCard(ch2).getId());
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.hideCard(ch2);
                gui.hideCard(ch1);
                step++;
            }
            gui.changeText("player" + (step%nOfPlayers+1));
        }
        int winner = 0;
        int points1=0;
        for (int i=0;i<players.size();i++){
            if (players.get(i).getPoints()>points1){
                points1=players.get(i).getPoints();
                winner=i+1;
            }
        }
        gui.newClosingMessage(winner);
    }

    
    
    
}
