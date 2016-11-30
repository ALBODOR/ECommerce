<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" lang="fr" />
        <title>Gestion Produits</title>
    </head>
    <body>
        <h1>Gestion des Produits :</h1>
        <form id="form-produits">
            <label >Name :</label>
            <input type="text" name="nom" />
            
            <label >Description :</label>
            <textarea form="form-produits"></textarea>
            
            <label>Prix :</label>
            <input type="number" name="prix" />
            
            <label>Quantité :</label>
            <input type="number" name="quantite"/>
            
            <label>Catégorie :</label>
            <select name="categorie">
                <option value="1" >Tablet</option>
                <option value="2" >Smartphone</option>
            </select> 

            <input type="submit" value="Enregistrer" />
            <input type="reset" value="Initialiser" />
        </form>
    </body>
</html>