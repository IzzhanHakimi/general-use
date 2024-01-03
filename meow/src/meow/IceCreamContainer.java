/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise;

/**
 *
 * @author bottl
 */
import java.util.ArrayList;

public class IceCreamContainer {
    ArrayList<IceCream> icecream = new ArrayList<>();
    
    protected void addIceCream(String flavor, double volume) {
        icecream.add(new IceCream(flavor, volume));
    }
    
    protected double calculateVolume(double radius, int scoops) {
        return (scoops * ((double)4/3) * Math.PI * Math.pow(radius, 3));
    }
    
    protected void scoopIceCream(String flavor, double volume) {
        for (int i = 0; i < icecream.size(); i++) {
            if (icecream.get(i).getFlavor().equalsIgnoreCase(flavor)) icecream.get(i).setVolume(icecream.get(i).getVolume() - volume);
        }
    }
    
    protected double remainingVolume(String flavor) {
        double remainingVolume = 0;
        for (int i = 0; i < icecream.size(); i++) {
            if (icecream.get(i).getFlavor().equalsIgnoreCase(flavor)) remainingVolume = icecream.get(i).getVolume();
        }
        return remainingVolume;
    }
    
    protected boolean prepareIceCream(String flavor, double volume) {
        boolean enoughChocolate = false;
        boolean enoughMint = false;
        for (int i = 0; i < icecream.size(); i++) {
            if (icecream.get(i).getFlavor().equalsIgnoreCase("Chocolate")) {
                if (flavor.equalsIgnoreCase("Chocolate") && icecream.get(i).getVolume() >= volume) enoughChocolate = true;
            }
            else if (icecream.get(i).getFlavor().equalsIgnoreCase("Mint")) {
                if (flavor.equalsIgnoreCase("Mint") && icecream.get(i).getVolume() >= volume) enoughMint = true;
            }
        }
        return (enoughChocolate && enoughMint);
    }
}
