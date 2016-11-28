/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author S614299
 */
public class GamePrinter extends JComponent {

    
    private GameOfLife gof;
    private Graphics g;
    int cellSize = 15;
    
    public void paint(Graphics g) {  
        if(gof!=null){
            //La zone
            g.setColor(Color.decode("333333"));
            g.fillRect(0, 0, gof.getNbCol()*cellSize, gof.getNbLigne()*cellSize);
            
            //Les cellules
            for(int i = 0; i < gof.getNbLigne(); i++){
            for(int j = 0; j < gof.getNbCol(); j++){                
                if(gof.isCellVivant(i, j)==1){
                    g.setColor(Color.WHITE);
                    g.fillRect(j*cellSize, i*cellSize, cellSize, cellSize);
                }
                
            }
        }
            
        }else{
            g.drawString("En attente de données", 0, 0);
        }
        
    }

    public GamePrinter(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 500, 500);
        window.getContentPane().add(this);
        window.setVisible(true);
    }

    void setGameOfLife(GameOfLife g) {
        this.gof = g;
    }

    void redraw() {
        paint(getGraphics());
    }
}
