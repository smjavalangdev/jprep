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
public interface Formula {
    
    double calculate(int a);
    
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    
    default double log(int a) {
        return Math.log(a);
    }
}
