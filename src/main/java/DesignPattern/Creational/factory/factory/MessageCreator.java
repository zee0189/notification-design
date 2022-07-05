package DesignPattern.Creational.factory.factory;

import DesignPattern.Creational.factory.product.Message;

public abstract class MessageCreator {

    public Message getMessage(){
        return createMessage();
    }

    //factory message
    protected abstract Message createMessage();

}
