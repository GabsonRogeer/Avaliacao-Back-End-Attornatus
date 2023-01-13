# Avaliação Desenvolvedor Back-end Attornatus

## Desafio: 
Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

- Criar uma pessoa 
- Editar uma pessoa 
- Consultar uma pessoa 
- Listar pessoas 
- Criar endereço para pessoa 
- Listar endereços da pessoa 
- Poder informar qual endereço é o principal da pessoa  

## Requisitos  
- Todas as respostas da API devem ser JSON
- Banco de dados H2

## Aplicação

- Desenvolvido com Spring Boot na versão 3.0.1
- Java JDK 17
- Banco de Dados H2 na porta :8080
- Link da imagem da aplicação em docker: https://hub.docker.com/r/gabsonroger/test-dev-back-end-jr-attornatus

## ENDPONITS
### Pessoa

1. Criar Pessoa:

``POST /pessoa``

Modelo da requisição:

```
{
    "nome": "João",
    "dataNascimento": "1994-09-02",
    "endereco":[
        {
        "logradouro": "rua teste",
        "cep": "6000000",
        "numero": 40,
        "cidade": "Fortaleza",
        "principal": true
        }
    ]
}
````

2. Buscar Pessoa:

``GET /pessoa``

3. Buscar Pessoa por ID:

``GET /pessoa/{id}``

4. Editar Pessoa:

``PUT /pessoa/{id}``

````
{
    "nome": "José",
    "dataNascimento": "1992-08-05"
}
````

5. Deletar Pessoa pelo ID:

``DELETE /pessoa/{id}``

### Endereco

1. Criar endereço para pessoa:

``POST /endereco``

````
{
    "logradouro": "Rua das pedrinhas",
    "cep": "6012312",
    "numero": 300,
    "cidade": "Juazeiro do Norte",
    "principal": false,
    "pessoa": {
        "id": 1
    }
}
````

2. Listar endereços:

``GET /endereco``

3. Listar endereços por ID:

``GET /endereco/{id}``

4. Excluir endereço por ID

``DELETE /endereco/{id}``

