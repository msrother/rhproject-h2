﻿# Projeto de Gestão de Recursos Humanos

Este projeto consiste em uma aplicação Java para gestão de Recursos Humanos (RH), onde serão criadas tabelas para armazenar informações sobre funcionários, cargos, departamentos e outros dados relacionados ao RH de uma empresa. A aplicação implementará autenticação utilizando JSON Web Tokens (JWT) para garantir a segurança das operações.

## Instalação e Configuração:
1. Clone este repositório para o seu ambiente de desenvolvimento:  
    ```
    https://github.com/msrother/rhproject-h2.git    
    ```
2. Certifique-se de ter o JDK e o Maven instalados na sua máquina:
    ```   
    https://www.oracle.com/middleeast/java/technologies/downloads/  
    ```

    ```   
    https://maven.apache.org/
    ```   
4. Utilizando o IntelliJ IDEA, importe as dependências do projeto contidas no arquivo `pom.xml`.
5. Inicie a aplicação Spring Boot.
6. A aplicação estará disponível no endereço http://localhost:8080/rhprojecth2/
7. Utilize a aplicação Postman para testar os endpoints da API. 

## Uso da API
1. Para gerar o token de autenticação, será necessário enviar uma solicitação HTTP GET para o endpoint `/authorize`
```
http://localhost:8080/rhprojecth2/user/authorize 
```
2. Na aba "Headers", adicione os dois cabeçalhos: key `email`, value `admin@rh.com` e key `password`, value `admin123`
3. Com o token gerado, nos demais endpoints, na aba "Headers", adicione o cabeçalho: key `token`, value `conteúdo do token gerado`

Endpoints para gerenciamento de usuário:

- `/rhprojecth2/user/create`: Cria um novo usuário.
- `/rhprojecth2/user/list`: Lista todos os usuários.
- `/rhprojecth2/user/searchById`: Busca um usuário por ID.
- `/rhprojecth2/user/searchByEmail`: Busca um usuário por e-mail.
- `/rhprojecth2/user/searchByPassword`: Busca usuários por senha.
- `/rhprojecth2/user/update`: Atualiza um usuário existente.
- `/rhprojecth2/user/delete`: Exclui um usuário.
