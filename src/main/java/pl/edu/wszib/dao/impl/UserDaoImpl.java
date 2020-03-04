package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.Product;
import pl.edu.wszib.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> usertMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.usertMap = new HashMap<>();
        prepareUsersList();
    }


    @Override
    public List<User> getUsers() {
        return new ArrayList<>(usertMap.values());
    }

    @Override
    public void saveUser(User user) {
        if(user.getId()<1){
            user.setId(id);
            id++;
        }
        usertMap.put(user.getId(),user);
    }

    @Override
    public void removeUser(Long id) {
    usertMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return usertMap.get(id);
    }


    private void prepareUsersList() {
        User user1 = new User();
        user1.setAge(50);
        user1.setCountry("Polska");
        user1.setEmail("mietek@abc.pl");
        user1.setLogin("mietek");
        user1.setAvailable(true);
        saveUser(user1);

        User user2 = new User();
        user2.setAge(60);
        user2.setCountry("Polska");
        user2.setEmail("franek@abcd.pl");
        user2.setLogin("franek");
        user2.setAvailable(false);
        saveUser(user2);

        User user3 = new User();
        user3.setAge(70);
        user3.setCountry("Polska");
        user3.setEmail("zenek@abcg.pl");
        user3.setLogin("zenek");
        user3.setAvailable(true);
        saveUser(user3);
    }
}
