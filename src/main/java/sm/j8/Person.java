/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.j8;

/**
 *
 * @author smdeveloper
 */
public class Person {

    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String toString() {
        return firstName + " " + lastName;
    }
}

interface PersonFactory <P extends Person>{
    P create(String firstName, String lastName);
}