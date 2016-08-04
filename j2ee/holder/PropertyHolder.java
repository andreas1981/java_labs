package com.kuzmenko.holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Andrew_Elena on 30.06.2016.
 */
public class PropertyHolder {
    private String host;
    private String login;
    private String password;

    private static PropertyHolder instance = null;

    public static PropertyHolder getInstance() {
        if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (PropertyHolder.class) {
                if (instance == null) {
                    instance = new PropertyHolder();
                }
            }
        }
        return instance;
    }

    public void getConnString(String path) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(path);
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

            /*System.out.println("HOST: " + getHost()
                    + ", LOGIN: " + getLogin()
                    + ", PASSWORD: " + getPassword());
            */
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

    private PropertyHolder() {
    }

    public String getHost() {
        return host;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}