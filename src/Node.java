class Node
{
    private int x;
    private int y;
    private Node parent;

    Node(int x, int y, Node parent)
    {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    Node getParent()
    {
        return this.parent;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }
}
