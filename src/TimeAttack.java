class TimeAttack extends Mäng {
    int aeg;

    public TimeAttack() {
        super();
        System.out.println("Tere tulemast Time Attack Mode'i!.");
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
            lõpetaMäng();
        }).start();
    }

    @Override
    boolean mängijaArvab(String sõna, String tähed) {
        if (sõna.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        if (sõna.equalsIgnoreCase("restart")) {
            lõpetaMäng();
            return false;
        }
        if (!sõnaOnMoodustatudPakutudTähtedest(sõna, tähed)) {
            System.out.println("Sõna ei saa moodustada pakutud tähtedest. Proovi uuesti.");
            return false;
        }
        int vanaAeg = aeg; // Määrame vanaAeg muutuja väärtuse enne sõna arvamist
        if (arvaSõna(sõna)) {
            System.out.println("Õige sõna!");
            aeg += 5; // iga õige sõna lisab 5 sekundit
        } else {
            System.out.println("Vale sõna. Proovi uuesti.");
            aeg -= 5; // iga vale sõna vähendab aega 5 sekundi võrra
        }
        int ajaMuutus = aeg - vanaAeg;
        System.out.println("Aega " + (ajaMuutus > 0 ? "juurde: " : "maha: ") + Math.abs(ajaMuutus) + " sekundit.");
        System.out.println("Alles on " + aeg + " sekundit.");
        return ajaMuutus > 0;
    }



    @Override
    void lõpetaMäng() {
        if (aeg <= 0) {
            super.lõpetaMäng();
        }
    }
}
