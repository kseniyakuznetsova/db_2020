package db;

import org.springframework.stereotype.Component;

@DAOType(databaseType = DatabaseTypes.DERBY)
//@Derby
@Component
public class DerbyDAO implements DAO {
    @Override
    public void save() {
        System.out.println("save from Derby");
    }
}
