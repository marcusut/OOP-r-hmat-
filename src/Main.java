import java.util.List;

class Main {
    static Lemmad lemmad = new Lemmad("ASSETS/lemmad.txt");
    static Kontroll kontroll = new Kontroll();

    static boolean saabTehaSõna(String tähed) {
        List<String> kombinatsioonid = kontroll.genereeriKombinatsioonid(tähed);
        for (String kombinatsioon : kombinatsioonid) {
            if (lemmad.sõnaEksisteerib(kombinatsioon)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lemmad.loefailist("ASSETS/lemmad.txt");
        System.out.println(lemmad.sõnaEksisteerib("koer")); // peaks printima "true", kui "koer" on lemmad.txt failis
        System.out.println(lemmad.sõnaEksisteerib("aib")); // peaks printima "false", kui "aib" ei ole lemmad.txt failis
        System.out.println(lemmad.sõnaEksisteerib("auto")); // peaks printima "true", kui "auto" on lemmad.txt failis
    }

}
