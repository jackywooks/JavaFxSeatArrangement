package org.example.assignment_three;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatingController {
    @FXML
    private Label seat01Name;
    @FXML
    private Label seat02Name;
    @FXML
    private Label seat03Name;
    @FXML
    private Label seat04Name;
    @FXML
    private Label seat05Name;
    @FXML
    private Label seat06Name;
    @FXML
    private Label seat07Name;
    @FXML
    private Label seat08Name;
    @FXML
    private Label seat09Name;
    @FXML
    private Label seat01Color;
    @FXML
    private Label seat02Color;
    @FXML
    private Label seat03Color;
    @FXML
    private Label seat04Color;
    @FXML
    private Label seat05Color;
    @FXML
    private Label seat06Color;
    @FXML
    private Label seat07Color;
    @FXML
    private Label seat08Color;
    @FXML
    private Label seat09Color;

    private Map<Integer, Label> seatNames; // Map to store seat position and Label
    private Map<Integer, Label> seatColors; // Map to store seat position and Label

    @FXML
    public void initialize() {
        seatNames = new HashMap<>();
        // Add Label objects to the map with their positions (modify for your actual number)
        seatNames.put(1, seat01Name);
        seatNames.put(2, seat02Name);
        seatNames.put(3, seat03Name);
        seatNames.put(4, seat04Name);
        seatNames.put(5, seat05Name);
        seatNames.put(6, seat06Name);
        seatNames.put(7, seat07Name);
        seatNames.put(8, seat08Name);
        seatNames.put(9, seat09Name);

        seatColors = new HashMap<>();
        seatColors.put(1, seat01Color);
        seatColors.put(2, seat02Color);
        seatColors.put(3, seat03Color);
        seatColors.put(4, seat04Color);
        seatColors.put(5, seat05Color);
        seatColors.put(6, seat06Color);
        seatColors.put(7, seat07Color);
        seatColors.put(8, seat08Color);
        seatColors.put(9, seat09Color);
    }
    @FXML
    private Label error;
    @FXML
    private TextField studentName;
    @FXML
    private ColorPicker color;

    List<Seat> seatArrangement = new ArrayList<>();
    @FXML
    protected void addStudent() {
        String seatName = studentName.getText();
        Color seatColor = color.getValue();


        if(Seat.seatColors.size()<9) {
            if(seatName.isEmpty()||seatName.trim().isEmpty()){
                error.setText("Please fill in the Name");
                return;
            }
            if(Seat.seatColors.contains(seatColor)){
                error.setText("Color is already in use");
                return;
            }
            error.setText("");
            Seat seat = new Seat(seatName, seatColor);
            seatArrangement.add(seat);
            System.out.println(seat.getSeatName() + seat.getSeatColor() + seat.getSeatPosition());
            fillSeat(seat.getSeatName(), seat.getSeatColor(), seat.getSeatPosition());
            if(Seat.seatColors.size()==9) {
                seatDone();
            }
        }else{
            error.setTextFill(Color.RED);
            error.setText("No More Seats!");
        }
    }

    protected void seatDone(){
            error.setTextFill(Color.BLACK);
            error.setText("Seating is Completed");
    }

    protected void fillSeat(String seatName, Color seatColor, int seatPosition){
        Label seatColorPosition = seatColors.get(seatPosition);
        Label seatNamePosition = seatNames.get(seatPosition);
        seatNamePosition.setText(seatName);
        seatColorPosition.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    protected void reset() {
        //Remove all Names
        for (Label setName : seatNames.values()) {
            setName.setText("");
        }
        //Remove all Colors
        for (Label setColor : seatColors.values()) {
            setColor.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        // Clear the student name text field
        studentName.setText("");
        // Clear the color picker
        color.setValue(Color.WHITE);
        seatArrangement.clear();
        error.setText("");
        Seat.reset();
    }
}