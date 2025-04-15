/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;

/**
 *
 * @author anudari
 */
import java.util.Stack;

public class Oven {
    private Stack<Cake> ovenStack = new Stack<>();
    private final int MAX_CAPACITY = 5;

    public String addCake(Cake cake) {
        if (ovenStack.size() >= MAX_CAPACITY) {
            return "No more capacity!";
        }
        ovenStack.push(cake);
        return "Cake added!";
    }

    public String removeCake() {
        if (ovenStack.isEmpty()) {
            return "Oven is empty!";
        }
        Cake removed = ovenStack.pop();
        return "Removed: " + removed.toString();
    }

    public String showCakes() {
        if (ovenStack.isEmpty()) return "No cakes in oven.";
        StringBuilder sb = new StringBuilder();
        for (Cake c : ovenStack) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
    public String peekTopCake() {
    if (ovenStack.isEmpty()) {
        return "Oven is empty.";
    }
    Cake topCake = ovenStack.peek(); // Just looks at the top without removing
    return "Top Cake: " + topCake.toString();
} 
}

