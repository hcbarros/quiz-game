## Projeto criado em 02 branchs, das quais a "main" se encontra o Spring Boot que cria a API utilizada na branch "react", que por sua vez cria a interface.

O projeto da branch "main" pode ser facilmente executado utilizando a IDE Eclipse que se encontra no endereço https://spring.io/tools bastando clicar na opção "Maven Install" e em seguida "Spring Boot App", ou pela linha de comando utilizando "mvn clean install" em seguida, "mvn spring-boot:run".

O projeto da branch "react" pode ser executado digitando na linha de comando: npm install (para instalar as dependências) e em seguida "npm start".

O projeto do Spring Boot pode ser acessado em http://localhost:8080/questions
O projeto da branch "react" pode ser acessado em http://localhost:3000

A API possui os seguintes verbos:

### GET/ \
### DELETE/

O "delete" apos deletar também salva 05 questoes e respostas em ordem aleatória.

Ambos os projeto também estão disponíveis nos seguintes endereços:

### https://api-quiz-game.herokuapp.com/questions \
### https://react-quiz-game.herokuapp.com/

###
###
###

1) Em javascript, qual a diferença entre Set e Map?
2) O que é closure em javascript?
3) No CSS, qual a diferença entre pseudo-classes e pseudo-elementos?
4) Quais tags HTML são usadas para exibir os dados na forma tabular?
5) Qual a principal diferença entre CSS Grid e Flexbox?

### Desafio: Quiz Game

### Descrição:
Uma vez respondido às questões acima, junte as perguntas e respostas e crie um quiz. O jogo
deve começar com uma tela que contenha uma mensagem de boas vindas e um botão "Iniciar
Jogo". Após o usuário clicar neste botão, a tela de boas vindas deve sumir e deve aparecer a
primeira pergunta. Caso o usuário acerte, a próxima pergunta deve ser mostrada. Caso ele erre,
um overlay preto (com a transparência a sua escolha) deve ser mostrado sobre a interface, com
uma mensagem que ele perdeu o jogo e com um botão para que ele recomece o quiz. Caso ele
acerte todas as perguntas, a interface deve mostrar uma mensagem parabenizando-o e um botão
para que ele recomece o jogo.

### Tecnologias:
- Deve ser usado HTML, CSS e Javascript para desenvolver a interface web. Você poderá usar
Typescript caso tenha familiaridade. Será permitido o uso de qualquer framework ou bibliotecas
que facilitem a implementação do desafio.
- Para desenvolver o web service, deve ser usada a linguagem Java. A interface de comunicação
deve seguir a especificação REST para fornecer os dados necessários à interface. Assim como no
desenvolvimento da interface, também poderá utilizar qualquer biblioteca ou framework que facilite
a implementação desse desafio.
- Os dados (perguntas e respostas), devem ser armazenados em um arquivo de texto ou em um
banco de dados em memória (H2, Sqlite, etc). Caso opte pelo banco de dados, cuide para que
este esteja sempre populado com os dados. O modelo de dados utilizado é de livre escolha.

### Projeto:
- Após o usuário clicar no botão iniciar jogo, o frontend deve fazer uma requisição AJAX para o
backend com a finalidade de obter a lista de perguntas e respostas. A ordem da lista deve vir de
forma aleatória do backend, dificultando a repetição da ordem das perguntas.
- O frontend deve armazenar esse resultado e gerir quando cada pergunta e respostas devem ser
mostrados. Quando o usuário recarregar a tela, o frontend deve fazer uma nova requisição para o
backend após o usuário clicar em "Iniciar Jogo". Não é necessário fazer o uso de cache de dados
do serviço.
###Considerações:
- O código deve estar todo em inglês (nome de variáveis, funções, classes, etc). Será permitido o
uso de português apenas nos comentários.
- É proibido o uso do alert() nesse desafio.
- A corretude das respostas do quiz também serão avaliadas.
- Preocupe-se em escrever um README explicando como rodar o seu projeto, tanto para frontend
quanto para backend.
- Uso de TDD é um diferencial.
### Obs.:
As respostas das perguntas de 1 a 5 não precisam ser enviadas separadamente, a avaliação
destas será feita no código que corresponderá ao desafio.

