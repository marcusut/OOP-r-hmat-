class Kontroll {
    List<String> genereeriKombinatsioonid(String tähed) {
        List<String> kombinatsioonid = new ArrayList<>();
        boolean[] kasutatud = new boolean[tähed.length()];
        genereeriKombinatsioonid("", tähed, kasutatud, kombinatsioonid);
        return kombinatsioonid;
    }

    private void genereeriKombinatsioonid(String praegune, String tähed, boolean[] kasutatud, List<String> kombinatsioonid) {
        if (!praegune.equals("")) {
            kombinatsioonid.add(praegune);
        }
        for (int i = 0; i < tähed.length(); i++) {
            if (!kasutatud[i]) {
                kasutatud[i] = true;
                genereeriKombinatsioonid(praegune + tähed.charAt(i), tähed, kasutatud, kombinatsioonid);
                kasutatud[i] = false;
            }
        }
    }
}
