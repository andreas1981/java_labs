package com.kuzmenko.holder;

/**
 * Created by Andrew_Elena on 03.07.2016.
 */
public class TestPropertyHolder {
    public static void main(String[] args) {
        PropertyHolder propertyHolder = PropertyHolder.getInstance();
        //Чтение из файла значений строки коннекта
        propertyHolder.getConnString("E:\\workspace\\src\\main\\java\\com\\kuzmenko\\holder\\config.properties");
        //Возврат конкретных значений из полей host, login, password
        System.out.println("host = " + propertyHolder.getHost());
        System.out.println("login = " + propertyHolder.getLogin());
        System.out.println("password = " + propertyHolder.getPassword());
    }
}
