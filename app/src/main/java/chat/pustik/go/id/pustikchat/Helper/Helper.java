package chat.pustik.go.id.pustikchat.Helper;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

import chat.pustik.go.id.pustikchat.Model.ChatModel;
import chat.pustik.go.id.pustikchat.Model.MessageModel;

public class Helper {
    public static int getDP(Context context, Double value){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        Double fpixels = metrics.density * value;
        int pixels = (int) (fpixels + 0.5f);
        return pixels;
    }

    public static List<ChatModel> getChatList(){
        List<ChatModel> getChatList = new ArrayList<>();
        ChatModel chatModel = new ChatModel("Bambang", "11:00 AM", "Mau proyek ga lu coy? Japri gua ya");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Al", "10:00 AM", " Hi bagaimana kabar kamu");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Ardi", "09:00 AM", " Dimana bro, buruan kesini lah!!!");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Nabila", "09:00 AM", "Jangan lupa doa kalau berangkat kerja");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Shinta", "08:00 AM", "Gimana sih, sini dong temenin gua");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Abah", "03:00 AM", "Bangun, bangun, bangun udah subuh");
        getChatList.add(chatModel);
        chatModel = new ChatModel("Ibu Rumah", "06:00 AM", "Kak, duit masih ada kan?");
        getChatList.add(chatModel);
        return getChatList;
    }

    public static List<MessageModel> getMessage(){
        List<MessageModel> getChatList = new ArrayList<>();
        MessageModel messageModel = new MessageModel("Cuy", "Ardi", "10:00 AM", 0);
        getChatList.add(messageModel);
        messageModel = new MessageModel("Gimana", "Ardi", "10:01 AM", 0);
        getChatList.add(messageModel);
        messageModel = new MessageModel("Ada perlu nih", "Ardi", "10:05 AM", 0);
        getChatList.add(messageModel);
        messageModel = new MessageModel("Perlu apa bro ?", "Ardi", "10:10 AM", 0);
        getChatList.add(messageModel);
        messageModel = new MessageModel("Jadi gini", "Ardi", "10:11 AM", 0);
        getChatList.add(messageModel);
        messageModel = new MessageModel("Gini gimana", "Jadi gini", "Ardi", "10:12 AM", "10:10 AM", "Jadi gini", "Ardi",1);
        getChatList.add(messageModel);
        return getChatList;
    }
}
