package quarter1.javaCoreAdvancedLevel.lesson07.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    Server server;
    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;

    private String nick;
    private String login;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //цикл аутентификации
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/auth ")) {
                            String[] token = str.split("\\s");
                            if (token.length < 3) {
                                continue;
                            }
                            String newNick = server
                                    .getAuthService()
                                    .getNicknameByLoginAndPassword(token[1], token[2]);
                            if (newNick != null) {
                                sendMsg("/authok " + newNick);
                                nick = newNick;
                                login = token[1];
                                server.subscribe(this);
                                System.out.printf("Клиент %s подключился \n", nick);
                                server.broadcastMsg("Подключился "+nick);
                                break;
                            } else {
                                sendMsg("Неверный логин / пароль");
                            }
                        }


                    }
                    //цикл работы
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/end")) {
                            out.writeUTF("/end");
                            break;
                        }

                        if (str.matches("/w\\s+\\S+\\s+.+")) {
                            sendMsgToNick(str);
                        } else {
                            server.broadcastMsg(this.nick+": "+str);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Клиент отключился");
                    server.broadcastMsg("Отключился "+nick);
                    server.unsubscribe(this);
                    try {
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void sendMsgToNick(String str) {
        String[] strArr = str.split("\\s");
        if (!server.isNick(strArr[1])) {
            sendMsg("Ника нет: "+strArr[1]);
            return;
        }


        String msg = str.substring(str.indexOf(strArr[2]));
        server.sendMegNick(this.nick,strArr[1],msg);
        sendMsg(this.nick +" -> "+strArr[1] +": "+msg);

    }

    void sendMsg(String str) {
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }
}
