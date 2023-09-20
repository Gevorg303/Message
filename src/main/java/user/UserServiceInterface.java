package user;

import chat.Chat;
import chat.ChatList;
import chat.ChatService;

import java.util.List;

public interface UserServiceInterface {
    /*Создать нового пользователя*/
    User createUser(UserList userList, String username);
    void deleteUser(ChatService chatService, ChatList chatList, UserList userList, User user);
    List<Chat> getUserChats(User user);
    Chat createChat(ChatService chatService, ChatList chatList, User user, String name, boolean isPrivate, String password, int maxUsers);
    void deleteChat(ChatService chatService, ChatList chatList, User user, Chat chat);
    void changeChatMaxUsers(AdminService adminService,Admin admin, Chat chat, int maxUsers);
    void deleteUserAndChats(ChatService chatService, ChatList chatList, UserList userList, User user);

}
