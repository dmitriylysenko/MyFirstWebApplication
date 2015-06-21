
package org.dmitriy.java.web.service;

import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.dmitriy.java.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;



@Repository(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
   @Autowired
    SessionFactory sf;
    
    @Override
    public List<User> findAll() throws SQLException {
        return sf.getCurrentSession().createQuery("from User").list();
    }
    
    @Override
    public int save(User u) {
        return  (Integer) sf.getCurrentSession().save(u);
    }
    
    @Override
    public User find(Integer id) {
        return (User) sf.getCurrentSession().get(User.class, id);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User user = null;
        
        try {
            Query q = sf.getCurrentSession().createQuery("from User u where u.email = :email");
            q.setString("email", string);
            List<User> users = q.list();
            if (users.isEmpty()) {
                throw new UsernameNotFoundException("User " + string + " not found");
            } else {
                return users.get(0);
            }
        } catch (Exception e) {
            System.err.println("ohshit");
        }
        return null;
    }
}
