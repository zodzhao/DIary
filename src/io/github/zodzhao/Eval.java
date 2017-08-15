package io.github.zodzhao;

import java.util.ArrayList;

/**
 * Created by jiazhengzhao on 8/15/17.
 * evaluate parsed instructions and read or write files.
 */
public class Eval {
    static String eval(String line) {
        Parse p = new Parse();
        p.parse(line);

        return "";
    }

    /**
     * Write the Diarys
     * @return
     */
    String write(String filename) {
        return null;
    }
}
