# controle-de-vacinas-pet
Aplicação desenvolvida para que o tutor tenha controle da vacinação dos seus pets.

## Como executar

Para rodar essa aplicacao você vai precisar importar-la na sua IDE e executar o método main, localizado na classe `Aplicacao.java`.

##
A classe `Aplicação` possui o método main, onde o Vacinometro é inicializado.

O `Vacinometro` é reponsável por gerenciar e executar as opçoes escolhidas pelo usuário, além de inicializar o `RepositorioDeTutores` e o `RepositorioDePets` em seu construtor.

A interface `RepositorioDeVacinas` define o contrato necessário para a criação de repositorios de vacinas mais específicos. As duas opções diponiveis atualmente são o `RepositorioDeVacinasFelino` e o `RepositorioDeVacinasCanino`, que utilizam as vacinas salvas em memória nos arquivos `arquivoDeVacinasFelino` e `arquivoDeVacinasCanino`, localizados na pasta resources.
