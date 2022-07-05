package DesignPattern.Creational.singleton;

public class RegistryHolder {

    private RegistryHolder(){}

    private static class RegistryInstance{
        private static final RegistryHolder INSTANCE = new RegistryHolder();
    }

    public static RegistryHolder getInstance(){
        return RegistryInstance.INSTANCE;
    }

    public String configuration(){
        return "config";
    }
}
