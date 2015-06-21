
package org.dmitriy.java.web.service;

import java.sql.SQLException;
import java.util.List;

import org.dmitriy.java.web.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    User find(Integer id);
    List<User> findAll() throws SQLException;
    int save(User u);
    
}
