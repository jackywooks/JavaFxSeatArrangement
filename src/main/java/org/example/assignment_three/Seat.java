package org.example.assignment_three;

import javafx.scene.paint.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Seat {
    String seatName;
    Color seatColor;
    int seatPosition;
    static Set<Integer> seatNumbers = new HashSet<>();
    public static Set<Color> seatColors = new HashSet<>();


    public Seat(String seatName, Color seatColor) {
        this.seatName = seatName;
        this.seatColor = seatColor;
        seatColors.add(seatColor);
        this.seatPosition = generateSeatNumber();
    }

    public String getSeatName() {
        return seatName;
    }

    public Color getSeatColor() {
        return seatColor;
    }

    public int getSeatPosition() {
        return seatPosition;
    }

    protected int generateSeatNumber(){
        Random rand = new Random();
        int seatNumber = rand.nextInt(9)+1; //nextInt(upperbound) generates random numbers in the range 0 to upperbound-1.
        while(!seatNumbers.add(seatNumber)){
            seatNumber = rand.nextInt(9)+1;
        }
        return seatNumber;
    }

    public static void reset(){
        seatNumbers.clear();
        seatColors.clear();
    }
}
