### Teste – Treinamento Java – API de Emprésmo

## Introdução
Neste teste você irá desenvolver uma API REST para um sistema de emprésmos de uma
empresa financeira. Você deve ulizar as tecnologias ulizadas no curso: Java, Maven e
Spring. Inicie o projeto em h(ps://start.spring.io/ considerando a sua versão do Java.
Para fins didácos e de correção objeva, iremos dividir o desenvolvimento do projeto
em 3 etapas destacando a pontuação e critérios de correção. Para cada item destacado
a seguir serão observados a corretude e qualidade do código produzido, especialmente
o uso correto das construções e convenções da linguagem visando baixo acoplamento e
alta coesão.

## Etapa 1 – Cadastro de clientes (pontuação: 2,5)
A API deve permitir cadastrar, alterar, visualizar e excluir clientes. Cada cliente possui os
seguintes dados obrigatórios: Nome, CPF, Telefone, Endereço (Rua, Número e CEP) e
Rendimento mensal. A seguir temos exemplo da URI com o cliente com CPF
53210216002
A API deve possuir os seguintes end-points para operação do cadastro de clientes:
POST /clientes
• (pontuação: 0,5) Adiciona um cliente na base de dados. O CPF deverá ser
utilizado como identificador único no cadastro. Deve ter validações de CPF,
Telefone, Endereço e Rendimento mensal.

GET /clientes
• (pontuação: 0,5) Obtém os dados de todos os clientes da base de dados.
Retorna uma lista com os clientes cadastrados.

GET /clientes/53210216002
• (pontuação: 0,5) Obtém os dados de um cliente da base de dados com o CPF
fornecido na URI. Inclua as validações necessárias.

DELETE /clientes/53210216002
• (pontuação: 0,5) Apaga um cliente da base de dados. Inclua as validações
necessárias.

PUT /clientes/53210216002
• (pontuação: 0,5) Atualiza os dados de um cliente na base de dados. Inclua as
validações necessárias.

## Etapa 2 – Cadastro de emprésmo (pontuação: 4,0)
A API deve permitir cadastrar, apagar e visualizar empréstimos. Cada empréstimo possui
os seguintes dados obrigatórios: Id, CPFCliente, ValorInicial, ValorFinal, Relacionamento
(Bronze, Prata ou Ouro), Data inicial e Data final.
A API deve possuir os seguintes end-points para operação do cadastro de empréstimos:
POST /clientes/53210216002/emprestimos
• (pontuação: 1,0) Adiciona um empréstimo para o cliente na base de dados.
Somente poderão ser cadastrados empréstimos para clientes previamente
cadastrados. No cadastro, o ValorFinal deve ser calculado automaticamente
de acordo com o tipo de Relacionamento (ver etapa 3).
• (pontuação: 1,5) Visando diminuir a inadimplência, um cliente somente
poderá ter um valor total de empréstimos equivalente a 10 vezes o seu
rendimento mensal. Por exemplo, um cliente com rendimento mensal = 10,
poderá ter até N (vários) empréstimos, porém a soma do ValorInicial desses
empréstimos não deve ultrapassar o valor de 100 (rendimento mensal * 10).
Essa verificação deve ocorrer sempre que um novo empréstimo for ser
inserido para determinado cliente e deve considerar a renda do cliente no
momento do cadastro do empréstimo.

DELETE /clientes/53210216002/emprestimos/{id}
• (pontuação: 0,5) Apaga os dados de um empréstimo da base de dados. Inclua
as validações necessárias.

GET /clientes/53210216002/emprestimos/{id}
• (pontuação: 0,5) Retorna os dados de um empréstimo da base de dados.
Inclua as validações necessárias.

GET /clientes/53210216002/emprestimos
• (pontuação: 0,5) Obtém a lista de empréstimos do cliente. Inclua as validações
necessárias.

## Etapa 3 – Cálculo do valorFinal no cadastro de emprésmo (pontuação: 3,5)
No cadastro de um empréstimo o sistema deve calcular automaticamente o valor final
do empréstimo, esse valor é calculado a partir do relacionamento.
• (pontuação: 0,5) Se o relacionamento com o cliente for Bronze:
o o valorFinal é igual ao valorInicial * 1,80
• pontuação: 1,5) Se o relacionamento com o cliente for Prata:
o o valorFinal é igual ao valorInicial * 1,40 se o valorInicial > 5000,
o Caso contrário (valorInicial <= 5000), o valorFinal é igual ao valorInicial
* 1,60

• pontuação: 1,5) Se o relacionamento com o cliente for Ouro:
o o valorFinal é igual ao valorInicial * 1,2 se o cliente tiver até 1
empréstimo
o o valorFinal é igual ao valorInicial * 1,3 se o cliente tiver mais de um
empréstimo
o Exemplo de execução:
 Cliente Ouro com 0 empréstimos, solicita o primeiro
empréstimo. O valor final do empréstimo é valorInicial * 1,2
(no momento da concessão ele tem até 1 empréstimo)
 Cliente Ouro com 1 empréstimo, solicita o segundo
empréstimo. O valor final do empréstimo é valorInicial * 1,2
(no momento da concessão ele tem até 1 empréstimo)
 Cliente Ouro com 2 empréstimos, solicita o terceiro
empréstimo. O valor final do empréstimo é valorInicial * 1,3
(no momento da concessão ele tem mais de um 1 empréstimo)
 Cliente Ouro com 3 empréstimos, solicita o quarto
empréstimo. O valor final do empréstimo é valorInicial * 1,3
(no momento da concessão ele tem mais de um 1 empréstimo)
