package br.com.fiap.main;

import br.com.fiap.bean.Operador;
import br.com.fiap.bean.OcorrenciaIncendio;
import br.com.fiap.bean.Regiao;
import br.com.fiap.bean.Sensor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dtmf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Usuarios fixos do sistema com o novo domínio
        Operador op1 = new Operador(1, "Astrogildo Silva", "astrogildo@fireshield.com", "11988887777", "Analista Sênior", "senha123");
        Operador op2 = new Operador(2, "Berisvaldo Lima", "berisvaldo@fireshield.com", "21977776666", "Coordenador de Campo", "senha123");
        Operador op3 = new Operador(3, "Astrovaldo Souza", "astrovaldo@fireshield.com", "31966665555", "Operador de Monitoramento", "senha123");

        Operador operadorLogado = null;
        OcorrenciaIncendio ocorrenciaAtual = null;
        int contadorOcorrencia = 0;
        int opcao = -1;

        // ---- MENU INICIAL ----
        while (opcao != 0) {
            System.out.println("\n==================================================");
            System.out.println("          FireShield - Sistema de Monitoramento   ");
            System.out.println("==================================================");
            System.out.println("1 - Login");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    // ---- LOGIN ----
                    System.out.println("\n--- Login ---");
                    System.out.print("E-mail : ");
                    String emailDigitado = scanner.nextLine().trim();
                    System.out.print("Senha  : ");
                    String senhaDigitada = scanner.nextLine().trim();

                    operadorLogado = null;

                    if (op1.getEmail().equals(emailDigitado) && op1.getSenha().equals(senhaDigitada)) {
                        operadorLogado = op1;
                    } else if (op2.getEmail().equals(emailDigitado) && op2.getSenha().equals(senhaDigitada)) {
                        operadorLogado = op2;
                    } else if (op3.getEmail().equals(emailDigitado) && op3.getSenha().equals(senhaDigitada)) {
                        operadorLogado = op3;
                    }

                    if (operadorLogado == null) {
                        System.out.println("\nLogin inválido.");
                        break;
                    }

                    System.out.println("\nBem-vindo(a), " + operadorLogado.getNome() + "!");

                    // ---- MENU PRINCIPAL ----
                    int opcaoMenu = -1;

                    while (opcaoMenu != 0) {
                        System.out.println("\n==================================================");
                        System.out.println("          FireShield - Menu Principal             ");
                        System.out.println("==================================================");
                        System.out.println("1 - Cadastrar Ocorrência");
                        System.out.println("2 - Classificar Risco");
                        System.out.println("3 - Gerar Alerta");
                        System.out.println("4 - Exibir Dashboard");
                        System.out.println("0 - Sair");
                        System.out.print("Escolha: ");

                        try {
                            opcaoMenu = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            opcaoMenu = -1;
                        }

                        switch (opcaoMenu) {

                            case 1:
                                // ---- CADASTRAR OCORRÊNCIA ----
                                System.out.println("\n--- Cadastrar Ocorrência de Incêndio ---");

                                contadorOcorrencia++;
                                int idOcorrencia = contadorOcorrencia;

                                LocalDate dataOcorrencia = null;
                                boolean dataValida = false;
                                while (!dataValida) {
                                    System.out.print("Data da ocorrência (DD/MM/AAAA): ");
                                    String dataoc = scanner.nextLine().trim();
                                    try {
                                        dataOcorrencia = LocalDate.parse(dataoc, dtmf);
                                        if (dataOcorrencia.isAfter(LocalDate.now())) {
                                            System.out.println("Data inválida.");
                                            System.out.println("A ocorrência não pode estar no futuro.");
                                        } else {
                                            dataValida = true;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Formato inválido. Use DD/MM/AAAA.");
                                    }
                                }

                                // Status do incêndio com validação
                                String status = "";
                                boolean statusValido = false;
                                while (!statusValido) {
                                    System.out.print("Status (ATIVO / CONTROLADO / EXTINTO): ");
                                    status = scanner.nextLine().trim().toUpperCase();
                                    if (status.equals("ATIVO") || status.equals("CONTROLADO") || status.equals("EXTINTO")) {
                                        statusValido = true;
                                    } else {
                                        System.out.println("Status inválido. Digite ATIVO, CONTROLADO ou EXTINTO.");
                                    }
                                }

                                if (status.equals("CONTROLADO")) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("AVISO: Incêndio CONTROLADO.");
                                    System.out.println("Risco reduzido. Manter monitoramento preventivo.");
                                    System.out.println("Alerta de emergência não será necessário.");
                                    System.out.println("--------------------------------------------------");
                                } else if (status.equals("EXTINTO")) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("AVISO: Incêndio EXTINTO.");
                                    System.out.println("Ocorrência encerrada. Registro apenas para histórico.");
                                    System.out.println("Nenhuma ação de combate necessária.");
                                    System.out.println("--------------------------------------------------");
                                }

                                // Região
                                System.out.println("\n-- Dados da Região --");
                                System.out.print("Nome da região: ");
                                String nomeRegiao = scanner.nextLine().trim();
                                System.out.print("País: ");
                                String pais = scanner.nextLine().trim();

                                double areaKm2 = 0;
                                boolean areaValida = false;
                                while (!areaValida) {
                                    System.out.print("Área (km²): ");
                                    try {
                                        areaKm2 = Double.parseDouble(scanner.nextLine().trim());
                                        areaValida = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor inválido. Digite um número.");
                                    }
                                }

                                Regiao regiao = new Regiao(idOcorrencia, nomeRegiao, pais, areaKm2);

                                // ---- DADOS DO SENSOR ----
                                System.out.println("\n-- Dados do Sensor --");
                                System.out.print("Fabricante: ");
                                String fabricante = scanner.nextLine().trim();

                                String statusSensor = "";
                                boolean statusSensorValido = false;
                                while (!statusSensorValido) {
                                    System.out.print("Status do sensor (ATIVO / INATIVO / MANUTENCAO): ");
                                    statusSensor = scanner.nextLine().trim().toUpperCase();
                                    if (statusSensor.equals("ATIVO") || statusSensor.equals("INATIVO") || statusSensor.equals("MANUTENCAO")) {
                                        statusSensorValido = true;
                                    } else {
                                        System.out.println("Status inválido. Digite ATIVO, INATIVO ou MANUTENCAO.");
                                    }
                                }

                                if (statusSensor.equals("INATIVO")) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("AVISO: Sensor INATIVO.");
                                    System.out.println("Leitura pode estar desatualizada ou incorreta.");
                                    System.out.println("Recomenda-se verificar ou substituir o sensor.");
                                    System.out.println("--------------------------------------------------");
                                } else if (statusSensor.equals("MANUTENCAO")) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("AVISO: Sensor em MANUTENÇÃO.");
                                    System.out.println("Dados registrados podem não refletir a realidade.");
                                    System.out.println("--------------------------------------------------");
                                }

                                // Leitura dos dados do sensor
                                System.out.println("\nFaixas de referência:");
                                System.out.println("  Temperatura → até 40°C = BAIXA | 41-70°C = MEDIA | acima 70°C = ALTA");
                                System.out.println("  Fumaça      → até 150ppm = BAIXA | 151-400ppm = MEDIA | acima 400ppm = ALTA");
                                System.out.println("  Umidade     → acima 50% = BAIXA | 20-50% = MEDIA | abaixo 20% = ALTA");

                                double valorTemp = 0;
                                boolean tempValida = false;
                                while (!tempValida) {
                                    System.out.print("Temperatura (°C): ");
                                    try {
                                        valorTemp = Double.parseDouble(scanner.nextLine().trim());
                                        tempValida = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor inválido. Digite um número.");
                                    }
                                }
                                double valorFumaca = 0;
                                boolean fumacaValida = false;
                                while (!fumacaValida) {
                                    System.out.print("Nível de fumaça (ppm): ");
                                    try {
                                        valorFumaca = Double.parseDouble(scanner.nextLine().trim());
                                        fumacaValida = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor inválido. Digite um número.");
                                    }
                                }
                                double valorUmidade = 0;
                                boolean umidadeValida = false;
                                while (!umidadeValida) {
                                    System.out.print("Umidade (%): ");
                                    try {
                                        valorUmidade = Double.parseDouble(scanner.nextLine().trim());
                                        umidadeValida = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor inválido. Digite um número.");
                                    }
                                }

                                // Cria os três sensores e registra as medições
                                Sensor sensorTemp    = new Sensor(idOcorrencia, "TEMPERATURA", fabricante, statusSensor);
                                Sensor sensorFumaca  = new Sensor(idOcorrencia, "FUMACA",      fabricante, statusSensor);
                                Sensor sensorUmidade = new Sensor(idOcorrencia, "UMIDADE",     fabricante, statusSensor);

                                sensorTemp.registrarMedicao(valorTemp);
                                sensorFumaca.registrarMedicao(valorFumaca);
                                sensorUmidade.registrarMedicao(valorUmidade);

                                // Combina os resultados: pior caso vence para exibir o alerta
                                String resultTemp    = sensorTemp.classificarIntensidade();
                                String resultFumaca  = sensorFumaca.classificarIntensidade();
                                String resultUmidade = sensorUmidade.classificarIntensidade();

                                String intensidade;
                                if (resultTemp.equals("ALTA") || resultFumaca.equals("ALTA") || resultUmidade.equals("ALTA")) {
                                    intensidade = "ALTA";
                                } else if (resultTemp.equals("MEDIA") || resultFumaca.equals("MEDIA") || resultUmidade.equals("MEDIA")) {
                                    intensidade = "MEDIA";
                                } else {
                                    intensidade = "BAIXA";
                                }

                                System.out.println("\n--------------------------------------------------");
                                System.out.println("Resultado por sensor:");
                                System.out.println("  Temperatura : " + resultTemp);
                                System.out.println("  Fumaça      : " + resultFumaca);
                                System.out.println("  Umidade     : " + resultUmidade);
                                System.out.println(">>> Intensidade final: " + intensidade);
                                System.out.println("--------------------------------------------------");

                                // Cria a ocorrência com sensor de temperatura como principal
                                ocorrenciaAtual = new OcorrenciaIncendio(
                                        idOcorrencia, dataOcorrencia, intensidade, status, regiao, sensorTemp, null
                                );

                                System.out.println("\nOcorrência #" + idOcorrencia + " cadastrada com sucesso!");
                                break;

                            case 2:
                                // ---- CLASSIFICAR RISCO ----
                                if (ocorrenciaAtual == null) {
                                    System.out.println("\nNenhuma ocorrência cadastrada ainda.");
                                } else if (ocorrenciaAtual.getStatus().equals("EXTINTO")) {
                                    System.out.println("\nOcorrência com status EXTINTO.");
                                    System.out.println("Classificação de risco não aplicável.");
                                } else if (ocorrenciaAtual.getStatus().equals("CONTROLADO")) {
                                    System.out.println("\nOcorrência com status CONTROLADO.");
                                    System.out.println("Risco reduzido. Exibindo classificação informativa:");
                                    ocorrenciaAtual.classificarRisco();
                                } else {
                                    System.out.println("\n--- Classificando Risco ---");
                                    ocorrenciaAtual.classificarRisco();
                                }
                                break;

                            case 3:
                                // ---- GERAR ALERTA ----
                                if (ocorrenciaAtual == null) {
                                    System.out.println("\nNenhuma ocorrência cadastrada ainda.");
                                } else if (ocorrenciaAtual.getStatus().equals("EXTINTO")) {
                                    System.out.println("\nOcorrência com status EXTINTO.");
                                    System.out.println("Não é necessário gerar alerta para incêndios extintos.");
                                } else if (ocorrenciaAtual.getStatus().equals("CONTROLADO")) {
                                    System.out.println("\nOcorrência com status CONTROLADO.");
                                    System.out.println("Incêndio sob controle — alerta de emergência não aplicável.");
                                    System.out.println("Mantenha o monitoramento preventivo da região.");
                                } else if (ocorrenciaAtual.getAlerta() != null) {
                                    System.out.println("\nAlerta já gerado para esta ocorrência:");
                                    ocorrenciaAtual.getAlerta().exibirAlerta();
                                    System.out.print("\nDeseja gerar novamente? (S / N): ");
                                    String regenar = scanner.nextLine().trim().toUpperCase();
                                    if (regenar.equals("S")) {
                                        ocorrenciaAtual.gerarAlerta();
                                    }
                                } else {
                                    if (ocorrenciaAtual.getSensor().getStatus().equals("INATIVO")
                                            || ocorrenciaAtual.getSensor().getStatus().equals("MANUTENCAO")) {
                                        System.out.println("\nAVISO: Sensor " + ocorrenciaAtual.getSensor().getStatus() + ".");
                                        System.out.println("Alerta gerado com base em leitura possivelmente imprecisa.");
                                    }
                                    ocorrenciaAtual.gerarAlerta();
                                }
                                break;

                            case 4:
                                // ---- DASHBOARD ----
                                System.out.println("\n==================================================");
                                System.out.println("                DASHBOARD FIRESHIELD              ");
                                System.out.println("==================================================");
                                operadorLogado.exibirDados();
                                System.out.println();
                                if (ocorrenciaAtual == null) {
                                    System.out.println("Nenhuma ocorrência registrada no sistema.");
                                } else {
                                    ocorrenciaAtual.exibirResumo();
                                }
                                break;

                            case 0:
                                System.out.println("\nLogout realizado.");
                                operadorLogado = null;
                                break;

                            default:
                                System.out.println("\nOpção inválida.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nSistema encerrado. Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }

        scanner.close();
    }
}
