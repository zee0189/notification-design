package DesignPattern.Creational.factory;

import DesignPattern.Creational.factory.factory.JsonMessageCreator;
import DesignPattern.Creational.factory.factory.MessageCreator;
import DesignPattern.Creational.factory.factory.TextMessageCreator;
import DesignPattern.Creational.factory.product.Message;

public class Client {

    public static void main(String[] args) {
         printMessage(new JsonMessageCreator());
         printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator messageCreator){
        Message message = messageCreator.getMessage();
        String encryptedMessage = message.getEncryptedMessage();
        System.out.println(encryptedMessage);
    }
}
