Proceso ej1
	Definir sueldo, horas, horasRes Como Entero
	
	Escribir "Deme el numero de horas realizadas en la semana";
	Leer horas;
	horasRes=horas - 40;
	
	Si horas <= 40 Entonces
		sueldo=horas*10
	SiNo
		sueldo= (40*10)+ (horasRes*15);
	FinSi
	
	Escribir "el sueldo semanal es :", sueldo, " euros"
FinProceso
