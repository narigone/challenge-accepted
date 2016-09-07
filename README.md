## Introdução

Interpretador de arquivos CSV com interface de filtros programáveis

## Inicialização do software

Uma vez baixado o software, basta chamar a Simple Build Tool (sbt):

```
$ sbt
[info] Loading project definition from /home/raphael/IdeaProjects/challenge-accepted/project
[info] Set current project to challenge-accepted (in build file:/home/raphael/IdeaProjects/challenge-accepted/)
> clean
[success] Total time: 0 s, completed Sep 6, 2016 9:06:45 PM
> compile
[info] Updating {file:/home/raphael/IdeaProjects/challenge-accepted/}root...
[info] Resolving jline#jline;2.12.1 ...
[info] Done updating.
[info] Compiling 10 Scala sources to /home/raphael/IdeaProjects/challenge-accepted/target/scala-2.11/classes...
[success] Total time: 3 s, completed Sep 6, 2016 9:06:51 PM
> run
[info] Running br.com.ideiainteligencia.challengeAccepted.ChallengeAccepted
[success] Total time: 1 s, completed Sep 6, 2016 9:06:57 PM
>
```

## Personalizando

É possível alterar o comportamento do interpretador modificando o arquivo config.xml:

```xml
<?xml version="1.0" encoding="utf-8" ?>
<files>
    <inputFile>mock.csv</inputFile>
    <outputFile>result.json</outputFile>
    <dateFormat>yyyy-mm-dd</dateFormat>
    <filter>BornOnFirstSemesterFilter</filter>
</files>
```

**inputFile**: Caminho relativo à raiz ou absoluto do arquivo de entrada
**outputFile**: Caminho relativo à raiz ou absoluto do arquivo de saída em formato JSON
**dateFormat**: Formato de entrada da data de aniversário. Caso mude a entrada, a máscara deve ser alterada
**filter**: Filtro a ser usado no processamento do arquivo. Atualmente disponíveis são:
  *BornOnFirstSemesterFilter*: Todos os usuários nascidos no primeiro semestre
  *BornOnSecondSemesterFilter*: Todos os usuários nascidos no segundo semestre
  *FemaleFilter*: Todos os usuários mulheres
  *MaleFilter*: Todos os usuários homens

