/**
 * Test inherit - decoration
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class TestDecoration {
    private static interface Employee {
        public int getSalary();
    }
    private static class BaseEmployee implements Employee {
        private final int baseSalary;
        private final int years;
        public BaseEmployee(int baseSalary, int years) {
            this.baseSalary = baseSalary;
            this.years = years;
        }
        public int getSalary() { // 普通员工工资算法
            return baseSalary + (100 * years);
        }
    }
    private static class TrafficAllowance implements Employee {
        private final Employee employee;
        private final int allowance;
        public TrafficAllowance(Employee employee, int allowance) {
            this.employee = employee;
            this.allowance = allowance;
        }
        public int getSalary() { // 管理层的工资算法
            return employee.getSalary() + allowance;
        }
    }
    private static class ManagerBonus implements Employee {
        private final Employee employee;
        private final int baseBonus;
        private final int level;
        public ManagerBonus(Employee employee, int bonus, int level) {
            this.employee = employee;
            baseBonus = bonus;
            this.level = level;
        }
        public int getSalary() { // 管理层的工资算法
            return employee.getSalary() + (baseBonus * level);
        }
    }
    public static void main(String[] args) {
        System.out.println(new ManagerBonus(new TrafficAllowance(new BaseEmployee(1000,10),500), 200, 2).getSalary());
    }
}
