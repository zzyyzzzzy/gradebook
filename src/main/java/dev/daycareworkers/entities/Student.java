package dev.daycareworkers.entities;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int sid;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "gname")
    private String gname;

    public Student() {
    }

    public Student(int sid, String fname, String lname, String gname) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.gname = gname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", gname='" + gname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid && fname.equals(student.fname) && lname.equals(student.lname) && gname.equals(student.gname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, fname, lname, gname);
    }
}

