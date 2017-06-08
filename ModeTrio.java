/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import cardgame.Graphics.GuiNormal;
import cardgame.Graphics.PlayerAsker;
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
public class ModeTrio extends Mode { //Ο€ΞΏΞ»Ξ»ΞΏΞΉ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚ , Ξ±Ξ½ Ξ²Ο�ΞµΞΉΟ‚ ΞΎΞ±Ξ½Ξ±Ο€Ξ±ΞΉΞ¶ΞµΞΉΟ‚
    
    /**Ο�Ο‰Ο„Ξ±ΞµΞΉ Ο€ΞΏΟƒΞΏΟ…Ο‚ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚ ΞΊΞ±ΞΉ Ο„ΞΉ Ξ΄Ο…ΟƒΞΊΞΏΞ»ΞΉΞ± , Ο„ΞΏΟ…Ο‚ Ο€ΞµΟ�Ξ½Ξ±ΞµΞΉ ΟƒΟ„ΞΏ players
        *Ξ΄Ξ·ΞΌΞΉΞΏΟ…Ο�Ξ³ΞµΞΉ ΞµΞ½Ξ± deck (12,3)
        */
    public ModeTrio() throws InterruptedException{
      super();
        NormalAsker asker=new NormalAsker();
        asker.setVisible(true);
        
        while (asker.getnOfPlayers()==0){
            Thread.sleep(1000);
            
        }
        nOfPlayers=asker.getnOfPlayers();
        asker.dispose();
        deck = new Deck(12,3);
        
        
        gui=new GuiNormal(deck,nOfPlayers);
        gui.setVisible(false);
        
        players= new ArrayList<>();
        players.add(new HumanPlayer(gui));
        for (int i=1;i<nOfPlayers;i++){
            PlayerAsker pl= new PlayerAsker(i);
            pl.setVisible(true);
            while (pl.getChoice()==0){
                Thread.sleep(1000);
            }
            int x=pl.getChoice();
            pl.setVisible(false);
            pl.dispose();
            if (x==1){
                players.add(new HumanPlayer(gui));
            }
            else if (x==2){
                players.add(new CpuPlayer(deck));
            }
            else if (x==3){
                players.add(new MediumPlayer(deck));
            }
            else{
                players.add(new HardPlayer(deck));
            }
        }
        gui.setVisible(true);
    }
        
            
    /** Ξ’Ξ±Ξ¶ΞµΞΉ Ο„ΞΏΞ½ Ο€Ξ±ΞΉΞΊΟ„Ξ· Ο€ΞΏΟ… ΞµΟ‡ΞµΞΉ ΟƒΞµΞΉΟ�Ξ± (step mod players) Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΌΞΉΞ± ΞΊΞ±Ο�Ο„Ξ± ΞΊΞ±ΞΉ ΟƒΟ„ΞµΞ»Ξ½ΞµΞΉ Ο„Ξ·Ξ½ Ξ³Ξ½Ο‰ΟƒΞ· ΟƒΞµ ΞΏΞ»ΞΏΟ…Ο‚ Ο„ΞΏΟ…Ο‚ Ο€Ξ±ΞΉΞΊΟ„ΞµΟ‚
    *Ο„ΞΏΞ½ Ξ²Ξ±Ξ¶ΞµΞΉ Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΊΞ±ΞΉ 2Ξ· ΞΊΞ±ΞΉ ΟƒΟ„ΞµΞ»Ξ½ΞµΞΉ Ο€Ξ±Ξ»ΞΉ Ο„Ξ·Ξ½ Ξ³Ξ½Ο‰ΟƒΞ·. Ξ‘Ξ½ ΞµΞΉΞ½Ξ±ΞΉ ΞΉΞ΄ΞΉΞµΟ‚ Ο„ΞΉΟ‚ Ξ±Ο†Ξ·Ξ½ΞµΞΉ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ Ο„ΞΉΟ‚ ΞΎΞ±Ξ½Ξ±ΞΊΞ±Ξ½ΞµΞΉ hide
    *Ξ±Ξ½ ΞµΞΉΞ½Ξ±ΞΉ ΞΉΞ΄ΞΉΞµΟ‚ ΞΎΞ±Ξ½Ξ±Ξ΄ΞΉΞ½ΞµΞΉ ΟƒΟ„ΞΏΞ½ ΞΉΞ΄ΞΉΞΏ Ο€Ξ±ΞΉΞΊΟ„Ξ· Ξ½Ξ± Ο€Ξ±ΞΉΞΎΞµΞΉ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ Ξ±Ο…ΞΎΞ±Ξ½ΞµΞΉ Ο„ΞΏ step ΞΊΞ±Ο„Ξ± 1 ΞΊΞ±ΞΉ
    *Ξ΄ΞΉΞ½ΞµΞΉ ΞΎΞ±Ξ½Ξ± ΟƒΞµΞΉΟ�Ξ± ΟƒΞµ ΞΏΟ€ΞΏΞΉΞΏΞ½ Ο€Ο�ΞµΟ€ΞµΞΉ. Ξ¤ΞµΟ�ΞΌΞ±Ο„ΞΉΞ¶ΞµΞΉ ΞΏΟ„Ξ±Ξ½ ΞΏΞ»ΞµΟ‚ Ξ³ΞΉΞ½ΞΏΟ…Ξ½ visible
    */
    @Override
    public void run(){
        int ch1 , ch2 ,ch3;
        gui.showDeckForSecs(4);
        while (deck.isAllVisible()==false){
            ch1= players.get(step % nOfPlayers).chooseThree();
            
            gui.showCard(ch1);
            giveKnowledge(ch1,deck.getCard(ch1).getId());

            do{
                ch2=players.get(step%nOfPlayers).chooseThree();
            }while (deck.isCardVisible(ch2));
            gui.showCard(ch2);
            giveKnowledge(ch2,deck.getCard(ch2).getId());
            
            do{
                ch3=players.get(step%nOfPlayers).chooseThree();
            }while (deck.isCardVisible(ch3));
            gui.showCard(ch3);
            
            giveKnowledge(ch3,deck.getCard(ch3).getId());
            if (deck.getCard(ch1).getId()==deck.getCard(ch2).getId() && deck.getCard(ch1).getId()==deck.getCard(ch3).getId()){
                givePoints(1,step%nOfPlayers);
                gui.changePointsText(step%nOfPlayers,players.get(step%nOfPlayers).getPoints());
            }
            else{
                try {
                Thread.sleep(5000);
                 }
                catch (InterruptedException ex) {
                Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.hideCard(ch2);
                gui.hideCard(ch1);
                gui.hideCard(ch3);
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

