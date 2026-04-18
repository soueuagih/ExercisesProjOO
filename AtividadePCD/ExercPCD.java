/*
P.C.D
Exercício: desenvolver uma aplicação de monitoramento do Rio Amazonas por universidades. Parâmetros: temperatura, PH, PA, URA
*/

import java.util.ArrayList;
import java.util.List;


interface Observer {
    void atualizar(double temperatura, double ph, double pressao, float umidrel);
}

//Classe subject - quem sofre alterações/atualizações

class SensorRio {
    private List<Observer> universidades = new ArrayList<>();
    private double temperatura;
    private double ph;
    private double pressao;
    private float umidrel;

    public void adicionar(Observer o){
        universidades.add(o);
    }

    public void Atualizacao(double temperatura, double ph, double pressao, float umidrel) {
        
        boolean Mudou = false;

        if (this.temperatura != temperatura ||
            this.ph != ph ||
            this.pressao != pressao ||
            this.umidrel != umidrel) {
            mudou = true;
        }

        this.temperatura = temperatura;
        this.ph = ph;
        this.pa = pressao;
        this.ura = umidrel;

        if(Mudou) {
            notificarUnis();
        }
        
    }

    private void notificarUnis(String titulo) {
        for (Observer o : universidades) {
            o.atualizar(temperatura, ph, pressao, umidrel);
        }
    }
}

//Classe observer - quem vai ser notificado quando houverem alterações

class Universidade implements Observer {
    private String nome;

    public Universidade(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(double temperatura, double ph, double pressao, float umidrel) {
        System.out.println(nome + " registrou atualizações no rio: ");
        System.out.println("Temperatura: %f, PH: %f, Press. Atm: %f, Umidade Rel. do Ar: %f ", temperatura, ph, pressao, umidrel);

    }
}

public class Main {
    public static void main(String[] args) {
        SensorRio sens = new SensorRio();
        
        Universidade uni1 = new Universidade("Unifesp");
        Universidade uni2 = new Universidade("Unicamp");
        Universidade uni3 = new Universidade("USP");

        sens.adicionar(uni1);
        sens.adicionar(uni2);

        sens.atualizar(25.0, 6.5, 1013.0, 80.0);
        sens.atualizar(25.0, 6.5, 1013.0, 80.0); 
        sens.atualizar(26.0, 6.7, 1012.0, 82.0); 

    }
}
