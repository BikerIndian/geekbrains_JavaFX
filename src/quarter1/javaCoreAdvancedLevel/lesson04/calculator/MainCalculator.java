package quarter1.javaCoreAdvancedLevel.lesson04.calculator;

    /*
	    ФИО:  		    Свищ Владимир Сергеевич
	    Факультет:      Geek University Android-разработки
	    Курс: 		    Java Core. Продвинутый уровень
	    Урок: 		    Урок 4. Продвинутые вопросы создания графического интерфейса
	    Дата правки:    24.06.2020
    */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCalculator extends Application {

    /*
        2. Создать калькулятор
    */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
