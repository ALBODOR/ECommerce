
package ecommerce.presentation.controllers;

import ecommerce.metier.Categorie;
import ecommerce.metier.bm.CategorieManagerImpl;
import ecommerce.metier.bm.ICategorieManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALi
 */
@WebServlet(name="gestionCategorieController", urlPatterns = {"/modifierCategorie"})
public class modifierCategorieController extends HttpServlet {

    ICategorieManager categorieManager;

    @Override
    public void init() throws ServletException {
        super.init(); 
        categorieManager = new CategorieManagerImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperer les parametres POST
        Long id = Long.parseLong(request.getParameter("id"));        
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        
        // Creation d'un Modele = Categorie
        Categorie cat = new Categorie(id, nom, description);
        
        // Modifier le Modele dans la BDD
        PrintWriter output = response.getWriter();
        if(categorieManager.modifyCategorie(cat)) {
            output.println("<DOCTYPE html><html><head><title>Operation Reussie</title></head>");
            output.println("<body><h3>Categorie Bien Modifiee!</h3></body></html>");
        } else {
            output.println("<DOCTYPE html><html><head><title>Operation Echouee</title></head>");
            output.println("<body><h3>Categorie N'a Pas Ete Modifiee!</h3></body></html>");        
        }
    }

}
