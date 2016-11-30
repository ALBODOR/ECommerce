<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" lang="fr" />
        <title>Page Login</title>
    </head>
    
    <body>
        <h1>Formulaire d'Authentification</h1>
        <form method="POST" action="login">
            <table>
                <tr>
                    <th><label>Login :</label></th>
                    <td><input type="text" name="login" placeholder="Entez votre login"></td>
                </tr>
                
                <tr>
                    <th><label>Mot de passe :</label></th>
                    <td><input type="password" name="password" placeholder="Entez votre mot de passe"></td>
                </tr>
                
                <tr>
                    <th></th>
                    <th><input type="submit" value="S'athentifier"></th>
                </tr>
                
                <tr>
                    <th></th>
                    <th><input type="checkbox" />Se souvenez de moi</th>
                </tr>
            </table>
        </form>
    </body>
</html>



