// Ativ 1 - Giovanna Souza, 163779
// Sistema de notificações: e-mail, SMS, push
// Permitir inclusão de novos tipos de notificação, sem alterações excessivas
// 1 comp central -> armz configs globais do sistema - nome aplicação, serv. envio, qtd max de tentativas de reenvio

using System;

public class Main
{
    interface Notifies {
        void send(String message);
    }

    static class Email implements Notifies {
        public void send(String message) {
            System.out.println("[EMAIL]: " + message);
        }
    }

    static class SMS implements Notifies {
        public void send(String message) {
            System.out.println("[SMS]: " + message);
        }
    }

    static class Push implements Notifies {
        public void send(String message) {
            System.out.println("[PUSH]: " + message);
        }
    }

    static class NotifiesFactory {
        public static Notifies create(String type) {

            if (type.equalsIgnoreCase("email")) {
                System.out.println("Factory criando Email");
                return new Email();
            }

            if (type.equalsIgnoreCase("sms")) {
                System.out.println("Factory criando SMS");
                return new SMS();
            }

            if (type.equalsIgnoreCase("push")) {
                System.out.println("Factory criando Push");
                return new Push();
            }

            throw new Exception("Tipo inválido");
        }
    }
    
     static class App {

        private static App instance;

        String appName;
        String server;
        int maxRetries;

        private App() {
            appName = "NotifySys";
            server = "server";
            maxRetries = 3;
        }

        public static App getInstance() {
            if (instance == null) {
                instance = new App();
            }
            return instance;
        }
    }


