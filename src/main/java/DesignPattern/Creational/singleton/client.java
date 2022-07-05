package DesignPattern.Creational.singleton;

public class client {

    public static void main(String[] args) {
        RegistryEager registryEager = RegistryEager.getInstance();
        System.out.println(registryEager.getConfiguration());

        RegistryLazy registryLazy = RegistryLazy.getInstance();
        System.out.println(registryLazy.configuration());

        RegistryEnum registryEnum = RegistryEnum.INSTANCE;
        System.out.println(registryEnum.getConfiguration());

        RegistryHolder registryHolder = RegistryHolder.getInstance();
        System.out.println(registryHolder.configuration());

    }
}
