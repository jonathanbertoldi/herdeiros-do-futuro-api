package br.com.herdeirosdofuturo.repository.contracts;

import br.com.herdeirosdofuturo.model.Evento;

import java.util.List;

public interface IEventoRepository {
    void salvar(Evento evento);
    List<Evento> buscarTodos();
    void remover(long eventoId);
}
