package com.larregle.quadtree;

public class BoundingBox {

    private Point2D point;
    private int width;
    private int height;

    public BoundingBox(int x, int y, int width, int height) {
        this(new Point2D(x, y), width, height);
    }

    public BoundingBox(Point2D point, int width, int height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public boolean containsPoint2D(Point2D point2D) {
        return ((point2D.getX() > point.getX()) && (point2D.getX() < point.getX() + width) &&
                (point2D.getY() > point.getY()) && (point2D.getX() < point.getY() + height));
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
