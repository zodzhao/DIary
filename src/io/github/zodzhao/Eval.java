package io.github.zodzhao;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jiazhengzhao on 8/15/17.
 * evaluate parsed instructions and read or write files.
 */
public class Eval {
    static String eval(String line) throws IOException, InterruptedException {
        Parse p = new Parse();
        p.parse(line);

        return "";
    }

    /**
     * Write the Diary
     * @return
     */
    String write(String filename) throws IOException, InterruptedException {
        File a  = File.createTempFile("zodthegod","nonempty");
//        File a = new File("res/temp.txt");
        Desktop.getDesktop().edit(a);

        PrintWriter writer = new PrintWriter(filename + ".txt", "UTF-8");
        writer.println(a.getAbsoluteFile());
        writer.close();
        return "lol";
    }
}
