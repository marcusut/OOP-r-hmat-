class TähtedeEemaldaja {
  String eemaldaKasutatudTähed(String sõna, String tähed) {
    for (char c : sõna.toCharArray()) {
      tähed = tähed.replaceFirst(String.valueOf(c), "");
    }
    return tähed;
  }
}
