package Model.TiposJogadas;

import Model.Jogador;

import javax.persistence.*;


public abstract class Jogada {
    private Integer identifier;
    private Jogador jogador;

    public Jogada() {

    }

    public String comparaCom(Jogada jogada) {
        return null;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
