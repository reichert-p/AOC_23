package Helper;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Input {
    public static String[] readStringLines(String path){
        var pathp = Paths.get("src/" + path);
        String content = " ";
        try {
            content = Files.readString(pathp, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            System.out.println("ouiouioui");
        }
        String[] splits = content.split("\r\n");
        return splits;
    }

    public static int[] readIntLines(String path){
        String[] splits = readStringLines(path);
        int[] output = new int[splits.length];
        int i = 0;
        for (String s: splits){
            output[i] = Integer.valueOf(s);
            i++;
        }
        return output;
    }

}
