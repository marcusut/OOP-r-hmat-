class TimeAttack extends Mäng {
    int aeg;

    public TimeAttack() {
        super();
        System.out.println("Tere tulemast Time Attack Mode'i!.");
        System.out.println("Uue tähe küsimine võtab maha sekundi Teie ajast.");
        this.aeg = 60; // mäng kestab 60 sekundit

        // Alusta taimerit eraldi lõimes
        new Thread(() -> {
            while (aeg > 0) {
                try {
                    Thread.sleep(1000); // oota 1 sekund
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                aeg--;
            }

            // Kui aeg on otsas, lõpeta mäng
            super.lõpetaMäng();
        }).start();

    }

    @Override
    boolean mängijaArvab(String sõna, String tähed) {
        if (!super.mängAktiivne) {
            return false;
        }
        if (sõna.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        if (sõna.equalsIgnoreCase("menüüsse")) {
            super.lõpetaMäng();
            return false;
        }
        int vanaAeg = aeg; // Määrame vanaAeg muutuja väärtuse enne sõna arvamist
        if (arvaSõna(sõna) && sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
            System.out.println("Õige sõna!");
            aeg += 5; // iga õige sõna lisab 5 sekundit
        } else if (sõna.equalsIgnoreCase("+")) {
            super.tähed += genereeriÜksTäht();
            aeg -= 1; // iga uue tähe küsimine võtab maha sekundi
        } else if (!sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
            System.out.println("Sõna ei saa moodustada pakutud tähtedest. Proovi uuesti.");
            aeg -= 5;
        } else {
            System.out.println("Vale sõna. Proovi uuesti.");
            aeg -= 5; // iga vale sõna vähendab aega 5 sekundi võrra
        }
        int ajaMuutus = aeg - vanaAeg;
        System.out.println("Aega " + (ajaMuutus > 0 ? "juurde: " : "maha: ") + Math.abs(ajaMuutus) + " sekundit.");
        System.out.println("Alles on " + aeg + " sekundit.");
        return ajaMuutus > 0;
    }
}
