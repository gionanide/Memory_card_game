/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.graphics;

import cardgame.Deck;
import cardgame.Graphics.ClosingMessage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cardgame.images.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
/**
 *
 * @author manos
 */
public class GuiNormal extends Gui {
    private JPanel panel;
    private JPanel panel1;
    private JFrame frame;
    private ArrayList<JButton> buttons;
    private Deck deck;
    private JButton exit;
    private JTextField textf;
    private ArrayList<JTextField> pl;
    private ActionListener ac;
    private ClosingMessage cl;

    private JButton button;
    private int buttonPressed;
    ImageIcon p1 = new ImageIcon(Resource.getURL("26.gif") , "image");
    
    
    /**
     * Ξ΄ΞµΟ‡ΞµΟ„Ξ±ΞΉ ΞµΞ½Ξ± deck ΟƒΞ±Ξ½ ΞΏΟ�ΞΉΟƒΞΌΞ± ΞΊΞ±ΞΉ Ο†Ο„ΞΉΞ±Ο‡Ξ½ΞµΞΉ ΞΏΞ»Ξ± Ο„Ξ± jlabel ΞΌΞµ ΞµΞΉΞΊΞΏΞ½Ξ± Ο„Ξ·Ξ½ ΞΊΟ�Ο…Ο†Ξ· ΞµΞΉΞΊΞΏΞ½Ξ±(hidden)
     * Ο€ΞµΟ�Ξ½Ξ± ΟƒΞ±Ξ½ Ξ΄ΞµΞΉΞΊΟ„Ξ· ΟƒΟ„ΞΏ deck Ο„ΞΏ deck Ο€ΞΏΟ… Ξ΄ΞµΟ‡ΞµΟ„Ξ±ΞΉ ΟƒΞ±Ξ½ ΞΏΟ�ΞΉΟƒΞΌΞ±. ΞΈΞµΟ„ΞµΞΉ Ο„ΞΏ acton performed ΟƒΞµ ΞΏΞ»Ξ± Ο„Ξ±
     * jlabel Ξ½Ξ± ΞµΞΉΞ½Ξ±ΞΉ Ξ½Ξ± ΞµΟ€ΞΉΟƒΟ„Ο�ΞµΟ†ΞΏΟ…Ξ½ Ο„Ξ·Ξ½ ΞΈΞµΟƒΞ· Ο„ΞΏΟ…Ο‚ Ξ±Ξ½ Ξ³ΞΉΞ½ΞµΞΉ ΞΊΞ»ΞΉΞΊ Ο€Ξ±Ξ½Ο‰ Ο„ΞΏΟ…Ο‚ . ΞΊΞ±Ξ½ΞµΞΉ visible ΞΏΞ»Ξ± Ο„Ξ± ΞΊΞΏΟ…ΞΌΟ€ΞΉΞ±
     */
    public GuiNormal(Deck deck,int nPlayers){
        
       buttonPressed=-1;
       this.deck=deck;
       
       frame = new JFrame ("Card Game");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setResizable(false);
       frame.setSize(1000,1000);
       
       panel1 = new JPanel();
       panel1.setLayout(new FlowLayout(FlowLayout.LEADING));
       panel1.setBackground(Color.GREEN);
       frame.add(panel1, BorderLayout.PAGE_START);
       
       textf= new JTextField("player 1");
       textf.setEditable(false);
       panel1.add(textf);
       
       
       
       button=new JButton("Dont Pick");
       button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               buttonPressed=-2;
               
           }
           
       });
       panel1.add(button);
       button.setEnabled(false);
       button.setVisible(false);
       
       
       pl= new ArrayList<>();
       for (int i=1;i<=nPlayers;i++){
           JTextField p= new JTextField("player " + i + " points: 0");
           p.setEditable(false);
           pl.add(p);
           panel1.add(p);
       }
       
       
       panel = new JPanel();
       panel.setLayout(new GridLayout(4,0));
       panel.setBackground(Color.WHITE);
       frame.add(panel, BorderLayout.CENTER);
       
       ac=new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               for (int t=0;t<buttons.size();t++){
                 if (e.getSource()==buttons.get(t)){ 
                      buttonPressed=t;
                 
                  }
                } 
            }
       };
       
       buttons=new ArrayList<>();
       
       for (int i=0;i<deck.getSize();i++){
           JButton b=new JButton();
           buttons.add(b);
            
       }
       
       for (JButton b:buttons){
           b.setIcon(p1);
           b.addActionListener(ac);
           panel.add(b);
           b.setVisible(true);
       }
       deck.hideDeck();
       frame.setVisible(true);
       
       exit= new JButton ("EXIT");
       exit.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
           
       });
       panel1.add(exit);
    }
    
    public int getButtonPressed(){
        return buttonPressed;
    }
    
    public void SetButtonPressedToFalse(){
        buttonPressed=-1;
    }
   /**
     * Ξ±Ξ»Ξ»Ξ±Ξ¶ΞµΞΉ Ο„ΞΏ jlabel ΟƒΟ„Ξ·Ξ½ ΞΈΞµΟƒΞ· pos ΞΌΞµ Ο„Ξ·Ξ½ ΞµΞΉΞΊΞΏΞ½Ξ± ΟƒΟ„ΞΏ deck ΟƒΟ„Ξ·Ξ½ ΟƒΟ…Ξ³ΞΊΞµΞΊΟ�ΞΉΞΌΞµΞ½Ξ· ΞΈΞµΟƒΞ·
     * @param pos
     */
    public void showCard(int pos){
      
       buttons.get(pos).setIcon(deck.getCard(pos).getPicture());
       deck.showCard(pos);
       
    }
    /**
     * @param x 
     */
    public void showDeckForSecs(int x){
        for (int i=0;i<deck.getSize();i++){
            buttons.get(i).setIcon(deck.getCard(i).getPicture());
        }
        try {
            Thread.sleep(x*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<deck.getSize();i++){
            buttons.get(i).setIcon(p1);
        }
        
    }
    /**
     *  
     * @param pos
     */        
    public void hideCard(int pos){
        buttons.get(pos).setIcon(p1);
        deck.hideCard(pos);
    }
    /**
     * ΞΈΞµΟ„ΞµΞΉ ΟƒΟ„ΞΏ Ο€Ο�Ο‰Ο„ΞΏ textfield Ο„ΞΏ ΞΊΞµΞΉΞΌΞµΞ½ΞΏ
     * @param str 
     */        
    public void changeText(String str){
        textf.setText(str);
    }
    /**
    * ΞµΞ½ΞµΟ�Ξ³ΞΏΟ€ΞΏΞΉΞµΞΉ/Ξ±Ο€ΞµΞ½ΞµΟ�Ξ³ΞΏΟ€ΞΏΞΉΞµΞΉ Ο„ΞΏ Ο€Ο�Ο‰Ο„ΞΏ textfield
    *  @param bool
    */
    public void enableText(Boolean bool){
        textf.setVisible(bool);
    }
    /**
     * pl.get(player).setText("player " + (player+1) + " points:" + points);
     * @param player
     * @param points 
     */
    @Override
    public void changePointsText (int player,int points){
        pl.get(player).setText("player " + (player+1) + " points:" + points);
    }
    
    @Override
    public void newClosingMessage (int winner){
        cl=new ClosingMessage(frame,true);
        cl.setText(winner);
        cl.setVisible(true);
        
    }
    public void newSinglePlayerClosingMessage (int turns){
        cl= new ClosingMessage (frame,true);
        cl.setTextSinglePlayer(turns);
        cl.setVisible(true);
    }
    
    public void showDontChooseButton(){
        button.setVisible(true);
    }
    
    
    public void enableDontChooseButton(boolean bool){
        button.setEnabled(bool);
        
    }
    
    public void setVisible(boolean bool){
        frame.setVisible(bool);
    }

}

