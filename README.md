🧊 Fridge API

API REST para gerenciamento de itens da geladeira, com foco em facilitar a lista de compras. Permite controlar o que você tem em casa, verificar validade dos alimentos e identificar o que está acabando.


📦 Funcionalidades

1. Cadastrar, editar e remover itens da geladeira

2. Filtrar por categoria (Frutas, Carnes, Laticínios...)

3. Buscar itens pelo nome

4. Verificar itens vencidos

5. Verificar itens que vencem em breve

6. Ver itens com estoque baixo

7. Gerar lista de compras com itens esgotados (quantidade = 0)


▶️ Como rodar

Pré-requisitos: Java 17+ e Maven instalados.

1. git clone https://github.com/seu-usuario/fridge.git

2. cd fridge

3. ./mvnw spring-boot:run


📖 Documentação da API

Acesse o Swagger UI com a aplicação rodando:
http://localhost:8080/swagger-ui.html
