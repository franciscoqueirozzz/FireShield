# 🔥 FireShield

Sistema Inteligente de Monitoramento e Prevenção de Incêndios Florestais desenvolvido em Java utilizando os conceitos de Programação Orientada a Objetos.

## 📖 Sobre o Projeto

O FireShield é uma aplicação desenvolvida com o objetivo de auxiliar no monitoramento ambiental e na prevenção de incêndios florestais. O sistema realiza o cadastro de ocorrências, coleta informações de sensores ambientais e classifica automaticamente os níveis de risco, permitindo a geração de alertas para apoiar a tomada de decisão dos operadores.

O projeto foi inspirado nos conceitos de monitoramento remoto utilizados em tecnologias de observação da Terra, nas quais sensores e sistemas de coleta de dados são empregados para identificar condições ambientais críticas e auxiliar na prevenção de desastres naturais.

---

## 🎯 Objetivo

Desenvolver uma solução capaz de:

- Monitorar ocorrências de incêndio florestal;
- Registrar informações de regiões monitoradas;
- Coletar dados de sensores ambientais;
- Classificar automaticamente os níveis de risco;
- Gerar alertas para auxiliar na prevenção e combate a incêndios;
- Aplicar os principais conceitos de Programação Orientada a Objetos.

---

## ⚙️ Funcionalidades

### 👤 Autenticação
- Login de operadores através de e-mail e senha.

### 🚨 Cadastro de Ocorrências
- Registro de ocorrências de incêndio.
- Validação de datas.
- Controle de status da ocorrência.

### 🌎 Gerenciamento de Regiões
- Cadastro da região afetada.
- Registro do país e área monitorada.

### 📡 Monitoramento por Sensores
- Sensor de Temperatura.
- Sensor de Fumaça.
- Sensor de Umidade.

### 📊 Classificação de Intensidade
O sistema avalia os sensores utilizando as seguintes faixas:

#### Temperatura
- Até 40°C → BAIXA
- 41°C a 70°C → MÉDIA
- Acima de 70°C → ALTA

#### Fumaça
- Até 150 ppm → BAIXA
- 151 ppm a 400 ppm → MÉDIA
- Acima de 400 ppm → ALTA

#### Umidade
- Acima de 50% → BAIXA
- Entre 20% e 50% → MÉDIA
- Abaixo de 20% → ALTA

### ⚠️ Classificação de Risco
A intensidade final da ocorrência é definida pela regra do **pior caso**, considerando o sensor mais crítico.

### 🔔 Geração de Alertas
- Alertas automáticos para ocorrências ativas.
- Bloqueio de alertas para ocorrências extintas.
- Monitoramento preventivo para ocorrências controladas.

### 📈 Dashboard
Exibição consolidada de:
- Dados do operador;
- Informações da ocorrência;
- Dados da região;
- Sensores monitorados;
- Status do alerta.

---

## 🏗️ Arquitetura do Projeto

### Pacotes

```text
br.com.fiap
│
├── bean
│   ├── Pessoa
│   ├── Operador
│   ├── Regiao
│   ├── Sensor
│   ├── Alerta
│   └── OcorrenciaIncendio
│
├── interfaces
│   └── AcoesMonitoramento
│
└── main
    └── Main
```

---

## 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- UML
- Draw.io
- Git
- GitHub

---

## 🧩 Conceitos de POO Aplicados

### Encapsulamento
Todos os atributos das classes são privados e acessados através de métodos apropriados.

### Herança
A classe `Operador` herda características da classe `Pessoa`.

### Polimorfismo
Implementação de métodos definidos por interface e utilização de construtores sobrecarregados.

### Interface
A interface `AcoesMonitoramento` define os comportamentos obrigatórios das ocorrências.

### Agregação
A classe `OcorrenciaIncendio` utiliza objetos da classe `Regiao` e `Sensor`.

### Composição
A classe `OcorrenciaIncendio` cria e gerencia objetos da classe `Alerta`.

---

## 📋 Regras de Negócio

### RN-001
A umidade possui lógica inversa:
- Quanto menor a umidade, maior o risco.

### RN-002
O sensor mais crítico determina a intensidade final da ocorrência.

### RN-003
Ocorrências com status:
- CONTROLADO → não geram alerta emergencial.
- EXTINTO → não geram alerta.

### RN-004
Não é permitido registrar ocorrências com datas futuras.


---

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/franciscoqueirozzz/FireShield.git
```

2. Abra o projeto em sua IDE Java.

3. Execute a classe:

```text
Main.java
```

4. Utilize um dos usuários cadastrados para realizar login.

---

## 👨‍💻 Desenvolvedores

Projeto acadêmico desenvolvido para a disciplina de Java e Programação Orientada a Objetos da FIAP.

---

## 📄 Licença

Este projeto foi desenvolvido exclusivamente para fins acadêmicos.
