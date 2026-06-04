package br.com.fiap.bean;

import br.com.fiap.interfaces.AcoesMonitoramento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa uma ocorrência de incêndio florestal registrada no sistema.
 * Implementa a interface AcoesMonitoramento para fornecer as ações de análise.
 */
public class OcorrenciaIncendio implements AcoesMonitoramento {

    //Atributos da classe
    private int idOcorrencia;
    private LocalDate dataOcorrencia;
    private String intensidade;
    private String status;
    private Regiao regiao;
    private Sensor sensor;
    private Alerta alerta;
    private String risco;

    // Construtor vazio
    public OcorrenciaIncendio() {
    }

    // Construtor com passagem de parametros
    public OcorrenciaIncendio(int idOcorrencia, LocalDate dataOcorrencia, String intensidade, String status, Regiao regiao, Sensor sensor, Alerta alerta) {
        this.idOcorrencia = idOcorrencia;
        this.dataOcorrencia = dataOcorrencia;
        this.intensidade = intensidade;
        this.status = status;
        this.regiao = regiao;
        this.sensor = sensor;
        this.alerta = alerta;
    }

    // Getters e Setters
    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public String getRisco() {
        return risco;
    }

    // Classifica o risco com base na intensidade
    @Override
    public void classificarRisco() {
        if (intensidade == null) {
            risco = "NÃO DEFINIDO";
            System.out.println("Intensidade não informada. Risco não classificado.");
            return;
        }

        String intensidadeI = intensidade.toUpperCase();

        if (intensidadeI.equals("BAIXA")) {
            risco = "BAIXO";
        } else if (intensidadeI.equals("MEDIA")) {
            risco = "MEDIO";
        } else if (intensidadeI.equals("ALTA")) {
            risco = "ALTO";
        } else {
            risco = "NÃO DEFINIDO";
        }

        System.out.println("Classificação de risco realizada: RISCO " + risco);
    }

    // Gera um alerta automático com base no risco classificado
    @Override
    public void gerarAlerta() {
        classificarRisco();

        String nivelAlerta;
        String descricao;

        if (risco.equals("BAIXO")) {
            nivelAlerta = "RISCO BAIXO";
            descricao = "Incêndio de baixa intensidade. Monitoramento preventivo recomendado.";
        } else if (risco.equals("MEDIO")) {
            nivelAlerta = "RISCO MEDIO";
            descricao = "Incêndio de intensidade média. Acionar equipes de campo imediatamente.";
        } else if (risco.equals("ALTO")) {
            nivelAlerta = "RISCO ALTO";
            descricao = "Incêndio de alta intensidade. EMERGÊNCIA! Evacuação e combate imediato necessários.";
        } else {
            nivelAlerta = "INDEFINIDO";
            descricao = "Risco não classificado. Verificar dados da ocorrência.";
        }

        alerta = new Alerta(idOcorrencia, nivelAlerta, descricao, LocalDate.now());

        System.out.println("Alerta gerado com sucesso!");
        alerta.exibirAlerta();
    }

    // Exibe resumo completo
    @Override
    public void exibirResumo() {
        DateTimeFormatter dtmf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("==================================================");
        System.out.println("          RESUMO DA OCORRÊNCIA DE INCÊNDIO        ");
        System.out.println("==================================================");
        System.out.println("ID Ocorrência : " + idOcorrencia);
        System.out.println("Data          : " + (dataOcorrencia != null ? dataOcorrencia.format(dtmf) : "Não informada"));
        System.out.println("Intensidade   : " + intensidade);
        System.out.println("Status        : " + status);
        System.out.println("Risco         : " + (risco != null ? risco : "Não classificado"));

        if (status.equals("CONTROLADO")) {
            System.out.println(">>> Situação  : Incêndio sob controle. Monitoramento contínuo recomendado.");
        } else if (status.equals("EXTINTO")) {
            System.out.println(">>> Situação  : Incêndio extinto. Registro de histórico.");
        }

        System.out.println();

        if (regiao != null) {
            regiao.exibirDados();
        } else {
            System.out.println("Região: não informada.");
        }

        System.out.println();

        if (sensor != null) {
            sensor.exibirDados();
        } else {
            System.out.println("Sensor: não informado.");
        }

        System.out.println();

        if (alerta != null) {
            alerta.exibirAlerta();
        } else {
            if (status.equals("EXTINTO")) {
                System.out.println("Alerta: não gerado (incêndio extinto).");
            } else {
                System.out.println("Alerta: ainda não gerado.");
            }
        }

        System.out.println("==================================================");
    }
}