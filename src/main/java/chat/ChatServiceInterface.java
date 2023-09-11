package chat;

import message.Message;
import user.Admin;
import user.User;

public interface ChatServiceInterface {
    Chat createChat(User creator, String name, boolean isPrivate, String password, int maxUsers);
    void deleteChat(User user, Chat chat);
    void addUserToChat(User user, Chat chat, String password);
    void removeUserFromChat(User user, Chat chat);
    void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers);
    void writeMessage(User user, Chat chat, Message message);
}
