package ecommerce.presentation.controllers;

import ecommerce.metier.Categorie;
import ecommerce.metier.bm.CategorieManagerImpl;
import ecommerce.metier.bm.ICategorieManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALi
 */
@WebServlet(name = "listeCategorieController", urlPatterns = {"/listeCategorie"})
public class listeCategorieController extends HttpServlet {
    
    ICategorieManager categorieManager;

    @Override
    public void init() throws ServletException {
        super.init(); 
        categorieManager = new CategorieManagerImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Exploiter les donnees de la BDD
        ICategorieManager categorieManager = new CategorieManagerImpl();
        List<Categorie> allCategories = categorieManager.allCategories();
        
        // Passer la liste a la page JSP "listeCategorie.jsp"
        request.setAttribute("allCategories", allCategories);
        
        // Rediriger vers la page JSP
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/views/listeCategorie.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recevoir les parametres POST
        String operation = request.getParameter("operation");
        Long id = Long.parseLong(request.getParameter("id"));
        
        // Construire un objet Model
        Categorie cat = new Categorie();
        cat.setId(id);
        
        // Executer l'Operation demandée
        if(operation.equals("supprimer")) {
            categorieManager.removeCategorie(cat);
            doGet(request, response);
        } else if(operation.equals("modifier")) {
            cat = categorieManager.findCategorie(id);
            request.setAttribute("categorie", cat);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                                        "/WEB-INF/views/modifierCategorie.jsp");
            dispatcher.forward(request, response);
        }
        
    }

}
