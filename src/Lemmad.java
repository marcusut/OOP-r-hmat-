import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Lemmad {
    Set<String> lemmad = new HashSet<>();

    public Lemmad(String failinimi) {
        loefailist(failinimi);
    }

    void loefailist(String failinimi) {
        try {
            File fail = new File(failinimi);
            Scanner scanner = new Scanner(fail, "windows-1252");
            while (scanner.hasNextLine()) {
                String lemma = scanner.nextLine();
                lemmad.add(lemma);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud: " + e.getMessage());
        }
    }

    boolean sõnaEksisteerib(String lemma) {
        return lemmad.contains(lemma);
    }
}