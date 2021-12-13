package neu.edu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtils {

    public static List<String> read(String fileName){
        List<String> res = new ArrayList<>();
        String thisLine = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fr);
            while((thisLine = in.readLine()) != null){
                res.add(thisLine);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static void write(String fileName, List<String> res){
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fw);
            for (String s: res){
                out.write(s);
                out.newLine();
            }
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test;
        String fileName = "ratioRules.txt";
        List<String> rules = FileUtils.read(fileName);
        for (String s: rules){
            System.out.println(s);
        }
        //rules.add("60-99999,15,15:1,2");
        FileUtils.write(fileName, rules);

        String fileName2 = "students.txt";
        List<String> students = FileUtils.read(fileName2);
        Random rand = new Random();
        for (int j = 0; j < students.size(); j++){
            String s = students.get(j);
//            s = s.concat(",");
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < 10; i++){
//                int digit = rand.nextInt(10);
//                if (i == 0 && digit == 0){
//                    digit = rand.nextInt(10);
//                }
//                sb.append(String.valueOf(digit));
//            }
//            s = s.concat(sb.toString());
//            students.set(j, s);
            System.out.println(s);
        }

        FileUtils.write(fileName2, students);


    }


}
