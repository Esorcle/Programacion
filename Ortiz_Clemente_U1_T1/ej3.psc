Proceso ej3
	Definir altura, i, j Como Entero;
	definir cont Como Caracter;
	
	cont<-"*";
	
	Escribir "Por favor ingrese la altura";
	leer altura;
	
	Mientras altura<3 o altura%2=0 Hacer
		Escribir "Error, ingrese un numero >= 3 e impar";
		leer altura;
	Fin Mientras
	
	Para i<-0 Hasta altura-1 Con Paso 1 Hacer
		cont=cont+"*";
	fin para
	Para i<-altura-1 Hasta 0 Con Paso -2 Hacer
		escribir sin saltar (altura-paso)/2
		escribir sin saltar cont
	Fin Para
	
	
FinProceso
