package dev.daycareworkers.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private int gid;
    @Column(name = "sid")
    private int sid;
    @Column(name = "treported")
    private long treported;
    @Column(name = "note")
    private String note;
    @Column(name = "behavior")
    @Enumerated(EnumType.STRING)
    private Behavior behavior;

    public Grade() {
    }

    public Grade(int gid, int sid, long treported, String note, Behavior behavior) {
        this.gid = gid;
        this.sid = sid;
        this.treported = treported;
        this.note = note;
        this.behavior = behavior;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public long getTreported() {
        return treported;
    }

    public void setTreported(long treported) {
        this.treported = treported;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", sid=" + sid +
                ", treported=" + treported +
                ", note='" + note + '\'' +
                ", behavior=" + behavior +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return gid == grade.gid && sid == grade.sid && treported == grade.treported && note.equals(grade.note) && behavior == grade.behavior;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, sid, treported, note, behavior);
    }
}
//    create table grade(
//        grade_id serial primary key,
//        student_id int references student(student_id),
//	time_reported int not null,
//            note varchar(128) not null,
//            behavior behavior not null
//            );