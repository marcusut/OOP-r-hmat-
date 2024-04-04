class SõnaArvaja {
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
}  
