package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.dto.EventoDTO;
import br.com.herdeirosdofuturo.dto.ItemDTO;
import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.model.Item;
import br.com.herdeirosdofuturo.repository.ItemRepository;
import br.com.herdeirosdofuturo.repository.contracts.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    private IItemRepository repository;

    public ItemController(@Autowired IItemRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ItemDTO> buscarTodos(){
        List<ItemDTO> resposta = new ArrayList<>();
        repository.buscarTodos().forEach(item -> resposta.add(new ItemDTO(item)));
        return resposta;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ItemDTO> criar(@RequestBody ItemDTO dto) {
        Item item = dto.toEntity();
        repository.salvar(item);
        ItemDTO dtoResposta = new ItemDTO(item);
        return new ResponseEntity<>(dtoResposta, HttpStatus.CREATED);
    }
}
