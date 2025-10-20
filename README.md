## 🧪 Teste de Back-end Interno

Este projeto implementa a **geração de pedidos** com integração a um sistema de **mensageria RabbitMQ**.  
Ao criar um pedido, uma mensagem é enviada para a fila, e um consumidor automaticamente **gera a entrega correspondente**.

### ⚙️ Tecnologias utilizadas
- **Java / Spring Boot**
- **RabbitMQ** (mensageria)
- **H2 Database** (banco em memória para testes)
- **JUnit 5 / MockMvc / Mockito** (testes automatizados)

### 🧩 Funcionamento
1. Um pedido é criado através do serviço principal.  
2. O sistema publica uma mensagem na fila RabbitMQ.  
3. O consumidor da fila lê a mensagem e cria automaticamente uma entrega associada ao pedido.  
4. Todos os dados são armazenados temporariamente no banco H2 em memória.

### 🧠 Objetivo
Validar o fluxo de criação de pedidos e entregas via mensageria, garantindo que:
- A mensagem seja publicada corretamente;
- O consumidor da fila processe e gere a entrega;
- O banco H2 registre corretamente os dados.

### ▶️ Execução
1. Inicie o RabbitMQ localmente com o docker com esse comando: docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management
2. O acesso ao banco H2 está disponível no application.yml
