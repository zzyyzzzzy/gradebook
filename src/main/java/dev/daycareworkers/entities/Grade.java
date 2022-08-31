package dev.daycareworkers.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int grade_id;
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "time_reported")
    private long time_reported;
    @Column(name = "note")
    private String note;
    @Column(name = "behavior")
    private Behavior behavior;

    public Grade() {
    }

    public Grade(int grade_id, int student_id, long time_reported, String note, Behavior behavior) {
        this.grade_id = grade_id;
        this.student_id = student_id;
        this.time_reported = time_reported;
        this.note = note;
        this.behavior = behavior;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public long getTime_reported() {
        return time_reported;
    }

    public void setTime_reported(long time_reported) {
        this.time_reported = time_reported;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return grade_id == grade.grade_id && student_id == grade.student_id && time_reported == grade.time_reported && note.equals(grade.note) && behavior == grade.behavior;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade_id, student_id, time_reported, note, behavior);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", student_id=" + student_id +
                ", time_reported=" + time_reported +
                ", note='" + note + '\'' +
                ", behavior=" + behavior +
                '}';
    }
}
//    create table grade(
//        grade_id serial primary key,
//        student_id int references student(student_id),
//	time_reported int not null,
//            note varchar(128) not null,
//            behavior behavior not null
//            );