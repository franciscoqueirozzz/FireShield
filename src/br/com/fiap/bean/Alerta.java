package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Representa um alerta gerado automaticamente pelo sistema
 * com base na análise de risco de uma ocorrência de incêndio.
 */
public class Alerta {

    // Atributos da classe
    private int idAlerta;
    private String nivelAlerta;
    private String descricao;
    private LocalDate dataAlerta;

    // Construtor vazio
    public Alerta() {
    }

    // Construtor com passagem de parâmetros
    public Alerta(int idAlerta, String nivelAlerta, String descricao, LocalDate dataAlerta) {
        this.idAlerta = idAlerta;
        this.nivelAlerta = nivelAlerta;
        this.descricao = descricao;
        this.dataAlerta = dataAlerta;
    }

    // Getters e Setters
    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getNivelAlerta() {
        return nivelAlerta;
    }

    public void setNivelAlerta(String nivelAlerta) {
        this.nivelAlerta = nivelAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    // Exibe as informações do alerta
    public void exibirAlerta() {
        DateTimeFormatter dtmf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("=== Alerta Gerado ===");
        System.out.println("ID do Alerta : " + idAlerta);
        System.out.println("Nível        : " + nivelAlerta);
        System.out.println("Descrição    : " + descricao);
        System.out.println("Data         : " + (dataAlerta != null ? dataAlerta.format(dtmf) : "Não informada"));
    }
}
