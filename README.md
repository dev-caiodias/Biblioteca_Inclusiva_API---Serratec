# 📚 Biblioteca Inclusiva API

**Aluno:** Caio Vinicius Dias  
**Instituição:** Serratec - SENAI  
**Data de Entrega:** 22/05/2026  
**Valor:** 30 pontos

---

## 🎯 Descrição do Projeto

A **Biblioteca Inclusiva** é uma API RESTful desenvolvida em Spring Boot que gerencia um sistema completo de empréstimo e devolução de livros com foco especial em **acessibilidade**. O sistema permite que usuários com diferentes perfis de acessibilidade (deficiência visual, auditiva, motora, etc.) se cadastrem e realizem empréstimos de livros adequados às suas necessidades específicas.

A plataforma controla disponibilidade de exemplares, registra histórico de empréstimos, aplica validações de negócio e oferece uma documentação interativa via Swagger/OpenAPI.

---

## 🎨 Tema Escolhido

**Biblioteca Inclusiva** — Sistema de Gerenciamento de Empréstimos com Acessibilidade

### Entidades Principais
- **Usuario** — Leitor cadastrado no sistema
- **PerfilAcessibilidade** — Necessidades especiais e formatos preferidos
- **Livro** — Acervo da biblioteca (com múltiplos formatos)
- **Categoria** — Gêneros e formatos de livros (Audiobook, Braille, Digital, Impresso)
- **Emprestimo** — Registro de retirada e devolução

### Regras de Negócio
- Um usuário não pode ter mais de 3 empréstimos ativos simultaneamente
- Livros sem exemplares disponíveis não podem ser emprestados
- Email de usuário é único no sistema
- Devoluções em atraso ficam registradas com status "ATRASADO"
- O perfil de acessibilidade guia recomendações de formato

---

## 📋 Pré-requisitos

### Software Necessário
- **Java 17** ou superior ([download aqui](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))
- **Maven 3.8+** ([download aqui](https://maven.apache.org/download.cgi))
- **PostgreSQL 12+** ([download aqui](https://www.postgresql.org/download/))
- **Git** para versionamento

### Validação de Instalação

```bash
java -version          # Deve mostrar Java 17+
mvn -version          # Deve mostrar Maven 3.8+
psql --version        # Deve mostrar PostgreSQL 12+
```

---

## 🗄️ Configuração do Banco de Dados

### 1. Criar o Banco

Abra o `pgAdmin` ou o terminal PostgreSQL (`psql`) e execute:

```sql
CREATE DATABASE biblioteca_inclusiva;
```

### 2. Configurar Credenciais

Edite `src/main/resources/application.properties`:

```properties
# Banco de dados
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_inclusiva
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

As tabelas serão criadas automaticamente quando a aplicação iniciar (primeira vez).

---

## 🚀 Instruções de Execução

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/biblioteca-inclusiva-api.git
cd biblioteca-inclusiva-api
```

### 2. Compilar o Projeto

```bash
mvn clean install
```

### 3. Executar a Aplicação

```bash
mvn spring-boot:run
```

Ou via IntelliJ IDEA: clique no botão verde ▶ na classe `InclusivaApplication.java`

### 4. Acessar a API

A API estará disponível em: **`http://localhost:8080`**

Documentação interativa (Swagger): **`http://localhost:8080/swagger-ui.html`**

---

## 📡 Endpoints Disponíveis

### 🏷️ Categorias

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/categorias` | Listar todas as categorias | 200 |
| GET | `/categorias/{id}` | Buscar categoria por ID | 200 / 404 |
| POST | `/categorias` | Criar nova categoria | 201 |
| PUT | `/categorias/{id}` | Atualizar categoria | 200 / 404 |
| DELETE | `/categorias/{id}` | Deletar categoria | 204 / 404 |

**Exemplo de Body — POST `/categorias`:**
```json
{
  "nome": "Audiobook",
  "descricao": "Livros em formato de áudio para deficientes visuais"
}
```

**Resposta 201:**
```json
{
  "id": 1,
  "nome": "Audiobook",
  "descricao": "Livros em formato de áudio para deficientes visuais"
}
```

---

### 👤 Perfil de Acessibilidade

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/perfilAcessibilidade` | Listar perfis | 200 |
| GET | `/perfilAcessibilidade/{id}` | Buscar perfil por ID | 200 / 404 |
| POST | `/perfilAcessibilidade` | Criar novo perfil | 201 |
| PUT | `/perfilAcessibilidade/{id}` | Atualizar perfil | 200 / 404 |
| DELETE | `/perfilAcessibilidade/{id}` | Deletar perfil | 204 / 404 |

**Exemplo de Body — POST `/perfilAcessibilidade`:**
```json
{
  "tipoDeficiencia": "VISUAL",
  "formatoPreferido": "BRAILLE",
  "observacoes": "Prefere livros em braille grande"
}
```

---

### 👥 Usuários

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/usuarios` | Listar usuários | 200 |
| GET | `/usuarios/{id}` | Buscar usuário por ID | 200 / 404 |
| POST | `/usuarios` | Criar novo usuário | 201 |
| PUT | `/usuarios/{id}` | Atualizar usuário | 200 / 404 |
| DELETE | `/usuarios/{id}` | Deletar usuário | 204 / 404 |

**Exemplo de Body — POST `/usuarios`:**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "telefone": "21999999999",
  "perfilId": 1
}
```

**Resposta 201:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "telefone": "21999999999",
  "perfilAcessibilidade": {
    "id": 1,
    "tipoDeficiencia": "VISUAL",
    "formatoPreferido": "BRAILLE"
  }
}
```

---

### 📖 Livros

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/livros` | Listar livros | 200 |
| GET | `/livros/{id}` | Buscar livro por ID | 200 / 404 |
| POST | `/livros` | Criar novo livro | 201 |
| PUT | `/livros/{id}` | Atualizar livro | 200 / 404 |
| DELETE | `/livros/{id}` | Deletar livro | 204 / 404 |

**Exemplo de Body — POST `/livros`:**
```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "9780132350884",
  "qtdExemplares": 5,
  "formato": "DIGITAL",
  "categoriaIds": [1, 3]
}
```

---

### 📅 Empréstimos

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| GET | `/emprestimos` | Listar empréstimos | 200 |
| GET | `/emprestimos/{id}` | Buscar empréstimo por ID | 200 / 404 |
| POST | `/emprestimos` | Criar empréstimo | 201 |
| PUT | `/emprestimos/{id}` | Atualizar empréstimo | 200 / 404 |
| DELETE | `/emprestimos/{id}` | Deletar empréstimo | 204 / 404 |
| PUT | `/emprestimos/{id}/devolver` | Registrar devolução | 200 / 404 |

**Exemplo de Body — POST `/emprestimos`:**
```json
{
  "usuarioId": 1,
  "livroId": 1,
  "dataPrevistaDevolucao": "2026-06-22"
}
```

---

## 🔒 Tratamento de Erros

A API retorna erros padronizados em formato JSON:

### Erro 400 — Validação Inválida
```json
{
  "timestamp": "2026-05-22T10:30:00",
  "status": 400,
  "message": "[email: deve ser um endereço de e-mail válido, nome: Preencha um nome.]",
  "path": "/usuarios"
}
```

### Erro 404 — Recurso Não Encontrado
```json
{
  "timestamp": "2026-05-22T10:30:00",
  "status": 404,
  "message": "Categoria não encontrada com id: 999",
  "path": "/categorias/999"
}
```

### Erro 409 — Conflito de Dados
```json
{
  "timestamp": "2026-05-22T10:30:00",
  "status": 409,
  "message": "Email já cadastrado: joao@email.com",
  "path": "/usuarios"
}
```

---

## 🔧 Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| Java | 17 | Linguagem de programação |
| Spring Boot | 3.5.14 | Framework web |
| Spring Data JPA | 3.5.11 | ORM para persistência |
| PostgreSQL | 12+ | Banco de dados relacional |
| Hibernate | 6.6.49 | Implementação de JPA |
| Maven | 3.8+ | Gerenciador de dependências |
| Springdoc OpenAPI | 2.8.6 | Documentação Swagger/OpenAPI |
| Bean Validation | 3.0.2 | Validação de dados |
| Jackson | 2.21.2 | Serialização JSON |

---

## 📊 Arquitetura e Estrutura do Projeto

```
src/main/java/com/biblioteca/inclusiva/
├── controller/          # Endpoints REST
├── service/            # Lógica de negócio
├── repository/         # Acesso ao banco (JPA)
├── entity/             # Mapeamento JPA (Entidades)
├── dto/
│   ├── request/        # DTOs de entrada
│   └── response/       # DTOs de resposta
├── exception/          # Exceções customizadas
├── config/             # Configurações (Swagger, etc)
└── InclusivaApplication.java  # Classe principal
```

---

## ✨ Diferenciais Implementados

### ✅ Funcionalidades Principais
- ✓ CRUD completo em todas as entidades (5 verbos HTTP)
- ✓ Relacionamentos JPA: OneToOne, OneToMany, ManyToMany
- ✓ DTOs de Request e Response em todos os endpoints
- ✓ Bean Validation obrigatória (@NotBlank, @Email, @Size, @Pattern, @Positive)
- ✓ Exception Handler global com respostas padronizadas
- ✓ Swagger/OpenAPI documentado com @Operation e @Schema

### 🌟 Diferenciais Extras
- ✓ **Auditoria automática** — campos `createdAt` e `updatedAt` em todas as entidades
- ✓ **Validação de regras de negócio** — limite de 3 empréstimos ativos, email único
- ✓ **Conversores DTO robustos** — métodos `toEntity` e `toResponse` centralizados
- ✓ **Relacionamento complexo** — Livro com ManyToMany em Categoria
- ✓ **Endpoint especial** — `/emprestimos/{id}/devolver` para registrar devoluções

---

## 🧪 Testando a API

### Via Swagger (Recomendado)
1. Acesse `http://localhost:8080/swagger-ui.html`
2. Clique em qualquer endpoint
3. Clique em "Try it out"
4. Preencha os dados e clique em "Execute"

### Via Postman/Insomnia
1. Importe a coleção ou crie manualmente
2. Defina o método HTTP (GET, POST, etc)
3. Cole a URL (ex: `http://localhost:8080/categorias`)
4. Para POST/PUT, adicione o JSON no Body (raw JSON)
5. Clique "Send"

### Exemplo de Fluxo Completo
```
1. POST /categorias → cria "Audiobook"
2. POST /perfilAcessibilidade → cria perfil visual
3. POST /usuarios → cria usuário com perfil
4. POST /livros → cria livro com categoria
5. POST /emprestimos → cria empréstimo (valida regras)
6. PUT /emprestimos/{id}/devolver → registra devolução
```

---

## 📝 Observações Relevantes

### Validações Obrigatórias
- **Email** — Deve ser único e em formato válido
- **Telefone** — Deve conter 10 ou 11 dígitos numéricos
- **Nome** — Não pode estar em branco
- **Categorias em Livro** — Todos os IDs enviados devem existir

### Status HTTP Utilizados
- `200 OK` — Operação bem-sucedida (GET, PUT)
- `201 Created` — Recurso criado (POST)
- `204 No Content` — Deletado com sucesso (DELETE)
- `400 Bad Request` — Validação falhou
- `404 Not Found` — Recurso não encontrado
- `409 Conflict` — Email duplicado ou regra de negócio violada
- `500 Internal Server Error` — Erro no servidor

### Configuração do `application.properties`
Certifique-se de que o arquivo está em `src/main/resources/application.properties` com as credenciais corretas do PostgreSQL. **Nunca commite senhas no Git** — use variáveis de ambiente em produção.

---

## 📸 Documentação Swagger

A API possui documentação completa e interativa acessível em:

**`http://localhost:8080/swagger-ui.html`**

Todos os endpoints estão documentados com:
- ✓ Descrição detalhada
- ✓ Exemplos de requisição e resposta
- ✓ Códigos de status possíveis
- ✓ Validações esperadas

---

## 🔗 Links Úteis

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Swagger/OpenAPI Specification](https://swagger.io/specification/)
- [Bean Validation Spec](https://beanvalidation.org/)

---

## ✅ Checklist de Funcionalidades

- [x] Estrutura de 7 pacotes obrigatória
- [x] Relacionamentos JPA (OneToOne, OneToMany, ManyToMany)
- [x] CRUD completo em todas as entidades
- [x] DTOs de Request e Response
- [x] Bean Validation em todos os DTOs de entrada
- [x] Exception Handler global (@ControllerAdvice)
- [x] Swagger/OpenAPI documentado
- [x] @JsonManagedReference/@JsonBackReference para evitar loops
- [x] PostgreSQL conectado e funcionando
- [x] Repositório Git com commits frequentes
- [x] README.md completo

---

**Data de Conclusão:** 22/05/2026  
**Desenvolvedor:** Caio Vinicius Dias  
**Instituição:** Serratec - SENAI
