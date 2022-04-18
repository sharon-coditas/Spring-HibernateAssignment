package bean;

import javax.persistence.*;

@Entity
@Table(name="coursedetails")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int courseId;
     private  String courseName;
     private  int StudentEnrolledCount;
     private  String courseFacultyName;
     private  int courseTotalCredit;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFacultyName() {
        return courseFacultyName;
    }

    public void setCourseFacultyName(String courseFacultyName) {
        this.courseFacultyName = courseFacultyName;
    }

    public int getCourseTotalCredit() {
        return courseTotalCredit;
    }

    public void setCourseTotalCredit(int courseTotalCredit) {
        this.courseTotalCredit = courseTotalCredit;
    }

    public int getStudentEnrolledCount() {
        return StudentEnrolledCount;
    }

    public void setStudentEnrolledCount(int studentEnrolledCount) {
        StudentEnrolledCount = studentEnrolledCount;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", StudentEnrolledCount=" + StudentEnrolledCount +
                ", courseFacultyName='" + courseFacultyName + '\'' +
                ", courseTotalCredit=" + courseTotalCredit +
                '}';
    }
}



