/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author vincent
 */
public final class GameOfLife {

    private Set<Cellule> cells;
    
    private int nbCol = 0;
    private int nbLigne = 0;
    
    public GameOfLife(){
    }

    public GameOfLife(int col, int ligne){
        initZone(col,ligne);
    }
    
    public void init(){
        initZone(nbCol,nbLigne);
    }
    
    public void initZone(int col, int ligne){
        cells = new HashSet<>();
        setNbCol(col);
        setNbLigne(ligne);
    }
    
    public void drawZone(){
        StringBuilder sb = new StringBuilder();
        
        for(int j = 0; j < getNbCol(); j++){                
            sb.append("*");
        }
        sb.append("\n");
        
        for(int i = 0; i < getNbLigne(); i++){
            for(int j = 0; j < getNbCol(); i++){                
                sb.append(isCellVivant(i, j)==1?"X":" ");
            }
            sb.append("\n");
        }
        
        for(int j = 0; j < getNbCol(); j++){                
            sb.append("*");
        }
        sb.append("\n");        
        System.out.println(sb.toString());
    }
    
    public void iterate(){
        //Pour chaque cellule, on calcule le nb de voisin vivant et on en déduit sont état...
        Set<Cellule> newCells = new HashSet<>();
        for(int i = 0; i < getNbLigne(); i++){
            for(int j = 0; j < getNbCol(); j++){
                if(calculerNouvelEtat(isCellVivant(i, j),getNbVoisinVivant(i,j))==1){
                    newCells.add(new Cellule(j, i));
                }       
            }
        }
        cells = newCells;
    }
    
    public int getNbVoisinVivant(int ligne, int col){
        
        int nbVoisin = 0;
        nbVoisin += isCellVivant(ligne-1, col-1);
        nbVoisin += isCellVivant(ligne-1, col);
        nbVoisin += isCellVivant(ligne-1, col+1);
        
        nbVoisin += isCellVivant(ligne, col-1);
        //La cellule : nbVoisin += isCellVivant(ligne, col);
        nbVoisin += isCellVivant(ligne, col+1);
        
        nbVoisin += isCellVivant(ligne+1, col-1);
        nbVoisin += isCellVivant(ligne+1, col);
        nbVoisin += isCellVivant(ligne+1, col+1);

        return nbVoisin;
    }
    
    public int calculerNouvelEtat(int etatCourant,int nbVoisin){
        int next = 0;
        if(nbVoisin < 2 && nbVoisin > 3){
            next = 0;
        }else if(nbVoisin == 2){
            next = etatCourant;
        }else if(nbVoisin == 3){
            next = 1;
        }
        return next;
    }

    void setVivant(int ligne, int col) {
        cells.add(new Cellule(col, ligne));
    }
    
    void setMort(int ligne, int col) {
        cells.remove(new Cellule(col, ligne));
    }
    
    int isCellVivant(int ligne, int col){
        for(Cellule cell : cells){
            if(cell.getX() == col && cell.getY()== ligne){
                return 1;
            }
        }
        return 0;
    }

    /**
     * @return the nbCol
     */
    public int getNbCol() {
        return nbCol;
    }

    /**
     * @param nbCol the nbCol to set
     */
    public void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }

    /**
     * @return the nbLigne
     */
    public int getNbLigne() {
        return nbLigne;
    }

    /**
     * @param nbLigne the nbLigne to set
     */
    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
    }    
    
}
