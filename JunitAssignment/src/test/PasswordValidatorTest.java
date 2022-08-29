package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.PasswordValidator;

public class PasswordValidatorTest {

	PasswordValidator password;

	@BeforeEach
	void setUp() throws Exception {
		password = new PasswordValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		password = null;
	}

	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		assertEquals(true, password.validatePassword("Asdf123"));
	}

	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		assertEquals(false, password.validatePassword("Asdf"));
	}

	@Test(expected = InfyAcademyException.class)
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		assertEquals(false, password.validatePassword(null));

	}

	@ParameterizedTest
	@ValueSource(strings = { "Qwerty", "Qwerty1234", "QwertAsdfZxcvFdsaRewq", "Zxcvb54321" })
	public void validatePasswordParameterizedPassword(String pass) throws InfyAcademyException {
		assertEquals(true, password.validatePassword(pass));
	}
}