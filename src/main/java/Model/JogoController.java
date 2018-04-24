package Model;


import Model.Intefaces.JogadorRepository;
import Model.Intefaces.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogoController {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    JogadorRepository jogadorRepository;


    //GET - LISTAR TODOS OS JOGOS
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos/", method = RequestMethod.GET)
    public Iterable<Jogo> listarJogos(){
        return jogoRepository.findAll();
    }

    /*//GET - LISTAR TODAS AS VITÓRIAS DE UM JOGADOR:
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos/{nome}", method = RequestMethod.GET)
    public Iterable<Jogo> ListarVitoriasJogador(@PathVariable("nome") String nome){
        return jogoRepository.findAllByVencedor(nome);
    }*/

    //POST - CRIAR UM NOVO JOGO
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos/{nome}/{escolha}", method = RequestMethod.POST)
    public Jogo criarJogo(@PathVariable("nome") String nome, @PathVariable("escolha") String escolha){
        Jogo novojogo = new Jogo().criarJogo(nome, escolha);

        return jogoRepository.save( novojogo);
    }

   /* //PUT: ALTERAR UM JOGO EXISTENTE
    @RequestMapping(value = "/jogos/", method = RequestMethod.PUT)
    public Jogo alterarJogo(@RequestBody Jogo jogo){
        *//*Jogo j1 = jogoRepository.findJogoByIdJogo(jogo.getIdJogo());

        if(jogo.getVencedor() != null)
            j1.setVencedor(jogo.getVencedor());

        if (jogo.getPerdedor() != null)
            j1.setPerdedor(jogo.getPerdedor());

        if (jogo.getEmpate() != null)
            j1.setEmpate(jogo.getEmpate());

        return jogo;*//*
    }
*/
    //DELETE: DELETAR UM JOGO
    @RequestMapping(value = "/jogos/{id}", method = RequestMethod.DELETE)
    public Boolean deletarJogo(@PathVariable("id") Integer idJogo){
        Boolean resultado = false;
        if(jogoRepository.findJogoByIdJogo(idJogo) != null) {
            jogoRepository.deleteById(idJogo);
            resultado = true;
        }

        return resultado;
    }


    //GET - LISTAR TODAS AS VITÓRIAS DE UM JOGADOR:
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/jogos/{nome}", method = RequestMethod.GET)
        public int getQuantidadeVitoriasJogador( @PathVariable("nome") String nome, @RequestParam("visao") String visao){
            Iterable<Jogo> vitorias = jogoRepository.findAllByVencedor(nome);
            int qtdVitorias = 0;
        for (Jogo jogo : vitorias) {
            qtdVitorias++;
        }
            return qtdVitorias;
    }






}
