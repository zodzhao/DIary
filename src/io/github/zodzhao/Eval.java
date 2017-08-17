package io.github.zodzhao;

import java.io.*;

/**
 * Created by jiazhengzhao on 8/15/17.
 * evaluate parsed instructions and read or write di.
 */
public class Eval {
    String FILEPATH = "res/di/";
    private BufferedReader in;

    Eval(BufferedReader in) throws IOException {
        // Prompt
        this.in = in;
        System.out.println("INITIATING...");

        //see if password already exist
        String PASSPATH = "res/.secure/";
        File varTmpDir = new File(PASSPATH + "passobj");
        if (varTmpDir.exists()) {
            in = new BufferedReader(new InputStreamReader(System.in));

            ObjectReader or = new ObjectReader(PASSPATH + "passobj");
            int password = (int) or.readObject();

            // prompt input password
            String inputPassword = "randomized long string that does nto nae ahdfape kjafd";
//            while (inputPassword != password){
            System.out.println("Please Enter Your Password Here:");
            inputPassword = in.readLine();
//            }
            if ((inputPassword.hashCode()) != (password)) {
                System.exit(0);
            } else {
                System.out.println("UNLOCKED");
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

            //TODO: NOT SECURE; HASH IT

            ObjectWriter ow = new ObjectWriter(PASSPATH + "passobj");
            ow.writeObject(password1.hashCode());

            System.out.println("You're All Set :P");
            System.out.print(">");
        }

    }

    String eval(String line) throws IOException, InterruptedException {
        Parse p = new Parse();
        p.parse(line, this);

        return "";
    }

    /**
     * Write the Diary
     *
     * @return
     */
    String write(String filename) throws IOException, InterruptedException {

        PrintWriter writer = new PrintWriter(FILEPATH + filename + ".txt", "UTF-8");
        String EXIT = "finish";
        String PROMPT = "-";
        String line = "";
        System.out.print(PROMPT);
        while ((line = in.readLine()) != null) {
            if (EXIT.equals(line)) break;
            if (!line.trim().isEmpty()) {
                writer.println(Utility.encrypt(line));
            }
            System.out.print(PROMPT);
        }
        writer.close();

        return null;
    }

    String setPassword() {
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
