

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.io.*;

public class slangmanager {

    public static HashMap<String,List<String>> list=new HashMap<String,List<String>>();
    public static List<String> history = new ArrayList<>();
    public static final String File_Name="slang.txt";

    public static void Load_Data_Slangword(){

        List<String> arr = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(File_Name)))) {
            String str=null;
            while (true) {
                str = br.readLine();
                if (str == null)
                    break;
                arr.add(str);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).contains("`")) {
                String[] array = arr.get(i).split("`");
                String[] array_defi = array[1].split("\\|");
                List<String> defi = Arrays.asList(array_defi);
                list.put(array[0], defi);
            }
        }

    }
   public static  void Get_hashmap(){

        System.out.print(list.keySet());
       for (String i: list.keySet())
       {
//           List<String> defLis = list.get(i);
//           for(String ii: defLis) {
//                  if (ii.contains(def)){
//                     sWords.add(i);
//                  }
//           }
           System.out.print(list.get(i));
           System.out.print("\n");
       }
   }


}
