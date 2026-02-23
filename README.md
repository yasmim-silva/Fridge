🧊 Fridge API
API REST para gerenciamento de itens da geladeira, com foco em facilitar a lista de compras. Permite controlar o que você tem em casa, verificar validade dos alimentos e identificar o que está acabando.

📦 Funcionalidades
✅ Cadastrar, editar e remover itens da geladeira
✅ Filtrar por categoria (Frutas, Carnes, Laticínios...)
✅ Buscar itens pelo nome
✅ Verificar itens vencidos
✅ Verificar itens que vencem em breve
✅ Ver itens com estoque baixo
✅ Gerar lista de compras com itens esgotados (quantidade = 0)

▶️ Como rodar
Pré-requisitos: Java 17+ e Maven instalados.
git clone https://github.com/seu-usuario/fridge.git
cd fridge
./mvnw spring-boot:run

📖 Documentação da API
Acesse o Swagger UI com a aplicação rodando:
http://localhost:8080/swagger-ui.html
