package br.com.herdeirosdofuturo.controller;

import br.com.herdeirosdofuturo.dto.EventoDTO;
import br.com.herdeirosdofuturo.dto.EventosDTO;
import br.com.herdeirosdofuturo.model.Evento;
import br.com.herdeirosdofuturo.repository.contracts.IEventoRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private IEventoRepository repository;

    public EventoController(@Autowired IEventoRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EventosDTO buscarTodos() {
        List<EventoDTO> resposta = new ArrayList<>();

        // for (Evento evento : repository.buscarTodos()) {
        //     resposta.add(new EventoDTO(evento));
        // }

        repository.buscarTodos().forEach(evento -> resposta.add(new EventoDTO(evento)));

        EventosDTO respostaEventos = new EventosDTO();
        respostaEventos.setEventos(resposta);

        return respostaEventos;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EventoDTO> criar(@RequestBody EventoDTO dto) {
        Evento evento = dto.toEntity();
        repository.salvar(evento);
        EventoDTO dtoResposta = new EventoDTO(evento);
        return new ResponseEntity<>(dtoResposta, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{eventoId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remover(@PathVariable long eventoId) {
        repository.remover(eventoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
