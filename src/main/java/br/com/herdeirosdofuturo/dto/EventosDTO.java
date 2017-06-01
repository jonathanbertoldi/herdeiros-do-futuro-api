package br.com.herdeirosdofuturo.dto;

import java.util.ArrayList;
import java.util.List;

public class EventosDTO {

    private List<EventoDTO> eventos;

    public EventosDTO() {
        eventos = new ArrayList<>();
    }

    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDTO> eventos) {
        this.eventos = eventos;
    }
}
