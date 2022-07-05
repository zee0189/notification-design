package DesignPattern.Creational.singleton;

public enum RegistryEnum {

    INSTANCE;

    public String getConfiguration(){
        return "Configuration";
    }
}
