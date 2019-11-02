package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jbr.springmvc.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;




  @Autowired
  JdbcTemplate jdbcTemplate;

    public String register(User user) {
        // first check whether user already registered using rollno
        //rolno--->rollno of user
          String rolno = user.getRollno();
          //
          String query0ne =  "select * from student where rollno='" + rolno + "' and status ='" + 1 + "'";
          List<User> users = jdbcTemplate.query(query0ne,new UserMapper());
          int usersize =   users.size()>0?1:0;
        //rp--->room preference variable
          int rp = user.getRoompref();
       // sql query to check availabilty of room preference
          String queryTwo = "select * from room where nop='" + rp + "' and cstatus !='" + 0 + "'" + " ORDER BY roomno";
          List<Room> rooms = jdbcTemplate.query(queryTwo,new RoomMapper());

          // sizeRoom -- >whether room exists or not
          int sizeRoom =  rooms.size()>0?1:0;

          if (sizeRoom == 1 && usersize==0) {
              Room  roomOne = rooms.get(0);
              String roomno = roomOne.getRoomno();
              int count = roomOne.getCstatus()-1;
              String insroom = "UPDATE room SET roomno=?,nop=?,cstatus = ? WHERE roomno=?";
              jdbcTemplate.update(insroom, new Object[]{roomOne.getRoomno(),roomOne.getNop(),count,roomno});

              String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
              jdbcTemplate.update(sql, new Object[]{user.getRollno(), roomno, user.getFirstname(),
                    user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(),user.getDoe(),"",1});
              return roomno;
        }
        else
        {
            //if the user preference room are full
            return "full";
        }
    }
    @Cacheable(value="roomFindCache", key="#login")
    public User validateUser(String login) {


        String sql = "select * from student where roomno='" + login +   "' and status='" + 1 + "'";

        List<User> users = jdbcTemplate.query(sql, new UserMapper());

        return users.size() > 0 ? users.get(0) : null;
    }
  //here
  public void delete(User user)
  {
     // doex-->date of exit
      String  doex = user.getDoexit();

      String user1 = "select * from  student where rollno= '" + user.getRollno()+ "'";
      List<User> users = jdbcTemplate.query(user1, new UserMapper());
      User m = users.get(0);
      //rmno-->roomno
      String rmno = m.getRoomno();
      //rn--->rollno
      String rn = m.getRollno();
      String room1 = "select * from  room where roomno='" +rmno + "'";
      List<Room> rooms = jdbcTemplate.query(room1, new RoomMapper());
      //taking output of list
      Room roomNo = rooms.get(0);
      int count = roomNo.getCstatus()+1;
      String insroom = "UPDATE room SET roomno=?,nop=?,cstatus = ? WHERE roomno=?";
      jdbcTemplate.update(insroom, new Object[]{roomNo.getRoomno(),roomNo.getNop(),count,rmno});

      String Delete = " DELETE FROM student WHERE rollno =?";
      jdbcTemplate.update(Delete, rn);
      String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";

      jdbcTemplate.update(sql, new Object[]{m.getRollno(), m.getRoomno(), m.getFirstname(),
              m.getLastname(), m.getEmail(), m.getAddress(), m.getPhone(),m.getDoe(),doex,0});


  }

  public List<User> getList(String user)
  {
      slowQuery(2000L);
      // to check wheather ca
      System.out.println("findByRoom is running...");


      String sql = "select * from student where roomno='" + user+ "'";
      List<User> users = jdbcTemplate.query(sql, new UserMapper());
      return users;
  }




    public List<Room> getList1()
    {
        String sqleij = "select * from  room";
        List<Room> rooms = jdbcTemplate.query(sqleij, new RoomMapper());
        return rooms;
    }


    public List<User> getStudinfo()
    {
        //stud-->studentinfo
        String stud = "select * from  student";
        List<User> studs = jdbcTemplate.query(stud, new UserMapper());
        return studs;
    }

    private void slowQuery(long seconds){
        try {

            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setRollno(rs.getString("rollno"));
        user.setRoomno(rs.getString("roomno"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getString("phone"));
        user.setDoe(rs.getString("doe"));
        user.setDoexit(rs.getString("doexit"));
        user.setStatus(rs.getInt("status"));
        return user;
    }
}
    class RoomMapper implements RowMapper<Room> {

        public Room mapRow(ResultSet rs, int arg1) throws SQLException {
            Room room = new Room();

            room.setRoomno(rs.getString("roomno"));

            room.setCstatus(rs.getInt("cstatus"));

            room.setNop(rs.getInt("nop"));

            return room;
        }

    }

