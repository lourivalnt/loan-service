# Loan Service

> Orquestrador de aprovação de empréstimos utilizando **Spring Boot**, **Camunda BPM** e arquitetura baseada em microserviços.

## 📖 Sobre o Projeto

O **Loan Service** é um microserviço responsável por orquestrar todo o processo de aprovação de empréstimos utilizando **BPMN** através do **Camunda Platform 7**.

Ao invés de concentrar toda a regra de negócio em uma única classe, o processo é definido em um fluxo BPMN, permitindo que cada etapa seja executada de forma organizada, desacoplada e de fácil manutenção.

Este projeto tem como objetivo demonstrar uma arquitetura corporativa baseada em:

- Java 21
- Spring Boot 3
- Camunda BPM 7
- Arquitetura em Camadas
- Delegates
- REST Clients
- BPMN
- WebClient
- Clean Code
- SOLID

---

# 🏗 Arquitetura

```
                           Cliente
                              │
                              ▼
                     LoanController
                              │
                              ▼
                     RuntimeService
                              │
                              ▼
                      Camunda Engine
                              │
                    loan-process.bpmn
                              │
        ┌──────────────┬──────────────┬──────────────┐
        ▼              ▼              ▼              ▼
 CustomerDelegate  VehicleDelegate ScoreDelegate ApprovalDelegate
        │              │              │              │
        ▼              ▼              ▼              ▼
 CustomerClient   VehicleClient   ScoreClient  ApprovalClient
        │              │              │              │
        ▼              ▼              ▼              ▼
 customer-service vehicle-service score-service approval-service
```

---

# 📋 Fluxo BPMN

```
Start
   │
   ▼
Validar Cliente
   │
   ▼
Consultar Veículo
   │
   ▼
Consultar Score
   │
   ▼
Exclusive Gateway
 ┌───────────────┐
 │ Score >= 700? │
 └───────┬───────┘
         │
    Sim  │  Não
         ▼
 Aprovar      Reprovar
         │
         ▼
        End
```

---

# 📂 Estrutura do Projeto

```
loan-service
│
├── controller
│      LoanController
│
├── delegate
│      CustomerDelegate
│      VehicleDelegate
│      ScoreDelegate
│      ApprovalDelegate
│
├── client
│      CustomerClient
│      VehicleClient
│      ScoreClient
│      ApprovalClient
│
├── service
│
├── dto
│
├── config
│
├── exception
│
├── resources
│   ├── application.yml
│   └── process
│       └── loan-process.bpmn
│
└── LoanServiceApplication
```

---

# 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Camunda Platform 7
- Spring Web
- Spring WebFlux (WebClient)
- Gradle
- OpenAPI / Swagger
- JUnit 5
- Mockito

---

# 🔄 Fluxo de Execução

1. O cliente realiza uma solicitação de empréstimo.

2. O `LoanController` recebe a requisição.

3. O `RuntimeService` inicia um novo processo BPM.

```java
runtimeService.startProcessInstanceByKey("loan-process");
```

4. O Camunda executa cada etapa definida no BPMN.

```
Start
   │
   ▼
CustomerDelegate
   │
   ▼
VehicleDelegate
   │
   ▼
ScoreDelegate
   │
   ▼
Gateway
   │
   ├────────► Aprovar
   │
   └────────► Reprovar
```

Cada etapa do processo é executada por um **JavaDelegate**, responsável por integrar com um microserviço específico.

---

# 🔗 Integrações

| Delegate | Microserviço |
|----------|--------------|
| CustomerDelegate | customer-service |
| VehicleDelegate | vehicle-service |
| ScoreDelegate | score-service |
| ApprovalDelegate | approval-service |

As integrações são realizadas utilizando **Spring WebClient**.

---

# 📊 Variáveis do Processo

O Camunda compartilha informações entre as etapas utilizando variáveis de processo.

Exemplo:

```java
execution.setVariable("customerId", customerId);
execution.setVariable("vehicleId", vehicleId);
execution.setVariable("score", 750);
execution.setVariable("approved", true);
```

O Gateway utiliza essas variáveis para decidir qual caminho seguir.

```text
${score >= 700}
```

```text
${score < 700}
```

---

# ▶️ Como Executar

## Clonar o projeto

```bash
git clone https://github.com/SEU-USUARIO/loan-service.git
```

## Entrar na pasta

```bash
cd loan-service
```

## Executar

Linux / macOS

```bash
./gradlew bootRun
```

Windows

```bash
gradlew bootRun
```

---

# 🌐 Endpoint

## Iniciar processo de empréstimo

```
POST /api/loans
```

Exemplo de payload:

```json
{
  "customerId": 1,
  "vehicleId": 10,
  "loanAmount": 50000
}
```

---

# 📚 Conceitos Demonstrados

- BPMN 2.0
- Camunda Platform
- Process Orchestration
- Spring Boot
- REST APIs
- WebClient
- Java Delegates
- RuntimeService
- Process Variables
- Exclusive Gateway
- Microservices
- Clean Code
- SOLID
- Arquitetura em Camadas

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para demonstrar uma arquitetura moderna de orquestração de processos utilizando Camunda BPM e Spring Boot, seguindo boas práticas encontradas em ambientes corporativos.

Além do funcionamento técnico, o projeto busca servir como referência para estudos sobre BPMN, integração entre microserviços e preparação para entrevistas técnicas de Backend Java.

---

# 👨‍💻 Autor

****

Backend Java Developer

**Stack**

- Java
- Spring Boot
- Camunda BPM
- Microservices
- REST APIs
- Docker
- SQL
- Gradle
- Git