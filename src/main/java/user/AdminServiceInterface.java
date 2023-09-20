package user;

import chat.Chat;
import chat.ChatList;
import chat.ChatService;

public interface AdminServiceInterface {
    void deleteAnyChat(ChatService chatService, ChatList chatList, Admin admin, Chat chat);
    void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers);
    Admin crateAdmin(UserList userList, String nameAdmin);
    void deleteAdmin(UserList userList, Admin admin);
}
