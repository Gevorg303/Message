package chat;

import java.util.ArrayList;
import java.util.List;

public class ChatList {
    private List<Chat> chats;/*Список всех чатов*/

    public ChatList() {
        this.chats = new ArrayList<>();
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
