package DesignPattern.Creational.singleton;

public class RegistryLazy {

    private RegistryLazy(){}

    private volatile static RegistryLazy INSTANCE;

    public static RegistryLazy getInstance(){
        if (INSTANCE == null){
            synchronized (RegistryLazy.class){
                if (INSTANCE == null){
                    INSTANCE = new RegistryLazy();
                    return INSTANCE;
                }
            }
        }
        return INSTANCE;
    }

    public String configuration(){
        return "Configurations";
    }
}
