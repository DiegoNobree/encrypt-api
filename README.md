# Encryot-Api

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

## Instruções de uso

1. Instalar Java 17
2. Intalar Maven
3. Configurar uma vertente local de PostgreSQL, ou configurar o application.properties com o seu SGBD de preferência(Importante o suporte com o flyway/DB migration)
4. Abri o link http://localhost:9090


## Pontos de Extremidade da API

**OBTENHA USUÁRIOS**
```markdown
POST /api/operation - Inclua os dados sensíveis do usuário.

{
"userDocument": "454545",
"creditCardToken": "57878787872",
"operationValue": 10000
}
```
Retorno:

```json

{
  "id": 1,
  "userDocument": "vj4Evl2u/I1sYaY8w5q1TVzldqvI18lpGz/C0rUNWifZvxjIbOoX03PzVAOXeyJO",
  "creditCardToken": "TkORD+bqjbq+Wys6X5QrzODNBCCGSa9tuHvnzlUHt2vZe9KaRY5oTsEhbXxUcg6b",
  "value": 10000
}
```

```markdown
GET /api/operation{id} - Liste as informações do usuário sem a criptografia.

RETORNO:

{
"id": 1,
"userDocument": "454545",
"creditCardToken": "57878787872",
"operationValue": 10000
}
```

```markdown
DELETE /api/operation{id} - Deleta as informações do usuário depois de ter dado o "get" em suas informações.

RETORNO:

{
"message": "Operation deleted successfully"
}


```

```markdown
PUT /api/operation{id} - Atualiza as informações do usuário logo após o get da criptografia.

{
"userDocument": "000000000000",
"creditCardToken": "57878787872",
"operationValue": 10000
}
```

RETORNO:

```markdown
{
"id": 2,
"userDocument": "vN90ueA+Vfc5AyQDyipDj4ag5SwBmcmiIYcxzj+38TUjFuIUlm+vk3fUdmyhMZix",
"creditCardToken": "UWzrUbtNq0dEMVqYQypiOsZHoAX00vKaIdDoUVg+RaH6qpq5GP6xyHh/Eng/UE3K",
"value": 10000
}
```

### DEPENDÊNCIA UTILIZADA PARA CRIPTOGRAFIA

Utilizei a dependência jasypt como algoritmo para criptografar os dados.

```markdown
<dependency>
	<groupId>com.github.ulisesbocchio</groupId>
	<artifactId>jasypt-spring-boot-starter</artifactId>
	<version>3.0.5</version>
</dependency>

