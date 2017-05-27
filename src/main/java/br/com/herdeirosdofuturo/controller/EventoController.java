package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.dto.EventoDTO;
import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.repository.contracts.IEventoRepository;
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
@RequestMapping("/api/eventos")
public class EventoController {

    private IEventoRepository repository;

    public EventoController(@Autowired IEventoRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EventoDTO> buscarTodos() {
        List<EventoDTO> resposta = new ArrayList<>();

        // for (Evento evento : repository.buscarTodos()) {
        //     resposta.add(new EventoDTO(evento));
        // }

        repository.buscarTodos().forEach(evento -> resposta.add(new EventoDTO(evento)));

        return resposta;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventoDTO> criar(@RequestBody EventoDTO dto) {
        Evento evento = dto.toEntity();
        repository.salvar(evento);
        EventoDTO dtoResposta = new EventoDTO(evento);
        return new ResponseEntity<>(dtoResposta, HttpStatus.CREATED);
    }
}
