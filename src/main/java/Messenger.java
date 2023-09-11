import chat.Chat;
import chat.ChatService;
import message.Message;
import user.Admin;
import user.AdminService;
import user.User;
import user.UserService;

import java.util.List;

public class Messenger {
    private UserService userService;
    private ChatService chatService;
    private AdminService adminService;

    public Messenger() {

        this.chatService = new ChatService();
        this.adminService = new AdminService();
        this.userService = new UserService(chatService);
    }

    public UserService getUserService() {
        return userService;
    }

    public ChatService getChatService() {
        return chatService;
    }

    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public User doNewUser(String userName) {
        return getUserService().createUser(userName);
    }

    public Chat doNewChat(User user1, String nameChat, boolean isPrivate, String password, int maxUser) {
        return getUserService().createChat(user1, nameChat, isPrivate, password, maxUser);
    }

    public List<Chat> printListChat(User user) {
        return getUserService().getUserChats(user);
    }

    public void removeChat(User user1, Chat chat1) {
        getUserService().deleteChat(user1, chat1);
    }

    public void changeChatMaxUsers(Admin admin, Chat chat1, int i) {
        getAdminService().changeChatMaxUsers(admin, chat1, i);
    }

    public void addUserToChat(User user2, Chat chat, String password) {
        getChatService().addUserToChat(user2, chat, password);
    }

    public void writeMessage(User user, Chat chat, Message message) {
        getChatService().writeMessage(user,chat, message);
    }

    public void removeChatAdmin(Admin admin, Chat chat1) {
        getAdminService().deleteAnyChat(admin, chat1);
    }

    public Admin doNewAdmin(String nameAdmin) {
        return getAdminService().crateAdmin(nameAdmin);
    }

    public void removeUser(User user2) {
        getUserService().deleteUserAndChats(user2);
    }

    public void removeAdmin(Admin admin) {
        getAdminService().deleteAdmin(admin);
    }

    public List<Chat> printAllChat() {
        return getChatService().getChats();
    }
}
