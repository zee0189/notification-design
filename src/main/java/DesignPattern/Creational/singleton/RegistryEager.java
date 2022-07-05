package DesignPattern.Creational.singleton;

public class RegistryEager {

    private RegistryEager(){}

    private static final RegistryEager INSTANCE = new RegistryEager();

    public static RegistryEager getInstance(){
        return INSTANCE;
    }

    public String getConfiguration(){
        return "Configurations";
    }
}
