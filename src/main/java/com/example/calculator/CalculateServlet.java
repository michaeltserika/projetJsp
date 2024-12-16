package com.example.calculator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Récupération des paramètres
        String operand1 = request.getParameter("operand1");
        String operator = request.getParameter("operator");
        String operand2 = request.getParameter("operand2");

        String resultMessage;

        try {
            // Conversion des nombres en doubles
            double number1 = Double.parseDouble(operand1);
            double number2 = Double.parseDouble(operand2);

            // Calcul en fonction de l'opérateur
            double result;
            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        throw new ArithmeticException("Division par zéro");
                    }
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Opérateur invalide");
            }

            // Générer le message de résultat
            resultMessage = "Résultat : " + result;

        } catch (NumberFormatException e) {
            resultMessage = "Erreur : Les nombres saisis sont invalides.";
        } catch (ArithmeticException e) {
            resultMessage = "Erreur : " + e.getMessage();
        } catch (Exception e) {
            resultMessage = "Erreur : " + e.getMessage();
        }

        // Générer une réponse HTML stylisée
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Résultat de Calcul</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Résultat de la Machine à Calculer</h1>");
        out.println("<p>" + resultMessage + "</p>");
        out.println("<a href='index.jsp'>Faire un autre calcul</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
