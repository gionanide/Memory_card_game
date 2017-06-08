/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

/**
 *
 * @author MANOS
 */
public abstract class Player {
    private int points;
    
    public Player(){
        points=0;
    }
    
    public abstract int choose();
    
    public abstract int chooseThree();
    
    public void takePoints(int points){
        this.points=this.points+points;
    }
    
    public int getPoints (){
        return points;
    }
}