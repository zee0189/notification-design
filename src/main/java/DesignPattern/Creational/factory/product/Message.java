package DesignPattern.Creational.factory.product;

import java.util.Locale;

public abstract class Message {

    protected abstract String getContent();

    public String getEncryptedMessage(){
        String content = getContent();
        return content.toLowerCase(Locale.ROOT);
    }
}
