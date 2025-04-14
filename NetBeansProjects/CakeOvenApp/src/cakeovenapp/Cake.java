/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;

/**
 *
 * @author anudari
 */
    public class Cake {
    private String name;
    private int weight;
    private String bestBefore;
    private String addedTime;

    public Cake(String name, int weight, String bestBefore, String addedTime) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.addedTime = addedTime;
    }

    @Override
    public String toString() {
        return name + " - " + weight + "g - Best Before: " + bestBefore + " - Added: " + addedTime;
    }
}

