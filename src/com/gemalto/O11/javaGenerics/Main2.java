package com.gemalto.O11.javaGenerics;

public class Main2 {
    
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseBallPlayer pat = new BaseBallPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");
        
        // Now Team allows specific type of Player
        Team<FootballPlayer> crows = new Team<>("Crows");
        crows.addPlayer(joe);
        // after Generics implementation below code --> throws compliation error
        // crows.addPlayer(pat);
        // crows.addPlayer(beckham);
        
        System.out.println(crows.numPlayers());
        
        // Similarly,
        Team<BaseBallPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);
        
        // <String> allowed: Except primitive type
        Team<String> brokenTeam = new Team<>("This won't work");
        brokenTeam.addPlayer("No one");
        
    }
    
}
