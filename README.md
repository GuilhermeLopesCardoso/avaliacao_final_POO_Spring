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
### Veiculo <br>

## Listar Todos os Veículos:<br>

 - GET /veiculo: Lista todos os veículos cadastrados.<br>
 
## Buscar Veículo por ID:<br>

 - GET /veiculo/{id}: Busca um veículo pelo ID.<br>
 - 
##Buscar Veículos por Marca:<br>

 - GET /veiculo/marca/{marca}: Lista veículos por marca.<br>
## Buscar Veículo por Placa:<br>

 - GET /veiculo/placa/{placa}: Busca um veículo pela placa.<br>
 
## Buscar Veículos por Ano de Fabricação:<br>

 - GET /veiculo/ano/{ano}: Lista veículos por ano de fabricação.<br>
 
## Cadastrar um Novo Veículo:<br>

 - POST /veiculo: Cadastra um novo veículo.<br>
 
## Atualizar um Veículo Existente:<br>

 - PUT /veiculo/{id}: Atualiza os dados de um veículo existente.<br>
 
## Excluir um Veículo:<br>

 - DELETE /veiculo/{id}: Exclui um veículo pelo ID.<br>
 
### Motorista<br>

## Listar Todos os Motoristas:<br>

 - GET /motorista: Lista todos os motoristas cadastrados.<br>
 
## Buscar Motorista por ID:<br>

 - GET /motorista/{id}: Busca um motorista pelo ID.<br>
 
## Buscar Motoristas por Nome:<br>

 - GET /motorista/nome/{nome}: Lista motoristas por nome.<br>
 
## Cadastrar um Novo Motorista:<br>

 - POST /motorista: Cadastra um novo motorista.<br>
 
## Atualizar um Motorista Existente:<br>

 - PUT /motorista/{id}: Atualiza os dados de um motorista existente.<br>
 
## Excluir um Motorista:<br>

 - DELETE /motorista/{id}: Exclui um motorista pelo ID.<br>
 
### Exemplo de Uso<br>

## Cadastrar um Veículo<br>


```
{
  "marca": "Ford",
  "placa": "ABC1234",
  "anoFabricacao": 2020,
  "motorista": {"id"}
}
 ```

## Buscar Veículo por Placa<br>

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

## Cadastrar um Novo Motorista<br>

``` 
{
  "nome": "Maria Souza",
  "cpf": "987.654.321-00"
}
 ```

## Este README.md fornece uma visão geral do projeto, instruções de configuração e uso, e detalhes sobre os endpoints da API. Certifique-se de ajustar quaisquer informações específicas do seu projeto, como o link do repositório e detalhes adicionais que possam ser relevantes.
