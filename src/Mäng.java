import java.util.*;

class Mäng {
    Lemmad lemmad;
    Kontroll kontroll;
    List<String> arvatudSõnad;
    String tähed;

    public Mäng() {
        this.lemmad = new Lemmad();
        this.kontroll = new Kontroll();
        this.arvatudSõnad = new ArrayList<>();
        this.tähed = "";
    }

    void mänguTsükkel() {
        Scanner scanner = new Scanner(System.in);
        tähed = genereeriTähed();
        while (!kontroll.saabTehaSõna(tähed)) {
            tähed = genereeriTähed();
        }
        while (mängAktiivne) {
            System.out.println("Siin on sinu tähed: " + tähed);
            String sõna = scanner.nextLine();
            if (mängijaArvab(sõna, tähed)) {
                tähed = eemaldaKasutatudTähed(sõna, tähed);
                while (tähed.length() < 7 || !kontroll.saabTehaSõna(tähed)) {
                    tähed += genereeriÜksTäht();
                }
            }
        }
    }

    String genereeriÜksTäht() {
        String tähed = "abdeghijklmnoprstuv";
        String haruldasedTähed = "fõäöü";
        String vägaHaruldasedTähed = "cqšzžwxy";
        Random rand = new Random();
        int valik = rand.nextInt(100);
        if (valik < 74) {
            // 75% tõenäosusega valime tavalise tähe
            int indeks = rand.nextInt(tähed.length());
            return String.valueOf(tähed.charAt(indeks));
        } else if (valik < 94) {
            // 20% tõenäosusega valime haruldase tähe
            int indeks = rand.nextInt(haruldasedTähed.length());
            return String.valueOf(haruldasedTähed.charAt(indeks));
        } else {
            // 5% tõenäosusega valime väga haruldase tähe
            int indeks = rand.nextInt(vägaHaruldasedTähed.length());
            return String.valueOf(vägaHaruldasedTähed.charAt(indeks));
        }
    }


    static void alustaMäng() {
        while (true) {
            Mäng mäng = valiMängutüüp();
            if (mäng == null) {
                break;
            }
            System.out.println("Mängu saab sulgeda, sisestades 'quit', mängu lõpetamiseks ja menüüsse naasmiseks, sisesta 'menüüsse'");
            System.out.println("Uue tähe saamiseks sisesta '+'");
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

    boolean mängijaArvab(String sõna, String tähed) {
        if (sõna.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        if (sõna.equalsIgnoreCase("menüüsse")) {
            lõpetaMäng();
            return false;
        }
        if (sõna.equalsIgnoreCase("+")) {
            this.tähed += genereeriÜksTäht();
            return false;
            }
        if (!sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
            System.out.println("Sõna ei saa moodustada pakutud tähtedest. Proovi uuesti.");
            return false;
        }
        if (arvaSõna(sõna)) {
            System.out.println("Õige sõna!");
            return true;
        } else {
            System.out.println("Vale sõna. Proovi uuesti.");
            return false;
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
        String tähed = "abdeghijklmnoprstuv";
        String haruldasedTähed = "fõäöü";
        String vägaHaruldasedTähed = "cqšzžwxy";
        Random rand = new Random();
        StringBuilder genereeritudTähed = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int valik = rand.nextInt(100);
            if (valik < 74) {
                // 75% tõenäosusega valime tavalise tähe
                int indeks = rand.nextInt(tähed.length());
                genereeritudTähed.append(tähed.charAt(indeks));
            } else if (valik < 94) {
                // 20% tõenäosusega valime haruldase tähe
                int indeks = rand.nextInt(haruldasedTähed.length());
                genereeritudTähed.append(haruldasedTähed.charAt(indeks));
            } else {
                // 5% tõenäosusega valime väga haruldase tähe
                int indeks = rand.nextInt(vägaHaruldasedTähed.length());
                genereeritudTähed.append(vägaHaruldasedTähed.charAt(indeks));
            }
        }
        return genereeritudTähed.toString();
    }

}

