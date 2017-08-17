package io.github.zodzhao;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jiazhengzhao on 8/15/17.
 * evaluate parsed instructions and read or write di.
 */
class Eval {
    private String FILEPATH = "res/di/";
    private int password;
    private BufferedReader in;
    private String PASSPATH;

    Eval(BufferedReader in) throws IOException {
        //init
        PASSPATH = "res/.secure/";
        ObjectReader or = new ObjectReader(PASSPATH + "passobj");
        password = (int) or.readObject();
        this.in = in;

        // Prompt
        System.out.println("INITIATING...");

        //see if password already exist
        //TODO: MAYBE MORE FRIENDLY INTERFACE
        File varTmpDir = new File(PASSPATH + "passobj");
        if (varTmpDir.exists()) {
            // prompt input password
            String inputPassword = "randomized long string that does nto nae ahdfape kjafd";
            System.out.println("Please Enter Your Password Here:");
            inputPassword = in.readLine();
            if ((inputPassword.hashCode()) != (password)) {
                System.exit(0);
            } else {
                System.out.println("UNLOCKED");
            }
        } else {
            //set password
            String password1 = "1";
            String password2 = "2";
            while (!password1.equals(password2)) {
                System.out.println("Please Enter Your Password Here:");
                password1 = in.readLine();

                System.out.println("Please Confirm Your Password:");
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

        return p.parse(line, this);

    }

    /**
     * Write the Diary
     *
     * @return
     */
    String write(String filename) throws IOException, InterruptedException {
        // todo: figure out how to update the folder immediately after writing
        PrintWriter writer = new PrintWriter(FILEPATH + filename, "UTF-8");
        String EXIT = "finish";
        String PROMPT = "-";
        String line = "";
        System.out.print(PROMPT);
        while ((line = in.readLine()) != null) {
            if (EXIT.equals(line)) {
                break;
            }
            if (!line.trim().isEmpty()) {
                writer.println(Utility.encrypt(line));
            }
            System.out.print(PROMPT);
        }
        writer.close();
        return filename + ".txt CLOSED and SAVED!";
    }

    /**
     * STEP 1: GET THE ORIGINAL PASSWORD
     * STEP 2: SET PASSWORD LIKE NEVER DID BEFORE
     *
     * @return
     */
    String setPassword() throws IOException {
        // prompt input old password
        System.out.println("Hey you wanna change your password huh?");
        System.out.println("First, please enter the current password");
        System.out.print("Old password: ");

        // get the line
        String usrInputOld = in.readLine();
        // compare
        if (usrInputOld.hashCode() == password) {
            System.out.println("Yay you can reset now");

            //set password
            String password1 = "1";
            String password2 = "2";
            while (!password1.equals(password2)) {
                System.out.println("Please Enter Your Password Here:");
                password1 = in.readLine();

                System.out.println("Please Confirm Your Password:");
                password2 = in.readLine();
            }

            //write to object
            ObjectWriter ow = new ObjectWriter(PASSPATH + "passobj");
            ow.writeObject(password1.hashCode());
            return "Your password has been reset, please don't forget it";

        } else {
            return "Uh Oh Wrong password! Bye you idiot";
        }
    }

    String delete(String filename) {
        //TODO: IMPLEMENT
        return "";
    }

    String read(String filename) {

        File file = new File(FILEPATH + filename );

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                System.out.println(i);
            }
            sc.close();
            return "";

        } catch (FileNotFoundException e) {
            return "This is not the droid you are looking for.";
        }

    }

    String view() {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        try {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory " + file.getName());
                }
            }
            return "";
        } catch (NullPointerException e) {
            return "Sorry there is not yet any files";
        }

    }
}
