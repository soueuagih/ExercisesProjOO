import java.util.ArrayList;
import java.util.List;


interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}

class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        System.out.println(sender.getName() + ": " + message);
        for (User user : users) {
            if (!user.equals(sender)) {
                user.receive(sender.getName() + ": " + message);
            }
        }
    }
}

class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(getName() + " received: " + message);
    }
}


public class ExMediator {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Maria", chatRoom);
        User user3 = new User("Anthony", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Olá pessoal!");
        user2.send("Vamos sair hoje?");
        user3.send("Vamos sim, que horas?");
    }
}

