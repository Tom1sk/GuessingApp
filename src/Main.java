import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> list = new HashMap<>();
        list.put("kočka", "Leze toto zvíře po stromech?");
        list.put("pes", "Má toto zvíře dlouhý ocas?");
        list.put("králík", "Má toto zvíře dlouhé uši?");
        list.put("myš", "Je toto zvíře menší než kočka?");

        boolean repeat = true;
        while (repeat) {
            System.out.println("Mysli si nějaké zvíře. Je toto zvíře kočka? (ano/ne)");
            String answer = scanner.nextLine();
            String animalGuess = "kočka";
            while (!answer.equalsIgnoreCase("ano")) {
                System.out.println("Myslel jsi na " + animalGuess + "? (ano/ne)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("ne")) {
                    System.out.println("Jakou otázku můžu položit, aby bylo jasné, jestli si myslel kočku");
                    String newQuestion = scanner.nextLine();
                    list.put(animalGuess, newQuestion);
                    System.out.println("Díky, naučil jsem se něco nového!");
                }
                animalGuess = findNewAnimal(list);
            }
            System.out.println("Hurá, uhodl jsem! Myslel jsi si na " + animalGuess + ".");
            System.out.println("Chceš si zahrát znovu? (ano/ne)");
            answer = scanner.nextLine();
            repeat = answer.equalsIgnoreCase("ano");
        }
        scanner.close();
    }
    private static String findNewAnimal(Map<String, String> list) {
        for (String animal : list.keySet()) {
            if (!animal.equalsIgnoreCase("kočka")) {
                System.out.println(list.get(animal) + " (ano/ne)");
            }
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("ano")) {
                    return animal;
            }

        }
        return null;
    }


}