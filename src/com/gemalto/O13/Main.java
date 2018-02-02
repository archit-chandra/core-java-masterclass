package com.gemalto.O13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        // Creating a duplicate reference to the same array list
        List<Seat> seatCopy = new ArrayList<>(theatre.getSeatList());
        printList(seatCopy);

        // Changes in one reference will also affect the other reference because its points to the same ArrayList object.
        // Separate reference => same object
        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already taken");
        }

        // seatCopy & theatre.getSeatList() are separate ArrayList but they refer to the same object that was initially created
        // reverse()-> reverses the order in the ArrayList
        // shuffle()-> pseudo random order
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.getSeatList()");
        printList(theatre.getSeatList());

        // min
        // max
        Seat minSeat = Collections.min(seatCopy);
        Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min. seat number : " + minSeat.getSeatNumber());
        System.out.println("Max. seat number : " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing bubble sorted seatCopy");
        printList(seatCopy);

        // Below code -> IndexOutOfBoundsException: Source does not fit in dest
        // newList has potential to have size = 96 = theatre.getSeatList().size() but at present its size = 0;
//        List<Seat> newList = new ArrayList<>(theatre.getSeatList().size());
//        Collections.copy(newList, theatre.getSeatList());
    }

    public static void printList(List<Seat> list) {
        for (Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("==============================================================================");
    }

    //Bubble sort method
    public static void sortList(List<? extends Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
