/**
 * Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise30 {
    public static class Annoyance extends RuntimeException {
        private static final long serialVersionUID = 0;
    }
    public static class Sneeze extends Annoyance {
        private static final long serialVersionUID = 0;
    }
    public static void wrapException(int exceptionNum) {
        try {
            switch (exceptionNum) {
                case 1: throw new Annoyance();
                case 2: throw new Sneeze();
                default: return;
            }
        } catch(Sneeze e) {
            throw new RuntimeException(e);
        } catch(Annoyance e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        //wrapException(2);
        // Catch the exact type:
        for (int i : new int[] {1,2}) {
            try {
                wrapException(i);
            } catch(RuntimeException e) {
                try {
                    throw e.getCause();
                } catch(Sneeze s) {
                    System.out.println("Caught Sneeze");
                } catch(Annoyance a) {
                    System.out.println("Caught Annoyance");
                } catch(Throwable t) {
                    System.out.println("Caught other Throwable!");
                }
            }
        }
    }
}
