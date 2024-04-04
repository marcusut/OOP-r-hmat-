class Mängulõpetaja {
  void lõpetaMäng() {
        System.out.println("Mäng on läbi! Teie arvatud sõnad olid:");
        for (String sõna : arvatudSõnad) {
            System.out.println(sõna);
        }
        mängAktiivne = false;
    }
}    
