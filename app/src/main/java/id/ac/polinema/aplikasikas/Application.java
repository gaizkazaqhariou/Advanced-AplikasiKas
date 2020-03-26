package id.ac.polinema.aplikasikas;

import id.ac.polinema.aplikasikas.model.Account;
import id.ac.polinema.aplikasikas.model.Session;

public class Application extends android.app.Application {
    private static Account account;
    private static Session session;

    public static Account getAccount() {
        return account;
    }

    public static Session getSession() {
        return session;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        account = new Account("gazka");
        session = new Session(this);
    }
}
