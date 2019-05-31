import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<String> input = new ArrayList<>();
        while (true)
        {
            String line = System.console().readLine();
            if (line.isEmpty()) break;
            input.add(line);
        }

        char[][] arrayInput = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++)
            arrayInput[i] = input.get(i).toCharArray();

        Navigator navigator = new BFSNavigator();
        char[][] result = navigator.searchRoute(arrayInput);

        for (char[] chars : result)
        {
            System.out.println(chars);
        }
    }
}
