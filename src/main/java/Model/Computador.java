package Model;

import Model.TiposJogadas.*;

import java.util.Random;

public class Computador extends Jogador {

    public Computador() {
        this.setNome("Computador");

    }

    public Jogada escolherJogada() {
        Jogada jogada = null;
        int numeroAleatorio = new Random().nextInt(4); //(int) (Math.random() * 4);

        switch (numeroAleatorio) {
            case 0:
                jogada = new Pedra();
                break;
            case 1:
                jogada = new Papel();
                break;
            case 2:
                jogada = new Tesoura();
                break;
            case 3:
                jogada = new Lagarto();
                break;
            case 4:
                jogada = new Spock();
                break;
        }
        return jogada;
    }
}