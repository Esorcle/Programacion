# U8_T2_Entregable_1920:Modificación_con_DOM_Guardado_a_fichero


Utilizando el xml que habéis creado en la práctica U8_T1

* Crear una clase ModificarDOM que en el main de esa misma clase, que es el método que se ejecutará, debe:
  * Carga el contenido del XML en la estructura DOM.
  * Añadir antes de cada nodo hijo de tipo etiqueta(en el ejemplo los nodos hijos eran <persona>  esiguiente comentario <!-- COMENTARIO AÑADIDO DESDDOM -->
  * Añadir un nueva etiqueta hija (en el ejemplo unnueva persona) como último hijo
  * Crear un nuevo nodo etiqueta (en el ejemplo unnueva persona) y reemplazar la primera etiquethija por ese nodo creado.
  * Volcar todo a un fichero XML llamado dom_modificadxml
  
* Crear una clase DomDesdeCero en cuyo main debes:
  * Crear un ArrayList con al menos 10 objetos. Dichos objetos deben tener al menos 4 atributos. La clase del Objeto deberá crearse en un fichero aparte.
  * Usando DOM volcar el contenido de ese ArrayList al fichero XML cero.xml
