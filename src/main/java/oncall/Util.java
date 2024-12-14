package oncall;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitInputWithSeparator(String input, String seperator){
        return Arrays.stream(input.split(seperator, -1)).map(String::trim).toList();
    }
}
