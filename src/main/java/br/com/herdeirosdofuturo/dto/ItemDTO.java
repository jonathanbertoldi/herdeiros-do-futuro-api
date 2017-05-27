package br.com.herdeirosdofuturo.dto;

import br.com.herdeirosdofuturo.model.Item;

public class ItemDTO {

    private Long id;
    private String nome;
    private String imagem;

    public ItemDTO(){}


    public ItemDTO(Item item){
        this.id = item.getId();
        this.nome = item.getNome();
        this.imagem = item.getImagem();
    }

    public Item toEntity() {
        Item item = new Item();
        item.setId(id);
        item.setNome(nome);
        item.setImagem(imagem);
        return item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
