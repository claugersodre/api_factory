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

Integração com banco postgress
está na versão de testes utilizando o banco H2.

criptografia do payload do token
utilizo o payload do token nos endpoints para verificar se o usuário pode executar determinada funcionalidade.

Regras de gerenciamento do workspace do usuário.
criar, listar, atualizar e deletar Especificações de API que estiverem em Workspaces aos quais pertençam-> Não implementado, o usuário pode realizar as operações nas APIs de qualquer workspace

