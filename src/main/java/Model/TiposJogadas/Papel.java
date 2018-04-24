package Model.TiposJogadas;

import Model.Jogador;

import javax.persistence.Entity;


public class Papel extends Jogada {

    public Papel() {
    }

    @Override
    public String comparaCom(Jogada jogada) {
        String resultado;
        if (jogada instanceof Spock || jogada instanceof Pedra) {
            resultado = "venceu";
        } else if(jogada instanceof Tesoura || jogada instanceof Lagarto ){
            resultado = "perdeu";
        } else{
            resultado = "empate";
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Papel";
    }
}
