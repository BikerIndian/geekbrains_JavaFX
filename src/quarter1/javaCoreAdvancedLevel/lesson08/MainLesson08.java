package quarter1.javaCoreAdvancedLevel.lesson08;

import quarter1.javaCoreAdvancedLevel.lesson08.server.Server;

public class MainLesson08 {

   /*
        ФИО:  		    Свищ Владимир Сергеевич
        Факультет:      Geek University Android-разработки
        Курс: 		    Java Core. Продвинутый уровень
        Урок: 		    Урок 8. Написание сетевого чата. Часть II
        Дата правки:    08.07.2020
    */

    public static void main(String[] args) {

    /*
           Задание.

        1. Разобраться с кодом.
        2. Добавить отключение неавторизованных пользователей по таймауту
        (120 сек. ждем после подключения клиента. Если он не авторизовался
        за это время, закрываем соединение).

    */

        new Server();

    }
}
