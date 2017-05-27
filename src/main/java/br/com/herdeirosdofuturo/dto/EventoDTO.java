package br.com.herdeirosdofuturo.dto;

import br.com.herdeirosdofuturo.model.Evento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;

public class EventoDTO {

    private Long id;
    private String titulo;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar data;

    public EventoDTO() { }

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.titulo = evento.getTitulo();
        this.data = evento.getData();
    }

    public Evento toEntity() {
        Evento evento = new Evento();
        evento.setId(id);
        evento.setTitulo(titulo);
        evento.setData(data);
        return evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
