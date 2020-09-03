package homework.never_use_switch;

import heroes.Hero;
import heroes.HeroesConfig;
import homework.never_use_switch.distributors.MailDistributor;
import homework.never_use_switch.distributors.MailDistributorsConfig;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MailService {

    private Map<Integer, MailDistributor> distributorMap = new MailDistributorsConfig().getDistributorMap();

    public void sendMailInfo(MailInfo mailInfo){
        int mailType = mailInfo.getMailType();
        MailDistributor distributor = distributorMap.get(mailType);
        distributor.sendMailInfo(mailInfo);
    }

}
