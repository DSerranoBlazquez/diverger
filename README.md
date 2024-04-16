Para ejecutar el proyecto se puede proceder de diferentes modos

La primera de ellas, la cual a la vez permite una mejor visualización del entorno sería clonar el proyecto desde GitHub para su posterior importación en un IDE como Eclipse 

Puedes seguir estos pasos:

Abre una terminal o línea de comandos en tu sistema operativo.

Utiliza el comando git clone seguido de la URL del repositorio de GitHub para clonarlo en tu máquina local. 
La URL del repositorio diverger es https://github.com/DSerranoBlazquez/diverger.git, así que se debe ejecutar el siguiente comando:

git clone https://github.com/DSerranoBlazquez/diverger.git

Una vez ejecutado el comando, Git descargará todos los archivos del repositorio diverger en un nuevo directorio llamado diverger en tu sistema local estando listo para su importación.

Se debe importar como gradle project

Para ejecutar la aplicación bastaría con ejecutarla con la siguiente opción
![image](https://github.com/DSerranoBlazquez/diverger/assets/91055694/a7b1911a-e015-47b5-8ea3-a15150bc3b12)

En caso de no funcioanr se puede hacer previamente gradle build y debería de funcionar correctamente (los test falláran pues no están correctamente implementados)

Una vez arrancada la app, para ver el resultado de la petición se debe hacer la llamada

http://localhost:8080/swapi-proxy/person-info?name=luke

pudiendo cambiar el nombre luke por el deseado. Para ello se puede ejecutar desde el navegador o desde Postman si así lo desea

![image](https://github.com/DSerranoBlazquez/diverger/assets/91055694/05c48dfd-65a4-4226-97a1-2d3cae00a5d6)
![image](https://github.com/DSerranoBlazquez/diverger/assets/91055694/bc6058e5-dd20-4c78-8926-11194a804e6f)

También se puede generar un archivo jar ejecutable con el siguiente comando

![image](https://github.com/DSerranoBlazquez/diverger/assets/91055694/0a46c66f-a5d5-4acd-8073-5d1dfaeb4aa1)

Este archivo se generará en la ruta starwars\build\libs (dependiendo de donde haya situado originalmente el proyecto)
Una vez generado se puede ejecutar el comando java -jar "nombre-jar-generado".jar y se debería levantar en la dirección (http://localhost:8080) como se hizo anteriormente desde el IDE

Por otro lado, para la implementación de los test y la dockerización, hablaría con el equipo que llevase la infraestructura del proyecto, pues al no haber trabajado con Gradle previamente, desconozco la implementación
de estas dependencias y no he logrado que funcione como lo haría con Maven. 

He dejado un breve esquema de testUnitario de como sería la estructura inicial de la prueba funcional.

El proyecto consta de un único commit, pero inicialmente creé las entidades de la parte model y sus correspondientes dto.
A continuación desarrollé el controlador y el servicio inicial, que luego fui compartimentando por funcionalidades en otros servicios, como el mapperUtils.
Es la idea original, pero puede haber otras alternativas. Ante la duda hablaría con el arquitecto del proyecto/lider técnico si lo hubiese para decidir la mejor implementación en cuanto a estructura, para adaptarme al funcionamiento del proyecto ya existente.
