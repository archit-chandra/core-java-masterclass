package com.gemalto.O13;

import java.util.Collection;
import java.util.LinkedList;

public class Theatre {
    private final String theatreName;
    //    ArrayList -> LinkedList (the code will still work)
    //    List -> Collection (made it more generic)
    private Collection<Seat> seats = new LinkedList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestSeat = seat;
                break;
            }
        }

        if (requestSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestSeat.reserve();
    }

    // for testing purpose
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
}
