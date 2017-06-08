/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.Graphics.GuiMonomaxia;

/**
 *
 * @author MANOS
 */
public class HumanPlayerMonomaxia extends Player{
    
    private GuiMonomaxia gui;
    
    public HumanPlayerMonomaxia(GuiMonomaxia gui){
        super();
        this.gui=gui;
        
    }
    /**
     * perimenei na path8ei ena jbutton kai epistrefei tn 8esh tou. leitourgei gia to modemonomaxia
     * @return 
     */
    @Override
    public int choose() {
             
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
     * DONT USE. uparxei mono kai mono epeidh eprepe na ulopoih8ei
     * @return 
     */
    @Override
    public int chooseThree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
