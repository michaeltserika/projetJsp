package com.example.devoir;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet1", value = "/hello-servlet1")
public class HelloServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Récupérer l'expression mathématique saisie par l'utilisateur
        String expression = request.getParameter("expression");
        String resultMessage;

        try {
            // Évaluer l'expression mathématique
            double result = evaluateExpression(expression);
            resultMessage = "Résultat : " + result;
        } catch (Exception e) {
            resultMessage = "Erreur : Expression invalide !";
        }

        // Générer une réponse HTML avec le résultat ou un message d'erreur
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Résultat de la calculatrice</h1>");
        out.println("<p>Expression : <b>" + expression + "</b></p>");
        out.println("<p>" + resultMessage + "</p>");
        out.println("<br><a href='index.jsp'>Retourner à la calculatrice</a>");
        out.println("</body></html>");
    }

    // Fonction pour évaluer une expression mathématique
    private double evaluateExpression(String expression) throws Exception {
        // Utiliser un moteur JavaScript pour traiter l'expression
        javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Évaluer l'expression et convertir le résultat en double
        Object result = engine.eval(expression);
        return Double.parseDouble(result.toString());
    }
}
