/**
 *  利用注解，从java类中直接生成SQL语句，创建Table。
 */
package com.ciaoshen.thinkinjava.chapter20.db;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLDecimal(10) Integer height;
    @SQLDate(20) Long birthday;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;
    static int memberCount;
    public String getHandle() { return handle; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String toString() { return handle; }
    public Integer getAge() { return age; }
}