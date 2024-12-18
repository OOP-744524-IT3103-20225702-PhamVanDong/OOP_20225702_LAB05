package hust.soict.program.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class PainterController {


    @FXML
    private Pane drawingAreaPane;

    private Boolean erase = false;


    @FXML
    void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event){
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        Rectangle newRectangle = new Rectangle(event.getX(), event.getY(), 4, 4);
        newRectangle.setFill(Color.WHITE);
        if (!erase) drawingAreaPane.getChildren().add(newCircle);
        else drawingAreaPane.getChildren().add(newRectangle);
    }

    @FXML
    void changeToPen(ActionEvent event){
        erase = false;
    }

    @FXML
    void changeToErase(ActionEvent event){
        erase = true;
    }


}
