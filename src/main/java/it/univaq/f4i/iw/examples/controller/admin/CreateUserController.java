package it.univaq.f4i.iw.examples.application.controller.admin;

import it.univaq.f4i.iw.examples.data.dao.UserDAO;
import it.univaq.f4i.iw.examples.data.dao.impl.UserDAOImpl;
import it.univaq.f4i.iw.examples.data.models.User;
import it.univaq.f4i.iw.examples.data.models.Role;
import it.univaq.f4i.iw.framework.security.SecurityHelpers;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/admin/create-user")
public class CreateUserController extends HttpServlet {
    
    private UserDAO userDAO;
    
    @Override
    public void init() {
        // Inicializace DAO z kontextu
        DataSource ds = (DataSource) getServletContext().getAttribute("dataSource");
        userDAO = new UserDAOImpl(ds);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
        try {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            
            // Hashování hesla
            String plainPassword = request.getParameter("password");
            user.setPassword(SecurityHelpers.hashPassword(plainPassword));
            
            user.setRole(Role.valueOf(request.getParameter("role")));
            
            userDAO.saveUser(user);
            
            // Přesměrování po úspěchu
            response.sendRedirect(request.getContextPath() + "/admin/users?success=1");
            
        } catch (Exception e) {
            throw new ServletException("Error creating user", e);
        }
    }
}