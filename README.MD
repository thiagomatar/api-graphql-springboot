# Sejam bem vindos!

O que é necessário antes de inicializar a aplicação?
- Atualizar o arquivo application.properties com seu usuario e senha do MySQL (Se preferir, pode utilizar o docker-compose que está na pasta docker na raiz do projeto)

Fluxo da aplicação:
- Ao inicializar a aplicação a url http://localhost:8080/graphiql estará disponivel. 
- É possivel realizar consultas e  cadastrar Clientes, Produtos e Pedidos, para mais detalhes, olhe a documentação que o GraphiQL

Exemplos:
Para cadastrar um Cliente
```graphql
mutation {
  saveCustomer(customer: {name: "Thiago Matar", 
						  document: "999.999.999-88", 
						  email: "thiago.matar@teste.com", 
						  address: "Rua teste, 123", 
						  phone: "(34) 99999-8877"}) {
    id,
    name
  }
}
```
Para cadastrar um produto
```graphql
mutation {
  saveProduct(product: {description: "PC Gamer", brand: "Acer", price: 5000.0}) {
    id
    description
    brand
  }
}

```
Para cadastrar um pedido:
```graphql
mutation {
  saveOrder(order: {customer: {id: 1}, products: [{id: 1}], requestDate: "2020-10-18", status: PENDING}) {
    id
    customer {
      id,
      name
    }
    products {
      id,
      description
    }
    requestDate
    status
  }
}
```
Para consultar um cliente por id:
```graphql
query{
  customer(id: 1){
    id,
    name,
    document,
    email,
    address,
    phone
  }
}
```

Para listar todos os clientes: 
```graphql
query{
  customers{
    id,
    name,
    document,
    email,
    address,
    phone
  }
}
```

Para saber mais como criar consultas avançadas acesse: [https://graphql.org/learn/queries/](https://graphql.org/learn/queries/)

Para ler o artigo que escrevi sobre este projeto acesse: https://medium.com/@thiagomatar/criando-uma-api-graphql-com-spring-boot
