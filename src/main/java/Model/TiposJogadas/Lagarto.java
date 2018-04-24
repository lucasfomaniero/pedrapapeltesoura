package Model.TiposJogadas;

import Model.Jogador;

import javax.persistence.Entity;

public class Lagarto extends Jogada {
    public Lagarto() {
    }

    @Override
    public String comparaCom(Jogada jogada) {
        String resultado;
        if (jogada instanceof Spock || jogada instanceof Papel) {
            resultado = "venceu";
        } else if(jogada instanceof Tesoura || jogada instanceof Pedra ){
            resultado = "perdeu";
        } else{
            resultado = "empate";
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Lagarto";
    }
}
