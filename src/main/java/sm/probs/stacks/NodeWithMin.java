/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sm.probs.stacks;

/**
 *
 * @author smazumder
 */
public class NodeWithMin<E> {    
        public E value;
        public E minValue;
        
        public NodeWithMin(E min, E item) {
            this.minValue = min;
            this.value = item;
        }
    
}
