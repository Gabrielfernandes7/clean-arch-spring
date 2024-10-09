# Arquitetura Limpa (Clean Architecture) 🫧 🧼

A **Arquitetura Limpa** foi desenvolvida com o objetivo principal de **desacoplar** as **regras de negócio** dos **detalhes da implementação**, como frameworks, bancos de dados, interfaces gráficas, entre outros. Essa abordagem permite que o sistema seja mais **manutenível**, **escalável** e **flexível** para futuras mudanças tecnológicas.

![Clean Arch](/docs/cleanarch.jpeg)

## Princípios da Arquitetura Limpa

1. **Independência de frameworks:** As regras de negócios devem ser independentes de frameworks e tecnologias externas. Isso permite a substituição de tecnologias sem afetar o núcleo do sistema.

2. **Testabilidade:** Como a regra de negócio está separada de dependências externas, fica mais fácil testar os casos de uso de maneira isolada.

3. **Independência da interface de usuário:** A lógica de negócios não deve depender de interfaces gráficas. Isso permite trocar a UI sem grandes refatorações.

4. **Independência do banco de dados:** A camada de persistência é desacoplada da regra de negócios, o que possibilita a mudança de banco de dados sem impacto significativo no sistema.

5. **Independência de qualquer agente externo:** O núcleo da aplicação não deve depender de agentes externos, como APIs, sistemas de terceiros, etc. Tudo isso deve ser tratado nas camadas externas.

## Estrutura do Projeto

O projeto segue a divisão da Arquitetura Limpa com as seguintes camadas:

### 1. **Domain**
Contém as **entidades** que representam o coração das regras de negócio. Esta camada **não pode depender de nenhum framework** ou tecnologia específica. Os conceitos fundamentais e regras de negócio estão aqui.

- **Entidades**: Modelos de dados que refletem diretamente as regras de negócio.
  
### 2. **Application**
Responsável pelos **casos de uso** (ou interatores), que são as implementações da lógica de aplicação. Eles orquestram as operações de negócio, chamando entidades e outras camadas necessárias para realizar a funcionalidade desejada.

- **Usecases**: Representam as funcionalidades principais que a aplicação deve realizar.
- **Gateway**: Definem interfaces que as camadas externas (como a persistência) devem implementar para interagir com os casos de uso.

### 3. **Infrastructure**
Esta camada trata dos **detalhes de implementação** e é onde as tecnologias são integradas ao sistema. Aqui, frameworks e bibliotecas são utilizados para fornecer funcionalidades ao sistema, mas são mantidos separados das regras de negócio.

- **Gateways**: Implementações dos repositórios, que fazem a ponte entre a aplicação e os mecanismos de persistência (banco de dados, APIs, etc.).
  
- **Persistence**: Representa a camada de persistência de dados (pode ser banco de dados relacional, NoSQL, etc.). Aqui estão os **adapters**, que implementam as interfaces definidas na camada **application** (gateway).

- **Controllers**: Pontos de entrada da aplicação, responsáveis por receber as requisições do usuário (HTTP, CLI, etc.) e encaminhá-las para os casos de uso apropriados.

## Benefícios da Arquitetura Limpa

- **Facilidade na troca de tecnologia**: É possível trocar o framework web, banco de dados ou qualquer outra tecnologia sem alterar as regras de negócio.
  
- **Alta testabilidade**: O núcleo do sistema pode ser facilmente testado sem a necessidade de se preocupar com infraestrutura ou detalhes técnicos.

- **Manutenibilidade**: Como cada camada tem uma responsabilidade bem definida, é mais fácil manter e evoluir o sistema ao longo do tempo.

- **Reutilização**: As regras de negócio podem ser reutilizadas em diferentes contextos (por exemplo, uma API, uma interface gráfica desktop, ou uma aplicação mobile) sem grandes modificações.
