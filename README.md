# API REST Controle de Produtos

## 📌 Informações Gerais

Este projeto é uma **API REST** simples desenvolvida em **Java** usando **Spring Boot**, com o objetivo de gerenciar produtos em estoque.  
Ele aplica conceitos de **Programação Orientada a Objetos (POO)**, incluindo Model, DTO, Repository, Service e Controller.

**Tema escolhido:** Controle de Produtos (estoque com nome, preço e quantidade).

---

## 🛠 Tecnologias

- Java 17+
- Spring Boot
- Maven
- IDE: VS Code ou IntelliJ IDEA

---

## 🚀 Endpoints

A API possui os 4 verbos HTTP básicos:

| Método | Endpoint         | Descrição                    | Exemplo de corpo (JSON)            |
|--------|-----------------|------------------------------|----------------------------------|
| GET    | `/produtos`      | Listar todos os produtos     | -                                |
| GET    | `/produtos/{id}` | Buscar produto por ID        | -                                |
| POST   | `/produtos`      | Adicionar novo produto       | `{ "nome": "Caneta", "preco": 2.5, "quantidade": 100 }` |
| PUT    | `/produtos/{id}` | Atualizar produto existente | `{ "nome": "Caneta Azul", "preco": 3.0, "quantidade": 120 }` |
| DELETE | `/produtos/{id}` | Remover produto             | -                                |

---

## ⚡ Como rodar o projeto

1. Certifique-se de ter **Java 17+** instalado.
2. Baixe ou clone o projeto no seu computador.
3. Abra o terminal na pasta do projeto e rode:

```bash
# Pelo Maven, se instalado
mvn spring-boot:run
