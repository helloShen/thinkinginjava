/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class VendingMachine11 {
    enum StateDuration { TRANSIENT } // Tagging enum
    enum State {
        RESTING, ADDING_MONEY, DISPENSING(StateDuration.TRANSIENT), GIVING_CHANGE(StateDuration.TRANSIENT),
        TERMINAL;
        
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
        
    }
    
    private State state = State.RESTING;
    private int amount = 0;
    private Product selection = null;
    private EnumMap<State,StateMachine> em=new EnumMap<State,StateMachine>(State.class);
    
    private class StateMachine {
        void next(Input11 input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }
        void output() { System.out.println(amount); }
    }
    
    public VendingMachine11(String path) {
        Product.loadProducts(path);
        em.put(State.RESTING,new StateMachine(){
            void next(Input11 input) {
                switch(Category11.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        });
        em.put(State.ADDING_MONEY,new StateMachine(){
            void next(Input11 input) {
                switch(Category11.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = Product.randomSelection();
                        if(amount < selection.amount()){
                            System.out.println("Insufficient money for " + selection);
                        }
                        else state = State.DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = State.GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        });
        em.put(State.DISPENSING,new StateMachine(){
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = State.GIVING_CHANGE;
            }
        });
        em.put(State.GIVING_CHANGE,new StateMachine(){
            void next() {
                if(amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = State.TERMINAL;
            }
        });
        em.put(State.TERMINAL,new StateMachine(){
            void output() { System.out.println("Halted"); }
        });
    }
    
    public void reset(){
        state = State.RESTING;
        amount = 0;
        selection = null;
    }
    
    public void run(Generator<Input11> gen) {
        while(state != State.TERMINAL) {
            em.get(state).next(gen.next());
            while(state.isTransient){
                em.get(state).next();
            }
            em.get(state).output();
        }
    }
    
    public static void main(String[] args) {
        VendingMachine11 vm=new VendingMachine11("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter19/product.txt");
        vm.run(new RandomInputGenerator11());
    }
}
