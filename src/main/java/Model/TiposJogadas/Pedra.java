package Model.TiposJogadas;

import Model.Jogador;

import javax.persistence.Entity;
import java.io.Serializable;

public class Pedra extends Jogada {

    public Pedra() {
    }

    @Override
    public String comparaCom(Jogada jogada) {
        String resultado;
        if (jogada instanceof Lagarto || jogada instanceof Tesoura) {
            resultado = "venceu";
        } else if(jogada instanceof Spock || jogada instanceof Papel ){
            resultado = "perdeu";
        } else {
            resultado = "empate";
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Pedra";
    }
}
