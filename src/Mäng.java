import java.util.*;

class Mäng {
    Lemmad lemmad;
    Kontroll kontroll;
    List<String> arvatudSõnad;

    public Mäng() {
        this.lemmad = new Lemmad();
        this.kontroll = new Kontroll();
        this.arvatudSõnad = new ArrayList<>();
    }

    void mänguTsükkel() {
        Scanner scanner = new Scanner(System.in);
        String tähed = genereeriTähed();
        while (mängAktiivne) {
            System.out.println("Siin on sinu tähed: " + tähed);
            System.out.println("Sisesta sõna, mida soovid arvata:");
            String sõna = scanner.nextLine();
            if (sõna.equalsIgnoreCase("quit")) {
                lõpetaMäng();
                break;
            }
            if (!sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
                System.out.println("Sõna ei saa moodustada pakutud tähtedest. Proovi uuesti.");
                continue;
            }
            mängijaArvab(sõna, tähed);
            tähed = eemaldaKasutatudTähed(sõna, tähed);
            while (tähed.length() < 7) {
                tähed += genereeriÜksTäht();
            }
        }
    }

    String genereeriÜksTäht() {
        String tähed = "abcdefghijklmnopqrsšzžtuvwõaöüxy";
        Random rand = new Random();
        int indeks = rand.nextInt(tähed.length());
        return String.valueOf(tähed.charAt(indeks));
    }

    boolean sõnaOnMoodustatudPakutudTähtedest(String sõna, String tähed) {
        Map<Character, Integer> tähedKaart = new HashMap<>();
        for (char c : tähed.toCharArray()) {
            tähedKaart.put(c, tähedKaart.getOrDefault(c, 0) + 1);
        }

        for (char c : sõna.toCharArray()) {
            if (!tähedKaart.containsKey(c) || tähedKaart.get(c) == 0) {
                return false;
            }
            tähedKaart.put(c, tähedKaart.get(c) - 1);
        }
        return true;
    }


    static void alustaMäng() {
        while (true) {
            Mäng mäng = valiMängutüüp();
            if (mäng == null) {
                break;
            }
            System.out.println("Mängu saab lõpetada, sisestades 'quit', või alustada uuesti sisestades 'restart'");
            mäng.mänguTsükkel();
        }
    }

    private static Mäng valiMängutüüp() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Vali mängutüüp: Endless või Aeg. Väljumiseks sisesta 'Quit'.");
            String mängutüüp = scanner.nextLine();

            if (mängutüüp.equalsIgnoreCase("Endless")) {
                return new EndlessMode();
            } else if (mängutüüp.equalsIgnoreCase("Aeg")) {
                return new TimeAttack();
            } else if (mängutüüp.equalsIgnoreCase("Quit")) {
                return null;
            } else {
                System.out.println("Vale mängutüüp. Proovi uuesti.");
            }
        }
    }

    // kui sõna on õieti ära arvatud, siis lisame selle arvatudSõnad listi
    boolean arvaSõna(String sõna) {
        sõna = sõna.toLowerCase();
        if (lemmad.sõnaEksisteerib(sõna)) {
            arvatudSõnad.add(lemmad.getSõnaOriginaalVorm(sõna));
            lemmad.eemaldaSõna(sõna);
            return true;
        }
        return false;
    }

    void mängijaArvab(String sõna, String tähed) {
        if (sõna.equalsIgnoreCase("quit")) {
            lõpetaMäng();
        } else if (sõna.equalsIgnoreCase("restart")) {
            lõpetaMäng();
            alustaMäng();
        } else {
            if (!sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
                System.out.println("Sõna ei saa moodustada pakutud tähtedest. Proovi uuesti.");
                return;
            }
            if (arvaSõna(sõna)) {
                System.out.println("Õige sõna!");
                tähed = eemaldaKasutatudTähed(sõna, tähed);
                while (tähed.length() < 7) {
                    tähed += genereeriÜksTäht();
                }
            } else {
                System.out.println("Vale sõna. Proovi uuesti.");
            }
        }
    }

    String eemaldaKasutatudTähed(String sõna, String tähed) {
        for (char c : sõna.toCharArray()) {
            tähed = tähed.replaceFirst(String.valueOf(c), "");
        }
        return tähed;
    }

    boolean mängAktiivne = true;

    void lõpetaMäng() {
        System.out.println("Mäng on läbi! Teie arvatud sõnad olid:");
        for (String sõna : arvatudSõnad) {
            System.out.println(sõna);
        }
        mängAktiivne = false;
    }

    String genereeriTähed() {
        String tähed = "abcdefghijklmnopqrsšzžtuvwõaöüxy";
        Random rand = new Random();
        StringBuilder genereeritudTähed = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int indeks = rand.nextInt(tähed.length());
            genereeritudTähed.append(tähed.charAt(indeks));
        }
        return genereeritudTähed.toString();
    }
}

