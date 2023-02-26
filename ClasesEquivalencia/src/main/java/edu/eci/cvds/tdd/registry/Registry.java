package edu.eci.cvds.tdd.registry;

import java.util.*;

/**
 * Registry representation class
 * @author Santiago Arévalo y Juan Felipe Sánchez
 *
 */
public class Registry {
	private HashMap<Integer, Person> people;
	
	/**
	 * A registry constructor
	 */
	public Registry() {
		people = new HashMap<Integer, Person>();
	}
	
	public HashMap<Integer, Person> getPeople () {
		return people;
	}
	
	/**
	 * Validates if a person is allowed to vote
	 * @param p person who we are validating
	 * @return a RegisterResult constant according to the validations
	 */
	public RegisterResult registerVoter(Person p) {
		if (people.containsKey(p.getId())) {
			return RegisterResult.DUPLICATED;
		} else if (!p.isAlive()) {
			return RegisterResult.DEAD;
		} else if (p.getAge() < 0) {
			return RegisterResult.INVALID_AGE;
		} else if (p.getAge() < 18) {
			return RegisterResult.UNDERAGE;
		}
		people.put(p.getId(), p);
		return RegisterResult.VALID;
	}
}
