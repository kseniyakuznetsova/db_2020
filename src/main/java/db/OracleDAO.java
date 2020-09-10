package db;

import org.springframework.stereotype.Component;

@DAOType(databaseType = DatabaseTypes.ORACLE)
//@Oracle
@Component
public class OracleDAO implements DAO {
    @Override
    public void save() {
        System.out.println("save from Oracle");
    }
}
