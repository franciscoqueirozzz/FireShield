package br.com.fiap.bean;
/**
 * Representa um operador do sistema FireShield.
 * Herda os atributos básicos de Pessoa e adiciona informações profissionais.
 */
public class Operador extends Pessoa {

    //Atributos da classe
    private String email;
    private String telefone;
    private String cargo;
    private String senha;

    // Construtor vazio
    public Operador() {
        super();
    }

    // Construtor com passagem de parametros
    public Operador(int id, String nome, String email, String telefone, String cargo, String senha) {
        super(id, nome);
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.senha = senha;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Exibe dados completos do operador
    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Operador ===");
        System.out.println("ID       : " + getId());
        System.out.println("Nome     : " + getNome());
        System.out.println("E-mail   : " + email);
        System.out.println("Telefone : " + telefone);
        System.out.println("Cargo    : " + cargo);
    }
}
