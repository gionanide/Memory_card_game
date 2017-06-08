/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import cardgame.Deck;
import cardgame.Graphics.GuiNormal;
import cardgame.players.HumanPlayer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manos
 */
public class ModeSinglePlayer extends Mode{
    
    public ModeSinglePlayer()  throws InterruptedException{
        super();
        deck= new Deck(12,2);
        nOfPlayers=1;
        gui=new GuiNormal(deck,nOfPlayers);
        gui.setVisible(false);
        players= new ArrayList<>();
        players.add(new HumanPlayer(gui));
        gui.setVisible(true);
    }
    
    @Override
    public void run(){
        int ch1 , ch2;
        gui.showDeckForSecs(3);
        while (deck.isAllVisible()==false){
            do{
            ch1= players.get(step % nOfPlayers).choose();
            }while (deck.isCardVisible(ch1));
            gui.showCard(ch1);
            
            do{
            ch2=players.get(step%nOfPlayers).choose();
            }while (deck.isCardVisible(ch2));
            gui.showCard(ch2);
      
            if (deck.getCard(ch1).getId()==deck.getCard(ch2).getId()){
                step++;
            }
            else{
                try {
                Thread.sleep(2500);
                } catch (InterruptedException ex) {
                Logger.getLogger(ModeNormal.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.hideCard(ch2);
                gui.hideCard(ch1);
                step++;
            }
            gui.changeText("turn " + (step+1));
        }
        
        gui.newSinglePlayerClosingMessage(step);
    }
    
}
