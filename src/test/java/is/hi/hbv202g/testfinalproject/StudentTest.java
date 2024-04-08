package is.hi.hbv202g.testfinalproject;

import is.hi.hbv202g.finalproject.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void testStudent() {
        Student student = new Student("Student Name", true);
        Assertions.assertEquals("Student Name", student.getName());
        Assertions.assertTrue(student.isFeePaid());
    }
}
