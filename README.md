# Challenge Java - Backend

 `Desafio`: construir uma API utilizando Java 8+, H2, JPA e JSP.
 
## Funcionalidades requeridas

1. Login
2. Consulta
3. Adição
4. Alteração
5. Remoção

## Dependências e plugins

H2 Database, Hibernate, JavaX { com Servlet, JSP, JSTL } e Tomcat. No build do maven proposto pelo mvnrepository.com já vieram um amontoado de plugins do próprio Maven, a lista completa está no [POM.xml](/master/pom.xml).

## Como usar

É necessário uma operação manual para realizar o deploy do projeto "WAR" dentro do diretório `~/src/main/webapp`. Como? Seguindo as instruções. No diretório raiz, com Maven instalado globalmente, digite:

```
mvn clean package install
```
Esse comando serve para instalar e realizar build com todas as dependências e plugins. No final, é gerado um arquivo *"challenge-maven-h2-jpa-jsf-1.0-SNAPSHOT.war"* 	que é salvo dentro diretório `~/target`. A partir de então, digite:

```
cd ..
cd src/main
mkdir webapp
```
E criando o diretório `src/main/webapp`, é só colar o arquivo *"challenge-maven-h2-jpa-jsf-1.0-SNAPSHOT.war"*. Desse ponto, digite no terminal:

```
mvn tomcat:run
```
Assim, o servidor local estará disponível em:  _http://localhost:8080/challenge-maven-h2-jpa-jsf_

## Observações

A partir de uma estrutura básica de um projeto Maven, as tentativas de desenvolvimento foram realizadas em branches diferentes. Aquele (hibernate-session) que mais avançou em alcançar os requesitos solicitados, foi juntado ao master na entrega do projeto.

Todos os outros branches [um](/tree/implement-tom-ee) e [dois](/tree/open-liberty-t1), com os commits e comentários foram deixados por motivos de avaliação.

## Desenvolvedor

> Thiago Jacinto @ 2020

- [Github](https://github.com/thiagojacinto)
- [LinkedIn](https://www.linkedin.com/in/thiago-jacinto-silva-dos-santos-3b629598/)
