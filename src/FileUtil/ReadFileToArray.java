package FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileToArray {

    public static Comparable[] ReadFile(File file) {
        Comparable[] intNumber = new Comparable[10000];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            int index = 0;
            while ((s = br.readLine()) != null) {
                intNumber[index] = Integer.parseInt(s);
                index++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intNumber;
    }

    public static void main(String[] args){
        File file = new File("data.txt");
        for (Comparable intNumber: ReadFile(file))
            System.out.println(intNumber);

    }
}