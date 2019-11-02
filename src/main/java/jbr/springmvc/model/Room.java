package jbr.springmvc.model;

import java.io.Serializable;

public class Room implements Serializable {


    private String roomno;
    private int cstatus;
    //nop --- > no of persons in a room
    private int nop;


    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }


    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }


}
