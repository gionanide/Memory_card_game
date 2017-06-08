/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.graphics;

/**
 *
 * @author manos
 * 
 * 
 */
public abstract class Gui {
    
     public abstract int getButtonPressed();
     public abstract void SetButtonPressedToFalse();
     public abstract void newClosingMessage (int winner);
     public abstract void changePointsText (int player,int points);
     public abstract void setVisible(boolean bool);
}
