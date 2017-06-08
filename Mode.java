/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.modes;

import cardgame.Graphics.GuiNormal;
import cardgame.*;
import cardgame.Graphics.Gui;
import cardgame.players.*;
import java.util.ArrayList;

/**
 *
 * @author manos
 * 
 * klhronomoun ola ta modes apo auto. Krata to deck tous paiktes kai to gui
 */
public abstract class Mode {
    protected Deck deck;
    protected ArrayList<Player> players;
    protected GuiNormal gui;

    protected int step;
    protected int nOfPlayers;
    
    public Mode(){
        step=0;
    }
    
    public abstract void run();
    
    /**
    *dinei points pontous ston paixth sthn 8esh posOfPlayer
    */
    protected void givePoints(int points,int posOfPlayer){
        players.get(posOfPlayer).takePoints(points);
    }
    
    /**
     * gia ka8e paikth hardplayer kai mediumplayer kalei thn sunarthsh receiveKnowledge(pos,id)
     * @param pos
     * @param id 
     */
    protected void giveKnowledge(int pos,int id){
        for (Player p:players){
            if (p instanceof HardPlayer){
               ((HardPlayer) p).receiveKnowledge(pos,id);
            }
            else if (p instanceof MediumPlayer){
                ((MediumPlayer) p).receiveKnowledge(pos, id);
            }
        }
    }
    /**
     * gia ka8e paikth hardplayer h mediumplayer svhnei thn gnwsh sth 8esh pos
     * kalwntas thn sunarthsh tou player receiveKnowledge(pos,-1)
     * @param pos 
     */
    protected void deleteKnowledge(int pos){
        for (Player p:players){
            if (p instanceof HardPlayer){
               ((HardPlayer) p).receiveKnowledge(pos,-1);
            }
            else if (p instanceof MediumPlayer){
                ((MediumPlayer) p).receiveKnowledge(pos, -1);
            }
        }
    }
     
    
}

