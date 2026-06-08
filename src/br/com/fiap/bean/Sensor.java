package br.com.fiap.bean;

/**
 * Representa um sensor de campo utilizado para detectar incêndios florestais.
 * Agora armazena o último valor medido e classifica a intensidade automaticamente.
 */
public class Sensor {

    // Atributos da classe
    private int idSensor;
    private String tipoSensor;
    private String fabricante;
    private String status;
    private double valorMedicao;
    private String unidadeMedicao;

    // Construtor vazio
    public Sensor() {
    }

    // Construtor com passagem de parametros
    public Sensor(int idSensor, String tipoSensor, String fabricante, String status) {
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.fabricante = fabricante;
        this.status = status;
        this.valorMedicao = 0;
        this.unidadeMedicao = resolverUnidade(tipoSensor);
    }

    // Getters e Setters
    public int getIdSensor() {
        return idSensor;
    }
    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }
    public String getTipoSensor() {
        return tipoSensor;
    }
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
        this.unidadeMedicao = resolverUnidade(tipoSensor);
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getValorMedicao() {
        return valorMedicao;
    }
    public void setValorMedicao(double valorMedicao) {
        this.valorMedicao = valorMedicao;
    }
    public String getUnidadeMedicao() {
        return unidadeMedicao;
    }

    // Resolve a unidade de medida com base no tipo do sensor
    private String resolverUnidade(String tipo) {
        if (tipo == null) return "?";
        String tipoUpper = tipo.toUpperCase();

        if (tipoUpper.equals("TEMPERATURA")) {
            return "°C";
        } else if (tipoUpper.equals("FUMACA")) {
            return "ppm";
        } else if (tipoUpper.equals("UMIDADE")) {
            return "%";
        } else {
            return "unid.";
        }
    }

    // Registra a medição e armazena o valor
    public void registrarMedicao(double valorMedido) {
        this.valorMedicao = valorMedido;
        this.unidadeMedicao = resolverUnidade(tipoSensor);

        System.out.println("--------------------------------------------------");
        System.out.println("Sensor ID " + idSensor + " (" + tipoSensor + ") registrou medição:");
        System.out.println("Valor      : " + valorMedido + " " + unidadeMedicao);
        System.out.println("Intensidade: " + classificarIntensidade());
        System.out.println("Status     : " + status);
        System.out.println("--------------------------------------------------");
    }
    // Metodo com o mesmo nome, mas recebe um parâmetro extra - String observação
    public void registrarMedicao(double valorMedido, String observacao) {
        System.out.println("\n[Nota do Sistema]: " + observacao);
        registrarMedicao(valorMedido);
    }

    // Classifica automaticamente a intensidade do incêndio
    public String classificarIntensidade() {
        String tipoUpper = (tipoSensor != null) ? tipoSensor.toUpperCase() : "";

        if (tipoUpper.equals("TEMPERATURA")) {
            if (valorMedicao <= 40) {
                return "BAIXA";
            } else if (valorMedicao <= 70) {
                return "MEDIA";
            } else {
                return "ALTA";
            }

        } else if (tipoUpper.equals("FUMACA")) {
            if (valorMedicao <= 150) {
                return "BAIXA";
            } else if (valorMedicao <= 400) {
                return "MEDIA";
            } else {
                return "ALTA";
            }

        } else if (tipoUpper.equals("UMIDADE")) {
            // Umidade baixa = risco alto (lógica invertida)
            if (valorMedicao > 50) {
                return "BAIXA";
            } else if (valorMedicao >= 20) {
                return "MEDIA";
            } else {
                return "ALTA";
            }

        } else {
            // Faixa genérica para outros tipos de sensor
            if (valorMedicao <= 40) {
                return "BAIXA";
            } else if (valorMedicao <= 70) {
                return "MEDIA";
            } else {
                return "ALTA";
            }
        }
    }

    // Exibe os dados completos do sensor, incluindo a leitura atual
    public void exibirDados() {
        System.out.println("=== Dados do Sensor ===");
        System.out.println("ID           : " + idSensor);
        System.out.println("Tipo         : " + tipoSensor);
        System.out.println("Fabricante   : " + fabricante);
        System.out.println("Status       : " + status);
        System.out.println("Última leitura: " + valorMedicao + " " + unidadeMedicao);
        System.out.println("Intensidade  : " + classificarIntensidade());
    }
}
