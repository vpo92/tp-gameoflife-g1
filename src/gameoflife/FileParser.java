/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author vincent
 */
public class FileParser {
    
     public static GameOfLife fromFile(File f) throws FileNotFoundException, Exception{
        GameOfLife gof = new GameOfLife();
        BufferedReader buff = new BufferedReader(new FileReader(f));

        //Lecture premiere ligne
        String line0 = buff.readLine();
        String[] lignes; 
        try{
           gof.setNbCol(Integer.parseInt(line0.split("[*]")[0]));
           gof.setNbLigne(Integer.parseInt(line0.split("[*]")[1]));
           lignes = new String[gof.getNbLigne()];
           String tmp;
           int i = 0;
           while((tmp = buff.readLine())!=null){
               lignes[i] = tmp;
               i++;
           }
        }catch(Exception e){
            throw new Exception("Invalid file format",e);
        }
        gof.init();

        //init lines
        for(int ligne = 0; ligne < gof.getNbLigne();ligne++){        
            for(int col = 0; col < gof.getNbCol(); col++){
               if('o' == lignes[ligne].charAt(col)){
                   gof.setVivant(ligne,col);
               }
            }
        }
          
        
        return gof;
    }
    
    
}
