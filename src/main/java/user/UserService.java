package user;

import chat.Chat;
import chat.ChatService;
import chat.ChatServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserServiceInterface{
    private List<User> users;
    private ChatService chatService;

    public UserService(ChatService chatService) {
        this.users = new ArrayList<>();
        this.chatService=chatService;
    }

    /*Создать нового пользователя*/
    @Override
    public User createUser(String username) {
        User user = new User(username);
        getUsers().add(user);
        System.out.println("Пользователь " + username + " создан.");
        return user;
    }

    /*Удалить пользователя из мессенджера*/
    @Override
    public void deleteUser(User user) {
        getUsers().remove(user);
        for (Chat chat : getChatService().getChats()) {
            if (!chat.getUserList().contains(user)) {
                chat.removeUser(user);
            }
        }
        System.out.println("Пользователь " + user.getNameUser() + " удален.");
    }

    /*Получить чаты пользователя*/
    @Override
    public List<Chat> getUserChats(User user) {
        return user.getChatMessagesUser();
    }

    @Override
    public Chat createChat(User user, String name, boolean isPrivate, String password, int maxUsers) {
        Chat chat = user.getChatService().createChat(user, name, isPrivate, password, maxUsers);
        user.getChatService().getChats().add(chat);
        return chat;
    }

    @Override
    public void deleteChat(User user, Chat chat) {
        user.getChatService().deleteChat(user, chat);
    }

    @Override
    public void changeChatMaxUsers(Admin admin, Chat chat, int maxUsers) {
        admin.getAdminService().changeChatMaxUsers(admin, chat, maxUsers);
    }

    /*Удаляем чаты пользователя*/
    @Override
    public void deleteUserAndChats(User user) {
        deleteUser(user);
        List<Chat> userChatsCopy = new ArrayList<>(user.getChatMessagesUser());
        for (Chat chat : userChatsCopy) {
            getChatService().deleteChat(user, chat);
        }
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ChatService getChatService() {
        return chatService;
    }

    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }
}
