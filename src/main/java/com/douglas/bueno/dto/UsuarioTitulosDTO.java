package com.douglas.bueno.dto;

public class UsuarioTitulosDTO {
    private String usuario;
    private Long quantidadeTitulos;

    // Construtor vazio (necessário para JPA)
    public UsuarioTitulosDTO() {
    }

    public UsuarioTitulosDTO(String usuario, Long quantidadeTitulos) {
        this.usuario = usuario;
        this.quantidadeTitulos = quantidadeTitulos;
    }

    // Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getQuantidadeTitulos() {
        return quantidadeTitulos;
    }

    public void setQuantidadeTitulos(Long quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }
}

