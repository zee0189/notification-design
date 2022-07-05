package DesignPattern.Creational.factory.product;

public class TextMessage extends Message{
    @Override
    public String getContent() {
        return "text messages";
    }
}
