<img src="../images/voip.gif" width="500px"/>

---

# PROJETO SIGABEM

O projeto sigabem é um desafio desenvolvido para ser uma aplicação (Back-end) onde o cliente poderá fazer a consulta do valor que será pago no frete.

Nesse aspecto foi designado que o projeto tenha algumas singularidades.

---

## Ferramentas com Pré-requisito

---

Foi solicitado que as ferramentas no qual construiríamos a aplicação fosse desenvolvido com:

- Java +8 ✔

- Spring Boot | Versão >= (Maior ou igual) a 2.4 ✔

Foi solicitado também, que obrigatoriamente deve ter as anotações:

- @Repository ✔

- @Entity ✔

- @Controller ✔

E a documentação mínima da API seria:

- Swagger ✔

ou

- Documentação em PDF

---

## Aspectos

---

No caso o projeto deve fazer alguns cálculos, que aplicarão descontos ou não no frete do cliente.

- CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia

- CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias

- CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias

- O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00

---

## URL's utilizadas e criadas no projeto.

---

- ### https://viacep.com.br/ws/{CEP_A_CONSULTAR}/json/ Method = GET

#### A api utilizada é gratuita e qualquer pessoa pode consultar os dados colocando um CEP valido no campo (CEP_A_CONSULTAR), assim um json será respondido para que seja consumido por um serviço de terceiros.

- ### http://localhost:8080/sigabem-api/{cepCliente} Method = GET

#### A url citada tem como funcionalidade a mesma da api acima, eu desenvolvi esta url para verificar a disponibilidade de alguns métodos e serviços no projeto.

- ### http://localhost:8080/sigabem-api/output Method = GET

#### Aqui é listado todas as consultas realizadas e salvas no banco de dados.

##### OBS: criei as 3 URL's de consulta não para ser a mesma função, e sim para ter 3 métodos de Request e ser feito as consultas nos três formatos. 

- ### http://localhost:8080/sigabem-api/input/{PESO_PRODUTO}/{CEP_DE_ORIGEM}/{CEP_DE_DESTINO}/{NOME_PROPRIETARIO} Method = POST | RequestMethod = PATHVARIABLE

#### Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta busca é feita com PathVariable em que a api simula uma busca sendo realizada a partir da implementação de pastas na url de busca).

- ### http://localhost:8080/sigabem-api/input/query Method = POST | RequestMethod = QUERY

#### Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta busca é feita com RequestParam, neste caso, os comandos de acesso são utilizados pela url Query, onde na url estarão disponíveis os dados necessários para a consulta).

- ###  http://localhost:8080/sigabem-api/input Method = POST | RequestMethod = JSON

#### Criação de dados no banco de dados em que foi realizado o levantamento sobre o valor total do frete com ou sem desconto. (Esta pesquisa é feita com RequestBody em JSON).

### Parâmetros obrigatórios para todos RequestMethods

```json
    {
    "cepDestino": "string",
    "cepOrigem": "string",
    "nomeDestinatario": "string",
    "peso": 0
    }
```

---

## Documentação e Teste

---

Para fazer os testes das API's você pode utilizar algum dos métodos que disponibilizei.

1 - Swagger

Swagger, é basicamente uma ferramenta que desenvolvedores utilizam para documentar funcionalidades, aplicabalidade e retornos das API's desenvolvidas.

Com essa ferramenta você fica mais tranquilo para fazer consultas das funcionalidades das API's.

Após a execução do projeto, você terá que acessar o link (http://localhost:8080/swagger-ui/index.html) para fazer as consultas nas API's, a aplicação é super simples e tem exemplos para seguir.

2 - Insomnia

Insomnia, é basicamente uma ferramenta que facilita para desenvolvedores fazerem consultas e testes das API's.

Você pode fazer o Download da ferramenta por aqui (https://insomnia.rest/download).

Disponibilizei o meu template JSON do Insomnia que utilizei para fazer os testes, o JSON está na pasta Insomnia neste Repositório, mais especificamente (https://github.com/Voipdbr/JavaTest/tree/main/Insomnia).

---

# Considerações finais

---

Esse desafio foi realmente intenso, deram poucos dias para desenvolvermos a aplicação e criar todas as funcionalidades, mas é como diz “O homem erudito é um descobridor de fatos que já existem – mas o homem sábio é um criador de valores que não existem e que ele faz existir.“ [Albert Einstein].

<img src="../images/albert.gif" width="300px"/>
