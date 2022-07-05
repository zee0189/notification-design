package DesignPattern.Creational.factory.factory;

import DesignPattern.Creational.factory.product.JsonMessage;
import DesignPattern.Creational.factory.product.Message;

public class JsonMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JsonMessage();
    }
}
