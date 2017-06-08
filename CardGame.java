/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import cardgame.Graphics.ModeAsker;
import cardgame.modes.*;
/**
 *
 * @author MANOS
 */
public class CardGame {
/**
     * kalei ena modeAsker gia na rwthsei ti mode 8elei na trexei
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Mode mode;
        ModeAsker asker= new ModeAsker();
        asker.setVisible(true);
        while (asker.buttonChosen()==0){
            Thread.sleep(1000);
        }
        int x=asker.buttonChosen();
        asker.setVisible(false);
        asker.dispose();
        if (x==1){
            mode= new ModeNormal();
        }
        else if (x==2){
            mode= new ModeNormalDoubleCards();
        }
        else if (x==3){
            mode= new ModeSwap();
        }
        else if (x==4){
            mode= new ModeTrio();
        }
        else if (x==5){
            mode= new ModeDontChoose();
        }
        else if (x==6){
            mode= new ModeMonomaxia();
        }
        else if (x==7){
            mode= new ModeTrioDontChoose();
        }
        else{
            mode= new ModeSinglePlayer();
        }
        mode.run();
    }
    
}
