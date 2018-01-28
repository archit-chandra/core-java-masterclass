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
        // After Bounded Type parameters
        // Team<String> brokenTeam = new Team<>("This won't work");
        // brokenTeam.addPlayer("No one");

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melborne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> freamantle = new Team<>("Freamantle");

        crows.matchResult(freamantle, 2, 1);
        //Error: Converted Team opponent -> Team<T> opponent
        //crows.matchResult(baseballTeam, 1, 1);

    }
    
}
