package it.univaq.f4i.iw.examples.controller;

import it.univaq.f4i.iw.examples.data.models.Role; // Nový import pro role
import it.univaq.f4i.iw.examples.data.models.User; // Upravený import pro vašeho uživatele
import it.univaq.f4i.iw.examples.application.ApplicationDataLayer;
import it.univaq.f4i.iw.examples.application.ApplicationBaseController;
import it.univaq.f4i.iw.framework.data.DataException;
import it.univaq.f4i.iw.framework.security.SecurityHelpers;
import it.univaq.f4i.iw.framework.view.TemplateManagerException;
import it.univaq.f4i.iw.framework.view.TemplateResult;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends ApplicationBaseController {

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, TemplateManagerException {
        TemplateResult result = new TemplateResult(getServletContext());
        request.setAttribute("referrer", request.getParameter("referrer"));
        result.activate("login.ftl.html", request, response);
    }

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, DataException {
        String username = request.getParameter("u");
        String password = request.getParameter("p");

        ApplicationDataLayer dl = (ApplicationDataLayer) request.getAttribute("datalayer");
        if (!username.isEmpty() && !password.isEmpty()) {
            User u = dl.getUserDAO().getUserByName(username);
            try {
                if (u != null && SecurityHelpers.checkPasswordHashPBKDF2(password, u.getPassword())) {
                    // Vytvoření session
                    SecurityHelpers.createSession(request, username, u.getKey());
                    
                    // Uložení celého uživatelského objektu do session
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    
                    // Přesměrování podle role
                    String redirectPage = determineRedirectPage(u);
                    
                    // Ošetření referreru
                    if (request.getParameter("referrer") != null) {
                        response.sendRedirect(request.getParameter("referrer"));
                    } else {
                        response.sendRedirect(redirectPage);
                    }
                    return;
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Přesměrování zpět na login s chybovou hláškou
        response.sendRedirect("login?error=1");
    }

    // Metoda pro určení přesměrování podle role
    private String determineRedirectPage(User user) {
        switch (user.getRole()) {
            case PURCHASER:
                return "purchaser/dashboard";
            case TECHNICIAN:
                return "technician/dashboard";
            case ADMIN:
                return "admin/dashboard";
            default:
                return "homepage";
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Přidání kontroly chybového parametru
        if (request.getParameter("error") != null) {
            request.setAttribute("error", "Neplatné přihlašovací údaje");
        }
        
        if (request.getParameter("login") != null) {
            action_login(request, response);
        } else {
            String https_redirect_url = SecurityHelpers.checkHttps(request);
            request.setAttribute("https-redirect", https_redirect_url);
            action_default(request, response);
        }
    }
}