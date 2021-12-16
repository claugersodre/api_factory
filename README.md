# Api_factory

Api factory

## Getting started

usuário padrão
{
  "id":"1",
  "password": "123456",
  "username": "user",
  "admin": "true"
}


buscar um novo token no endpoint http:localhost:8085/auth/authenticate metodo Post e body
{
 
  "password": "123456",
  "username": "user"
}
```

## Funções não implementadas


criptografia do payload do token
utilizo o payload do token nos endpoints para verificar se o usuário pode executar determinada funcionalidade.

Regras de gerenciamento do workspace do usuário.
criar, listar, atualizar e deletar Especificações de API que estiverem em Workspaces aos quais pertençam-> Não implementado, o usuário pode realizar as operações nas APIs de qualquer workspace -- falta implementar consultas no banco para validar as regras de gerenciamento

## Para rodar o projeto
na pasta raiz do projeto
mvn package && java -jar target/gs-spring-boot-docker-0.1.0.jar
docker-compose build
docker-compose up
inserir no banco o usuário (1l,  "user","e1aba48178af68eef61976b46623c152",true)

pagina inicial

http://localhost:8085/swagger-ui.html
