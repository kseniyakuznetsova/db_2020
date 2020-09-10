package db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import real_spring.quoters.Film;
import real_spring.quoters.Quoter;

import java.util.List;

@Service
public class DBService {

    @Autowired
    //@Oracle
    @DAOType(databaseType = DatabaseTypes.ORACLE)
    private DAO dbDAOForDoWork;

    @Autowired
    //@Derby
    @DAOType(databaseType = DatabaseTypes.DERBY)
    private DAO dbDAOForBackup;

    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        dbDAOForDoWork.save();
    }

    @Scheduled(fixedDelay = 3000)
    public void doBackup(){
        dbDAOForBackup.save();
    }
}
