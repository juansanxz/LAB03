package edu.eci.cvds.tdd.registry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisterVoterTest {
	
	private Registry registry = new Registry();
	
	@Test
	public void should_NotAllowToVote_When_PersonIsAlreadyIn () {
		//arrange
		Person person = new Person("Ivan", 1234567890, 27, Gender.MALE, true);
		RegisterResult prev = registry.registerVoter(person);
		
		//act
		RegisterResult result = registry.registerVoter(person);
		
		//assert
		assertEquals(RegisterResult.DUPLICATED, result);
	}
	
	@Test
	public void should_NotAllowToVote_When_PersonIsDead () {
		//arrange
		Person person = new Person("Juan", 1011320038, 19, Gender.MALE, false);
		
		//act
		RegisterResult result = registry.registerVoter(person);
		
		//assert
		assertEquals(RegisterResult.DEAD, result);
	}
	
	@Test
	public void should_NotAllowToVote_When_PersonHasANegativeAge () {
		//arrange
		Person person = new Person("Santiago", 1000327978, -14, Gender.MALE, true);
		
		//act
		RegisterResult result = registry.registerVoter(person);
		
		//assert
		assertEquals(RegisterResult.INVALID_AGE, result);
	}
	
	@Test
	public void should_NotAllowToVote_When_PersonLessThan18 () {
		//arrange
		Person person = new Person("Julieta", 1012345786, 16, Gender.FEMALE, true);
		
		//act
		RegisterResult result = registry.registerVoter(person);
		
		//assert
		assertEquals(RegisterResult.UNDERAGE, result);
	}
	
	@Test
	public void should_AllowsToVote_When_AgeGreaterThan18 () {
		//arrange
		Person person = new Person("Verónica", 52279783, 48, Gender.FEMALE, true);
		
		//act
		RegisterResult result = registry.registerVoter(person);
		
		//assert
		assertEquals(RegisterResult.VALID, result);
	}
}
