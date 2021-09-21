# API Marketplace

## Tecnologias utilizadas
 - [X] Springboot
 - [X] Spring Data
 - [X] Docker
 - [X] Maven
 - [X] JUnit
 - [X] Cucumber
 - [X] Mockito
 - [X] Swagger
 

***
### Testes Funcionais com Cucumber
Fora realizado a execução de testes funcionais por meio do Cucumber.
Segue algumas razões pelo qual escolher testes com cucumber:

 - Linguagem mais próxima ao cliente, mostrando os passos executados para testar.
 - Facilidade ao escrever testes, pois ficam bem estruturados, etc.

Para rodar os testes deverá ser executado a classe RunCucumberTest.

***

***
### Testes Unitários com JUnit
Fora realizado a execução de testes unitários por meio do JUnit.
Segue algumas razões pelo qual escolher testes com JUnit:

- Junit é uma estrutura de teste amplamente usada em conjunto com a linguagem de programação Java.
- Facilidade na estruturação de automação para os testes de unidade e de interface do usuário.
- Ajuda a definir o fluxo de execução do código com diferentes anotações.

Para rodar os testes deverá ser executado as classes:

- BaseMarketPlaceServiceTest
- CreateMarketplaceServiceTest
- DeleteMarketplaceServiceTest
- FindMarketplaceServiceTest
- UpdateMarketplaceServiceTest

***


## Documentação

### Exemplo do uso do endpoint

 - Obs: Os endpoints podem ser executados no serviço do Swagger da seguinte URL: http://localhost:8080/swagger-ui.html

#### POST 
- Endpoint: /v1/marketplaces

```
{
    "area": "3321223",
    "districtCode": "1233223",
    "districtName": "BRASILIA",
    "latitude": 34532,
    "longitude": 12094,
    "name": "LOJA DE LIVROS",
    "neighborhood": "BRASILIA",
    "number": "13",
    "reference": "PRÓXIMO AO HOSPITAL DO GUARÁ",
    "region05": "DF",
    "region08": "DF",
    "register": "435344",
    "sector": "NORTE",
    "street": "BRASILIA",
    "subCityHallCode": 55,
    "subCityHallName": "GUARÁ"
}
```

***


### Deploy com docker

Fora aplicado uma imagem Docker com Alpine, dado que é a imagem mais limpa e mais otimizada para manter 
a aplicação.

Para fazer o deploy da aplicação e execução do projeto via container utilizando docker, deverá executar 
os passos abaixo no terminal:

```
./mvnw clean package -DskipTests

docker-compose up -d
```
Após a conclusão validar se o container estará disponível no endereço: http://localhost:8080/swagger-ui.html

***
