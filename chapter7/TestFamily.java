/**
 *  to test the People, FamilyMember, Family, World class
 *
 *  @author Wei SHEN
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import com.ciaoshen.thinkinjava.family.*;

import java.com.ciaoshen.thinkinjava.clanWar.SEX;


public class TestFamily{

    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        //pass to 1930
        Family.yearsLater(1930);

        //create two new family
        Family familyShen = Family.createNewFamilyWithSex("XiangYang", "SHEN", SEX.MALE);
        Family familyWang = Family.createNewFamilyWithSex("Ding",  "WANG", SEX.MALE);
        Family familyQian = Family.createNewFamilyWithSex("RuiHua", "QIAN", SEX.FEMALE);
        Family familyLin = Family.createNewFamilyWithSex("ShouLian", "LIN", SEX.FEMALE);

        //insert the new family into the world
        familyShen.addFamilyToWorld();
        familyWang.addFamilyToWorld();
        familyQian.addFamilyToWorld();
        familyLin.addFamilyToWorld();

        //print world
        Family.printTheWorld();

        

        //25 years passed
        Family.yearsLater(25);
        //marriage
        //and check the bride and the bridegroom before the marriage
        if(familyShen.hasMember("XiangYang") && familyQian.hasMember("RuiHua")){
            familyShen.marriage("XiangYang", familyQian, "RuiHua");
        }

        //print world
        Family.printTheWorld();
        
        //1 year later
        Family.yearsLater(1);
        //give birth
        if (familyShen.hasMember("RuiHua")){
            familyShen.giveBirthBaby("RuiHua", "ZhiQing");
        }
        
        //print world
        Family.printTheWorld();


        //1 year later
        Family.yearsLater(1);
        //another marriage
        if(familyWang.hasMember("Ding") && familyLin.hasMember("ShouLian")){
            familyWang.marriage("Ding", familyLin, "ShouLian");
        }

        //print world
        Family.printTheWorld();
        
        //1 year later
        Family.yearsLater(1);
        //give birth
        if (familyWang.hasMember("ShouLian")){
            familyWang.giveBirthBaby("ShouLian", "ZhiPing");
        }

        //print world
        Family.printTheWorld();


    }
}