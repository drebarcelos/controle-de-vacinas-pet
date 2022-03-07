# controle-de-vacinas-pet

A classe Aplicação possui o método main e inicializa o Vacinometro.

O Vacinometro inicializa o RepositorioDeTutores e o RepositorioDePets em seu construtor, e é reponsável por gerenciar e executar as opçoes escolhidas pelo usuário.

A interface RepositorioDeVacinas define o contrato necessário para a criação de repositorios de vacinas mais específicos, as duas opções diponiveis atualmente são o RepositorioDeVacinasFelino e o RepositorioDeVacinasCanino, que utilizam as vacinas salvas em memória nos arquivos arquivoDeVacinasFelino e arquivoDeVacinasCanino, localizados na pasta resources.
