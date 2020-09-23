/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Casa
 */
@WebServlet(name = "calcServlet", urlPatterns = {"/calcServlet"})
public class calcula extends HttpServlet {

    
          
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
           
           
           PrintWriter out = response.getWriter();
           
           String svalorA = request.getParameter("ValorA");
           String svalorB = request.getParameter("ValorB");
           String soperacao = request.getParameter("operacao");
           
           double dvalorA = Double.parseDouble(svalorA);
           double dvalorB = Double.parseDouble(svalorB);
           double resultado = 0;
           String op= soperacao;
           
            
           if (soperacao.equals("+")){
               resultado = dvalorA + dvalorB;
               
           }
           
           else if (soperacao.equals("-")){
               resultado = dvalorA - dvalorB;
               
           }
           else if (soperacao.equals("*")){
               resultado = dvalorA * dvalorB;
               
           }
           else if (soperacao.equals("/")){
               resultado = dvalorA / dvalorB;
               
           }
           
        
           out.print("Resultado:" + resultado);
       
           // Define parametros para a sessão
        double op1 =dvalorA ;
        double op2 = dvalorB; 
        double result = resultado;
        int contador = 1;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("contador")) {				
				contador = Integer.parseInt(cookie.getValue()) + 1;
				break;
			}
		}
		Cookie cookie = new Cookie("contador", String.valueOf(contador));
		response.addCookie(cookie);
		request.setAttribute("contador", contador);
		//request.getRequestDispatcher("./calculadoraweb.jsp").forward(request, response);

          
       request.setAttribute("dvalorA", op1);
       request.setAttribute("dvalorB", op2);
       request.setAttribute("resultado", result);
       request.setAttribute("soperacao", op);
 
        // Chama pagina de resposta
       request.getRequestDispatcher("/teleFinal.jsp").forward(request, response); 
       
  
           
          
    }


  
}
