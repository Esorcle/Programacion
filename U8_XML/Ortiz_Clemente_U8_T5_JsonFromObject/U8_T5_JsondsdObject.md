## U8: Tarea 5 - Generar Json desde objeto Java

Se desea generar una cadena en formato json que contenga la alineación de la selección española que ganó el mundial de Fútbol.

Se tiene por tanto, que implementar una clase Futbolista, que contenga un entero para el dorsal, un String para el nombre y una lista de dermacaciones posibles en las que puede jugar. También se tendrá un atributo (un String) para el equipo del que procede.

Los datos son los siguientes:

>1, "Casillas", ["Portero"], "Real Madrid"
15, "Ramos", ["Lateral derecho", "Medio centro"], "Real Madrid"
3, "Pique", ["Central"], "FC Barcelona"
5, "Puyol", ["Central"], "FC Barcelona"
11, "Capdevila", ["Lateral izquierdo"] "Villareal"
14, "Xabi Alonso", ["Defensa mediocampo", "Mediocampo"], "Real Madrid"
16, "Busquets", ["Defensa mediocampo"], "FC Barcelona"
8, "Xavi Hernandez", ["Mediocampo"], "FC Barcelona"
18, "Pedrito", ["Extremo izquierdo", "Falso extremo"], "FC Barcelona
6, "Iniesta", ["Extremo derecho", "Mediocampo"], "FC Barcelona"
7, "Villa", ["Delantero centro"], "FC Barcelona"

En el fichero principal por tanto, se debe crear un ArrayList de Futbolistas con la información anterior, y a partir de él y utilizando Gson generar una única String en formato Json que se deberá mostrar por pantalla.