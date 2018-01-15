package com.gemalto.O11.javaGenerics;

import java.util.ArrayList;

//When we instantiate a class, <T> will be replaced by Java with the actual class with the real type
public class Team<T> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    
    private ArrayList<T> members = new ArrayList<>();
    
    public Team(String name) {
        super();
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(((Player) player).getName() + " is already on this team"); // Casting because of
                                                                                          // Compilation error. Compiler
                                                                                          // do not know that Player of
                                                                                          // Type T has getName() until
                                                                                          // runtime.
            return false;
        } else {
            members.add(player);
            System.out.println(((Player) player).getName() + " picked for team " + name);
            return true;
        }
    }
    
    public int numPlayers() {
        return members.size();
    }
    
    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        played++;
        
        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore); // to keep score of opponent & null => avoid cyclic
            // calling
        }
    }
    
    public int ranking() {
        return (won * 2) + tied;
    }
    
}
