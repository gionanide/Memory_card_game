/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.Graphics.Gui;
import cardgame.Graphics.GuiNormal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manos
 * 
 * ΞΏ Ξ±Ξ½ΞΈΟ�Ο‰Ο€ΞΉΞ½ΞΏΟ‚ Ο€Ξ±ΞΉΞΊΟ„Ξ·Ο‚
 */
public class HumanPlayer extends Player {
    private GuiNormal gui;
    
    public HumanPlayer(GuiNormal gui){
        super();
        this.gui=gui;
        
    }

   
    
    /**
     * 
     * Ο€ΞµΟ�ΞΉΞΌΞµΞ½ΞµΞΉ Ξ½Ξ± Ο€Ξ±Ο„Ξ·ΞΈΞµΞΉ ΞµΞ½Ξ± jbutton ΞΊΞ±ΞΉ ΞµΟ€ΞΉΟƒΟ„Ο�ΞµΟ†ΞµΞΉ Ο„Ξ·Ξ½ ΞΈΞµΟƒΞ· Ο„ΞΏΟ… 
     * @return 
     */
    @Override
    public int choose(){
        
        while (gui.getButtonPressed()==-1){
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }
        int x=gui.getButtonPressed();
        gui.SetButtonPressedToFalse();
        return x;
    }
    /**
     * perimenei Ξ½Ξ± Ο€Ξ±Ο„Ξ·ΞΈΞµΞΉ ΞµΞ½Ξ± jbutton ΞΊΞ±ΞΉ ΞµΟ€ΞΉΟƒΟ„Ο�ΞµΟ†ΞµΞΉ Ο„Ξ·Ξ½ ΞΈΞµΟƒΞ· Ο„ΞΏΟ…. Ξ»ΞµΞΉΟ„ΞΏΟ…Ο�Ξ³ΞµΞΉ Ξ³ΞΉΞ± Ο„ΞΏ modetrio
     * @return 
     */
    @Override
    public int chooseThree(){
        return choose();
    }
}

