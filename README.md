
# Attornatus Procuradoria

Esse é um teste prático para o processo seletivo da empresa Attornatus Procuradoria.

## Appendix

O teste tem como objetivo a criação de uma API simples que realize o cadastro de uma pessoa, que foi denominada por mim como um Cliente. Sendo possível realizar a consulta de varios clientes, podendo também atualizar e deletar seus dados. Abaixo, haverá informações que o auxiliarão no utilizamento da API.
## Authors

- [@lucasraimundo](https://www.github.com/LucasRaimundo)


## How to use?

1. Primeiro clone o repositório em sua maquina.

2. Em seguida, rode o projeto Spring Boot App.

3. O projeto já inicia com uma instancia de banco então, você poderá executar a seguinte requisição para retornar o cliente já instanciado: 

- localhost:8080/clientes

OBS: Utilize o método GET

4. É possivel obter informações maiores sobre um cliente especifico utilizando seu Id como parâmetro, como mostrado na requisição abaixo:

- lolocalhost:8080/clientes/1

5. Para incluir mais clientes a base, utilize a requisição e use como exemplo o texto JSON que estão abaixo:

- localhost:8080/clientes

OBS: Utilize o método POST

- {
 "nome":"Lucas Raimundo",

 "nasc":"27/11/2002",

 "logadouro": "Rua das belezas",

 "number":"1580",

 "complement":"Casa de esquina",

 "district":"Alto da Rivieira",

 "cep":"04929350",

 "cidadeId": 2

}

OBS: Já existem algumas cidades já instanciadas, com seus respectivos códigos, sendo eles: 

- Uberlandia - 1
- São Paulo - 2
- Campinas - 3
- Sorocaba - 4

6. Para atualizar os dados do cliente, é necessário saber o seu perspectivo Id, utilize a requisição e texto JSON que estão abaixo como exemplo:
 
 - localhost:8080/clientes/2 

 - {

     "nome": "Lucas Silva",

     "nasc": "27/11/2001"
 }

 OBS: Utilize o método PUT

 7. Para realizar a deleção, também é necessário saber o respectivo Id, utilize a requisição abaixo: 
  
  - localhost:8080/clientes/2

  OBS: Utilize o método DELETE.
## Used stack

**Back-end:** Java, Spring Boot, Spring Web, H2, Maven e Git.



