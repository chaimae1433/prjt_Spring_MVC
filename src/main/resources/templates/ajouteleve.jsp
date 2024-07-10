<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un élève</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Ajouter un élève</h2>
    <form action="ajouterEleve" method="post">
        <div class="form-group">
            <label for="cne">CNE</label>
            <input type="text" class="form-control" id="cne" name="cne" required>
        </div>
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="moyenne">Moyenne</label>
            <input type="text" class="form-control" id="moyenne" name="moyenne" required>
        </div>
        <div class="form-group">
            <label for="filiere">Filière</label>
            <select class="form-control" id="filiere" name="codeFil">
                <c:forEach var="filiere" items="${listFiliere}">
                    <option value="${filiere.codeFil}">${filiere.nomFil}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>

</body>
</html>
