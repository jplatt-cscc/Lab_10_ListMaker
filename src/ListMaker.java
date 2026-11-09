import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner pipe = new Scanner(System.in);
    private static String prompt = "";
    private static boolean inMenu = false;
    private static String input = "";
    private static int low = 0;
    private static int high = 0;
    private static String pattern = "";

    public static void main(String[] args) {
        /*
        ArrayList<String> myArrList = new ArrayList<>(); --> create list
        String var = myArrList.get(m); --> get value
        myArrList.add("Some String"); --> append
        myArrList.add(m, "Some String"); --> insert
        myArrList.remove(m); -- > delete
        myArrList.set(m, "New String Value"); --> replace
        myArrList.size(); --> .length equivalent
        */

        while (!inMenu) { // counter intuitive name but I'm too lazy to think of a better one & the quitList() function works easier this way
            inputMenu();
        }
    }

    private static void inputMenu() {
        prompt = "What would you like to do with the ArrayList? Add (A); Delete (D); Insert (I); Print (P); Quit Program (Q) ";
        pattern = "[AaDdIiPpQq]";
        input = SafeInput.getRegExString(pipe, prompt, pattern);
        input = input.toUpperCase();

        if (input.equals("A")) {
            addList();
        } else if (input.equals("D")) {
            deleteList();
        } else if (input.equals("I")) {
            insertList();
        } else if (input.equals("P")) {
            printList();
        } else {
            quitList();
        }
    }

    private static void addList() {
        prompt = "What would you like to add to the list? ";
        String addString = SafeInput.getNonZeroLenString(pipe, prompt);

        list.add( addString);
    }

    private static void deleteList() {
        prompt = "Which item would you like to delete from the list? (number value) ";
        low = 1;
        high = list.size();
        int deleteInt = SafeInput.getRangedInt(pipe, prompt, low, high);
        deleteInt--;

        list.remove(deleteInt);
    }

    private static void insertList() {
        prompt = "What would you like to insert into the list? ";
        String insertString = SafeInput.getNonZeroLenString(pipe, prompt);
        prompt = "Where in the list would you like to insert that? (number value) ";
        low = 1;
        high = list.size();
        int insertInt = SafeInput.getRangedInt(pipe, prompt, low, high);
        insertInt--;

        list.add(insertInt, insertString);
    }

    private static void printList() {
        for (int i = 0; i < list.size(); i++) {
            String tempPrint = list.get(i);
            System.out.println(tempPrint);
        }
    }

    private static void quitList() {
        prompt = "Are you sure you want to exit the program? (Y/N) ";
        inMenu = SafeInput.getYNConfirm(pipe, prompt);
    }
}