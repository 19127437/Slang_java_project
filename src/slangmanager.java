

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.*;
import java.io.*;

public class slangmanager {

    public static HashMap<String,List<String>> list=new HashMap<String,List<String>>();
    public static List<String> history = new ArrayList<>();
    public static final String File_Name="slang.txt";
    public static final String File_save ="fixslang.txt";

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
           System.out.print(i +":" +list.get(i));
           System.out.print("\n");
       }
   }
   public static void Find_slang(String name){
        history.add(name);
        List<String> defi = list.get(name);
        if(defi==null){
            System.out.print("Can not find definition: please re-enter!! \n" );
        }
        else{

            for(int i=0;i<defi.size();i++){
                System.out.print("Definition: " + defi.get(i) +"\n");
            }
        }
   }
   public static void Find_Definition(String name){
        List<String> array = new ArrayList<>();
       for (String i: list.keySet()) {
           for(int j=0;j<list.get(i).size();++j){
               if(list.get(i).get(j).contains(name)){
                   array.add(i);
               }
           }
       }
       if(array.isEmpty()){
           System.out.print(" Slang word no find !!\n ");
       }
       else{
           System.out.print("Slang is:\n");
           for(int i=0;i<array.size();i++){
               System.out.print( array.get(i) +"\n");
           }
       }
   }
   public static void Get_history(){
        System.out.print("History\n");
        for(int i=0;i<history.size();i++){
            System.out.print(history.get(i) + "\n");
        }
   }
   public static void save_file_hashmap(String file ,HashMap<String,List<String>> h ){
       List<String> b = new ArrayList<String>();

       try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)))) {


           List<String> array = new ArrayList<>();
           for (String i: list.keySet()) {
               bw.write(i +" ` ");
               array= list.get(i);
               if(array.size()==1){
                   bw.write(array.get(0)+"|");
               }
               else{
                   for(int j=0;j<array.size();++j){
                       if(j+1==array.size())
                           
                       bw.write(array.get(j)+"|");

                   }
               }

           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public static void add_slangword(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter new slangword: \n");
       String slangnew = scanner.nextLine();
       int n=1;
       List<String> list_defi =new ArrayList<>();
       while(n!=0){
           System.out.print("Enter new definition: \n");
           String defi = scanner.nextLine();
           list_defi.add(defi);
           System.out.print("Do you want to add mỏe definition? (yes=1 , no=0)");
           {
               int m=scanner.nextInt();
               if(m==1){
                   n=1;
               }
               else
                   n=0;
           }
       }
       if(list.containsKey(slangnew)){
           System.out.print("I'm sorry slang word existed :( !!!\n");
           System.out.print("You want overwrite or duplicate\n");
           System.out.print("    1-overwrite\n");
           System.out.print("    2- duplicate\n");
           int choice=scanner.nextInt();
           if(choice==1){

           }
       }

   }



}
