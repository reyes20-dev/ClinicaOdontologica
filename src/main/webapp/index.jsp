<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro Clínica</title>
    </head>
    <body>
        <h1>Registrar Nueva Persona</h1>
        <form action="SvPersona" method="POST">
            DNI: <input type="text" name="dni"><br>
            Nombre: <input type="text" name="nombre"><br>
            Apellido: <input type="text" name="apellido"><br>
            Teléfono: <input type="text" name="telefono"><br>
            Dirección: <input type="text" name="direccion"><br>
            Fecha Nac (yyyy-mm-dd): <input type="text" name="fecha_nac"><br>
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>