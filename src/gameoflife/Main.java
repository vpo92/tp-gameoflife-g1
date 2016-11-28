/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.io.File;

/**
 *
 * @author vincent
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Le fichier en entree
        String filePath = "test/simple.txt";
        
        //Le nombre d'iterations
        int nbIterations = 1200;
        
        try {
            //Instanciation du jeu
            GameOfLife gameOfLife = FileParser.fromFile(new File(filePath));
            
            //Instanciation de IHM d affichage
            GamePrinter gamePrinter = new GamePrinter();
            
            //Injection du gameOfLife pour affichage
            gamePrinter.setGameOfLife(gameOfLife);
            //Affichage
            gamePrinter.redraw();
            
            
            
            for (int i = 0; i < nbIterations; i++) {
                //Iteration du jeu
                gameOfLife.iterate();       
                
                //Mise a jour de l'affichage
                gamePrinter.redraw();
                
                //Temporisation pour affichage
                Thread.sleep(200);
            }
        } catch (Exception ex) {
            System.out.println("Une erreur est survenue : "+ex.getMessage());
        }
    }
    
}
