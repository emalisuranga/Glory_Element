/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer.LeaderBoard;

/**
 *
 * @author Emal Isuranga
 */
public class MdelTable {
    String name,scor;

    public MdelTable(String name, String scor) {
        this.name = name;
        this.scor = scor;
       // this.rank = rank;
    }
   

//    public String getRank() {
//        return rank;
//    }
//
//    public void setRank(String rank) {
//        this.rank = rank;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScor() {
        return scor;
    }

    public void setScor(String scor) {
        this.scor = scor;
    }
}
