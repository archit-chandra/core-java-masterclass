package com.gemalto.O11.javaGenerics;

public class Main2 {
    
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseBallPlayer pat = new BaseBallPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");
        
        Team crows = new Team("Crows");
        crows.addPlayer(joe);
        crows.addPlayer(pat);
        crows.addPlayer(beckham);
        
        System.out.println(crows.numPlayers());
    }
    
}
