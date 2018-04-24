package Model.TiposJogadas;

import Model.*;

import javax.persistence.Entity;

public class Tesoura extends Jogada {

    public Tesoura() {
    }

    public String comparaCom(Jogada jogada) {
        String resultado;

        if (jogada instanceof Lagarto || jogada instanceof Papel) {
            resultado = "venceu";
        } else if (jogada instanceof Spock || jogada instanceof Pedra) {
            resultado = "perdeu";
        } else {
            resultado = "empate";
        }
        return resultado;
    }

    public String toString() {
        return "Tesoura";
    }
}
