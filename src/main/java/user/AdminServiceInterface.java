package user;

import chat.Chat;

public interface AdminServiceInterface {
    void deleteAnyChat(Admin admin, Chat chat);
    void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers);
    Admin crateAdmin(String nameAdmin);
    void deleteAdmin(Admin admin);
}
