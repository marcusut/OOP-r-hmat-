import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static Lemmad lemmad = new Lemmad();
    static Kontroll kontroll = new Kontroll();
    static List<String> arvatudSõnad = new ArrayList<>();

    static boolean saabTehaSõna(String tähed) {
        List<String> kombinatsioonid = kontroll.genereeriKombinatsioonid(tähed);
        for (String kombinatsioon : kombinatsioonid) {
            if (lemmad.sõnaEksisteerib(kombinatsioon)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Mäng.alustaMäng();
    }
}
