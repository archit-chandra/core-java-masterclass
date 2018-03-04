package com.gemalto.O11.javaGenerics.challenge1_TeamsAndPlayer;


public class ChallengeMain {

    public static void main(String[] args) {
        //ArrayList<Team> teams;
        //Collections.sort(teams);

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        Team<FootballPlayer> crows = new Team<>("Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melborne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> freamantle = new Team<>("Freamantle");
        Team<BaseBallPlayer> baseBallTeam = new Team<>("Chicago Cubs");

        hawthorn.matchResult(freamantle, 1, 0);
        hawthorn.matchResult(crows, 3, 8);
        crows.matchResult(freamantle, 2, 1);

        footballLeague.add(crows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(freamantle);

        // throws an error because of Generics
        //footballLeague.add(baseBallTeam);

        footballLeague.showLeagueTable();

        // Problem of using raw types
        League reallyRaw = new League("Really Raw");
        reallyRaw.add(crows);
        reallyRaw.add(baseBallTeam); // this is bad, different teams added in the same league

    }
}
