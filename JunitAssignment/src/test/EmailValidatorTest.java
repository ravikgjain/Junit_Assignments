package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest {
	
	EmailValidator email;
	
	@BeforeEach
	void setUp() throws Exception {
		email=new EmailValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		email=null; 
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		assertEquals(true, email.validateEmailId("James_Potter@infy.com"));
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		assertEquals(false, email.validateEmailId("James_Potter@infy.org"));
	}

	@Test(expected= InfyAcademyException.class )
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		assertNull(email.validateEmailId(null));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Sirius_Black","Lily_Evans@Hoggy.in","Remus_Lups","NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(String emailId) throws InfyAcademyException {
		assertEquals(true, email.validateEmailId(emailId));
	}
}
