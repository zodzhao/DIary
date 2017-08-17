package io.github.zodzhao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiazhengzhao on 8/15/17.
 * Function: Parse commandline input and calls evaluation
 */
public class Parse {
    private final String REST = "\\s*(.*)\\s*";

    // Stage 1 syntax, contains the command name.
    private final Pattern PASSWORD_CMD = Pattern.compile("set password" + REST),
            WRITE_CMD = Pattern.compile("write " + REST),
            READ_CMD = Pattern.compile("read " + REST),
            DELETE_CMD = Pattern.compile("delete " + REST),
            VIEW_CMD = Pattern.compile("view" + REST);


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
    String parse(String query, Eval e) throws Exception {

        Matcher m;

        if ((m = WRITE_CMD.matcher(query)).matches()) {
            System.out.println(m.group(1));
            return e.write(m.group(1));
        } else if ((m = READ_CMD.matcher(query)).matches()) {
            System.out.println(m.group(1));
            return e.read(m.group(1));
        } else if ((m = PASSWORD_CMD.matcher(query)).matches()) {
            return e.setPassword();
        } else if ((m = DELETE_CMD.matcher(query)).matches()) {
            System.out.println(m.group(1));
            return e.delete(m.group(1));
        } else if ((m = VIEW_CMD.matcher(query)).matches()) {
            System.out.println(m.group(1));
            return e.view();
        } else {
            return "malformed command!";
        }
    }
}
