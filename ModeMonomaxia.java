/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import cardgame.Deck;
import cardgame.Graphics.GuiMonomaxia;
import cardgame.players.HumanPlayer;
import cardgame.players.HumanPlayerMonomaxia;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manos
 */
 * Ξ¤ΞΏ mode Ο„Ξ·Ο‚ ΞΌΞΏΞ½ΞΏΞΌΞ±Ο‡ΞΉΞ±Ο‚
 */
public class ModeMonomaxia extends Mode { 
    
    private Deck deck2;
    private GuiMonomaxia gui;
    
    
    /**
     *  Ξ΄Ξ·ΞΌΞΉΞΏΟ…Ο�Ξ³ΞµΞΉ Ο„ΞΏ deck ΞΊΞ±ΞΉ Ο„ΞΏ Ξ±Ξ½Ο„ΞΉΞ³Ο�Ξ±Ο†ΞµΞΉ ΟƒΟ„ΞΏ deck2 ΟƒΟ„ΞΏΞΉΟ‡ΞµΞΉΞΏ Ο€Ο�ΞΏΟ‚ ΟƒΟ„ΞΏΞΉΟ‡ΞµΞΉΞΏ
     * Ξ΄Ξ·ΞΌΞΉΞΏΟ…Ο�Ξ³ΞµΞΉ 2 human Ξ· 1 human ΞΊΞ±ΞΉ ΞµΞ½Ξ±Ξ½ cpu player
     */
    public ModeMonomaxia(){
        super();
        nOfPlayers=2;
        deck = new Deck(12,1);
        deck2= new Deck (12,1);
        gui= new GuiMonomaxia (deck,deck2);
        gui.setVisible(false);
        players= new ArrayList<>();
        players.add(new HumanPlayerMonomaxia(gui));
        players.add(new HumanPlayerMonomaxia(gui));
        gui.setVisible(true);
    }  
            
    /** Ξ’Ξ±Ξ¶ΞµΞΉ Ο„ΞΏΞ½ Ο€Ξ±ΞΉΞΊΟ„Ξ· Ο€ΞΏΟ… ΞµΟ‡ΞµΞΉ ΟƒΞµΞΉΟ�Ξ± (step mod players) Ξ½Ξ± Ξ±Ξ½ΞΏΞΉΞΎΞµΞΉ ΞΌΞΉΞ± ΞΊΞ±Ο�Ο„Ξ±.
    *Ο„Ξ·Ξ½ ΞΊΞ±Ξ½ΞµΞΉ visible ΞΊΞ±ΞΉ ΟƒΟ„Ξ± 2 decks ΞΊΞ±ΞΉ ΞΏ Ξ±Ξ»Ξ»ΞΏΟ‚ Ο€Ξ±ΞΉΞΊΟ„Ξ·Ο‚ Ξ±Ξ½ΞΏΞΉΞ³ΞµΞΉ Ο„Ξ·Ξ½ ΞµΟ€ΞΏΞΌΞµΞ½Ξ·.
    * Ο„Ξ·Ξ½ ΞΊΞ±Ξ½ΞµΞΉ visible ΞΊΞ±ΞΉ Ξ±Ξ½ ΞµΞΉΞ½Ξ±ΞΉ ΞΉΞ΄ΞΉΞµΟ‚ ΞΌΞµΞ½ΞΏΟ…Ξ½ ΞΊΞ±ΞΉ Ο€Ξ±ΞΉΟ�Ξ½ΞµΞΉ Ο€ΞΏΞ½Ο„ΞΏΟ…Ο‚ ΞΏ Ξ΄ΞµΟ…Ο„ΞµΟ�ΞΏΟ‚ Ο€Ξ±ΞΉΞΊΟ„Ξ·Ο‚ Ξ±Ξ»Ξ»ΞΉΟ‰Ο‚ hide
    *EΟ€ΞµΞΉΟ„Ξ± ΞΏ Ξ±Ξ»Ξ»ΞΏΟ‚ Ο€Ξ±ΞΉΞΊΟ„Ξ·Ο‚ Ξ±Ξ½ΞΏΞΉΞ³ΞµΞΉ Ο€Ο�Ο‰Ο„ΞΏΟ‚. Ξ¤ΞµΟ�ΞΌΞ±Ο„ΞΉΞ¶ΞµΞΉ ΞΏΟ„Ξ±Ξ½ ΞΏΞ»ΞµΟ‚ Ξ³ΞΉΞ½ΞΏΟ…Ξ½ visible
    */
    @Override
    public void run(){
        int ch1,ch2;
        gui.showDeckForSecs(3);
        while (deck.isAllVisible()==false && deck2.isAllVisible()==false){
            if (step%2==0){
                do{
                    ch1= players.get(0).choose();
                }while (deck.isCardVisible(ch1));
                gui.showCard(ch1,true);
                do{
                    ch2=players.get(1).choose();
                }while (deck2.isCardVisible(ch2));
                gui.showCard(ch2,false);
                if (deck.getCard(ch1).getId()==deck2.getCard(ch2).getId()){
                    givePoints(1,1);
                    gui.changePointsText(1,players.get(1).getPoints());// me to 1 anaferomaste ston 2o paikth
                }
                 else{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    gui.hideCard(ch1, true);
                    gui.hideCard(ch2,false);
                    
                }
                gui.changeText("player 2");
            }
            else{
                do{
                    ch1= players.get(1).choose();
                }while (deck2.isCardVisible(ch1));
                gui.showCard(ch1,false);
                do{
                    ch2=players.get(0).choose();
                }while (deck.isCardVisible(ch2));
                gui.showCard(ch2,true);
                if (deck2.getCard(ch1).getId()==deck.getCard(ch2).getId()){
                    givePoints(1,0);
                    gui.changePointsText(0,players.get(0).getPoints());
                }
                 else{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    gui.hideCard(ch1,false);
                    gui.hideCard(ch2,true);
                   
                }
                gui.changeText("player 1");
            }
            step++;
        }
        if (players.get(0).getPoints()>players.get(1).getPoints()){
            gui.newClosingMessage(1);
        }
        else{
            gui.newClosingMessage(2);
        }
    }

    
    
}

