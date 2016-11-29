package base;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.StudentDomainModel;

public class Student_Test {
	private static Date testDate;
	private static StudentDomainModel student;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testDate = new SimpleDateFormat("MM.dd.YYYY").parse("02.02.2002");
		student = new StudentDomainModel("Xiaxin", "", "Zhang", testDate);
		StudentDAL.addStudent(student);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_addStudent() {
		assertEquals(student, StudentDAL.getStudent(student.getStudentID()));
	}
	
	@Test
	public void test_deleteStudent() {
		StudentDAL.deleteStudent(student.getStudentID());
		assertEquals(null, StudentDAL.getStudent(student.getStudentID()));
	}
	
	@Test
	public void test_updateStudent() {
		student.setMiddleName("Jean");
		StudentDAL.updateStudent(student);
		assertEquals(student,StudentDAL.getStudent(student.getStudentID()));
	}

}
