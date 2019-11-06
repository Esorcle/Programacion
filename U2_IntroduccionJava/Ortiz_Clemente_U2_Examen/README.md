# U2_Examen
*Condicionales, Bucles y cadenas*
---


Ejercicio 1:
---

Con motivo de la celebración del día de la mujer, el 8 de marzo, nos han encargado realizar un programa que pinte un 8 por pantalla usando la letra M. Se pide al usuario la altura, que debe ser un número entero impar mayor o igual que 5. Si el número introducido no es correcto, el programa deberá mostrar un mensaje de error. A continuación se muestran algunos ejemplos. La anchura de la figura siempre será de 6 caracteres.

> Ejemplo 1:
Por favor, introduzca la altura (número impar mayor o igual a 5): 8
La altura introducida no es correcta

> Ejemplo 2:
Por favor, introduzca la altura (número impar mayor o igual a 5): 3
La altura introducida no es correcta

> Ejemplo 3:
Por favor, introduzca la altura (número impar mayor o igual a 5): 5
MMMMMM
M    M
MMMMMM
M    M
MMMMMM

> Ejemplo 4:
Por favor, introduzca la altura (número impar mayor o igual a 5): 9
MMMMMM
M    M
M    M
M    M
MMMMMM
M    M
M    M
M    M
MMMMMM


Ejercicio 2:
---
Escribe un programa que permita partir un número introducido por teclado en dos partes. Las posiciones se cuentan de izquierda a derecha empezando por
el 1. Suponemos que el usuario introduce correctamente los datos, es decir, el número introducido tiene dos dígitos como mínimo y la posición en la que
se parte el número está entre 2 y la longitud del número. No se permite en este ejercicio el uso de funciones de manejo de String (por ej. para extraer
subcadenas dentro de una cadena).

> Ejemplo:
Por favor, introduzca un número entero positivo: 406783
Introduzca la posición a partir de la cual quiere partir el número: 5
Los números partidos son el 4067 y el 83.

Ejercicio 3:
---
Realiza un programa que diga los dígitos que aparecen y los que no aparecen en un número entero introducido por teclado. El orden es el que se muestra en
los ejemplos. Utiliza el tipo long para que el usuario pueda introducir números largos.

> Ejemplo 1:
Introduzca un número entero: 67706
Dígitos que aparecen en el número: 0 6 7
Dígitos que no aparecen: 1 2 3 4 5 8 9

> Ejemplo 2:
Introduzca un número entero: 555
Dígitos que aparecen en el número: 5
Dígitos que no aparecen: 1 2 3 4 6 7 8 9

> Ejemplo 3:
Introduzca un número entero: 9876543210
Dígitos que aparecen en el número: 0 1 2 3 4 5 6 7 8 9
Dígitos que no aparecen:

> Ejemplo 4:
Introduzca un número entero: 13247721
Dígitos que aparecen en el número: 1 2 3 4 7
Dígitos que no aparecen: 0 5 6 8 9

Ejercicio 4:
---
Realiza un programa que calcule el máximo, el mínimo y la media de una serie de números enteros positivos introducidos por teclado. El programa terminará
cuando el usuario introduzca un número primo. Este último número no se tendrá en cuenta en los cálculos. El programa debe indicar también cuántos
números ha introducido el usuario (sin contar el primo que sirve para salir).

> Ejemplo:
Por favor, vaya introduciendo números enteros positivos. Para terminar, introduzca un número primo:
6
8
15
12
23
Ha introducido 4 números no primos.
Máximo: 15
Mínimo: 6
Media: 10.25

Ejercicio 5:
---
Dada una cadena mostrar por pantalla la cantidad de vocales que tiene. 

> Ejemplo:
Entrada: cad = "Hola tu"
Salida: La cantidad de vocales es 3
