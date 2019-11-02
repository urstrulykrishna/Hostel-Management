package jbr.springmvc.model;

import java.io.Serializable;

public class User implements Serializable {

  private String rollno;
  private String roomno;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private String phone;
  private String doe;
  private String doexit;
  private int status;
  private int roompref;
  //cstatus--->current status

  //nop --- > no of persons in a room


    public String getRollno() {
    return rollno;
  }

  public void setRollno(String rollno) {
    this.rollno = rollno;
  }

  public String getRoomno() {
    return roomno;
  }

  public void setRoomno(String roomno) {
    this.roomno = roomno;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDoe() {
    return doe;
  }

  public void setDoe(String doe) {
    this.doe = doe;
  }

  public String getDoexit() {
    return doexit;
  }

  public void setDoexit(String doexit) {
    this.doexit = doexit;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }


  public int getRoompref() {
    return roompref;
  }

  public void setRoompref(int roompref) {
    this.roompref = roompref;
  }
}
