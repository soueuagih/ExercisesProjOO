import java.util.ArrayList;
import java.util.List;

/*
 * definindo callback
 */
@FunctionalInterface
interface CallbackAtualizacao {
    void chamar(double temperatura, double ph, double pressao, float umidrel);
}

/*
 * Subject
 *  - armazenar os dados do rio
 *  - detectar mudanças
 *  - notificar os observadores (callbacks)
 */
class SensorRio {

    /* 
     * Lista de callbacks (observadores)
     */
    private List<CallbackAtualizacao> callbacks = new ArrayList<>();

    /*
     * Dados que serão monitorados
     */
    private double temperatura;
    private double ph;
    private double pressao;
    private float umidrel;

    /*
     * Registrando um novo observador
     * Vínculo sujeito - observador
     */
    public void adicionar(CallbackAtualizacao cb){
        callbacks.add(cb);
    }

    /*
     * Quando chegam novos dados do sensor
     */
    public void atualizar(double temperatura, double ph, double pressao, float umidrel) {

        boolean mudou = false;

        /*
         * Verifica se teve alteração nos dados
         */
        if (this.temperatura != temperatura ||
            this.ph != ph ||
            this.pressao != pressao ||
            this.umidrel != umidrel) {
            mudou = true;
        }

        /*
         *Atualiza o estado
         */
        this.temperatura = temperatura;
        this.ph = ph;
        this.pressao = pressao;
        this.umidrel = umidrel;

        /*
         * Se tiver mudado, envia notificação
         */
        if(mudou) {
            notificar();
        }
    }

    /*
     * Callback
     *
     * SensorRio chama funções
     * executa callbacks
     *
     * Inversão de Controle (IoC) -> fluxo de execução está no SensorRio e não nas universidades
     */
    private void notificar() {
        for (CallbackAtualizacao cb : callbacks) {
            cb.chamar(temperatura, ph, pressao, umidrel); //Callback
        }
    }
}

/*
 * Classe que representa uma universidade - não controla fluxo, só define o que fazer quando for notificada
 */
class Universidade {
    private String nome;

    public Universidade(String nome) {
        this.nome = nome;
    }

    /*
     * criar e retornar callback
     *
     * lambda - definir comportamento após notif. do sensor
     */
    public CallbackAtualizacao criarCallback() {
        return (temp, ph, pressao, umid) -> {

            System.out.println(nome + " recebeu atualização:");

            System.out.printf(
                "Temperatura: %.2f | PH: %.2f | Pressão: %.2f | Umidade: %.2f\n",
                temp, ph, pressao, umid
            );
        };
    }
}


public class Main {
    public static void main(String[] args) {

        /*
         *Criando o sujeito
         */
        SensorRio sensor = new SensorRio();

        /*
         * Criando observers
         */
        Universidade uni1 = new Universidade("Unifesp");
        Universidade uni2 = new Universidade("Unicamp");

        
        /*
         * Registrando callbacks
         */
        
        sensor.adicionar(uni1.criarCallback());
        sensor.adicionar(uni2.criarCallback());

        /*
         * callback sem classe
         */
        sensor.adicionar((t, ph, p, u) -> {
            System.out.println("Sistema externo recebeu dados!");
        });

        /*
         * Atualizações do sensor
         * Quando tiver mudança, callbacks vão ser executados
         */
        sensor.atualizar(25.0, 6.5, 1013.0f, 80.0f);
        sensor.atualizar(25.0, 6.5, 1013.0f, 80.0f); 
        sensor.atualizar(26.0, 6.7, 1012.0f, 82.0f); 
    }
}
