package br.com.herdeirosdofuturo.dto;

import java.util.ArrayList;
import java.util.List;

public class ItensDTO {

    private List<ItemDTO> itens;

    public ItensDTO() {
        itens = new ArrayList<>();
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }
}
