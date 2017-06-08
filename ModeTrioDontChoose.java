/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manos
 */
public class ModeTrioDontChoose extends ModeTrio {
    public ModeTrioDontChoose() throws InterruptedException{
        super();
        gui.showDontChooseButton();
    }
    
    @Override
    public void run(){
        int ch1 , ch2,ch3;
        gui.showDeckForSecs(4);
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
                do{
                    ch3=players.get(step%nOfPlayers).choose();
                    if (ch3==-2){
                        loop=false;
                    }
                    else if (!deck.isCardVisible(ch3)){
                        loop=false;
                    }
                }while (loop==true);
                if (ch3!=-2){
                    gui.showCard(ch3);
                    giveKnowledge(ch3,deck.getCard(ch3).getId());
                    if (deck.getCard(ch1).getId()==deck.getCard(ch2).getId()&&deck.getCard(ch1).getId()==deck.getCard(ch3).getId()){
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
                        gui.hideCard(ch3);
                        step++;
                
                    }
            }
            else{
                step++;
                gui.hideCard(ch1);
                gui.hideCard(ch2);
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
