package user;

import chat.Chat;
import chat.ChatList;
import chat.ChatService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserServiceInterface{

    /*Создать нового пользователя*/
    @Override
    public User createUser(UserList userList, String username) {
        User user = new User(username);
        userList.getUsers().add(user);
        System.out.println("Пользователь " + username + " создан.");
        return user;
    }

    /*Удалить пользователя из мессенджера*/
    @Override
    public void deleteUser(ChatService chatService, ChatList chatList, UserList userList, User user) {
        userList.getUsers().remove(user);
        for (Chat chat : chatList.getChats()) {
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
    public Chat createChat(ChatService chatService, ChatList chatList, User user, String name, boolean isPrivate, String password, int maxUsers) {
        Chat chat = chatService.createChat(chatList, user, name, isPrivate, password, maxUsers);
        chatList.getChats().add(chat);
        return chat;
    }

    @Override
    public void deleteChat(ChatService chatService, ChatList chatList, User user, Chat chat) {
        chatService.deleteChat(chatList, user, chat);
    }

    @Override
    public void changeChatMaxUsers(AdminService adminService, Admin admin, Chat chat, int maxUsers) {
        adminService.changeChatMaxUsers(admin, chat, maxUsers);
    }

    /*Удаляем чаты пользователя*/
    @Override
    public void deleteUserAndChats(ChatService chatService, ChatList chatList, UserList userList, User user) {
        deleteUser(chatService, chatList, userList, user);
        List<Chat> userChatsCopy = new ArrayList<>(user.getChatMessagesUser());
        for (Chat chat : userChatsCopy) {
            chatService.deleteChat(chatList, user, chat);
        }
    }
}
