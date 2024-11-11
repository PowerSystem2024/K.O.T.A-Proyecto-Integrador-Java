# K.O.T.A Knights Of The Algoritmo
## Proyecto Integrador Java

Repositorio para el Trabajo Final en Java para el equipo K.O.T.A Knights Of The Algoritmo. Para la Tecnicatura en programacion en la UTN sede San Rafel. 

Integrantes : 

-Franco Poblete

-Maxi Montenegro

El juego puede ser ejecutado ademas por fuera de un IDE desde el exe en la carpeta Ejecutable. Si desea compilarlo usted aqui le dejamos la documentacion de como hacerlo.
![imagen](https://github.com/user-attachments/assets/d1385afd-f79a-4004-849a-013c414ac058)

### Documentación para Compilar y Ejecutar el Juego de Batalla Naval en Java por fuera de netbeans.

### Requisitos Previos
    
Instalar JDK: Asegúrate de tener instalado el Java Development Kit (JDK). Puedes verificar la instalación ejecutando javac -version y java -version en la terminal o     consola. Si no aparece la versión, instala el JDK y configura las variables de entorno (JAVA_HOME y PATH).

Estructura del Proyecto:

Tu proyecto debe tener una estructura de carpetas que separe el código fuente (src) y los archivos compilados (out). Por ejemplo:

BatallaNavalJava/

├── src/

│   ├── maingame/

│   │   ├── MainGame.java

│   │   └── (otros archivos .java)

├── out/ (salida para archivos compilados)

├── Manifest.txt

#### Paso 1: Compilar el Código Fuente

Navega hasta el Directorio del Proyecto: Abre una terminal y navega hasta la carpeta raíz del proyecto (BatallaNavalJava).

Compila el Proyecto: Ejecuta el siguiente comando para compilar el código fuente y almacenar los archivos .class en la carpeta out:

    javac -d out -sourcepath src src/maingame/MainGame.java

Este comando toma MainGame.java como clase principal y compila todas las dependencias en el mismo paquete.

Verifica la Compilación: Tras la compilación, verifica que la carpeta out contenga el árbol de directorios con los archivos .class.

#### Paso 2: Crear el Archivo JAR Ejecutable

  Crear el Archivo de Manifesto: Asegúrate de tener un archivo Manifest.txt en el directorio raíz del proyecto (BatallaNavalJava/). El contenido del archivo Manifest.txt debe ser:

Main-Class: maingame.MainGame

Esto le indica al JAR qué clase contiene el método main.

Crear el JAR: Ejecuta el siguiente comando para empaquetar el proyecto en un archivo JAR:

      jar cfm BatallaNavalJava.jar Manifest.txt -C out .

Este comando crea un archivo JAR ejecutable llamado BatallaNavalJava.jar en el directorio actual, incluyendo el manifiesto y todos los archivos .class del directorio out.

Verificar el JAR: Puedes verificar que el JAR está correctamente configurado ejecutando:

      jar tf BatallaNavalJava.jar

Deberías ver una lista de archivos .class y el manifiesto.

#### Paso 3: Ejecutar el Juego en Java

Para ejecutar el juego, simplemente utiliza el siguiente comando:

      java -jar BatallaNavalJava.jar

#### Paso 4: Ejecutar el Juego sin Comandos en Consola en Windows y crear un EXE con Launch4j

Para ejecutar el juego sin consola en Windows:

Launch4j  permite envolver el archivo JAR en un ejecutable (EXE) para Windows, lo que facilita su ejecución sin consola y ayuda a mantener el programa abierto hasta que termine por completo.

    1 Descargar y abrir Launch4j: Si aún no tienes Launch4j, descárgalo y ejecútalo.

    2 Configurar el archivo JAR:
        En "Output file", selecciona la ruta y nombre del archivo .exe que deseas crear.
        En "Jar", selecciona el archivo BatallaNavalJava.jar.
        En la pestaña HEADER marca header type CONSOLE.

    3 Especificar la ruta del JDK o JRE (opcional):
        En "JRE", selecciona la versión mínima de Java que tu aplicación necesita (por ejemplo, 1.8.0 para Java 8).
        Si es necesario, configura una ruta de JRE específica en la máquina donde correrá el programa.

    4 Definir comportamiento en caso de error:
        En "Err Title" y "Err Message", puedes personalizar los mensajes de error que aparecerán si el JAR falla al ejecutarse.

    5 Generar el EXE:
        Guarda el proyecto y haz clic en el ícono de "Engranaje" para crear el archivo EXE.
        El archivo EXE resultante ejecutará tu juego sin abrir una consola.

    6 Probar el EXE:
        Ejecuta el EXE para verificar que el juego se abre sin consola y se mantiene abierto hasta que el usuario lo cierre.

#### Posibles Errores y Soluciones

  Error no main manifest attribute: Verifica que Manifest.txt está correctamente configurado con Main-Class y que el archivo JAR fue creado usando -cfm. Y que tenga una linea en blanco al final.
  
  Error de archivo no encontrado: Asegúrate de que las rutas especificadas (como src/maingame/MainGame.java) son correctas.
