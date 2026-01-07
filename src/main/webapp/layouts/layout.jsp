<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="titulo"/></title>
</head>
<body>

    <tiles:insert attribute="header" /> 
    
    <div class="content">
        <tiles:insert attribute="cuerpo" /> 
    </div>

    <tiles:insert attribute="footer" /> </body>
    
</html>