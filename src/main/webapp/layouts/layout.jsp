<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="titulo"/></title>
</head>
<body>
    <header>
        <h1>Mi Clínica Profesional</h1>
        <hr>
    </header>

    <main>
        <tiles:insert attribute="cuerpo"/>
    </main>

    <footer>
        <hr>
        <p>&copy; 2023 Sistema Odontológico</p>
    </footer>
</body>
</html>