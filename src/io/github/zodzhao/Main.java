package io.github.zodzhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String EXIT = "exit";
    private static final String PROMPT = "> ";

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        System.out.print(PROMPT);
        Eval e = new Eval(in);

        String line = "";
        while ((line = in.readLine()) != null) {
            if (EXIT.equals(line)) {
                break;
            }

            if (!line.trim().isEmpty()) {
                String result = e.eval(line);
                if (result.length() > 0) {
                    System.out.println(result);
                }
            }
            System.out.print(PROMPT);
        }
        in.close();
    }

}
