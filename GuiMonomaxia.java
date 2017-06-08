/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.graphics;

import cardgame.Deck;
import cardgame.images.Resource;
import cardgame.players.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author manos
 */
public class GuiMonomaxia {
    private int buttonPressed;
    private Deck deck1;
    private Deck deck2;
    private JFrame frame;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JButton exit;
    private ActionListener ac;
    private ArrayList<JButton> buttons1;
    private ArrayList<JButton> buttons2;
    private JTextField textf;
    private ClosingMessage cl;
    private int step;
    private ArrayList<JTextField> pl;
    private int turn=1; // 
    ImageIcon p1 = new ImageIcon(Resource.getURL("26.gif") , "image");
    
    /**
    * 
    */
    public GuiMonomaxia (Deck deck1,Deck deck2){
        buttonPressed=-1;
        this.deck1=deck1;
        this.deck2=deck2;
        step=0;
       frame = new JFrame ("Card Game");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setResizable(false);
       frame.setSize(1300,1000);
       
       panel = new JPanel();
       panel.setLayout(new FlowLayout(FlowLayout.LEADING));
       panel.setBackground(Color.GREEN);
       frame.add(panel, BorderLayout.PAGE_START);
       
       textf= new JTextField("player 1");
       textf.setEditable(false);
       panel.add(textf);
       
       panel1 = new JPanel();
       panel1.setLayout(new GridLayout(2,0));
       panel1.setBackground(Color.WHITE);
       frame.add(panel1, BorderLayout.WEST);
       
       panel2 = new JPanel();
       panel2.setLayout(new GridLayout(2,0));
       panel2.setBackground(Color.BLACK);
       frame.add(panel2, BorderLayout.EAST);
       
       buttons1= new ArrayList<>();
       buttons2= new ArrayList<>();
       
       for (int i=0;i<deck1.getSize();i++){
           JButton b=new JButton();
           JButton c=new JButton();
           buttons1.add(b);
           buttons2.add(c);     
       }
       /**
        */
       
       ac=new ActionListener(){
           @Override
          public void actionPerformed(ActionEvent e) {
            if (step%2==0){
                
               if (turn==1){
                    for (int t=0;t<buttons1.size();t++){
                        if (e.getSource()==buttons1.get(t)){ 
                            turn=2;
                            buttonPressed=t;
                            
                        }
                    }
               }
               else{
                   for (int t=0;t<buttons2.size();t++){
                       if (e.getSource()==buttons2.get(t)){
                           turn=1;
                           step++;
                           buttonPressed=t;
                           
                       }
                   }
               }
            }
            else{
                
                if (turn==1){
                    for (int t=0;t<buttons2.size();t++){
                        if (e.getSource()==buttons2.get(t)){ 
                            turn=2;
                            buttonPressed=t;
                            
                        }
                    }
               }
               else{
                   for (int t=0;t<buttons1.size();t++){
                       if (e.getSource()==buttons1.get(t)){
                           turn=1;
                           step++;
                           buttonPressed=t;
                           
                       }
                   }
               }
            }
           }
       };
       
        pl= new ArrayList<>();
       for (int i=1;i<=2;i++){
           JTextField p= new JTextField("player " + i + " points: 0");
           p.setEditable(false);
           pl.add(p);
           panel.add(p);
       }
       
       for (JButton b:buttons1){
           b.setIcon(p1);
           b.addActionListener(ac);
           panel1.add(b);
           b.setVisible(true);
       }
       
       for (JButton b:buttons2){
           b.setIcon(p1);
           b.addActionListener(ac);
           panel2.add(b);
           b.setVisible(true);
       }
       
       deck1.hideDeck();
       deck2.hideDeck();
       
       exit= new JButton ("EXIT");
       exit.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
           
       });
       panel.add(exit);
       
       frame.setVisible(true);
    }
    
    public int getButtonPressed(){
        return buttonPressed;
    }
    
    public void SetButtonPressedToFalse(){
        buttonPressed=-1;
    }
    
    /**
    * @param pos
    * @param bool 
    */
    public void showCard(int pos,boolean bool){
      
       if (bool==true){ 
            buttons1.get(pos).setIcon(deck1.getCard(pos).getPicture());
            deck1.showCard(pos);
       }
       else{
            buttons2.get(pos).setIcon(deck2.getCard(pos).getPicture());
            deck2.showCard(pos);
       }
    }
   /**
    * @param x 
    */ 
    public void showDeckForSecs (int x){
        for (int i=0;i<deck1.getSize();i++){
            buttons1.get(i).setIcon(deck1.getCard(i).getPicture());
            buttons2.get(i).setIcon(deck2.getCard(i).getPicture());
        }
        try {
            Thread.sleep(x*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiMonomaxia.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<deck1.getSize();i++){
            buttons1.get(i).setIcon(p1);
            buttons2.get(i).setIcon(p1);
        }
    }
    /**
     * 
     * @param pos
     * @param bool 
     */
   public void hideCard(int pos,boolean bool){//to idio me showCard
      if (bool==true){
            buttons1.get(pos).setIcon(p1);
            deck1.hideCard(pos);
      }
      else{
          buttons2.get(pos).setIcon(p1);
          deck2.hideCard(pos);
      }
    }
   
   public void changeText(String str){
        textf.setText(str);
    }
   
   public void changePointsText (int player,int points){
        pl.get(player).setText("player " + (player+1) + " points:" + points);
    }
/*
    * @param winner 
    */
   public void newClosingMessage (int winner){
        cl=new ClosingMessage(frame,true);
        cl.setText(winner);
        cl.setVisible(true);
        
    }
   
   public void setVisible(boolean bool){
        frame.setVisible(bool);
    }
}

