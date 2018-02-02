package com.gemalto.O13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already taken");
        }

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already taken");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already taken");
        }

        List<Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
    }

    public static void printList(Collection<Seat> list) {
        for (Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("==============================================================================");
    }
}
