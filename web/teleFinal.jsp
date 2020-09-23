<%-- 
    Document   : teleFinal
    Created on : 22/09/2020, 18:18:01
    Author     : Casa
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         
       <% 
            //&lt;c:out value="${dvalorA}"/&gt;
          
           
        double dvalorA = ((Double) request.getAttribute("dvalorA")).doubleValue();
        double dvalorB = ((Double) request.getAttribute("dvalorB")).doubleValue();
        double resultado = ((Double) request.getAttribute("resultado")).doubleValue();
        String soperacao = (String) request.getAttribute ("soperacao");
        int contador = (Integer) request.getAttribute ("contador");
         %>
         Cálculo:
         </br>            
        <% 
         
        out.print ( dvalorA);
       %>
       </br>
        <% 
       
        out.print ( soperacao);
       %>
        </br>    
       <% 
          out.print ( dvalorB);
        %>
         </br>  
         
         =
       <% 
         out.print ( resultado);
        
          %>
          
          
          </br>      
          
          O usuário já acesso este site 
           <% 
          out.print ( contador);
        %> vezes.
         </br>  
          
                
      
    </body>
</html>
