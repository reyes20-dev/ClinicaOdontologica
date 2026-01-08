<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Pacientes</title>
</head>
<body>
    <div style="margin: 20px;">
        <%-- Título dinámico: Si el DNI ya está en el form, estamos editando --%>
        <h2>
            <c:choose>
                <c:when test="${not empty personaForm.dni}">
                    Actualizar Datos del Paciente
                </c:when>
                <c:otherwise>
                    Registrar Nueva Persona
                </c:otherwise>
            </c:choose>
        </h2>

        <html:form action="/guardarPersona" method="post">
            <%-- Campo oculto que decide si llamar a 'editar' o 'crear' en el Java --%>
            <input type="hidden" name="action" value="${not empty personaForm.dni ? 'editar' : 'crear'}">

            <table cellpadding="5">
                <tr>
                    <td>DNI:</td>
                    <td>
                        <html:text property="dni" readonly="${not empty personaForm.dni}" />
                    </td>
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
                    <td>Teléfono:</td>
                    <td><html:text property="telefono" /></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><html:text property="direccion" /></td>
                </tr>
                <tr>
                    <td>Fecha Nacimiento(yyyy-mm-dd):</td>
                    <td><html:text property="fecha_nac" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="padding-top: 20px;">
                        <html:submit value="Guardar Datos" />                      
                    </td>
                </tr>
            </table>
        </html:form>
    </div>
</body>
</html>