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
public class ModeDontChoose extends ModeNormal {
    
    public ModeDontChoose() throws InterruptedException{
        super();
        gui.showDontChooseButton();
    }
    /**
    *Ξ²Ξ±Ξ¶ΞµΞΉ ΞµΞ½Ξ±Ξ½ ΞµΞ½Ξ±Ξ½ Ο„ΞΏΟ…Ο‚ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚ Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞ³ΞΏΟ…Ξ½ ΞΊΞ±Ο�Ο„Ξ±. Ξ”ΞΉΞ½ΞµΞΉ Ο„ΞΏ Ξ΄ΞΉΞΊΞ±ΞΉΟ‰ΞΌΞ± ΟƒΟ„ΞΏΞ½ Ο€Ξ±ΞΉΞΊΟ„Ξ· ΞΊΞ±Ο„Ξ± Ο„Ξ·Ξ½ Ξ΄ΞµΟ…Ο„ΞµΟ�Ξ· ΞΊΞ±Ο�Ο„Ξ±
    * Ξ½Ξ± Ο€Ξ±Ο„Ξ·ΟƒΞµΞΉ Ο„ΞΏ ΞΊΞΏΟ…ΞΌΟ€ΞΉ dontchoose Ξ³ΞΉΞ± Ξ½Ξ± ΞΌΞ·Ξ½ Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΊΞ±Ο�Ο„Ξ±
    */
    @Override
     public void run(){
        int ch1 , ch2;
        gui.showDeckForSecs(3);
        while (deck.isAllVisible()==false){
            do{
                ch1= players.get(step % nOfPlayers).choose();
            }while(deck.isCardVisible(ch1));
            gui.showCard(ch1);
            giveKnowledge(ch1,deck.getCard(ch1).getId());
            gui.enableDontChooseButton(true);
            boolean loop=true;
            do{
                ch2=players.get(step%nOfPlayers).choose();
                if (ch2==-2){
                    loop=false;
                }
                else if (!deck.isCardVisible(ch2)){
                    loop=false;
                }
            }while (loop==true);
            if (ch2!=-2){
            gui.showCard(ch2);
      
            giveKnowledge(ch2,deck.getCard(ch2).getId());
            if (deck.getCard(ch1).getId()==deck.getCard(ch2).getId()){
                givePoints(1,step%nOfPlayers);
                gui.changePointsText(step%nOfPlayers,players.get(step%nOfPlayers).getPoints());
            }
            else{
                gui.enableDontChooseButton(false);
                try {
                Thread.sleep(3500);
                } catch (InterruptedException ex) {
                Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.hideCard(ch2);
                gui.hideCard(ch1);
                step++;
                
            }
            }
            else{
                step++;
                gui.hideCard(ch1);
                
            }
            
            gui.changeText("player " + (step%nOfPlayers+1));
            gui.enableDontChooseButton(false);
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

