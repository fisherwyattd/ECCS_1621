public class Pirate {
    private String name;
    private String rank;
    public Pirate(String name, String rank) {  this.name = name;  this.rank = rank;  }

    public static void countPirates() {
        System.out.println("20 Pirates");
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }
}
