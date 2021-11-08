# EboraIT
Laboratorio Ingeniería del Software II

## Descripción del problema 🔨
Las tarea práctica consiste en la realización de un proyecto (durante todo el cuatrimestre) de desarrollo software siguiendo los métodos y técnicas de ingeniería del software vistas en teoría así como aplicando las herramientas que se irán presentando en algunas sesiones de prácticas.

## Resolución del problema 🔨
Para desarrollar dicho problema hemos ido desarrollando una metodología ágil, también con ayuda de projects de Github hemos podido ir creando tickets con tareas las cuales hemos ido resolviendo, el tipo de projects utilizado es Kanban. Teniamos 3 columnas las cuales eran:
* **To do** , aquí situamos las tareas o progresos que teniamos plantado hacer.
* **In progress**, aquí situamos las tareas o progresos que estamos haciendo en ese momento.
* **Done**, y por último aquí estarán las tareas ya completadas.

Todo esto utilizado como Product Backlog del cúal luego hemos ido seleccionando historias de usuarios para realizar los Sprint Backlog durante el proyecto.
El enlace para visitar nuestro project sería [Product Backlog](https://github.com/escolanojorge/eborait/projects/2)

Además durante el desarrollo del problema se han ido realizando reuniones entre los miembros de la empresa para ir poniendo todo a punto y resolver posibles dudas de las que se pedía en el enunciado.
 
Hemos considerado en dividir el problema en las 3 capas habituales utilizadas en un proyecto.
* **[Dominio](./GSNS/src/main/java/com/eborait/gsns/dominio)** , esta la hemos utilizado para dividir también en dos paquetes:
	* **[Controller](./GSNS/src/main/java/com/eborait/gsns/dominio/controller)**, en controller tendremos los gestores los cuales más tarde se encargaran de llamar a las clases DAO. Estos comunmente harán referencias a insetar,mostrar o actualizar datos.
	* **[Entitymodel](./GSNS/src/main/java/com/eborait/gsns/dominio/entitymodel)**, en este paquete estarán las clases con sus metodos getters y setter así como los toString de cada una de ellas. 
* **[Persistencia](./GSNS/src/main/java/com/eborait/gsns/persistencia)** , en esta capa tendremos mayormente las clases DAO de Entrega,LoteVacunas y VacunacionDAO, tendremos también las clase DAOFactory la cual se usará para crear los objetos DAO siguiendo el patron singleton. También tendremos la clase BDConstantes en la cual vamos a tener todos los datos para instanciar nuestra BD. Y por último implementamos en este paquete la clase AbstractEntityDAO en la que definimos los métodos para implementar en los DAO.
* **[Persistencia](./GSNS/src/main/java/com/eborait/gsns/presentacion)** , en esta última capa tendremos las vistas en forma de JPanel para la parte gráfica de nuestro proyecto.

También hacemos referencia al [POM](./GSNS/pom.xml), en el cual hemos declarado y utilizado las dependencias de junit y de apache.derby esta última para utilizar una Base de Datos embebida. Además de los plugins de Maven. También destacar que este fichero lo hemos utilizado a cada version, por lo tanto para el versionado de la aplicación. 

## Autores ✒️

_Proyecto creado por_ 
* **Roberto Esteban Olivares** 
* **Jorge Fernandez Escolano** 

## Construido con 🛠️

_Las tecnologías utilizadas para el desarrollo del proyecto son:_

⚙️Java <br>
