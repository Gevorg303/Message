package chat;

import user.User;

public class PublicChat extends Chat {
    public PublicChat(User creator, String chatName, int numberUser, String password) {
        super(creator, chatName, numberUser, null);
    }

    @Override
    public boolean isPrivate() {
        return false;
    }

    @Override
    public String toString() {
        return "\nНазвание ПУБЛИЧНОГО чата: "+getChatName()+" Максимальное количество пользователей: "+ getMaxUser()+" Список пользователей в чате: "+ getUserList()+" История сообщений в чате: "+getMessagesHistory();
    }
}
