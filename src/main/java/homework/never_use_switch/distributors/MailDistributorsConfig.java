package homework.never_use_switch.distributors;

import homework.never_use_switch.distributors.BirthdayMailDistributor;
import homework.never_use_switch.distributors.EmailCallBackMailDistributor;
import homework.never_use_switch.distributors.MailDistributor;
import homework.never_use_switch.distributors.WelcomeMailDistributor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MailDistributorsConfig {
    @Getter
    Map<Integer, MailDistributor> distributorMap = new HashMap<>() {
        {
            put(1, new WelcomeMailDistributor());
            put(2, new EmailCallBackMailDistributor());
            put(3, new BirthdayMailDistributor());
        }
    };
}
