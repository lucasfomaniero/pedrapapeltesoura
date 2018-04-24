package Model.TiposJogadas;

import Model.*;

import javax.persistence.Entity;

public class Spock extends Jogada {


    public Spock(){}

    public String comparaCom(Jogada jogada) {
        String resultado;
        if (jogada instanceof Tesoura || jogada instanceof Pedra) { //Ganha de
            resultado = "venceu";
        } else if(jogada instanceof Lagarto || jogada instanceof Papel){ //Perde de
            resultado = "perdeu";
        } else{
            resultado = "empate";
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Spock";
    }
}
