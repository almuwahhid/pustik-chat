package chat.pustik.go.id.pustikchat.Model;

public class ChatModel {
    String name = "", time = "", message = "";

    public ChatModel(String name, String time, String message) {
        this.name = name;
        this.time = time;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
