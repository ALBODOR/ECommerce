<%@page import="ecommerce.metier.Categorie"%>
<%@page import="java.util.List"%>
<%

    List<Categorie> categories = (List<Categorie>) 
                                        request.getAttribute("allCategories");   

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Liste des Catégories</title>
    </head>
    <body>
        <h1>Catalogue des CatÃ©gories :</h1>
        <form role="form">
            <table>
                <thead>
                    <tr>
                        <th>Id_Catégorie</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Categorie cat : categories) { %>
                    <tr>
                        <td><%= cat.getId() %></td>
                        <td><%= cat.getNom()%></td>
                        <td><%= cat.getDescription()%></td>
                        <td>
                            <form method="POST" action="listeCategorie" >
                                <input type="hidden" name="operation" value="modifier" />
                                <input type="hidden" name="id" value="<%=cat.getId() %>" />
                                <input type="submit" value="Modifier" />
                            </form>
                            <form method="POST" action="listeCategorie" >
                                <input type="hidden" name="operation" value="supprimer" />
                                <input type="hidden" name="id" value="<%=cat.getId() %>" />
                                <input type="submit" value="Supprimer" />
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                <tfoot>  
                    <tr>
                        <th colspan="4">
                            <button>Nouveau</button>
                        </th>
                    </tr>
                </tfoot>
            </table>
        </form>
    </body>
</html>