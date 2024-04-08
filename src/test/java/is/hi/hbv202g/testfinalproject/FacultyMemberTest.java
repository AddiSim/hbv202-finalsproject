package is.hi.hbv202g.testfinalproject;

import is.hi.hbv202g.finalproject.FacultyMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FacultyMemberTest {

    @Test
    void testFacultyMember() {
        FacultyMember facultyMember = new FacultyMember("Faculty Name", "CompSci");
        Assertions.assertEquals("Faculty Name", facultyMember.getName());
        Assertions.assertEquals("CompSci", facultyMember.getDepartment());
    }
}
