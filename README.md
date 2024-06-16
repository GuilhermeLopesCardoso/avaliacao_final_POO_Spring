# Sistema de Gerenciamento de Veículos e Motoristas

Este projeto é uma aplicação Spring Boot que gerencia veículos e motoristas. Ele utiliza o Spring Data JPA para persistência de dados e fornece uma API REST para interação com o sistema.

## Estrutura do Projeto

- **Model:** Contém as classes de entidade `Veiculo` e `Motorista`.
- **Repository:** Contém as interfaces de repositório `VeiculoRepository` e `MotoristaRepository` para interação com o banco de dados.
- **Resources:** Contém os controladores REST `VeiculoResource` e `MotoristaResource`.
- **Services:** Contém os serviços `VeiculoService` e `MotoristaService` que implementam a lógica de negócio.
- **Application:** Classe principal para iniciar a aplicação.

## Requisitos

- Java 17+
- Maven 3.6+
- Banco de dados H2 (default) ou outro banco de dados suportado pelo Spring Data JPA

## Configuração

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/seu-usuario/trabalho_final.git
   cd trabalho_final

   Endpoints da API
###Veiculo
##Listar Todos os Veículos:
 - GET /veiculo: Lista todos os veículos cadastrados.
##Buscar Veículo por ID:
 - GET /veiculo/{id}: Busca um veículo pelo ID.
##Buscar Veículos por Marca:
 - GET /veiculo/marca/{marca}: Lista veículos por marca.
##Buscar Veículo por Placa:
 - GET /veiculo/placa/{placa}: Busca um veículo pela placa.
##Buscar Veículos por Ano de Fabricação:
 - GET /veiculo/ano/{ano}: Lista veículos por ano de fabricação.
##Cadastrar um Novo Veículo:
 - POST /veiculo: Cadastra um novo veículo.
##Atualizar um Veículo Existente:
 - PUT /veiculo/{id}: Atualiza os dados de um veículo existente.
##Excluir um Veículo:
 - DELETE /veiculo/{id}: Exclui um veículo pelo ID.
###Motorista
##Listar Todos os Motoristas:
 - GET /motorista: Lista todos os motoristas cadastrados.
##Buscar Motorista por ID:
 - GET /motorista/{id}: Busca um motorista pelo ID.
##Buscar Motoristas por Nome:
 - GET /motorista/nome/{nome}: Lista motoristas por nome.
##Cadastrar um Novo Motorista:
 - POST /motorista: Cadastra um novo motorista.
##Atualizar um Motorista Existente:
 - PUT /motorista/{id}: Atualiza os dados de um motorista existente.
##Excluir um Motorista:
 - DELETE /motorista/{id}: Exclui um motorista pelo ID.
###Exemplo de Uso
##Cadastrar um Veículo
POST localhost:8080/veiculo
Content-Type: application/json

``` {
  "marca": "Ford",
  "placa": "ABC1234",
  "anoFabricacao": 2020,
  "motorista": {"id"}
}
 ```

##Buscar Veículo por Placa

``` 
{
  "marca": "Ford",
  "placa": "ABC1234",
  "anoFabricacao": 2020,
  "motorista": {
    "id": 1,
    "nome": "João Silva",
    "cpf": "123.456.789-00"
  }
}
 ```

##Cadastrar um Novo Motorista

``` 
{
  "nome": "Maria Souza",
  "cpf": "987.654.321-00"
}
 ```

##Este README.md fornece uma visão geral do projeto, instruções de configuração e uso, e detalhes sobre os endpoints da API. Certifique-se de ajustar quaisquer informações específicas do seu projeto, como o link do repositório e detalhes adicionais que possam ser relevantes.
