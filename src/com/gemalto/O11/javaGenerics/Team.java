package com.gemalto.O11.javaGenerics;

import java.util.ArrayList;

//When we instantiate a class, <T> will be replaced by Java with the actual class with the real type
// Java provides mechanism to restrict Type arguments ==> Bounded Type parameters (Upper Bound)
public class Team<T extends Player> {
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
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + name);
            return true;
        }
    }

    public int numPlayers() {
        return members.size();
    }

    //Converted Team opponent -> Team<T> opponent : to have only similar type of team competing for match
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            message = " beat ";
            won++;
        } else if (ourScore == theirScore) {
            message = " drew with ";
            tied++;
        } else {
            message = " lost to ";
            lost++;
        }
        played++;

        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore); // to keep score of opponent & null => avoid cyclic
            // calling
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

}
