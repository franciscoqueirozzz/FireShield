package br.com.fiap.bean;

/**
 * Classe base que representa uma pessoa no sistema FireShield.
 * Outras classes podem herdar desta para reaproveitar os atributos comuns.
 */
public class Pessoa {

    //Atributos da classe
    private int id;
    private String nome;

    // Construtor vazio
    public Pessoa() {
    }

    // Construtor com passagem de parametros
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Exibe os dados da pessoa
    public void exibirDados() {
        System.out.println("=== Dados da Pessoa ===");
        System.out.println("ID   : " + id);
        System.out.println("Nome : " + nome);
    }
}
