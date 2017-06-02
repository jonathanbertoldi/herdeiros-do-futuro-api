package br.com.herdeirosdofuturo.repository.contracts;

import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.model.Item;

import java.util.List;

public interface IItemRepository {

    void salvar(Item item);
    List<Item> buscarTodos();
    void remover(long itemId);
}
