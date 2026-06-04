package br.com.fiap.bean.interfaces;

/**
 * Interface que define as ações obrigatórias de monitoramento de incêndios.
 * Toda classe que implementar esta interface deve fornecer os métodos abaixo.
 */
public interface AcoesMonitoramento {

    // Gera um alerta com base na classificação de risco da ocorrência
    void gerarAlerta();

    // Classifica o nível de risco com base na intensidade do incêndio
    void classificarRisco();

    // Exibe um resumo completo da ocorrência registrada
    void exibirResumo();
}
