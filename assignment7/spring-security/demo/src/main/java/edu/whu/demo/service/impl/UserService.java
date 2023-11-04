package edu.whu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.whu.demo.dao.UserDao;
import edu.whu.demo.domain.User;
import edu.whu.demo.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDao, User> {
    @Autowired
    UserDao userDao;

    @Cacheable(cacheNames = "user",key = "#name",condition = "#name!=null")
    public UserDto getUser(String name){
        return userDao.getUser(name);
    }

    @CacheEvict(cacheNames = "user",key = "#userName")
    public void deleteUser(String userName) {
        userDao.deleteById(userName);
    }

    @CacheEvict(cacheNames = "user",key = "#user.id")
    public void updateUser(User user) {
        userDao.updateById(user);
    }

    public void addUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.insert(user);
    }
}
