# 📚 Library Management API

API REST desenvolvida para gerenciamento de uma biblioteca, permitindo o controle de livros, autores e empréstimos de forma estruturada e eficiente.

---

## 📖 Descrição

Este projeto consiste em uma API REST construída com Java e Spring Boot, com o objetivo de simular o funcionamento de um sistema de biblioteca.

A aplicação permite cadastrar autores e livros, além de gerenciar empréstimos realizados por clientes, mantendo o relacionamento entre as entidades.

---

## 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Docker 
* Swagger (OpenAPI)

---

## ⚙️ Funcionalidades

* 📌 Cadastro de autores
* 📌 Cadastro de livros
* 📌 Relacionamento entre livros e autores
* 📌 Registro de empréstimos
* 📌 Consulta de empréstimos com dados completos (cliente, livro e autor)
* 📌 Listagem de dados com DTOs personalizados

---

## 🗂️ Estrutura do Projeto

```bash
src/
 ├── controller    # Camada responsável pelas requisições HTTP
 ├── service       # Regras de negócio
 ├── repository    # Acesso ao banco de dados
 ├── entities      # Entidades JPA
 ├── dto           # Objetos de transferência de dados
 └── config        # Configurações do Swagger
```
---

## 🧪 Visualizar API no Swagger Editor

Você pode visualizar os endpoints diretamente no Swagger Editor:

1. Acesse: https://editor.swagger.io/
2. Clique em "File" → "Import File"
3. Selecione o arquivo `docs/openapi.json`

---

## 🐳 Por que utilizei Docker?

O Docker foi utilizado neste projeto com o objetivo de garantir consistência e portabilidade do ambiente de execução da aplicação.

Em projetos backend, é muito comum surgir o clássico problema:

> “Na minha máquina funciona”

Isso geralmente acontece por diferenças de ambiente, como versão do Java, configuração do banco de dados e etc.

Com o Docker, a aplicação roda dentro de um container isolado, garantindo que funcione da mesma forma em qualquer máquina — evitando esse tipo de situação.

Além disso, o uso de containers traz benefícios importantes:

* 📦 **Padronização do ambiente**: elimina conflitos entre diferentes setups
* 🚀 **Facilidade de execução**: o projeto pode ser iniciado com poucos comandos
* 🔄 **Reprodutibilidade**: qualquer pessoa consegue rodar o projeto sem dor de cabeça

Dessa forma, o Docker contribui para uma abordagem mais profissional, reduzindo problemas comuns no desenvolvimento.

---

## ⭐ Observações

Este projeto foi desenvolvido com fins educacionais, com foco em aprendizado de:

* Modelagem de banco de dados relacional
* Boas práticas com Spring Boot
* Construção de APIs REST
* Uso de DTOs e separação de camadas

---
