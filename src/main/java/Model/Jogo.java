package Model;

import Model.TiposJogadas.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Jogo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idJogo;
    private Date dataehora = new Date();
    private String jogador1_nome;
    private String jogador2_nome;
    private String jogador1_escolha;
    private String jogador2_escolha;
    private String vencedor;
    private String perdedor;
    private Boolean empate;
    private int vitoriasConsecutivasVencedor;


    public Jogo criarJogo(String nomeP1, String escolhaP1){
        //Cria o jogo

        //Criar e executa todas as ações referentes ao jogador 1
        Jogador p1 = new Jogador();
        p1.setNome(nomeP1);
        Jogada jogadaP1 = criarJogada(escolhaP1);
        jogadaP1.setJogador(p1);

        //Criar e executa todas as ações referentes ao jogador 2
        Computador p2 = new Computador();
        Jogada jogadaP2 = p2.escolherJogada();
        jogadaP2.setJogador(p2);

        compararJogadas(jogadaP1, jogadaP2);

        //Criar a controller e pede que salve os jogadores no banco;
//        JogadorController controller = new JogadorController();
//        controller.salvarJogador(p1);
//        controller.salvarJogador(p2);

        return this;
    }


    public void compararJogadas(Jogada jogada1, Jogada jogada2){
        this.setJogador1_nome(jogada1);
        this.setJogador2_nome(jogada2);
        this.setJogador1_escolha(jogada1);
        this.setJogador2_escolha(jogada2);
        if(jogada1.comparaCom(jogada2).equals("venceu")){
            setVencedor(jogada1.getJogador());
            setPerdedor(jogada2.getJogador());
            setEmpate(false);
        } else if (jogada1.comparaCom(jogada2).equals("perdeu")){
            setVencedor(jogada2.getJogador());
            setPerdedor(jogada1.getJogador());
            setEmpate(false);
        } else{
            setEmpate(true);
        }


    }

    public Jogada criarJogada(String escolha){
        Jogada jogada = null;
            if (escolha.equals("pedra")) {
                jogada = new Pedra();
            }else if (escolha.equals("papel")) {
                jogada = new Papel();
            }else if (escolha.equals("tesoura")) {
                jogada = new Tesoura();
            }else if (escolha.equals("lagarto")) {
                jogada = new Lagarto();
            }else {
                jogada = new Spock();
            }

        return jogada;
    }



    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getJogador1_nome() {
        return jogador1_nome;
    }

    public void setJogador1_nome(Jogada jogada) {

        this.jogador1_nome = jogada.getJogador().getNome();
    }

    public String getJogador2_nome() {
        return jogador2_nome;
    }

    public void setJogador2_nome(Jogada jogada) {
        this.jogador2_nome = jogada.getJogador().getNome();
    }

    public String getJogador1_escolha() {
        return jogador1_escolha;
    }

    public void setJogador1_escolha(Jogada jogada) {
        this.jogador1_escolha = jogada.toString();
    }

    public String getJogador2_escolha() {
        return jogador2_escolha;
    }

    public void setJogador2_escolha(Jogada jogador2_escolha) {
        this.jogador2_escolha = jogador2_escolha.toString();
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor.getNome();
        vencedor.getPartidasJogadas().add(this);
        this.vitoriasConsecutivasVencedor = vencedor.getNumeroVitoriasConsecutivas();

    }

    public String getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(Jogador perdedor) {
       perdedor.getPartidasJogadas().add(this);
        this.perdedor = perdedor.getNome();
    }

    public Boolean getEmpate() {
        return empate;
    }

    public void setEmpate(Boolean empate) {
        this.empate = empate;
    }
}
