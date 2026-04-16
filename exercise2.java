/*
Exercício 2 - Home Theater System
*/

class TV {
    public void turnOn() { System.out.println("TV on"); }
    public void turnOff() { System.out.println("TV off"); }
}

class Projector {
    public void turnOn() { System.out.println("Projector on"); }
    public void turnOff() { System.out.println("Projector off"); }
}

class Receiver {
    public void turnOn() { System.out.println("Receiver on"); }
    public void turnOff() { System.out.println("Receiver off"); }
}

class MediaPlayer {
    public void turnOn() { System.out.println("Media player on"); }
    public void playMovie() { System.out.println("Playing movie"); }
    public void playMusic() { System.out.println("Playing music"); }
    public void turnOff() { System.out.println("Media player off"); }
}

class SoundSys {
    public void turnOn() { System.out.println("Sound on"); }
    public void turnOff() { System.out.println("Sound off"); }
}

class AmbLight {
    public void low() { System.out.println("Lights are low"); }
    public void bright() { System.out.println("Lights on"); }
}


class HomeTheater {
    private TV tv;
    private Projector projector;
    private Receiver receiver;
    private MediaPlayer player;
    private SoundSys sound;
    private AmbLight light;

    public HomeTheater(TV tv, Projector projector, Receiver receiver,
                       MediaPlayer player, SoundSys sound, AmbLight light) {
        this.tv = tv;
        this.projector = projector;
        this.receiver = receiver;
        this.player = player;
        this.sound = sound;
        this.light = light;
    }

    public void watchMovie() {
        System.out.println("\nStarting the movie...");
        light.low();
        tv.turnOn();
        projector.turnOn();
        receiver.turnOn();
        sound.turnOn();
        player.turnOn();
        player.playMovie();
    }

    public void listenMusic() {
        System.out.println("\nTime for some music...");
        light.bright();
        receiver.turnOn();
        sound.turnOn();
        player.turnOn();
        player.playMusic();
    }

    public void shutdown() {
        System.out.println("\nShutting everything down...");
        player.turnOff();
        sound.turnOff();
        receiver.turnOff();
        projector.turnOff();
        tv.turnOff();
        light.bright();
    }
}


public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Projector projector = new Projector();
        Receiver receiver = new Receiver();
        MediaPlayer player = new MediaPlayer();
        SoundSys sound = new SoundSys();
        AmbLight light = new AmbLight();

        HomeTheater home = new HomeTheater(
                tv, projector, receiver, player, sound, light
        );

        home.watchMovie();
        home.shutdown();

        home.listenToMusic();
        home.shutdown();
    }
}