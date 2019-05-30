import java.util.ArrayDeque;
import java.util.Queue;

public class BFSNavigator implements Navigator {
    private static final char wall = '#';
    private static final char road = '.';
    private static final char chaA = '@';
    private static final char chaB = 'x';
    private static final char path = '+';

    private static final int[] shiftX = {-1, 0, 1, 0};
    private static final int[] shiftY = {0, -1, 0, 1};

//    private Pair<Integer, Integer> start;
//    private Pair<Integer, Integer> finish;
    private Node start;
    private char[][] navMap;
    private boolean[][] visitedMap;
    private int width;
    private int height;

    @Override
    public char[][] searchRoute(char[][] map) {
        parseMap(map);
        return parseResult(searchBFS());
    }

    private void parseMap(char[][] map) {
        if (map.length <= 0 || map[0].length <= 0)
            throw new IllegalArgumentException("Invalid array size");

        height = map.length;
        width = map[0].length;
        visitedMap = new boolean[height][width];

        boolean hasFinish = false;
        navMap = new char[height][width];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                navMap[x][y] = map[x][y];
                switch (map[x][y]) {
                    case wall:
                    case road:
                        break;
                    case chaA:
                        start = new Node(x, y, null);
                        break;
                    case chaB:
                        hasFinish = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown symbol");
                }
            }
        }
        if (start == null)
            throw new IllegalArgumentException("No start found");
        if (!hasFinish)
            throw new IllegalArgumentException("No finish found");
    }

    private boolean isValidMove(int x, int y){
        return x >= 0 && x < height && y >= 0 && y < width && navMap[x][y] != wall && !visitedMap[x][y];
    }

    private boolean isFinish(Node node) {
        return navMap[node.getX()][node.getY()] == chaB;
    }

    private void enqueueAdjacentNodes(Node node, Queue<Node> queue) {
        for (int s = 0; s < 4; s++) {
            int newX = node.getX() + shiftX[s];
            int newY = node.getY() + shiftY[s];
            if (isValidMove(newX, newY)) {
                visitedMap[newX][newY] = true;
                queue.add(new Node(newX, newY, node));
            }
        }
    }

    private Node searchBFS(){
        Queue<Node> queue = new ArrayDeque<>();
        visitedMap[start.getX()][start.getY()] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (isFinish(node))
                return node;
            enqueueAdjacentNodes(node, queue);
        }
        return null;
    }

    private char[][] parseResult(Node node){
        if (node == null)
            return null;

        while (node.getParent() != null) {
            if (navMap[node.getX()][node.getY()] == road)
                navMap[node.getX()][node.getY()] = path;
            node = node.getParent();
        }
        return navMap;
    }
}
