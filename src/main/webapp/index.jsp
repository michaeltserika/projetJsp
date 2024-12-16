<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Machine à Calculer</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h1>Machine à Calculer</h1>
    <form action="calculate" method="get">
        <label for="operand1">Entrez le premier nombre :</label>
        <input type="number" id="operand1" name="operand1" required>

        <label for="operator">Sélectionnez l'opérateur :</label>
        <select id="operator" name="operator" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>

        <label for="operand2">Entrez le deuxième nombre :</label>
        <input type="number" id="operand2" name="operand2" required>

        <button type="submit">Calculer</button>
    </form>
</div>
</body>
</html>
