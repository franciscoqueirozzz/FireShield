package br.com.fiap.bean;

/**
 * Representa uma região geográfica monitorada pelo sistema FireShield.
 */
public class Regiao {

    // Atributos da classe
    private int idRegiao;
    private String nomeRegiao;
    private String pais;
    private double areaKm2;

    // Construtor vazio
    public Regiao() {
    }

    // Construtor com passagem de parametros
    public Regiao(int idRegiao, String nomeRegiao, String pais, double areaKm2) {
        this.idRegiao = idRegiao;
        this.nomeRegiao = nomeRegiao;
        this.pais = pais;
        this.areaKm2 = areaKm2;
    }

    // Getters e Setters
    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(double areaKm2) {
        this.areaKm2 = areaKm2;
    }

    // Exibe os dados da região
    public void exibirDados() {
        System.out.println("=== Dados da Região ===");
        System.out.println("ID      : " + idRegiao);
        System.out.println("Nome    : " + nomeRegiao);
        System.out.println("País    : " + pais);
        System.out.println("Área    : " + areaKm2 + " km²");
    }
}
