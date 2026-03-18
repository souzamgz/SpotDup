Spotify Backend Clone (Spring Boot + Kotlin)

API REST desenvolvida com Spring Boot e Kotlin simulando funcionalidades básicas de um sistema de músicas (estilo Spotify).
Projeto focado em aprendizado de backend, banco de dados e boas práticas com arquitetura em camadas.

## Tecnologias utilizadas

- Kotlin
- Spring Boot
- Spring Data JPA
- MySQL (Docker)
- Gradle
--------------------------------------------
## Arquitetura

O projeto segue o padrão:

Controller → Service → Repository → Database

- Controller: recebe requisições HTTP
- Service: contém regras de negócio
- Repository: comunicação com o banco
--------------------------------------------
- ##  Endpoints

###  Listar músicas
GET /musics

###  Buscar por ID
GET /musics/{id}

###  Criar música
POST /musics

###  Atualizar música
PUT /musics/{id}

###  Deletar música
DELETE /musics/{id}


## Como rodar
--------------------------------------------
### 1. Subir o banco com Docker

docker start mysql-spotify

### 2. Rodar a aplicação

--------------------------------------------
## Aprendizados

- Construção de API REST com Spring Boot
- Integração com banco de dados MySQL
- Uso de Docker para ambiente local
- Arquitetura em camadas (Controller, Service, Repository)
- Uso de Git com branches, commits e pull requests
  --------------------------------------------
