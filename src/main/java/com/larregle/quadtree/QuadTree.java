package com.larregle.quadtree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    public static final int QT_NODE_CAPACITY = 4;

    private final BoundingBox boundingBox;
    private final List<Node> nodes;

    private QuadTree northWest;
    private QuadTree northEast;
    private QuadTree southWest;
    private QuadTree southEast;

    public QuadTree(BoundingBox boundingBox) {
        this.nodes = new ArrayList<>(QT_NODE_CAPACITY);
        this.boundingBox = boundingBox;
    }

    /**
     * Insert a {@link Node} in the {@link QuadTree}
     * @param node
     * @return
     */
    public boolean insert(Node node) {
        if (!boundingBox.containsPoint2D(node.getPosition()))
            return false;
        if (nodes.size() < QT_NODE_CAPACITY) {
            nodes.add(node);
            return true;
        }

        if (northWest == null)
            subdivide();

        if (northWest.insert(node)) { return true; }
        if (northEast.insert(node)) { return true; }
        if (southWest.insert(node)) { return true; }
        if (southEast.insert(node)) { return true; }

        return false;
    }

    /**
     * Retrieves the specific {@link QuadTree} that the given {@link Point2D} belongs to
     * @param point2D
     * @return {@link QuadTree}
     */
    public QuadTree getQuadrant(Point2D point2D) {
        if (!boundingBox.containsPoint2D(point2D))
            return null;
        if (northWest == null)
            return null;

        if (northWest.boundingBox.containsPoint2D(point2D)) { return northWest; }
        if (northEast.boundingBox.containsPoint2D(point2D)) { return northEast; }
        if (southWest.boundingBox.containsPoint2D(point2D)) { return southWest; }
        if (southEast.boundingBox.containsPoint2D(point2D)) { return southEast; }

        return null;
    }


    /**
     * Create four children that fully divide this quad into four quads of equal area
     */
    public void subdivide() {
        int x = boundingBox.getPoint().getX();
        int y = boundingBox.getPoint().getY();
        int width = boundingBox.getWidth() / 2;
        int height = boundingBox.getHeight() / 2;

        northWest = new QuadTree(new BoundingBox(x, y, width, height));
        northEast = new QuadTree(new BoundingBox(x + width, y, width, height));
        southWest = new QuadTree(new BoundingBox(x, y + height, width, height));
        southEast = new QuadTree(new BoundingBox(x + width, y + height, width, height));
    }
}
