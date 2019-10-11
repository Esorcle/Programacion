Proceso ej2
	
	Definir  posicion, i Como entero;
	Definir num, digito Como Caracter;
	
	Escribir "Por favor, introduzca un número entero positivo";
	leer num;
	
	Escribir "Introduzca la posición dentro del número";
	leer posicion;
	
	Escribir "Introduzca el nuevo dígito";
	leer digito;
	
	Para i<-0 Hasta Longitud(num)-1 Con Paso 1 Hacer
		si i=posicion-1 Entonces
			escribir sin saltar digito;
		sino 
			Escribir sin saltar Subcadena(num, i, i);
			
		FinSi
		
	Fin Para
	
FinProceso
