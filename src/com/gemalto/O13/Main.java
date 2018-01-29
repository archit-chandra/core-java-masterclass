package com.gemalto.O13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        // Creating a duplicate reference to the same array list
        List<Seat> seatCopy = new ArrayList<>(Theatre.seats);
        printList(seatCopy);

        // Changes in one reference will also affect the other reference.
        // Separate reference => same object
        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already taken");
        }
    }

    public static void printList(List<Seat> list) {
        for (Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("==============================================================================");
    }


}
