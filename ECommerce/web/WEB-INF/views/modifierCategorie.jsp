<%@page import="ecommerce.metier.Categorie"%>
<%
    Categorie categorie = (Categorie) request.getAttribute("categorie");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" lang="fr" />
        <title>Gestion Catégories</title>
    </head>
    <body>
        <h1>Gestion des Catégories :</h1>
        <form method="POST" id="form-categories" action="modifierCategorie">   
            <table>
                <tr>
                    <td>Nom :</td>
                    <td><input type="text" name="nom" value="<%=categorie.getNom() %>" /></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td>
                        <input type="text" name="description" value="<%=categorie.getDescription()%>" />
                    </td>
                </tr>
                <tr>
                    <input type="hidden" name="id" value="<%=categorie.getId() %>"   />
                    <td><input type="submit" value="Enregistrer" /></td>
                    <td><input type="reset" value="Initialiser" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>