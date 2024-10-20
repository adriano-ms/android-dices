package com.edu.fateczl.dices;

import androidx.annotation.NonNull;

/**
 * @author Adriano M Sanchez
 */
public class Dice {

    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int roll(){
        return (int) (Math.random() * sides + 1);
    }

    @NonNull
    @Override
    public String toString() {
        return "D" + sides;
    }
}
