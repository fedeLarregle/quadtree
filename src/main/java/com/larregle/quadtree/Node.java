package com.larregle.quadtree;

public class Node {

    private Point2D position;
    private int value;

    public Node(Point2D position, int value) {
        this.position = position;
        this.value = value;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
