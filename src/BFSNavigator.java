import javafx.util.Pair;

public class BFSNavigator implements Navigator {
    private static final char wall = '#';
    private static final char road = '.';
    private static final char chaA = '@';
    private static final char chaB = 'x';

    private Pair<Integer, Integer> start;
    private Pair<Integer, Integer> finish;
    private boolean[][] boolMap;
    private int width;
    private int height;

    @Override
    public char[][] searchRoute(char[][] map) {
        parseMap(map);
        return new char[0][];
    }

    private void parseMap(char[][] map) {
        if (map.length <= 0 || map[0].length <= 0)
            throw new IllegalArgumentException();

        height = map.length;
        width = map[0].length;
        boolMap = new boolean[height][width];

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                switch (map[x][y]) {
                    case wall:
                        boolMap[x][y] = false;
                        break;
                    case road:
                        boolMap[x][y] = true;
                        break;
                    case chaA:
                        boolMap[x][y] = true;
                        start = new Pair<>(x, y);
                        break;
                    case chaB:
                        boolMap[x][y] = true;
                        finish = new Pair<>(x, y);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
    }
}
