<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="titulo"/></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        /* Fondo azul para Header y Footer */
        header, .main-footer { 
            background-color: #004a99; 
            color: white; 
            padding: 15px; 
            text-align: center; 
        }
        .content { padding: 20px; min-height: 400px; }
        table { margin-top: 20px; border-collapse: collapse; }
        td { padding: 8px; }
    </style>
</head>
<body>

    <tiles:insert attribute="header" /> 
    
    <div class="content">
        <tiles:insert attribute="cuerpo" /> 
    </div>

    <tiles:insert attribute="footer" /> 

</body>
</html>