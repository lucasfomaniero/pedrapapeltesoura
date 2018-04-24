package Model;

import Model.TiposJogadas.Jogada;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identifier;
    private String nome;
    private int numeroVitoriasConsecutivas = 0;
    @OneToMany
    private List<Jogo> partidasJogadas = new ArrayList<>();

    public Jogador(){
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroVitoriasConsecutivas() {
        int contador = 0;

        for (Jogo jogo: partidasJogadas) {
            if(jogo.getVencedor() == null){
                contador = 0;
            }else if(jogo.getVencedor().equals(this.nome)){
                contador++;
            }else{
             contador = 0;
            }
        }

        return contador;
    }


    public List<Jogo> getPartidasJogadas() {

        return partidasJogadas;
    }

    public void setPartidasJogadas(List<Jogo> partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }



    @Override
    public String toString() {
        return this.nome;
    }
}
