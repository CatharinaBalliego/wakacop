#Sistema de Votação Cooperativa

## Sobre o Projeto
Este sistema é um back-end desenvolvido em Java Spring Boot para gerenciar sessões de votação em cooperativas. Ele permite o cadastramento de pautas, abertura de sessões de votação, recebimento e contabilização de votos dos associados, e fornece os resultados das votações. O sistema opera na nuvem e é acessível via API REST.

## Architecture Haiku
### Objetivos do Negócio
- Facilitar a gestão democrática em cooperativas.
- Assegurar a integridade e confiabilidade dos votos.
- Prover resultados rápidos e precisos das votações.

  
### Restrições
-Operação na nuvem.
- Persistência de dados.
- Foco no back-end.

  
### Atributos de Qualidade
Segurança > Disponibilidade > Escalabilidade

### Decisões de Design
Java Spring Boot, Maven, Docker Compose.
- API RESTful.
 Integração com sistema externo para validação de CPF.
- Mensageria para divulgação de resultados.
- Estratégia de versionamento da API.
  
## Pré-Requisitos
-Java 17
- Maven
- Docker e Docker Compose
  
## Como Executar o Projeto
1. Clone o repositório: git clone https://github.com/CatharinaBalliego/wakacop.git
2. Navegue até a pasta do projeto: cd wakacop
3. Construa o projeto com Maven: mvn clean install
4. Inicie os serviços usando Docker Compose: docker-compose up
5. O sistema estará rodando e acessível.

## Testando a Aplicação
- Importe a collection do Postman fornecida para testar as APIs.
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/32643469-5f98dcf5-a3fe-4ca2-932e-e748b5b6337d?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D32643469-5f98dcf5-a3fe-4ca2-932e-e748b5b6337d%26entityType%3Dcollection%26workspaceId%3D3113d6d0-e119-4822-9103-86b481006178)
