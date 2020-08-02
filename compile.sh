#!/bin/bash

FILE=out
if [ -d "$FILE" ]
then
    rm -R $FILE
fi
mkdir $FILE

#### procedimiento donde no utilizamos las librerias creadas por nosotros como 
#### ficheros jar externos.
#javac --module-path /usr/share/openjfx/lib --module-source-path src  -d out $(find . -name '*.java')

### esta parte hace referencia a una librería o fichero jar que hemos creado mediante módulos
### se incorpora para poder compilar.
javac --module-path /usr/share/openjfx/lib:libs \
      -d out/ \
      --source-path	src $(find . -name *.java)

### copia los recursos para que pueda ejecutarse la aplicación.
cp -R src/main/resources $FILE/
