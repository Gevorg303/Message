package chat;

import message.Message;
import user.Admin;
import user.User;

public interface ChatServiceInterface {
    Chat createChat(ChatList chatList, User creator, String name, boolean isPrivate, String password, int maxUsers);
    void deleteChat(ChatList chatList, User user, Chat chat);
    void addUserToChat(User user, Chat chat, String password);
    void removeUserFromChat(ChatList chatList, User user, Chat chat);
    void writeMessage(User user, Chat chat, Message message);
}
