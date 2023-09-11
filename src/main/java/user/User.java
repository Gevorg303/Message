package user;

import chat.Chat;
import chat.ChatService;

import java.util.ArrayList;
import java.util.List;

public class User implements UserInterface{
    private String nameUser;
    private List<Chat> chatMessagesUser;/*Список чатов пользователя*/
    private UserService userService;
    private ChatService chatService;

    public User(String nameUser) {
        this.nameUser = nameUser;
        this.chatMessagesUser=new ArrayList<>();

        this.chatService=new ChatService();
        this.userService=new UserService(chatService);
    }

    /*Чат добавить в список чатов пользователя*/
    @Override
    public void addChat(Chat chat) {
        getChatMessagesUser().add(chat);
    }

    /*Чат удалить из списка чатов пользователя*/
    @Override
    public void removeChat(Chat chat) {
        getChatMessagesUser().remove(chat);
    }

    @Override
    public String toString() {
        return "Имя пользователя: "+getNameUser();
    }

    public ChatService getChatService() {
        return chatService;
    }

    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Chat> getChatMessagesUser() {
        return chatMessagesUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setChatMessagesUser(List<Chat> chatMessagesUser) {
        this.chatMessagesUser = chatMessagesUser;
    }
}
