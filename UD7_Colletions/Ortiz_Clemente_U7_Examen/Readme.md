
# Examen_Collections_Ficheros_1920_Mañana

EXAMEN COLLECTIONS - FICHEROS 10/03/2020
---
Queremos desarrollar una aplicación para la gestión de un concurso canino internacional. Para ello crearemos una clase llamada Concurso en donde guardaremos todos los perros del concurso, el nombre del concurso y la localidad en la que se va a celebrar.

Como los concursos de los perros son por razas dentro de la clase Concurso tendremos que crear la estructura de datos necesaria para acceder mediante el nombre de la raza, que es único, al conjunto de perros de dicha raza.

De cada uno de los perros debemos guardar la siguiente lista de atributos:

    El nombre del perro.
    La edad (un entero, no hace falta que sea una fecha de nacimiento).
    El peso del perro.
    Si tienen o no tienen todas las vacunas requeridas.
    El Propietario del perro.
    Y por supuesto la raza del mismo.

De los propietarios de los perros deberemos guardar a su vez los siguiente datos:

    El nombre.
    Los apellidos.
    El número de socio de la Sociedad Canina Mundial.
    El país de origen.

La clase Concurso tiene que tener los siguientes métodos:

1. Un **método addDog()** que recibe como parámetros la raza y un perro y que añadirá a la  estructura de datos ese perro en la raza determinada o mostrará un mensaje de error en caso  de que estemos intentando introducir en la raza un perro que no sea de dicha raza.
2. El **método disqualifyDog()** que recibe como parámetro un perro y lo elimina del concurso  borrándolo de la estructura de datos que contienen los datos de los perros participantes organizados por razas. En caso de ese perro no esté escrito deberá mostrar el siguiente mensaje "Perro no inscrito".
3. **El método ownerDogs()** que mostrará por pantalla todos los perros de un dueño determinado (sea de la raza que sean). Este método recibe como parámetro el número de socio de la Sociedad Canina y mostrará el mensaje "Este socio no tiene perros inscritos" en caso de que el socio no tenga ningún perro en este concurso.
4. El **método perrosporPeso()** que mostrará la lista de perros de una raza, que se recibe como parámetro, ordenados por peso de manera decreciente.
5.  El **método perrosporEdad()** que mostrará la lista de perros de una raza, que se recibe como parámetro, ordenados por edad de manera decreciente.

Como cuando hay un concurso las inscripciones de los mismos se realizan en varios días y para no perder todos los inscritos debemos también de tener dos métodos en la clase:

1. **cargarPerros()** que leerá todos los perros desde el fichero binario "perros.dat" y los colocará en el conjunto de perros de su raza.
2. **guardarPerros()** que escribirá todos los perros cargados en el fichero "perros.dat". Estos perros serán guardados de manera individual sin tener que estar, en esa estructura, organizados por raza.

Usar dicha clase y todos sus métodos en la la clase Main. Deberéis tener, al menos, 3 razas, 10 perros y 3 dueños (combinados de la manera que queráis).