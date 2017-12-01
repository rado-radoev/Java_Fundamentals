/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author superlamer
 */
 public enum PenSize {
    SMALL(2),
    MEDIUM(4),
    LARGE(6);
 
    private final int radius;
 
    PenSize(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
};
