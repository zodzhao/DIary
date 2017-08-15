package io.github.zodzhao;

import java.awt.*;
import java.io.*;

import static java.lang.System.in;

/**
 * Created by jiazhengzhao on 8/15/17.
 * evaluate parsed instructions and read or write files.
 */
public class Eval {
    String FILEPATH = "res/files/";
    String PASSPATH = "res/.secure/";
    String password;
    BufferedReader in;

    public Eval(BufferedReader in) throws IOException {
        // Prompt
        this.in = in;
        System.out.println("INITIATING...");

        //see if password already exist
        File varTmpDir = new File(PASSPATH + "passobj.txt");
        if (varTmpDir.exists()) {
            in = new BufferedReader(new InputStreamReader(System.in));

            ObjectReader or = new ObjectReader(PASSPATH + "passobj.txt");
            String password = (String) or.readObject();

            // prompt input password
            String inputPassword = "randomized long string that does nto nae ahdfape kjafd";
//            while (inputPassword != password){
                System.out.println("Please Enter Your Password Here:");
                inputPassword = in.readLine();
//            }
            if (!inputPassword.equals(password)) {
                System.exit(0);
            }


        } else {
            in = new BufferedReader(new InputStreamReader(System.in));

            //set password
            String password1 = "1";
            String password2 = "2";
            while (!password1.equals(password2)) {
                System.out.println("Please Enter Your Password Here:");
                password1 = in.readLine();

                System.out.println("Please Enter Your Confirm Your Password:");
                password2 = in.readLine();
            }

            //TODO: WRITE PASSWORD IN OBJECT FILE;
            System.out.println("You're All Set");
            System.out.print(">");





        }

    }

    String eval(String line) throws IOException, InterruptedException {
        Parse p = new Parse();
        p.parse(line, this , in);

        return "";
    }

    /**
     * Write the Diary
     *
     * @return
     */
    String write(String filename) throws IOException, InterruptedException {
        File a = File.createTempFile("zodthegod", "nonempty");
        Desktop.getDesktop().edit(a);

        PrintWriter writer = new PrintWriter(filename + ".txt", "UTF-8");
        writer.println(a.getAbsoluteFile());
        writer.close();
        return "lol";
    }

    String setPassword(BufferedReader in) {
        //TODO: IMPLEMENT
        return null;
    }

    String delete(String filename) {
        //TODO: IMPLEMENT
        return null;
    }

    String read(String filename) {
        //TODO: IMPLEMENT
        return null;

    }
}
