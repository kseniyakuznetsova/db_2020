package db;

import org.springframework.stereotype.Component;

@Oracle
@Component
public class OracleDAO implements DAO {
    @Override
    public void save() {
        System.out.println("save from Oracle");
    }
}
