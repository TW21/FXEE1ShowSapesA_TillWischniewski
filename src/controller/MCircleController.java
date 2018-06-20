package controller;


import javafx.scene.input.MouseEvent;
import model.MCircle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 * @author Till Wischniewski
 * version 1.1
 */

public class MCircleController implements EventHandler<MouseEvent> {

    private MCircle mcircle;
    private Circle circle;
    private Text text;

    public MCircleController(MCircle mcircle, Circle circle, Text text) {
        this.circle = circle;
        this.mcircle = mcircle;
        this.text = text;
    }


    @Override
    public void handle(MouseEvent me) {
        enterCircleStage().show();
    }

    private Stage enterCircleStage(){
        Stage secondStage = new Stage();
        secondStage.setTitle("Change Circle  "+ this.mcircle.getRadius());
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(8, 8, 8, 8));
        root.getColumnConstraints().add(new ColumnConstraints(150)); // column 0 is 100 wide
        root.getColumnConstraints().add(new ColumnConstraints(250));
        Label radius = new Label("New Radius: ");
        root.add(radius, 0, 0);
        TextField enterradius = new TextField();
        root.add(enterradius, 1, 0);
        Button submit = new Button("submit");
        submit.setOnAction(e -> setCircleRadius(enterradius, secondStage));
        root.add(submit, 0, 2);
        secondStage.setScene(new Scene(root, 450, 400));
        return secondStage;
    }


    private void setCircleRadius(TextField t, Stage secondStage){

        try {
            double newRadius = Double.parseDouble(t.getText());

            this.mcircle.setRadius(newRadius);
            this.circle.setRadius(newRadius);
            this.text.setText(Double.toString(Math.round(this.mcircle.area())));

            secondStage.close();

        } catch (NumberFormatException e) {
            wrongRadius(t);
        }

    }

    private void wrongRadius(TextField te) {
        te.setStyle("-fx-background-color: red");
    }
}