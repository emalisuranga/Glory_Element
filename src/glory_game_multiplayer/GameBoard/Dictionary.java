/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory_game_multiplayer.gameboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Pulasthi Thejan
 */
public final class Dictionary {
    private final HashMap<String, String> hm;
    String word;

    public Dictionary() {
        hm = new HashMap<>();
        loadDictionaryIntoHashMap();
                   
    }
    void loadDictionaryIntoHashMap(){
        //String fullFilePath = "/src/gameboard/Resources/beingzero_dictionary.csv";
        String line;
        try{
            File f = new File("src/glory_game_multiplayer/resources/beingzero_dictionary.csv"); 
            FileReader fr = new FileReader(f.getAbsolutePath());
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                String parts[]=line.split("===");
                hm.put(parts[0].trim().toLowerCase(),parts[1].trim());
            }
        }catch(IOException ex){
            System.out.println("Dictionary Error  "+ex.getMessage());
        }
    }
    
    public String checkDictionaryWord(String word)
    {
        return hm.get(word);
    }
    
}
    
    

