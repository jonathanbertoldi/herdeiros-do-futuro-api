package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.dto.ItemDTO;
import br.com.herdeirosdofuturo.dto.ItensDTO;
import br.com.herdeirosdofuturo.model.Item;
import br.com.herdeirosdofuturo.repository.contracts.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/itens")
public class ItemController {

    private IItemRepository repository;

    public ItemController(@Autowired IItemRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ItensDTO buscarTodos(){
        List<ItemDTO> resposta = new ArrayList<>();
        repository.buscarTodos().forEach(item -> resposta.add(new ItemDTO(item)));

        ItensDTO itens = new ItensDTO();
        itens.setItens(resposta);

        return itens;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemDTO> criar(@RequestBody ItemDTO dto) {
        Item item = dto.toEntity();
        repository.salvar(item);
        ItemDTO dtoResposta = new ItemDTO(item);
        return new ResponseEntity<>(dtoResposta, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remover(@PathVariable long itemId) {
        repository.remover(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
