 class Mänguvalija {
   static Mäng valiMängutüüp() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Vali mängutüüp: Endless või Aeg. Väljumiseks sisesta 'Quit'.");
            String mängutüüp = scanner.nextLine();

            if (mängutüüp.equalsIgnoreCase("Endless")) {
                return new EndlessMode();
            } else if (mängutüüp.equalsIgnoreCase("Aeg")) {
                return new TimeAttack();
            } else if (mängutüüp.equalsIgnoreCase("Quit")) {
                return null;
            } else {
                System.out.println("Vale mängutüüp. Proovi uuesti.");
            }
        }
    }
 }
