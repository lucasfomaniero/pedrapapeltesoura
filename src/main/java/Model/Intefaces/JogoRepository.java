package Model.Intefaces;

import Model.Jogo;
import org.springframework.data.repository.CrudRepository;

public interface JogoRepository extends CrudRepository<Jogo, Integer> {
    Jogo findJogoByIdJogo(Integer id);
    Iterable<Jogo> findAllByVencedor(String nome);
}
