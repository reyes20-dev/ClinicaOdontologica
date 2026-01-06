<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<h2>Registrar Nueva Persona</h2>

<html:form action="/guardarPersona" method="POST">
    <table>
        <tr>
            <td>DNI:</td>
            <td><html:text property="dni" /></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><html:text property="nombre" /></td>
        </tr>
        <tr>
            <td>Apellido:</td>
            <td><html:text property="apellido" /></td>
        </tr>
         <tr>
            <td>Telefono:</td>
            <td><html:text property="telefono" /></td>
        </tr>
         <tr>
            <td>Direccion:</td>
            <td><html:text property="direccion" /></td>
        </tr>
        <tr>
            <td>Fecha Nac:</td>
            <td><html:text property="fecha_nac" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <html:submit value="Guardar Registro" />
            </td>
        </tr>
    </table>
</html:form>