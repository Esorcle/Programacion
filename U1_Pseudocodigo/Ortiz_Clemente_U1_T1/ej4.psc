Proceso ej4
	definir cad, i Como Entero
	definir respuesta Como caracter
	dimension cad[20];
	
	Para i<-0 Hasta 19 Con Paso 1 Hacer
		cad[i]=azar(400)+1;
		Escribir "Los numeros son: ", cad[i];
	Fin Para
	
	escribir "¿quieres resaltar los multipos de 5 o e 7?"
	Leer respuesta;
	
	Si respuesta= "Si" o respuesta= "si" Entonces
		Para i<-0 Hasta 19 Con Paso 1 Hacer
			si cad[i]%5=0 o cad[i]%7=0 Entonces
				Escribir "[", cad[i],"]" 
			sino
				escribir cad[i];
			FinSi
		Fin Para
	Fin Si
FinProceso
