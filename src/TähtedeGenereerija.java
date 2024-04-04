class TähtedeGenereerija {
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
}
