package chat.pustik.go.id.pustikchat.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chat.pustik.go.id.pustikchat.Helper.Helper;
import chat.pustik.go.id.pustikchat.Model.MessageModel;
import chat.pustik.go.id.pustikchat.R;

public class ChatRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    Context context;
    List<MessageModel> list;

    public ChatRoomAdapter(Context context, List<MessageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_attacment, parent, false);
        // Inflate the layout view you have created for the list rows here
        if (i == 0) {
            return new ChatRoomAdapter.Holder(view1);
        } else if (i == 1) {
            return new ChatRoomAdapter.AttachmentHolder(view2);
        }
        return new ChatRoomAdapter.Holder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final int itemType = getItemViewType(i);

        if (itemType == 0) {
            ((Holder)holder).bindData((MessageModel)list.get(i), i);
        } else if (itemType == 1) {
            ((AttachmentHolder)holder).bindData((MessageModel)list.get(i), i);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_message)
        TextView tv_message;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.lay_chat)
        LinearLayout lay_chat;
        @BindView(R.id.lay_container_chat)
        LinearLayout lay_container_chat;
        @BindView(R.id.read_receipt_view)
        ImageView read_receipt_view;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(MessageModel messageModel, int position) {
            tv_name.setText(messageModel.getName());
            tv_message.setText(messageModel.getMessage());
            tv_time.setText(messageModel.getTime());

            ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            if(position%2 != 0){
                ((LinearLayout.LayoutParams) params).setMargins(Helper.getDP(context, 33.0), 0, 0, 0);
                lay_chat.setBackgroundResource(R.drawable.bg_chat_right);
                lay_container_chat.setGravity(Gravity.RIGHT);
                tv_name.setText("Aku");
                read_receipt_view.setVisibility(View.VISIBLE);
            } else {
                ((LinearLayout.LayoutParams) params).setMargins(0, 0, Helper.getDP(context, 33.0), 0);
                lay_chat.setBackgroundResource(R.drawable.bg_chat_left);
                lay_container_chat.setGravity(Gravity.LEFT);
                read_receipt_view.setVisibility(View.GONE);
            }
        }
    }

    public class AttachmentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_message)
        TextView tv_message;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_attachment_name)
        TextView tv_attachment_name;
        @BindView(R.id.tv_attachment_time)
        TextView tv_attachment_time;
        @BindView(R.id.tv_attachment)
        TextView tv_attachment;
        @BindView(R.id.lay_attachment)
        LinearLayout lay_attachment;
        @BindView(R.id.lay_container_chat)
        LinearLayout lay_container_chat;
        @BindView(R.id.read_receipt_view)
        ImageView read_receipt_view;
        public AttachmentHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(MessageModel messageModel, int position) {
            tv_name.setText(messageModel.getName());
            tv_message.setText(messageModel.getMessage());
            tv_time.setText(messageModel.getTime());

            tv_attachment.setText(messageModel.getMessage_attachment());
            tv_attachment_name.setText(messageModel.getName_attachment());
            tv_attachment_time.setText(messageModel.getTime_attachment());

            ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            if(position%2 != 0){
                ((LinearLayout.LayoutParams) params).setMargins(Helper.getDP(context, 33.0), 0, 0, 0);
                lay_attachment.setBackgroundResource(R.drawable.bg_chat_right);
                lay_container_chat.setGravity(Gravity.RIGHT);
                tv_name.setText("Aku");
                read_receipt_view.setVisibility(View.VISIBLE);
            } else {
                ((LinearLayout.LayoutParams) params).setMargins(0, 0, Helper.getDP(context, 33.0), 0);
                lay_attachment.setBackgroundResource(R.drawable.bg_chat_left);
                lay_container_chat.setGravity(Gravity.LEFT);
                read_receipt_view.setVisibility(View.GONE);
            }
        }
    }
}
