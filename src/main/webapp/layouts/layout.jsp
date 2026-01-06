<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="titulo"/></title>
</head>
<body style="margin:0; font-family: sans-serif;">

    <tiles:insert attribute="header" />

    <div class="container" style="padding: 20px;">
        <tiles:insert attribute="cuerpo" />
    </div>

    <tiles:insert attribute="footer" />

</body>
</html>