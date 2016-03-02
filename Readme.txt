# Project_HomeWork3_PSP
Repositiorio para subir la tarea 3 de Conceptos Avanzados de Inge Soft - ECOS - UniAndes

Estructura del proyecto maven
|___ pom.xml
|___ src
||___ main
|||___ java
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
|||||||||___ principal
||||||||||___ App.java
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

URL del proyecto:      https://github.com/BarJuanMi/ECOS_ConceptosIS_Tarea_2.git

- Para descargar el proyecto:
	- Ubicarse dentro de la carpeta sobre la cual pretende descargar el proyecto
	- Con el click derecho del mouse, haga click sobre la opcion: Click Bash Here.
	- En la consola de git digitar el siguiente comando   git pull https://github.com/BarJuanMi/ECOS_ConceptosIS_Tarea3.git
	- Abrir la consola de comandos, ubicarse sobre la carpeta deonde realizo la descarga del proyecto
	- Ejecutar el comnando   mvn package
	- Desde consoola, Ubicarse en el directorio target/classes/ y ejecutar el comando   java co.com.andes.homework.three.principal.App

- Ejecucion
	- Sobre la consola introduzca la ruta para ser iniciado el conteo
	- Los errores y resultados seran visualizados mediante la consola de comandos