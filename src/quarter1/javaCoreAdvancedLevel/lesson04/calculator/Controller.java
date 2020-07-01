package quarter1.javaCoreAdvancedLevel.lesson04.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private Label result;
    @FXML
    private Label history;
    @FXML
    private TextField display;

    Calculator calculator = new Calculator();


    public void clickBtnPanel(ActionEvent actionEvent) {
        String inTextBtn = ((Button) actionEvent.getSource()).getText();
        calculator.setDisplay(inTextBtn);
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(calculator.getDisplay());
        history.setText(calculator.getHistory());
        result.setText(calculator.getResult());
    }

    public void clickBtnFun(ActionEvent actionEvent) {
        String textBtn = ((Button) actionEvent.getSource()).getText();
        calculator.btnFun(textBtn);
        updateDisplay();

    }

    public void clickBtnClear(ActionEvent actionEvent) {
        calculator.clear();
        updateDisplay();
    }



}
