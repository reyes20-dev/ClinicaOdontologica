<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Importamos las librerías de etiquetas de Struts --%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%-- Este contenido será inyectado en el layoutBase definido en tiles-defs.xml --%>
<h2>Registrar Nueva Persona</h2>

<html:form action="/guardarPersona" method="POST">
    DNI: <html:text property="dni" /><br>
    Nombre: <html:text property="nombre" /><br>
    Apellido: <html:text property="apellido" /><br>
    Teléfono: <html:text property="telefono" /><br>
    Dirección: <html:text property="direccion" /><br>
    <%-- Nota: En Struts 1 el ActionForm maneja Strings, luego convertimos a Date en la Action --%>
    Fecha Nac: <html:text property="fecha_nac" /> (yyyy-mm-dd)<br>
    
    <html:submit value="Guardar" />
</html:form>