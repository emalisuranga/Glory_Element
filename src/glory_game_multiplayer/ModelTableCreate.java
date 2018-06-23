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
public class ModelTableCreate {

    String name, hscore,online ;
  

    public ModelTableCreate(String name, String hscore, String online) {

        this.name = name;
        this.hscore = hscore;
        this.online = online;

    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHscore() {
        return hscore;
    }

    public void setHscore(String hscore) {
        this.hscore = hscore;
    }

}
