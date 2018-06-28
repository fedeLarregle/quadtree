package com.larregle.quadtree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    public static final int QT_NODE_CAPACITY = 4;

    private BoundingBox boundingBox;

    private final List<Node> nodes;

    private QuadTree northWest;
    private QuadTree northEast;
    private QuadTree southWest;
    private QuadTree southEast;

    public QuadTree() {
        this.nodes = new ArrayList<>(QT_NODE_CAPACITY);
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
     *
     * @param point2D
     * @return
     */
    public Node search(Point2D point2D) {
        return null;
    }

    /**
     * Create four children that fully divide this quad into four quads of equal area
     */
    public void subdivide() {}
}
