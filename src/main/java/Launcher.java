import services.PersistanceService;

public class Launcher {


    public static void main(String[] args) {
        PersistanceService ps = new PersistanceService();
        ps.testJoueursTable();

        ps.getAllPlayerFromGame(1);
    }
}
