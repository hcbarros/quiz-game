## Projeto criado em 02 branchs, das quais a "main" se encontra o Spring Boot que cria a API utilizada na branch "react", que por sua vez cria a interface.

O projeto da branch "main" pode ser facilmente executado utilizando a IDE Eclipse que se encontra no endereço https://spring.io/tools bastando clicar na opção "Maven Install" e em seguida "Spring Boot App", ou pela linha de comando utilizando "mvn clean install" em seguida, "mvn spring-boot:run".

O projeto da branch "react" pode ser executado digitando na linha de comando: npm install (para instalar as dependências) e em seguida "npm start".

O projeto do Spring Boot pode ser acessado em http://localhost:8080/questions
O projeto da branch "react" pode ser acessado em http://localhost:3000

A API possui os seguintes verbos:

### GET/
### DELETE/

O "delete" apos deletar também salva 05 questoes e respostas em ordem aleatória.

Ambos os projeto também estão disponíveis nos seguintes endereços:

### https://api-quiz-game.herokuapp.com/questions
### https://react-quiz-game.herokuapp.com/

