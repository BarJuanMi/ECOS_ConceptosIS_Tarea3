# Project_HomeWork3_PSP
Repositiorio para subir la tarea 3 de Conceptos Avanzados de Inge Soft - ECOS - UniAndes

Estructura del proyecto maven
|___ pom.xml
|___ src
||___ main
|||___ java
||||___ App.java
||||___ co
|||||___ com
||||||___ andes
|||||||___ homework
||||||||___ three
|||||||||___ business
||||||||||___ BusinessDelegate.java
||||||||||___ BusinessMathOperation.java
||||||||||___ ReadDataFile.java
|||||||||___ exception
||||||||||___ BusinessException.java
|||||||||___ validation
||||||||||___ ValidationObject.java
|||||||||___ vo
||||||||||___ OperationsAuxVO.java
||||||||||___ ResultsDataVO.java
||___ test
|||___ java
||||___ co
|||||___ com
||||||___ andes
|||||||___ homework
||||||||___ three
|||||||||___ business
|||||||||___ BusinessMathOperationTest.java

URL del proyecto:      https://github.com/BarJuanMi/ECOS_ConceptosIS_Tarea3.git

- Para descargar el proyecto:
	- Ubicarse dentro de la carpeta sobre la cual pretende descargar el proyecto
	- Con el click derecho del mouse, haga click sobre la opcion: Click Bash Here.
	- En la consola de git digitar el siguiente comando   git pull https://github.com/BarJuanMi/ECOS_ConceptosIS_Tarea3.git
	- Abrir la consola de comandos, ubicarse sobre la carpeta deonde realizo la descarga del proyecto
	- Ejecutar el comnando   mvn package
	- No es posible que la aplicacion se ejecute desde consola, dada la estructura del main quien ejecuta una interaccion con heroku.

- Ejecucion heroku
	- https://nameless-fortress-17372.herokuapp.com/calculate
	- 