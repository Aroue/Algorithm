package FileUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile
{
    public static void main( String[] args )
    {
        try{
            int[] data = new int[10000];
            for (int i = 0;i < data.length; i++){
                data[i] = (int) (1 + Math.random() * 100000);
            }

            File file =new File("data.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            //true = append file
            FileWriter fileWriter = new FileWriter(file.getName());
            for(int i = 0;i < data.length;i++) {
                bw.write(String.valueOf(data[i]));
                bw.newLine();
            }
            bw.close();
            fw.close();

            System.out.println("Done");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}