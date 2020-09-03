package homework.never_use_switch.distributors;

import homework.never_use_switch.MailInfo;

public class WelcomeMailDistributor implements MailDistributor {

    @Override
    public void sendMailInfo(MailInfo mailInfo) {
        System.out.println("WELCOME " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }
}
