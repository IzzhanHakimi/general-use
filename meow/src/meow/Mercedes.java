/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise;

/**
 *
 * @author bottl
 */

import java.util.Random;

public class Mercedes {
    private double mana;
    private static double[] skillMana;
    private static double[] skillDamage;
    private int skill = 0;
    
    Mercedes(){
        this.mana = 1000.00;
        skillMana = new double[3];
        skillDamage = new double[3];
    }

    protected double getMana() {
        return mana;
    }

    protected void setMana(double mana) {
        if (mana < 0 || mana > 5000) {
            System.out.println("Mana should be within range 0.00 and 5000.00!");
            return;
        }
        else this.mana = mana;
    }

    protected static double[] getSkillMana() {
        return skillMana;
    }

    protected static void setSkillMana(double[] skillMana) {
        try {
            for (int i = 0; i < 3; i++) {
                if (skillMana[i] < 0 || skillMana[i] > 100) {
                    System.out.println("Mana usage for each skill should be within range 0.00 and 100.00!");
                    return;
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Accidentally entered more than 3 skill mana usage!");
            return;
        }
        
        Mercedes.skillMana = skillMana;
    }

    protected static double[] getSkillDamage() {
        return skillDamage;
    }

    protected static void setSkillDamage(double[] skillDamage) {
        try {
            for (int i = 0; i < 3; i++) {
                if (skillDamage[i] < 0 || skillDamage[i] > 1000) {
                    System.out.println("Damage for each skill should be within range 0.00 and 1000.00!");
                    return;
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Accidentally entered more than 3 skill damage!");
            return;
        }
        
        Mercedes.skillDamage = skillDamage;
    }
    
    protected double[] randomlyOptimize() {
        Random rnd = new Random();
        double mana = this.mana;
        double minSkillMana = 100;
        int skillCount = 0;
        boolean allZero = true;
        double totalManaCost = 0;
        double totalSkillDamage = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (skillMana[i] != 0.0) {
                    allZero = false;
                    break;
                }
            }
            
            if (allZero) skillMana[i] = rnd.nextDouble(0.1, 0.99)*100;
            if (skillMana[i] < minSkillMana) {
                minSkillMana = skillMana[i];
                skill = i;
            }
            
            for (int j = 0; j < 3; j++) {
                if (skillDamage[i] != 0.0) {
                    allZero = false;
                    break;
                }
            }
            
            if (allZero) skillDamage[i] = rnd.nextDouble(0.1, 0.99)*1000;
        }
        
        while (true) {
            int skillNum = rnd.nextInt(3);
            
            if (mana < skillMana[skillNum]) {
                if (mana < minSkillMana) break;
                else {
                    skillCount++;
                    mana = mana - minSkillMana;
                    totalManaCost += minSkillMana;
                    totalSkillDamage += skillDamage[skill];
                    break;
                }
            }
            else {
                skillCount++;
                mana = mana - skillMana[skillNum];
                totalManaCost += skillMana[skillNum];
                totalSkillDamage += skillDamage[skillNum];
            }
        }
        
        return new double[]{totalManaCost, totalSkillDamage};
    }
    
    protected void toString(double[] info) {
        System.out.println("Mercedes Info");
        System.out.printf("Remaining Mana: %.2f/%.2f\n", (this.mana-info[0]), this.mana);
        System.out.printf("Damage output: %.2f\n", info[1]);
    }
}
