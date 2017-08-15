package io.github.zodzhao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiazhengzhao on 8/15/17.
 * Function: Parse commandline input and calls evaluation
 */
public class Parse {
    private final String REST = "\\s*(.*)\\s*",
            COMMA = "\\s*,\\s*",
            AND = "\\s+and\\s+";

    // Stage 1 syntax, contains the command name.
    private final Pattern PASSWORD_CMD = Pattern.compile("set password " + REST),
            WRITE_CMD = Pattern.compile("write " + REST),
            READ_CMD = Pattern.compile("read " + REST),
            MOD_CMD = Pattern.compile("mod " + REST);

//            PRINT_CMD = Pattern.compile("print " + REST),
//            SELECT_CMD = Pattern.compile("select " + REST);


    /**
     * parse method returns String Array
     * <p>
     * - The first element of the array indicates the number of arguments.
     * i.e. the length of the array
     * - The second element specifies action it requires
     * - From the third element on is the arguments of that action.
     *
     * @return String[]
     */
    String parse(String query) {

        Matcher m;
        Eval e = new Eval();

        if ((m = WRITE_CMD.matcher(query)).matches()) {
            System.out.println(m.group(1));
            return e.write(m.group(1));
        }

        return null;
    }
}
