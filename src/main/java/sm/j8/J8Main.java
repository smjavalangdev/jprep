/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.j8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author smdeveloper
 */
public class J8Main {

    private static final Logger logger = Logger.getLogger((sm.j8.J8Main.class).getClass().getName());

    /**
     * Uses java 8 lambdas
     * shorter syntax, lambda expressions:
     */
    
    private static void useLambdas() {
        List<String> names = Arrays.asList("Sam", "Mary", "Peter", "Jacob");
        
        Collections.sort(names,(String a,String b) -> {
            return b.compareTo(a);
        });
        
        logger.info("********* LAMBDA EXPRESSIONS **************");
        names.forEach(System.out :: println);
    }
    
    //Usage of functional interfaces
    // Annotation declaratrion is optional
    //Must have one abstract interface. 
    //We can use arbitrary interfaces as lambda expressions as long as 
    //the interface only contains one abstract method. To ensure that your 
    //interface meet the requirements, you should add the @FunctionalInterface 
    //annotation. The compiler is aware of this annotation and throws a compiler
    //error as soon as you try to add a second abstract method declaration to the interface.
    
    @FunctionalInterface 
    interface Converter<F,T> {
        T convert(F from);
    }
    
    public static void main(String[] args) {
        //Delare and use the default method.
        Formula f = new Formula() {

            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };

        logger.info("The value of calculate: " + f.calculate(100));
        logger.info("The value of calculate: " + f.calculate(4));
              
        J8Main.useLambdas();
        
        logger.info("============ Using functional interface =================");
        
        Converter<String, Integer> c = Integer::valueOf; 
        logger.info(c.convert("123").toString());
        
        logger.info("****** Constructor References.*******");
        //We create a reference to the Person constructor via Person::new. 
        //The Java compiler automatically chooses the right constructor by 
        //matching the signature of PersonFactory.create.
        
        PersonFactory<Person> pf = Person::new;
        Person p = pf.create("Suvankar", "Mazumder");
        logger.info(p.toString());
    }
}
