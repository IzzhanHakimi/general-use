/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise;

/**
 *
 * @author bottl
 */
public class IceCream {
    private String flavor;
    private double volume;
    
    IceCream(String flavor, double volume){
        this.flavor = flavor;
        this.volume = volume;
    }

    protected String getFlavor() {
        return flavor;
    }

    protected void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    protected double getVolume() {
        return volume;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }
    
}
