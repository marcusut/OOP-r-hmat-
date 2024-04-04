class Sõnakontrollija {
  boolean sõnaOnMoodustatudPakutudTähtedest(String sõna, String tähed) {
        Map<Character, Integer> tähedKaart = new HashMap<>();
        for (char c : tähed.toCharArray()) {
            tähedKaart.put(c, tähedKaart.getOrDefault(c, 0) + 1);
        }

        for (char c : sõna.toCharArray()) {
            if (!tähedKaart.containsKey(c) || tähedKaart.get(c) == 0) {
                return false;
            }
            tähedKaart.put(c, tähedKaart.get(c) - 1);
        }
        return true;
    }
}
