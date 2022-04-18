package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        CoursesDao d = (CoursesDao) applicationContext.getBean("dao");
        Courses c = new Courses();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("****************Courses Details Using Spring and Hibernate********************");
        do {
            System.out.println("Enter choice: \n1.Insert\n2.Update\n3.Delete\n4.Fetch\n5.Exit");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {

                //insert
                case 1:
                    System.out.println("Enter CourseName,StudentEnrolledCount,CourseFacultyName,CourseTotalCredit");
                    c=new Courses();
                    c.setCourseName(br.readLine());
                    c.setStudentEnrolledCount(Integer.parseInt(br.readLine()));
                    c.setCourseFacultyName(br.readLine());
                    c.setCourseTotalCredit(Integer.parseInt(br.readLine()));
                    d.insertCourse(c);
                    System.out.println("Record Inserted Successfully");
                    break;


                    //update
                case 2:
                    System.out.println("Enter CourseId and CourseTotalCreditScore");
                    int n=Integer.parseInt(br.readLine());
                    int s=Integer.parseInt(br.readLine());
                    d.updateCourses(n,s);
                    System.out.println("Updated Record Successfully");
                    break;

                case 3:
                    System.out.println("Enter record to be deleted");
                    int n1=Integer.parseInt(br.readLine());
                    d.deleteCourses(n1);
                    System.out.println("Record deleted Successfully");
                    break;

                case 4:
                    System.out.println("Fetch all the Courses in the Database");
                    d.fetchCourses().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Thank you...!");
                    System.exit(0);
                    break;

            }
        }
        while (true);


    }
}
/*
Output:
1.INSERT:
1
Enter CourseName,StudentEnrolledCount,CourseFacultyName,CourseTotalCredit
Python
5
Mrs Priya kapoor
60
Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Hibernate: insert into coursedetails (StudentEnrolledCount, courseFacultyName, courseName, courseTotalCredit, courseId) values (?, ?, ?, ?, ?)
Record Inserted Successfully


2.UPDATE:
Enter CourseId and CourseTotalCreditScore
3
30
Hibernate: update coursedetails set courseTotalCredit='30' where courseId='3'
Updated Record Successfully


3.DELETE
Enter record to be deleted
4
Hibernate: delete from coursedetails where courseId='4'
Record deleted Successfully


4.Fetch  all record

Fetch all the Courses in the Database
Apr 18, 2022 6:47:24 PM org.hibernate.internal.SessionImpl createCriteria
WARN: HHH90000022: Hibernate's legacy org.hibernate.Criteria API is deprecated; use the JPA javax.persistence.criteria.CriteriaQuery instead
Hibernate: select this_.courseId as courseid1_0_0_, this_.StudentEnrolledCount as studente2_0_0_, this_.courseFacultyName as coursefa3_0_0_, this_.courseName as coursena4_0_0_, this_.courseTotalCredit as courseto5_0_0_ from coursedetails this_
Courses{courseId=1, courseName='Java', StudentEnrolledCount=19, courseFacultyName='Mrs. Aarti Dhumal', courseTotalCredit=50}
Courses{courseId=2, courseName='Data Security', StudentEnrolledCount=10, courseFacultyName='Mr. Sukesh kothari', courseTotalCredit=40}
Courses{courseId=3, courseName='Computer Vision', StudentEnrolledCount=25, courseFacultyName='Mr Amit Sharma', courseTotalCredit=30}



mysql> select * from coursedetails;
+----------+----------------------+--------------------+-----------------+-------------------+
| courseId | StudentEnrolledCount | courseFacultyName  | courseName      | courseTotalCredit |
+----------+----------------------+--------------------+-----------------+-------------------+
|        1 |                   19 | Mrs. Aarti Dhumal  | Java            |                50 |
|        2 |                   10 | Mr. Sukesh kothari | Data Security   |                40 |
|        3 |                   25 | Mr Amit Sharma     | Computer Vision |                30 |
+----------+----------------------+--------------------+-----------------+-------------------+

 */