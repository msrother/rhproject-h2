# Projeto de Gestão de Recursos Humanos

Este projeto consiste em uma aplicação Java para gestão de Recursos Humanos (RH), onde serão criadas tabelas para armazenar informações sobre funcionários, cargos, departamentos e outros dados relacionados ao RH de uma empresa. Utiliza-se o banco de dados H2, um banco de dados em memória, para armazenar os dados. Além disso, a aplicação implementa autenticação utilizando JSON Web Tokens (JWT) para garantir a segurança das operações. O script `import.sql` é utilizado para popular o banco de dados com dados iniciais."

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

Endpoints para gerenciamento de usuários:

- `/rhprojecth2/user/create`: cria um novo usuário.
- `/rhprojecth2/user/list`: lista todos os usuários.
- `/rhprojecth2/user/searchById`: busca um usuário por ID.
- `/rhprojecth2/user/searchByEmail`: busca um usuário por e-mail.
- `/rhprojecth2/user/searchByPassword`: busca usuários por senha.
- `/rhprojecth2/user/update`: atualiza um usuário existente.
- `/rhprojecth2/user/delete`: exclui um usuário.

Endpoints para gerenciamento de departamentos:

- `/rhprojecth2/department/create`: cria um novo departamento.
- `/rhprojecth2/department/list`: lista todos os departamentos.
- `/rhprojecth2/department/searchById`: busca um departamento por ID.
- `/rhprojecth2/department/searchByName`: busca departamentos pelo nome.
- `/rhprojecth2/department/update`: atualiza um departamento existente.
- `/rhprojecth2/department/delete`: exclui um departamento.

Endpoints para gerenciamento de cargos:

- `/rhprojecth2/jobPosition/create`: cria um novo cargo.
- `/rhprojecth2/jobPosition/list`: lista todos os cargos.
- `/rhprojecth2/jobPosition/searchById`: busca um cargo por ID.
- `/rhprojecth2/jobPosition/searchByName`: busca cargos pelo nome.
- `/rhprojecth2/jobPosition/update`: atualiza um cargo existente.
- `/rhprojecth2/jobPosition/delete`: exclui um cargo.

Endpoints para gerenciamento de funcionários:

- `/rhprojecth2/employee/create`: cria um novo funcionário.
- `/rhprojecth2/employee/list`: lista todos os funcionários.
- `/rhprojecth2/employee/searchById`: busca um funcionário por ID.
- `/rhprojecth2/employee/searchByName`: busca funcionários pelo nome.
- `/rhprojecth2/employee/searchByDepartmentId`: busca funcionários por ID de departamento. 
- `/rhprojecth2/employee/update`: atualiza um funcionário existente.
- `/rhprojecth2/employee/delete`: exclui um funcionário.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para contribuir com melhorias, correções de bugs, etc.