package chat;

import message.Message;
import user.Admin;
import user.User;
import user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatService implements ChatServiceInterface{

    /*Создать новый чат*/
    @Override
    public Chat createChat(ChatList chatList, User creator, String name, boolean isPrivate,
                           String password, int maxUsers) {
        Chat chat;
        if (isPrivate) {
            chat = new PrivateChat(creator, name, maxUsers, password);
        } else {
            chat = new PublicChat(creator, name, maxUsers, null);
        }
        System.out.println("Создан чат " + name + " пользователем "+creator.getNameUser());
        chat.addUser(creator);
        chatList.getChats().add(chat);
        creator.addChat(chat);
        return chat;
    }

    /*Удалить чат*/
    @Override
    public void deleteChat(ChatList chatList,User user, Chat chat) {
        if (user.equals(chat.getCreator())) {
            chatList.getChats().remove(chat);
            for (User u : chat.getUserList()) {
                removeUserFromChat(chatList, u, chat);
            }
            System.out.println("Чат " + chat.getChatName() + " удален пользователем " + user.getNameUser());
        } else {
            System.out.println(user.getNameUser() + " не может удалить чат " + chat.getChatName() + " так как он не создатель и не администратор.");
        }
    }

    /*Добавить пользователя в чат*/
    @Override
    public void addUserToChat(User user, Chat chat, String password) {
        if(!(chat.isPrivate())) {
            chat.addUser(user);
        }else {
            if(Objects.equals(chat.getPassword(), password)){
                chat.addUser(user);
            }else {
                System.out.println(user.getNameUser()+" ввел неверный пароль для входа в чат "+chat.getChatName());
            }
        }
    }

    /*Удалить пользователя из чата*/
    @Override
    public void removeUserFromChat(ChatList chatList, User user, Chat chat) {
        chat.removeUser(user);
        for (Chat c : chatList.getChats()) {
            if (c != chat && c.getUserList().contains(user)) {
                c.removeUser(user);
            }
        }
    }

    /*Написать сообщение*/
    @Override
    public void writeMessage(User user, Chat chat, Message message) {
        if (chat.getUserList().contains(user)) {
            chat.writeMessage(user, message);
            System.out.println("Сообщение от пользователя: " + user.getNameUser() + " в чате " + chat.getChatName() + " '" + message + "'");
        } else {
            System.out.println(user.getNameUser() + " не может отправить сообщение в чат " + chat.getChatName() + ", так как он не является его участником");
        }
    }
}
