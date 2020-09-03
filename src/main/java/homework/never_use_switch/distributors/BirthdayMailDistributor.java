package homework.never_use_switch.distributors;

import homework.never_use_switch.MailInfo;

public class BirthdayMailDistributor implements MailDistributor {

    @Override
    public void sendMailInfo(MailInfo mailInfo) {
        System.out.println("HAPPY_BIRTHDAY " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }
}
