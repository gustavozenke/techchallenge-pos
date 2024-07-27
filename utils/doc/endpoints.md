# Endpoints

> Os endpoints estão listados na pagina do Swagger  
> (o index "/" faz um redirecionamento para essa documentação).

## Clientes: 
- GET /cliente  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro cpf passado
  como query parameter na requisição.
- POST /cliente  
  Responsavel por cadastrar o registro no banco de dados as informações passadas no body da requisição.
- DELETE /cliente  
  Responsavel por apagar o registro no banco de dados usando como parametro cpf passado
  como query parameter na requisição.
- PATCH /cliente/nome  
  Responsavel por atualizar o nome do cliente cadastrado no banco de dados, 
  usando como parametro cpf passado como query parameter e o complemento no body na requisição.
- PATCH /cliente/marketing  
  Responsavel por atualizar a decisão de receber informações de marketing do cliente cadastrado no banco de dados,
  usando como parametro cpf passado como query parameter e o complemento no body na requisição.
- PATCH /cliente/email  
  Responsavel por atualizar email do cliente cadastrado no banco de dados,
  usando como parametro cpf passado como query parameter e o complemento no body na requisição.

## Pedidos:
- GET /pedido  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro o numero do pedido passado
  como query parameter na requisição.
- GET /pedido/status  
  Responsavel por fazer uma pesquisa no banco de dados listando todos os pedidos em determinado estado usando como parametro um status passado
  como query parameter na requisição.
- GET /pedido/paymentstatus  
  Responsavel por fazer uma pesquisa no banco de dados verificando qual o status de pagamento do pedido usando como parametro o numero do pedido passado
  como query parameter na requisição.
- GET /pedido/list  
  Responsavel por listar os pedidos e suas descrições ordenados com as seguintes regras: 
  - Pronto > Em Preparação > Recebido;
  - Pedidos mais antigos primeiro e mais novos depois;
  - Pedidos com status *finalizado* não devem aparecer na lista.

Os endpoints a seguir são responsaveis por criar e atualizar os estados dos pedidos durante o atendimento e devem ser executados
na seguinte ordem: 
1. POST /pedido  
   Responsavel por cadastrar o pedido no banco de dados usando as informações passadas no body da requisição.
2. GET /pago  
   Mock de pagamento
3. PATCH /recebido  
   Responsavel por alterar o estado do pedido para *recebido*
4. PATCH /empreparacao  
   Responsavel por alterar o estado do pedido para *em preparação*
5. PATCH /pronto  
   Responsavel por alterar o estado do pedido para *pronto*
6. PATCH /finalizado  
   Responsavel por alterar o estado do pedido para *finalizado*


## Produtos
Os endpoints da aplicação seguem um determinado padrão para o que for referente aos produtos a serem cadastrados,
listados, atualizados e excluidos do banco de dados.

### Acompanhamentos: 
- GET /acompanhamento  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- PUT /acompanhamento  
  Responsavel por atualizar o registro no banco de dados, usando como parametro nomeBanco passado
  como query parameter e o complemento no body na requisição.
- POST /acompanhamento  
  Responsavel por cadastrar o registro no banco de dados usando as informações passadas no body da requisição.
- DELETE /acompanhamento  
  Responsavel por apagar o registro no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- GET /acompanhamento/all  
  Responsavel por fazer uma pesquisa no banco de dados listando todos os acompanhamentos cadastrados.

### Bebidas: 
- GET /bebida  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- PUT /bebida  
  Responsavel por atualizar o registro no banco de dados, usando como parametro nomeBanco passado
  como query parameter e o complemento no body na requisição.
- POST /bebida  
  Responsavel por cadastrar o registro no banco de dados usando as informações passadas no body da requisição.
- DELETE /bebida  
  Responsavel por apagar o registro no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- GET /bebida/all  
  Responsavel por fazer uma pesquisa no banco de dados listando todos os bebidas cadastrados.

### Lanches: 
- GET /lanche  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- PUT /lanche  
  Responsavel por atualizar o registro no banco de dados, usando como parametro nomeBanco passado
  como query parameter e o complemento no body na requisição.
- POST /lanche  
  Responsavel por cadastrar o registro no banco de dados usando as informações passadas no body da requisição.
- DELETE /lanche  
  Responsavel por apagar o registro no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- GET /lanche/all  
  Responsavel por fazer uma pesquisa no banco de dados listando todos os lanches cadastrados.

### Sobremesas: 
- GET /sobremesa  
  Responsavel por fazer uma pesquisa no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- PUT /sobremesa  
  Responsavel por atualizar o registro no banco de dados, usando como parametro nomeBanco passado
  como query parameter e o complemento no body na requisição.
- POST /sobremesa  
  Responsavel por cadastrar o registro no banco de dados usando as informações passadas no body da requisição.
- DELETE /sobremesa  
  Responsavel por apagar o registro no banco de dados usando como parametro nomeBanco passado
  como query parameter na requisição.
- GET /sobremesa/all  
  Responsavel por fazer uma pesquisa no banco de dados listando todos os sobremesas cadastrados.