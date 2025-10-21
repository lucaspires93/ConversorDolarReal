# Conversor Dólar/Real em Java 💵

Este projeto é um conversor de moedas que permite ao usuário calcular valores entre Dólar (USD) e Real (BRL) **em tempo real**, consumindo uma **API pública de cotações**. Desenvolvido em Java, o projeto foca em manipulação de APIs, entrada de dados via console e tratamento de erros.

## Funcionalidades

* Consulta da **cotação atual do Dólar em tempo real** via API pública.
* Conversão de valores:

  * Dólar para Real
  * Real para Dólar
* Interface de console simples e interativa.
* Tratamento de entradas inválidas e erros de conexão.

## Tecnologias Utilizadas

* Java 17+
* JSON (org.json)
* **API pública de cotações** [AwesomeAPI](https://economia.awesomeapi.com.br/)

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/conversor-dolar.git
```

2. Compile o projeto:

```bash
javac -d bin src/app/ConversorDolar.java src/controller/CotacaoController.java
```

3. Execute:

```bash
java -cp bin app.ConversorDolar
```

4. Siga as instruções no console.

## Aprendizados

* Consumo de **API REST pública em Java para obter dados em tempo real**
* Parsing de JSON
* Manipulação de dados numéricos e formatação
* Estrutura de controle `switch-case` e loops `do-while`
* Tratamento de exceções
