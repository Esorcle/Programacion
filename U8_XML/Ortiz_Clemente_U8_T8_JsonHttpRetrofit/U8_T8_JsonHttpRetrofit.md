## U8: Tarea 8 - Entregable - JSON y peticiones HTTP con Retrofit

Teniendo en cuenta el JSON que se adjunta, intenta modelar las clase necesarias (Alumnos y Asignaturas) para realizar una petición Retrofit a la siguiente URL:

* baseUrl: https://my-json-server.typicode.com/chemaduran/json_entrega1/

* listAlumnos: (baseUrl) + /alumnos?_embed=asignaturas

La clase Alumno deberá contener un ArrayList con objetos de tipo Asignatura.

Se deberá sacar por pantalla el contenido completo del objeto Alumno correspondiente, relleno con la información recibida de la petición HTTP.