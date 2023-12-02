/**
 * Los metodos guardan variables llamadas "contexto" (Valores actuales de las variables en ese momento),
 * tambien los metodos recursivos tienen la desventaja de que no guarda automaticamente en el stack, siempre compara los
 * beneficios a las contras antes de integrar este metodo

 * Hay 3 formas generales:
 *  1- Se realiza una llamada recursiva después de las operacioes con el espacio de busqueda
 *  2- Dos o más llamadas recursivas después de las operaciones
 *  3- Dos o más llamadas recursivas antes de las operaciones

 * (Espacio de busqueda = Datos disponibles sobre los que va a trabajar)
 * (Infijo: Primero a la izquierda y luego a la derecha)
 * (Prefijo: Primero a la derecha, luego al centro y luego a la izquierda)
 * (Postfijo: )

 *      •Tipo Funciión-recursiva (Espacio de búsqueda, párametros):
 *      1- Puede acabar la recursión con éxito o fracaso? Devolver un valor o salir
 *      2- Operaciones con el espacio de búsqueda )si aplica)
 *      3- Modificación de parámetros (por cada caso posible)
 *      4- LLamar función-recursiva (espació de búsqueda, nuevos parámetros)

 *      •Tipo Función-iterativa (Espacio de búsqueda, párametros)
 *        •Repetir mientras el paso 1 sea falso
 *        1- Puedo terminar con éxito o fracaso?
 *        2- Operaciones con el espacio de búsqueda (si aplica)
 *        3- Modificación de parámetros (Por cada caso posible)
 *
 *
 *
 */