package chat.pustik.go.id.pustikchat.Model;

public class MessageModel {
    String message = "", attachment = "", name = "", time = "", time_attachment = "", message_attachment = "", name_attachment = "";
    int type = 0;

    public MessageModel(String message, String name, String time, int type) {
        this.message = message;
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public MessageModel(String message, String attachment, String name, String time, String time_attachment, String message_attachment, String name_attachment, int type) {
        this.message = message;
        this.attachment = attachment;
        this.name = name;
        this.time = time;
        this.time_attachment = time_attachment;
        this.message_attachment = message_attachment;
        this.name_attachment = name_attachment;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getTime_attachment() {
        return time_attachment;
    }

    public String getMessage_attachment() {
        return message_attachment;
    }

    public String getName_attachment() {
        return name_attachment;
    }
}
