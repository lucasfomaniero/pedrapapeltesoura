package Model.Intefaces;

import Model.Jogador;
import org.springframework.data.repository.CrudRepository;

import static javafx.scene.input.KeyCode.T;

public interface JogadorRepository extends CrudRepository<Jogador, Integer> {
}
