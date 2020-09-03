package homework.never_use_switch.distributors;

import homework.never_use_switch.MailInfo;

public class EmailCallBackMailDistributor implements MailDistributor {
    @Override
    public void sendMailInfo(MailInfo mailInfo) {
        System.out.println("EMAIL_CALLBACK " + mailInfo.getText() + " was sent to" + mailInfo.getEmail());
    }
}
