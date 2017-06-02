package br.com.herdeirosdofuturo.repository;

import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.model.Item;
import br.com.herdeirosdofuturo.repository.contracts.IItemRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// gerencia instancia 
@Repository
@Transactional
public class ItemRepository implements IItemRepository {

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public void salvar(Item item) {
        manager.persist(item);
    }

    @Override
    public List<Item> buscarTodos() {
        return manager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
    }

    @Override
    public void remover(long itemId) {
        Item item = manager.find(Item.class, itemId);
        manager.remove(item);
    }
}
