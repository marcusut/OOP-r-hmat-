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
    void mängijaArvab(String sõna, String tähed) {
        int vanaAeg = aeg;
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
    }

    @Override
    void lõpetaMäng() {
        if (aeg <= 0) {
            super.lõpetaMäng();
        }
    }
}
