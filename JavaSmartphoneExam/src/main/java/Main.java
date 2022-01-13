import Models.SmartPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmartPhone smartPhone1 = new SmartPhone("Samsung", "Note 4", 2014, "black", 500);
        SmartPhone smartPhone2 = new SmartPhone("Iphone", "4", 2010, "black", 1000);
        SmartPhone smartPhone3 = new SmartPhone("Huawei", "P40 Lite", 2020,"blue", 475);

        List<SmartPhone> smartPhones = new ArrayList<>();
        smartPhones.add(smartPhone1);
        smartPhones.add(smartPhone2);
        smartPhones.add(smartPhone3);

        Collections.sort(smartPhones);

        for (SmartPhone s:smartPhones
             ) {
            System.out.println(s);
        }

        saveTheMostExpensiveSmartphoneInATextFile(getTheMostExpensiveSmartphone(smartPhones));

    }

    public static SmartPhone getTheMostExpensiveSmartphone(List<SmartPhone> smartPhones){
        SmartPhone mostExpensiveSmartphone = null;
        for (SmartPhone s:smartPhones
             ) {
            if (mostExpensiveSmartphone==null||mostExpensiveSmartphone.getPrice()<s.getPrice()){
                mostExpensiveSmartphone=s;
            }
        }
        return mostExpensiveSmartphone;
    }

    public static void saveTheMostExpensiveSmartphoneInATextFile(SmartPhone smartPhone){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            System.out.println("Enter a file name:");
            fileName = reader.readLine();

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            writer.println(smartPhone);
            writer.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
