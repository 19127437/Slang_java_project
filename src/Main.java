import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        slangmanager.Load_Data_Slangword();
//        slangmanager.save_file_hashmap(slangmanager.File_save , slangmanager.list);
        slangmanager.edit_slangword();
        int n=4;
//        while(n!=0) {
//
//            System.out.print("Nhập tên slang: \n");
//            String name = scanner.nextLine();
//            slangmanager.Find_Definition(name);
//            n=n-1;
//        }

        //slangmanager.Get_history();
    }
}