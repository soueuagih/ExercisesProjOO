/*
Exercício 2 - Sistema Home Theater  
*/


class TV {
    public void ligar() { System.out.println("TV ligada"); }
    public void desligar() { System.out.println("TV desligada"); }
}

class Projetor {
    public void ligar() { System.out.println("Projetor ligado"); }
    public void desligar() { System.out.println("Projetor desligado"); }
}

class Receiver {
    public void ligar() { System.out.println("Receiver ligado"); }
    public void desligar() { System.out.println("Receiver desligado"); }
}

class PlayerMidia {
    public void ligar() { System.out.println("Player ligado"); }
    public void reproduzirFilme() { System.out.println("Filme reproduzido!"); }
    public void reproduzirMusica() { System.out.println("Música reproduzida!"); }
    public void desligar() { System.out.println("Player desligado"); }
}

class SistemaSom {
    public void ligar() { System.out.println("Sistema de som ligado"); }
    public void desligar() { System.out.println("Sistema de som desligado"); }
}

class LuzAmbiente {
    public void diminuir() { System.out.println("Luzes diminuídas"); }
    public void aumentar() { System.out.println("Luzes acesas"); }
}


class HomeTheater {
    private TV tv;
    private Projetor projetor;
    private Receiver receiver;
    private PlayerMidia player;
    private SistemaSom som;
    private LuzAmbiente luz;

    public HomeTheater(TV tv, Projetor projetor, Receiver receiver,
                             PlayerMidia player, SistemaSom som, LuzAmbiente luz) {
        this.tv = tv;
        this.projetor = projetor;
        this.receiver = receiver;
        this.player = player;
        this.som = som;
        this.luz = luz;
    }

    public void assistirFilme() {
        System.out.println("\nO filme já vai começar...");
        luz.diminuir();
        tv.ligar();
        projetor.ligar();
        receiver.ligar();
        som.ligar();
        player.ligar();
        player.reproduzirFilme();
    }

    public void ouvirMusica() {
        System.out.println("\nAumente o volume! Vamos ouvir alguma música!");
        luz.aumentar();
        receiver.ligar();
        som.ligar();
        player.ligar();
        player.reproduzirMusica();
    }

    public void desligarTudo() {
        System.out.println("\nDesligando tudo...");
        player.desligar();
        som.desligar();
        receiver.desligar();
        projetor.desligar();
        tv.desligar();
        luz.aumentar();
    }
}


public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Projetor projetor = new Projetor();
        Receiver receiver = new Receiver();
        PlayerMidia player = new PlayerMidia();
        SistemaSom som = new SistemaSom();
        LuzAmbiente luz = new LuzAmbiente();

        HomeTheater home = new HomeTheater(
                tv, projetor, receiver, player, som, luz
        );

        home.assistirFilme();
        home.desligarTudo();

        home.ouvirMusica();
        home.desligarTudo();
    }
}
