
import DAO.AlbaranDAO;
import model.Albaran;
import sql.MotorPostgres;

public class App {
    public static void main(String[] args) {
        MotorPostgres pg = new MotorPostgres();
        AlbaranDAO adao = new AlbaranDAO();
        Albaran albaran = new Albaran();
        adao.update(albaran);

    }
}
