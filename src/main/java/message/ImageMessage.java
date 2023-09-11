package message;

public class ImageMessage extends Message{

    public ImageMessage(String message) {
        super(message);
    }

    @Override
    public String getMessageType() {
        return "Картинка";
    }
}
