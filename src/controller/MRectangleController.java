package controller;


import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.MRectangle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * @author Till Wischniewski
 * version 1.1
 */

public class MRectangleController implements EventHandler<MouseEvent> {

    private MRectangle mrectangle;
    private Rectangle rectangle;
    private Text text;

    public MRectangleController(MRectangle mrectangle, Rectangle rectangle, Text text) {
        this.rectangle = rectangle;
        this.mrectangle = mrectangle;
        this.text = text;
    }


    @Override
    public void handle(MouseEvent me) {
        enterRectangleStage().show();
    }
    /*
     * This help method creates a secondary stage
     * that allows a user to enter a rating.
     */
    private Stage enterRectangleStage(){
        Stage secondStage = new Stage();
        secondStage.setTitle("Change Rectangle  ");
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(8, 8, 8, 8));
        root.getColumnConstraints().add(new ColumnConstraints(150)); // column 0 is 100 wide
        root.getColumnConstraints().add(new ColumnConstraints(250));
        Label length = new Label("Half of Length: ");
        root.add(length, 0, 0);
        TextField enterLength = new TextField();
        root.add(enterLength, 1, 0);
        Label width = new Label ("Half of width: ");
        root.add(width,0,1);
        TextField enterWidth = new TextField();
        root.add(enterWidth,1,1);
        Button submit = new Button("submit");
        submit.setOnAction(e -> setXDeltaYDelta(enterLength, enterWidth, secondStage));
        root.add(submit, 0, 2);
        secondStage.setScene(new Scene(root, 450, 400));
        return secondStage;
    }


    private void setXDeltaYDelta(TextField t,TextField t2, Stage secondStage){


        try {
            double newXDelta = Double.parseDouble(t.getText());
            double newYDelta = Double.parseDouble(t2.getText());

            this.mrectangle.setxDelta(newXDelta);
            this.mrectangle.setyDelta(newYDelta);
            this.rectangle.setHeight(newXDelta);
            this.rectangle.setWidth(newYDelta);
            this.text.setText(Double.toString(Math.round(mrectangle.area())));
            secondStage.close();

        } catch (NumberFormatException e) {
            wrongDelta(t);
            wrongDelta(t2);
        }

    }

    private void wrongDelta(TextField te) {
         te.setStyle("-fx-background-color: red");
    }
}