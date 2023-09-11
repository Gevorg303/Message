package user;

import chat.Chat;
import chat.ChatService;

public class Admin extends User{
    private AdminService adminService;
    private ChatService chatService;

    public Admin(String nameUser) {
        super(nameUser);
        this.adminService = new AdminService();
        this.chatService=new ChatService();
    }

    @Override
    public ChatService getChatService() {
        return chatService;
    }

    @Override
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
