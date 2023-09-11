package user;

import chat.Chat;
import chat.ChatService;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminServiceInterface{
    private List<Admin> adminList;

    public AdminService() {
        this.adminList = new ArrayList<>();
    }

    /*Удалить любой чат*/
    @Override
    public void deleteAnyChat(Admin admin, Chat chat) {
        admin.getChatService().deleteChat(admin, chat);
        System.out.println("Админ " + admin.getNameUser() + " удалил чат " + chat.getChatName());
    }

    /*Изменить максимальное количество пользователей в чате*/
    @Override
    public void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers) {
        admin.getChatService().changeChatMaxUsers(admin, chat, maxUsers);
    }

    /*Добавить нового админа*/
    @Override
    public Admin crateAdmin(String nameAdmin){
        Admin admin1=new Admin(nameAdmin);
        getAdminList().add(admin1);
        System.out.println("Админ " + admin1.getNameUser() + " создан.");
        return admin1;
    }

    /*Удалить админа*/
    @Override
    public void deleteAdmin(Admin admin) {
        getAdminList().remove(admin);
        System.out.println("Админ " + admin.getNameUser() + " удален.");
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }
}
