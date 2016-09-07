## Introdução

Interpretador de arquivos CSV com interface de filtros programáveis

## Inicialização do software

Uma vez baixado o software, basta chamar a Simple Build Tool (sbt):

```
$ sbt
[info] Loading project definition from /home/raphael/IdeaProjects/challenge-accepted/project
[info] Set current project to challenge-accepted (in build file:/home/raphael/IdeaProjects/challenge-accepted/)
> compile
[info] Updating {file:/home/raphael/IdeaProjects/challenge-accepted/}root...
[info] Resolving jline#jline;2.12.1 ...
[info] Done updating.
[info] Compiling 10 Scala sources to /home/raphael/IdeaProjects/challenge-accepted/target/scala-2.11/classes...
[success] Total time: 3 s, completed Sep 6, 2016 9:06:51 PM
> run
[info] Running br.com.ideiainteligencia.challengeAccepted.ChallengeAccepted
[success] Total time: 1 s, completed Sep 6, 2016 9:06:57 PM
> test
[info] Compiling 1 Scala source to /home/raphael/scala-workspace/challenge-accepted/target/scala-2.11/test-classes...
[info] RecordFactoryTest:
[info] - RecordFactory should return Record when valid record is passed as parameter
[info] - RecordFactory should return NULL when incomplete record is passed as parameter
[info] BornOnSecondSemesterFilterTest:
[info] - BornOnSecondSemesterFilter should return TRUE when record birthday is after/equal July
[info] - BornOnSecondSemesterFilter should return FALSE when record birthday is before July
[info] MaleFilterTest:
[info] - MaleFilter should return TRUE when gender is MALE
[info] - MaleFilter should return FALSE when gender is not FEMALE
[info] FilterFactoryTest:
[info] - FilterFactory should return MaleFilter when string MaleFilter is passed as parameter
[info] - FilterFactory should return FemaleFilter when string FemaleFilter is passed as parameter
[info] - FilterFactory should return BornOnSecondSemesterFilter when string BornOnSecondSemesterFilter is passed as parameter
[info] - FilterFactory should return BornOnFirstSemesterFilter when string BornOnFirstSemesterFilter is passed as parameter
[info] - FilterFactory should return BornOnFirstSemesterFilter when any other string is passed as parameter
[info] FemaleFilterTest:
[info] - FemaleFilter should return TRUE when gender is FEMALE
[info] - FemaleFilter should return FALSE when gender is not FEMALE
[info] BornOnFirstSemesterFilterTest:
[info] - BornOnFirstSemesterFilter should return TRUE when record birthday is after/equal June
[info] - BornOnFirstSemesterFilter should return FALSE when record birthday is after June
[info] LineProcessorTest:
[info] - LineProcessor should return Record when valid record is passed as parameter and record matches filter
[info] - LineProcessor should return NULL when valid record is passed as parameter and record doesn't match filter
[info] Run completed in 176 milliseconds.
[info] Total number of tests run: 17
[info] Suites: completed 7, aborted 0
[info] Tests: succeeded 17, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed Sep 7, 2016 1:20:37 AM

```

* **compile**: Baixa dependências e compila código
* **run**: Executa aplicação conforme parâmetros do arquivo de configuração
* **test**: Executa testes unitários

## Personalizando

É possível alterar o comportamento do interpretador modificando o arquivo config.xml:

```xml
<?xml version="1.0" encoding="utf-8" ?>
<files>
    <inputFile>data.csv</inputFile>
    <outputFile>result.json</outputFile>
    <singleThread>true</singleThread>
    <filter>BornOnFirstSemesterFilter</filter>
</files>
```

* **inputFile**: Caminho relativo à raiz ou absoluto do arquivo de entrada
* **outputFile**: Caminho relativo à raiz ou absoluto do arquivo de saída em formato JSON
* **single-thread**: Determina se as linhas do arquivos devem ser processadas em sequência ou de maneira concorrente
* **filter**: Filtro a ser usado no processamento do arquivo. Atualmente disponíveis são:
  * *BornOnFirstSemesterFilter*: Todos os usuários nascidos no primeiro semestre
  * *BornOnSecondSemesterFilter*: Todos os usuários nascidos no segundo semestre
  * *FemaleFilter*: Todos os usuários mulheres
  * *MaleFilter*: Todos os usuários homens

## Testes de carga

Programa foi testado com arquivos de até 40.000 registros apresentando performance e conformidade aceitáveis. Tentativas 
com 4.000.000 de registros demonstraram queda significativa de performance