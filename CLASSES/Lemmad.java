class Lemmad {
    Set<String> lemmad = new HashSet<>();

    void loefailist(String failinimi) {
        try {
            File fail = new File(failinimi);
            Scanner scanner = new Scanner(fail, "windows-1252");
            while (scanner.hasNextLine()) {
                String lemma = scanner.nextLine();
                lemmad.add(lemma);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud: " + e.getMessage());
        }
    }

    boolean sõnaEksisteerib(String lemma) {
        return lemmad.contains(lemma);
    }
}