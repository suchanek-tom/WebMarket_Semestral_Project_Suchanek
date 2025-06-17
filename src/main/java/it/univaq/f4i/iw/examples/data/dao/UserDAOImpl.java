package it.univaq.f4i.iw.examples.data.dao.impl;

import it.univaq.f4i.iw.examples.data.dao.UserDAO;
import it.univaq.f4i.iw.examples.data.models.User;
import it.univaq.f4i.iw.examples.data.models.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {
    
    private final DataSource dataSource;
    
    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User getUserById(int id) {
        // JDBC implementace
    }
    
    // Ostatní metody...
}