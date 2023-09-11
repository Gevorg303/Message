package user;

import chat.Chat;

import java.util.List;

public interface UserServiceInterface {
    User createUser(String username);
    void deleteUser(User user);
    List<Chat> getUserChats(User user);
    Chat createChat(User user, String name, boolean isPrivate, String password, int maxUsers);
    void deleteChat(User user, Chat chat);
    void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers);
    void deleteUserAndChats(User user);

}
