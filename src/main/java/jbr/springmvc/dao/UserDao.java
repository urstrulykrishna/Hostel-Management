package jbr.springmvc.dao;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.Room;
import jbr.springmvc.model.User;

import java.util.List;

public interface UserDao {

  String register(User user);

  User validateUser(String login);

  void delete(User user);

  List<User> getList(String user);

  List<Room> getList1();

  List<User>  getStudinfo();
}
