<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="titulo"/></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; display: flex; flex-direction: column; min-height: 100vh; }
        
        /* Estilo Azul para Header y Footer */
        header, .main-footer { 
            background-color: #0056b3; 
            color: white; 
            padding: 20px; 
            text-align: center; 
        }
        
        .content { 
            flex: 1; 
            padding: 30px; 
            background-color: #f4f7f6; 
        }

        
        .form-container {
		    background: white;
		    padding: 30px; 
		    border-radius: 8px;
		    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
		    width: 50%;         
		    max-width: 1000px;   
		    margin: 40px auto;   
		}
        
    </style>
</head>
<body>

    <tiles:insert attribute="header" /> 
    
    <div class="content">
        <div class="form-container">
            <tiles:insert attribute="cuerpo" /> 
        </div>
    </div>

    <tiles:insert attribute="footer" /> 

</body>
</html>