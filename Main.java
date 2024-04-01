class Main {
    Lemmad lemmad = new Lemmad();
    Kontroll kontroll = new Kontroll();

    static boolean saabTehaSõna(String tähed) {
        List<String> kombinatsioonid = kontroll.genereeriKombinatsioonid(tähed);
        for (String kombinatsioon : kombinatsioonid) {
            if (lemmad.sisaldabLemma(kombinatsioon)) {
                return true;
            }
        }
        return false;
    }
}