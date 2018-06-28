package com.larregle.quadtree;

public class BoundingBox {

    private int topLeft;
    private int topRight;
    private int botLeft;
    private int botRight;

    public BoundingBox(int topLeft, int topRight, int botLeft, int botRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.botLeft = botLeft;
        this.botRight = botRight;
    }

    public boolean containsPoint2D(Point2D point2D) {
        return ((point2D.getX() > topLeft) && (point2D.getX() < topLeft + topRight) &&
                (point2D.getY() > topLeft) && (point2D.getX() < topLeft + botLeft));
    }

    public int getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(int topLeft) {
        this.topLeft = topLeft;
    }

    public int getTopRight() {
        return topRight;
    }

    public void setTopRight(int topRight) {
        this.topRight = topRight;
    }

    public int getBotLeft() {
        return botLeft;
    }

    public void setBotLeft(int botLeft) {
        this.botLeft = botLeft;
    }

    public int getBotRight() {
        return botRight;
    }

    public void setBotRight(int botRight) {
        this.botRight = botRight;
    }

}
