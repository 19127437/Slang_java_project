
package  Dict_19127437;

import java.io.BufferedReader;
import java.util.Collections;
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
    public static HashMap<String,List<String>>  Load_Slangword(){
        HashMap<String,List<String>> list1=new HashMap<String,List<String>>();
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
                list1.put(array[0], defi);
            }
        }
        return list1;

    }
    public static  void Get_hashmap(){
    }
    public static void Find_slang(String name){

    }
    public static List<String> Find_Definition(String name){
        List<String> array = new ArrayList<>();
        for (String i: list.keySet())
        {
            List<String> defLis = list.get(i);
            for(String j: defLis) {
                if (j.contains(name)){
                    array.add(i);
                }
            }
        }
        return array;
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file_save),true))) {
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
            for (String i: h.keySet()) {
                bw.write(i +"`");
                array= h.get(i);
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
        save_file_hashmap(File_Name, list);
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
    }
    public static  void edit_slangword(){

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
    public  static String getrandom(){
        Random r = new Random();
        int k = r.nextInt(list.size());
        String kw= (String)list.keySet().toArray()[k];
        return kw;
    }
    public static void random(){
        System.out.print(">> Slang word random: \n");
        String slang=getrandom();
        System.out.print("Slang word: "+ slang +"\n");
        for(String j: list.get(slang) ){
            System.out.print("Definition: "+ j +"\n");
        }
    }
    public static void Question(){

        String random=getrandom();
        Random r = new Random();
        List<String> Ans= list.get(random);

        int index = r.nextInt(Ans.size());
        String Answer = Ans.get(index);
        List<String> list_question=new ArrayList<>();
        int check=0;
        while(check<3){
            String slangnew = getrandom();
            if(!slangnew.equals(random)) {
                List<String> new_Ans = list.get(slangnew);
                String Answer_1 = new_Ans.get(r.nextInt(new_Ans.size()));
                check=check+1;
                list_question.add(Answer_1);
            }
            if(check==3)
                break;
        }
        list_question.add(Answer);
        Collections.shuffle(list_question);
        for(int i = 0; i < list_question.size(); i++) {
            System.out.println(i + " - " + list_question.get(i));
        }

    }

}
