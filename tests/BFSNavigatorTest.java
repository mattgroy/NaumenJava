import static org.junit.Assert.*;

import app.navigator.BFSNavigator;
import app.navigator.Navigator;
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
        assertNull(navigatorBFS.searchRoute(null));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowNoStartFound()
//    {
//        char[][] input = {
//            {'.', '.', '.', '.', '.'},
//            {'#', '.', '#', '#', '#'},
//            {'.', '.', '.', '.', '.'},
//            {'.', '.', '.', '.', 'X'},
//            {'.', '.', '.', '.', '.'}
//        };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureNoStartFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '.'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', 'X'},
            {'.', '.', '.', '.', '.'}
        };

        assertNull(navigatorBFS.searchRoute(input));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowNoFinishFound()
//    {
//        char[][] input = {
//            {'.', '.', '.', '.', '@'},
//            {'#', '.', '#', '#', '#'},
//            {'.', '.', '.', '.', '.'},
//            {'.', '.', '.', '.', '.'},
//            {'.', '.', '.', '.', '.'}
//        };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureNoFinishFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'}
        };

        assertNull(navigatorBFS.searchRoute(input));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowUnknownSymbolFound()
//    {
//        char[][] input = {
//            {'.', '.', '.', '.', '@'},
//            {'#', '.', '#', '#', '#'},
//            {'.', '.', 'H', '.', '.'},
//            {'.', '.', '.', '.', 'X'},
//            {'.', '.', '.', '.', '.'}
//        };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureUnknownSymbolFound()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '.', '#', '#', '#'},
            {'.', '.', 'H', '.', '.'},
            {'.', '.', '.', '.', 'X'},
            {'.', '.', '.', '.', '.'}
        };

        assertNull(navigatorBFS.searchRoute(input));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowEmptyInputPassed()
//    {
//        char[][] input = { };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureEmptyInputPassed()
    {
        char[][] input = { };
        assertNull(navigatorBFS.searchRoute(input));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowEmptyLineInInputPassed()
//    {
//        char[][] input = {
//            {'.', '.', '.', '.', '@'},
//            {},
//            {'X', '.', '.', '.', '.'}
//        };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureEmptyLineInInputPassed()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {},
            {'X', '.', '.', '.', '.'}
        };

        assertNull(navigatorBFS.searchRoute(input));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_searchRoute_ThrowInconsistent2DArrayPassed()
//    {
//        char[][] input = {
//            {'.', '.', '.', '.', '@'},
//            {'#', '#', '.'},
//            {'X', '.', '.', '.', '.'}
//        };
//
//        char[][] actual = navigatorBFS.searchRoute(input);
//    }

    @Test()
    public void test_searchRoute_FailureInconsistent2DArrayPassed()
    {
        char[][] input = {
            {'.', '.', '.', '.', '@'},
            {'#', '#', '.'},
            {'X', '.', '.', '.', '.'}
        };

        assertNull(navigatorBFS.searchRoute(input));
    }
}