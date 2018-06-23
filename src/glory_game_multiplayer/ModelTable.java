/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer;

/**
 *
 * @author Hashan Perera
 */
public class ModelTable {

   String name,score,hscore;

    public ModelTable(String name, String score, String hscore) {
      
        this.name = name;
        this.score = score;
        this.hscore = hscore;
        ///tftfy
        
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHscore() {
        return hscore;
    }

    public void setHscore(String hscore) {
        this.hscore = hscore;
    }
     
    
}
