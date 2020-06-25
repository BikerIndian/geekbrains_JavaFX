package quarter1.javaCoreAdvancedLevel.lesson04.chat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private ImageView friendSmiley;
    @FXML
    private TextField nik;
    @FXML
    private TextField sendText;
    @FXML
    private TextFlow chatText;

    private String nikFlag;


    public void clickBtnSend(ActionEvent actionEvent) {
        addTextChat(checkNik(),nik.getText(), sendText.getText());
        sendText.setText("");
    }

    /**
     * Проверка изменения ника
     */
    private String checkNik() {
        String  nikIn= nik.getText();
        if (!nikIn.equals(nikFlag)){
            String mess = String.format("[%s] поменял ник на [%s]\n",nikFlag,nik.getText());
            nikFlag = nik.getText();
            return mess;
        }
        return "";
    }

    private void addTextChat(String info, String user, String textIn){
        textIn = info+"["+user+"] " +textIn;
        sendMess(textIn+"\n");
    }

    private void addIcoChat(String info, String user, ImageView ico){
        String text = info+"["+user+"] ";
        sendMess(new Text(text),ico,new Text("\n"));
    }

    public void clickIco(MouseEvent mouseEvent) {
        String id = ((ImageView) mouseEvent.getSource()).getId();
        ImageView ico = new IcoSmiley().getIco(id);
        addIcoChat(checkNik(),nik.getText(), ico);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nikFlag = nik.getText();
        setFocus();
    }


    /**
     * Вокус на окне отправки
     */
    private void setFocus() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                sendText.requestFocus();
            }
        });
    }


    private void sendMess(String text) {
        sendMess(new Text(text));
    }
    private void sendMess(Node... text) {
        chatText.getChildren().addAll(text);
    }

}
