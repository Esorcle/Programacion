 ## U9: Tarea 4 - Entregable

Realiza dos transacciones:

1.  * Insertar una nueva oficina en Sevilla con dos nuevos empleados. 
    
    * Insertar un nuevo cliente que esté relacionado con uno de los empleados de la oficina nueva.
2.  Con cliente nuevo de la transacción anterior, insertar un pedido nuevo con dos productos cualesquiera.

- Para los datos, puedes abrir las diferentes tablas para comprobar a qué se refiere cada uno de los campos y el tipo que es, así te puede servir de inspiración.

- En ningún caso, la BD puede tener una oficina nueva sin empleados, un cliente sin empleado y ningún pedido sin detalles.

- Toma las decisiones de diseño que consideres necesarias, creando las clases y consultas correspondientes. Todas las consultas deberán ser preparedStatements.

3. Realiza también dos consultas para mostrar por pantalla:

    * Una consulta que muestre el nombre del cliente, el nombre del empleado que le lleva las ventas y la ciudad donde está la oficina del empleado.
    * Una consulta que muestre el nombre del cliente, la fecha y estado del pedido, el nombre de los productos del pedido, su cantidad y el precio de cada producto.

NOTA 1: No es necesario que el resultado de estas consultas sean guardadas en objetos concretos, se puede mostrar por pantalla directamente.

NOTA 2 : Desde el programa principal, para cada transacción, deberá hacerse una única llamada a función. Dentro de dicha función, todo lo necesario podrá diseñarse como se considere más óptimo.