

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.*;
import java.io.*;

public class slangmanager {

    public static HashMap<String,List<String>> list=new HashMap<String,List<String>>();
    public static final String File_Name="slang.txt";
    public static final String File_save ="fixslang.txt";
    public static final String File_history="history.txt";
    public static final String File_root ="slangroot.txt";

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
    public static void savehistory(boolean check, String str){
        String save = null;
        if (check)
            save = "Slangword: " + str;
        else {
            save = "Definition: " + str;
        }
        savefile(File_history, save);
    }
    public static void savefile(String file_save , String value){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file_save)))) {
            bw.write(value);
            bw.newLine();
        }catch (IOException e) {
            System.out.print("Update fail!!!");
            e.printStackTrace();
        }
    }
   public static void Get_history(){
       List<String> arr = new ArrayList<>();
       try(BufferedReader br = new BufferedReader(new FileReader(new File(File_history)))) {
           String str=null;
           while (true) {
               str = br.readLine();
               if (str == null) {
                   System.out.print("No data");
                   break;
               }
               arr.add(str);

           }
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
           for (int i = 0; i < arr.size(); i++) {
               System.out.print(arr.get(i) + "\n");
           }

   }
   public static void save_file_hashmap(String file ,  HashMap<String,List<String>> h ){
       List<String> b = new ArrayList<String>();
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)))) {
           List<String> array = new ArrayList<>();
           for (String i: list.keySet()) {
               bw.write(i +"`");
               array= list.get(i);
               if(array.size()==1){
                   bw.write(array.get(0));
               }
               else{
                   for(int j=0;j<array.size();++j){
                       if(j+1==array.size())
                           bw.write(array.get(j));
                       else
                           bw.write(array.get(j)+"|");
                   }
               }
               bw.newLine();
           }
           bw.close();
       } catch (IOException e) {
           System.out.print("Update fail!!!");
           e.printStackTrace();
       }
   }

   public static void savefile_list() {
        save_file_hashmap(File_save, list);
    }

    public static int Input(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int m=scanner.nextInt();
            if (m!=1 && m!=0)
                System.out.print("please re-enter:");
            else
                return m;
        }
    }
    public static int Input1(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int m=scanner.nextInt();
            if (m!=1 && m!=2 )
                System.out.print("please re-enter:");
            else
                return m;
        }
    }
    public static String  Input11(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String m=scanner.nextLine();
            if (!m.equals("1") && !m.equals("2"))
                System.out.print("please re-enter:");
            else
                return m;
        }
    }
    public static int Input2(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int m=scanner.nextInt();
            if (m!=1 && m!=2 && m!=3 )
                System.out.print("please re-enter:");
            else
                return m;
        }
    }
    public static String Input3(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String m=scanner.nextLine();
            if (!m.equals("1") && !m.equals("2") && !m.equals("3") && !m.equals("4") )
                System.out.print("please re-enter:");
            else
                return m;
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
           System.out.print("Do you want to add more definition? (yes=1 , no=0)");
           {
               int m = Input();
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
           System.out.print("         1-duplicate           \n");
           System.out.print("         2- overwrite          \n");

           int choice=Input1();
           switch (choice) {
               case 1 :
                   updateslang(slangnew, list_defi, true);
                   System.out.print("Add new slang success ");

                   break;
               case 2 :
                   list.put(slangnew, list_defi);
                   System.out.print("Add new slang success ");

                   savefile_list();
                   break;
           }
       }
       else{
           System.out.print("Add new slang success ");
           updateslang(slangnew,list_defi,false);
       }

   }
   public static void updateslang(String slang , List<String> list_defi , boolean check){
        if(check==true){
            List<String> defi=list.get(slang);
            for (String j:defi)
            {
                list_defi.add(j);
            }
            list.put(slang,list_defi);
        }else{
            list.put(slang,list_defi);
        }
       savefile_list();
   }
   public static  void edit_slangword(){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter slangword edit: \n");
       String slangnew = scanner.nextLine();
       savehistory(true,slangnew);
       int n=1;
       List<String> list_defi =new ArrayList<>();
       if(!list.containsKey(slangnew)){
           System.out.print("Not found slang\n");
       }
       else{
           list_defi=list.get(slangnew);
           System.out.print("Slang word: "+ slangnew +"\n");
           for(String j:list_defi){
               System.out.print("Definition: " + j +"\n");
           }
           System.out.print("************ EDIT SLANG ************\n");
           System.out.print("*      1: Edit slangword           *\n");
           System.out.print("*      2: Edit Definition          *\n");
           System.out.print("*      3: Exit                     *\n");
           System.out.print("************************************\n");
           System.out.print("You choice");
           int choice =Input2();
           switch (choice) {
               case 1:
                   System.out.print("Enter slang new: \n");
                   String new_slang=scanner.nextLine();
                   list.put(new_slang,list_defi);
                   savefile_list();
                   break;
               case 2:
                   System.out.print("************ EDIT DEFINITION ************\n");
                   System.out.print("*      1: Edit Definition               *\n");
                   System.out.print("*      2: Add Definition new            *\n");
                   System.out.print("*      3: Change Definition new         *\n");
                   System.out.print("*      4: Exit                          *\n");
                   System.out.print("*****************************************\n");
                   System.out.print("You choice");
                   String choice1=Input3();
                   List<String> list_defi1 =new ArrayList<>();
                   String defi=null;
                   int m;
                   int check=1;
                   int check1=1;
                   switch (choice1){
                       case "1":
                           updatedefi(slangnew,list_defi);

                           break;
                       case "2":
                           while(check!=0){
                               System.out.print("Enter new definition: \n");

                               defi = scanner.nextLine();
                               list_defi1.add(defi);
                               System.out.print("Do you want to add more definition? (yes=1 , no=0)");
                               {
                                   m = Input();
                                   if(m==1){
                                       check=1;
                                   }
                                   else
                                       check=0;
                               }
                           }
                           if(list.containsKey(slangnew)){
                               updateslang(slangnew, list_defi1, true);
                               savefile_list();
                               System.out.print("success !!!!!!!!!! ");

                           }
                           break;
                       case "3":
                           while(check1!=0){
                               System.out.print("Enter new definition: \n");

                               defi = scanner.nextLine();
                               list_defi1.add(defi);
                               System.out.print("Do you want to add more definition? (yes=1 , no=0)");
                               {
                                   m = Input();
                                   if(m==1){
                                       check1=1;
                                   }
                                   else
                                       check1=0;
                               }
                           }
                           if(list.containsKey(slangnew)){
                               list.put(slangnew,list_defi1);
                               savefile_list();
                               System.out.print("success !!!!!!!!!! ");

                           }
                           break;
                       case "4":
                           break;
                   }
               case 3:
                   break;

           }
       }

   }
   public static void updatedefi(String slangnew,List<String> list_defi){
       Scanner scanner = new Scanner(System.in);
       int count=1;
       for(String j:list_defi){
           System.out.print("   "+ count +" "+j +"\n");
           count=count+1;
       }
       while(true){
           int choice2;
           System.out.print("You choice : \n");
           choice2= scanner.nextInt();
           if (choice2 > list_defi.size() || choice2 <0 )
               System.out.print("please re-enter:");
           else {
               System.out.print("You enter definition: ");
               String defi;
               String defiii=scanner.nextLine();
               defi = scanner.nextLine();
               List<String> list_defi1 = new ArrayList<>();
               int count1 = 1;
               for (String n : list_defi) {
                   if (count1 == choice2)
                       list_defi1.add(defi);
                   else
                       list_defi1.add(n);
                   count1 = count1 + 1;
               }
               list.put(slangnew, list_defi1);
               list_defi=list_defi1;
           }
           System.out.print("continue?? (Yes= y | No= n)");
           String cont = scanner.nextLine();
           if (cont.equals("y") || cont.equals("Y")) {
               continue;
           }
           else
               break;

       }
       savefile_list();
   }
   public static void deleteslangword(){
       Scanner scanner = new Scanner(System.in);
       String slangnew;
       System.out.print("Enter slangword delete: \n");
       slangnew= scanner.nextLine();
       savehistory(true,slangnew);
       if(!list.containsKey(slangnew)){
           System.out.print("Not found slang\n");
       }
       else{
            System.out.print("*--------You want delete?--------*\n");
            System.out.print("*             1-yes              *\n");
            System.out.print("*             2-no               *\n");
            System.out.print("*---------------------------------\n");
            System.out.print("You choice: ");
            String input= Input11();
            switch (input){
                case "1":
                    list.remove(slangnew);
                    savefile_list();
                    System.out.print("You have successfully deleted !!!!");
                    break;
                case "2":
                    break;
            }
       }

   }
   public static void reset(){
        list.clear();
       List<String> arr = new ArrayList<>();
       try(BufferedReader br = new BufferedReader(new FileReader(new File(File_root)))) {
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
       System.out.print(list.size());


   }

}
