package homework.radio_alarm;

public class RadioAlarm implements Radio, Alarm{
    private Radio radio = new RadioImpl();
    private Alarm alarm = new AlarmImpl();

    @Override
    public void c() {
        alarm.c();
    }

    @Override
    public void d() {
        alarm.d();
    }

    @Override
    public void a() {
        radio.a();
    }

    @Override
    public void b() {
        radio.b();
    }
}
