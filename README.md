# ForumHub API - Documentação para a Equipe Front-End

## Visão Geral

O ForumHub é uma API que gerencia tópicos em um fórum de discussão, permitindo aos usuários criar, atualizar, listar e excluir tópicos. A aplicação também oferece funcionalidades para autenticação e segurança utilizando tokens JWT. A interface foi projetada para ser consumida por um front-end, facilitando a interação com os tópicos e o controle de status.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

src/ │ ├── ForumHub.Api/ │ ├── Forum/ # Contém as entidades, repositórios e lógica de tópicos │ │ ├── Forum.java # Entidade do fórum │ │ ├── ForumController.java # Controlador que gerencia as requisições de tópicos │ │ ├── ForumRepository.java # Repositório para persistir tópicos │ │ ├── Status.java # Enum que representa o status dos tópicos (Pendente, Resolvido) │ │ └── DadosCadastroForum.java # Dados usados para cadastrar um novo tópico │ ├── Security/ # Configurações relacionadas à segurança e autenticação │ │ ├── SecurityConfiguration.java # Configura a segurança da API │ │ ├── SecurityFilter.java # Filtro que valida o token JWT a cada requisição │ │ ├── TokenService.java # Lógica para geração e verificação de tokens JWT │ │ └── SpringDocConfigration.java # Configuração do Swagger para documentação da API │ ├── Usuario/ # Contém a lógica de autenticação de usuários │ │ ├── Usuario.java # Entidade de usuário │ │ ├── UsuarioRepository.java # Repositório para persistir usuários │ │ └── AutenticacaoService.java # Serviço que carrega o usuário com base no login │ └── ApiApplication.java # Classe principal que inicializa a aplicação └── resources/ ├── application.properties # Configurações da aplicação (ex: porta, banco de dados, JWT secret) └── static/ # Arquivos estáticos (se houver)




## Como Testar a API - Swagger UI

A API está documentada e pode ser testada interativamente utilizando o Swagger UI. Para acessar, siga as etapas abaixo:

1. Inicie o servidor da API (geralmente em `localhost:8080`).
2. Acesse o Swagger UI no seguinte link: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/).
3. Na interface do Swagger, você pode explorar todos os endpoints da API, como criar tópicos, listar tópicos e atualizar status. Basta clicar nos endpoints para expandi-los e executar as requisições.

## Cenário de Teste para Login

No Swagger UI, você pode testar a funcionalidade de login. Para isso, será necessário enviar um JSON com as credenciais do usuário:


{
  "login": "ana",
  "senha": "123"
}


Essas credenciais correspondem a um usuário de exemplo chamado "ana" com a senha "123". Após enviar o login, o sistema gerará um token JWT que será usado para autenticar as requisições subsequentes. Esse token deve ser incluído no cabeçalho de autorização das requisições, como mostrado abaixo:


Authorization: Bearer {token_jwt_gerado}



## Funcionalidades da API
## 1. Cadastro de Tópico
Endpoint: POST /api/forum
Ação: Cria um novo tópico no fórum.
Dados necessários:
titulo: Título do tópico.
mensagem: Corpo do tópico.
data_Criacao: Data de criação do tópico (formato: "yyyy-MM-dd").
autor: Nome do autor do tópico.
curso: Curso relacionado ao tópico.
status: Status inicial do tópico que deve ser preenchido como Pendente.

## 2. Listar Todos os Tópicos
Endpoint: GET /api/forum
Ação: Retorna todos os tópicos registrados no fórum.

## 3. Listar Tópico por ID
Endpoint: GET /api/forum/{id}
Ação: Retorna os detalhes de um tópico específico pelo ID.

## 4. Atualizar Tópico
Endpoint: PUT /api/forum
Ação: Atualiza as informações de um tópico existente.
Dados necessários:
id: ID do tópico.
status: Novo status do tópico (Pendente ou Resolvido).
resposta: Texto da resposta ao tópico.
data_Resposta: Data da resposta (formato: "yyyy-MM-dd").

## 5. Deletar Tópico
Endpoint: DELETE /api/forum/{id}
Ação: Deleta um tópico do fórum pelo ID.
Processo de Autenticação
A autenticação é feita utilizando o padrão JWT (JSON Web Token). O fluxo é o seguinte:

O front-end envia uma requisição POST para o endpoint de login, passando as credenciais do usuário (login e senha).

Exemplo de payload de login:
{
  "login": "ana",
  "senha": "123"
}

O back-end verifica as credenciais e, se válidas, gera um token JWT.

Esse token deve ser enviado em todas as requisições subsequentes para acessar endpoints protegidos, no cabeçalho de autorização:
Authorization: Bearer {token_jwt_gerado}

## Tecnologias Usadas
Spring Boot: Framework para construir aplicações Java.
Spring Security: Para autenticação e autorização usando JWT.
Swagger UI: Para documentação interativa da API.
JPA/Hibernate: Para persistência dos dados (banco de dados).
JWT: Para autenticação baseada em token.

## As Tabelas do banco de dados.
As tabelas criadas para este projeto, foram exportadas tabelas_forumhub..
São elas: 
forumhub.sql 

| id | autor  | curso  | data_criacao | mensagem | status    | titulo       | resposta        | data_resposta |



usuarios.sql

| id | senha | login |



## Considerações Finais
Este projeto foi desenvolvido para gerenciar tópicos em um fórum de discussão, com foco na segurança e na facilidade de uso da API. A integração com o front-end pode ser feita utilizando o Swagger UI ou consumindo diretamente os endpoints da API, utilizando o token JWT para autenticação.

Caso tenha dúvidas ou precise de mais informações, entre em contato com a equipe de back-end!
