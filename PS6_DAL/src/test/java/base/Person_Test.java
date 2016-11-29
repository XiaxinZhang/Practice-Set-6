package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
		
	private static PersonDomainModel person1;
	private static UUID person1UUID = UUID.randomUUID();
	
	@BeforeClass
	public static void personInstance() throws Exception{
		
		Date person1Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		 person1 = new PersonDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person1.setPersonID(person1UUID);
		person1.setFirstName("Mingkun");
		person1.setMiddleName("a");
		person1.setLastName("Chen");
		person1.setBirthday(person1Birth);
		person1.setCity("Elkton");
		person1.setStreet("702 Stone Gate Blvd");
		person1.setPostalCode(21921);
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test_addStudent() {
		assertEquals(person1.getPersonID(), PersonDAL.getPerson(person1.getPersonID()).getPersonID());
	}
	
	@Test
	public void test_updateStudent() {
		int newPostalCode = 19716;
		person1.setPostalCode(newPostalCode);
		PersonDAL.updatePerson(person1);
		assertEquals(PersonDAL.getPerson(person1.getPersonID()).getPostalCode(), newPostalCode);
	}
	
	@Test
	public void test_deleteStudent() {
		assertEquals(person1.getPersonID(), PersonDAL.getPerson(person1.getPersonID()).getPersonID());
		PersonDAL.deletePerson(person1.getPersonID());
		assertEquals(PersonDAL.getPerson(person1.getPersonID()), null);
	}
	
	

}
