U4_U5_Examen_1920_Turno_Mañana

EXAMEN UNIDADES 4 y 5_CURSO 19-20 TURNO MAÑANA

Debemos crear una clase RPG. Esta clase contendrá una LISTA de Personajes que gestionará y que nunca podrá exceder de 10.

Los Personajes son una clase no instanciable de los que guardaré:

    El nombre
    La energía (entre 0 y 1000)
    La capacidad de ataque (entre 0 y 100)
    La capacidad de defensa (entre 0 y 100).
    Si están encantados o no.

En relación a la lista de personajes debo de tener en cuenta que:

    En cualquier momento puedo añadir un Personaje pero nunca podré tener más de 10.
    En la lista de personajes nunca puedo tener un personaje muerto (energía menor o igual a cero). Si existe debo de actualizar la lista para borrarlo. Para ello debo implementar el método borrarMuertos().
    Puedo mostrar el estado de la partida sacando por pantalla la información de todos los personajes ordenados por energía. Lo hará mediante el uso del método mostrarEstado() aunque adicionalmente puedo mostrarlos ordenados por capacidad de ataque o de defensa mediante los métodos mostrarxAtaque() o mostrarxDefensa().
    Debo de tener también un método hayGanador() que me diga cuando hay un sólo jugador vivo y que muestre toda su información por pantalla declarándolo ganador.

Aunque los personajes no son instanciables tengo a su vez distintos tipos:

    Elfos de los que guardaré también el tipo (BOSQUE o COSTA).
    Orcos de los que guardaré el tonelaje.
    Enanos de los que guardaré la altura.
    Y otra clase no instanciable Hombres de la que derivan Guerreros de los que me guardo la edad y Magos de los que me guardo la longitud de la barba.

Todas estas clases deben implementar su propio método toString() para mostrar toda la información.

No todos los personajes se comportan igual:

    Elfos, Orcos, Enanos y Guerreros implementarán el interfaz Atacar que contiene un método atacarPersonaje() que recibe un personaje como parámetro. Cada uno de ellos sacará por pantalla un grito diferente con su nombre cuando lo ejecute. Por ejemplo "GIMLI - ATACANDO".
    Los Magos implementarán el interfaz Magia que contiene dos funciones encantar()  y desencantar() que reciben un Personaje como parámetro y cuya implementación por defecto es que cambian el estado de encantamiento del personaje recibido.

Al la hora de producirse el ataque debemos de tener en cuenta (además de que debo sacar por pantalla el grito de guerra) lo siguiente:

    Si el Personaje atacado es del mismo tipo del que ataca no se producirá daño.
    En caso contrario el daño producido sigue la siguiente fórmula:

Energía_del_atacado = Energía_anterior - (Capacidad de Ataque del atacante -  Capacidad de defensa del atacado)

Si el personaje atacado está encantado se multiplicará lo que va entre paréntesis por 2.

Todos los atributos deben ser privados.

Crear en el Main un ejemplo de partida que contenga al menos 5 personajes, que muestre al menos 5 ataques que provoquen algún muerto, dos encantamientos y que tras todo eso muestre la lista de personajes atendiendo a todos los criterios solicitados:
