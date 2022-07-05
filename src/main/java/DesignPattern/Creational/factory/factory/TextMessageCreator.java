package DesignPattern.Creational.factory.factory;

import DesignPattern.Creational.factory.product.Message;
import DesignPattern.Creational.factory.product.TextMessage;

public class TextMessageCreator extends MessageCreator{


    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
