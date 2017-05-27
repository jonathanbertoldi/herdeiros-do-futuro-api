package br.com.herdeirosdofuturo.repository;

import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.repository.contracts.IEventoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EventoRepository implements IEventoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void salvar(Evento evento) {
        manager.persist(evento);
    }

    @Override
    public List<Evento> buscarTodos() {
        return manager.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
    }
}
