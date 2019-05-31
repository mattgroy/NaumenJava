import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class BFSNavigatorTest
{
    private Navigator navigatorBFS = new BFSNavigator();

    @Test
    public void test_searchRoute_Success1()
    {
        char[][] input = {
            {'.', '.', '.', '@', '.'},
            {'.', '#', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'#', '#', '#', '#', '.'},
            {'.', 'X', '.', '.', '.'}
        };
        char[][] expected = {
            {'+', '+', '+', '@', '.'},
            {'+', '#', '#', '#', '#'},
            {'+', '+', '+', '+', '+'},
            {'#', '#', '#', '#', '+'},
            {'.', 'X', '+', '+', '+'}
        };
        char[][] actual = navigatorBFS.searchRoute(input);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void test_searchRoute_Success2()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', 'X'},
            {'.', '.', '.', '.', '.'}
        };

        char[][] expected = {
            {'.', '+', '+', '+', '@'},
            {'#', '+', '#', '#', '#'},
            {'.', '+', '.', '.', '.'},
            {'.', '+', '+', '+', 'X'},
            {'.', '.', '.', '.', '.'}
        };
        char[][] actual = navigatorBFS.searchRoute(input);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void test_searchRoute_Failure()
    {
        char[][] input = {
            {'.', '.', '.', '@', '.'},
            {'#', '#', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', 'X', '.', '.', '.'}
        };
        char[][] actual = navigatorBFS.searchRoute(input);
        assertNull(actual);
    }

    @Test
    public void test_searchRoute_FailureNullInput()
    {
        char[][] actual = navigatorBFS.searchRoute(null);
        assertNull(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowNoStartFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '.'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', 'X'},
            {'.', '.', '.', '.', '.'}
        };

        char[][] actual = navigatorBFS.searchRoute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowNoFinishFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'}
        };

        char[][] actual = navigatorBFS.searchRoute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowUnknownSymbolFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', 'H', '.', '.'},
            {'.', '.', '.', '.', 'X'},
            {'.', '.', '.', '.', '.'}
        };

        char[][] actual = navigatorBFS.searchRoute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowEmptyInputPassed()
    {
        char[][] input = { };

        char[][] actual = navigatorBFS.searchRoute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowEmptyLineInInputPassed()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {},
            {'X', '.', '.', '.', '.'}
        };

        char[][] actual = navigatorBFS.searchRoute(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchRoute_ThrowInconsistent2DArrayPassed()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '#', '.'},
            {'X', '.', '.', '.', '.'}
        };

        char[][] actual = navigatorBFS.searchRoute(input);
    }
}