package jbr.springmvc.service;

import jbr.springmvc.model.Room;
import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public String register(User user) {
    return userDao.register(user);
  }

  public User validateUser(String login) {
    return userDao.validateUser(login);
  }

  public void delete(User user) {
    userDao.delete(user);
  }

  public List<User> getList(String user) {
    return userDao.getList(user);
  }

  public List<Room> getList1() {
    return userDao.getList1();
  }

  public List<User> getStudinfo(){return userDao.getStudinfo();}
}