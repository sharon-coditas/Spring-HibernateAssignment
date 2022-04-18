
package bean;

import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CoursesDao {
    private HibernateTemplate ht;

    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }

    @Override
    public String toString() {
        return "CoursesDao{" +
                "ht=" + ht +
                '}';
    }
    public int insertCourse(Courses c){
        return (int) ht.save(c);

    }

     public int updateCourses(int n,int s){
        return  ht.bulkUpdate("update Courses SET courseTotalCredit='"+s+"' where courseId='"+n+"'");
    }
    public  int deleteCourses(int n){
        return ht.bulkUpdate("delete from Courses where courseId='"+n+"'");

    }
    public List<Courses> fetchCourses(){
        return ht.loadAll(Courses.class);
    }


}
