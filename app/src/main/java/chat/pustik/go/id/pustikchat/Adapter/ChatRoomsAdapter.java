package chat.pustik.go.id.pustikchat.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chat.pustik.go.id.pustikchat.Model.ChatModel;
import chat.pustik.go.id.pustikchat.R;

public class ChatRoomsAdapter extends RecyclerView.Adapter<ChatRoomsAdapter.Holder>{

    List<ChatModel> modelList;

    public ChatRoomsAdapter(List<ChatModel> modelList, OnClick onClick) {
        this.modelList = modelList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ChatRoomsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layoutView;
        layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chat_rooms_adapter, parent, false);
        ChatRoomsAdapter.Holder rcv = new ChatRoomsAdapter.Holder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatRoomsAdapter.Holder holder, final int i) {
        holder.tv_message.setText(modelList.get(i).getMessage());
        holder.tv_name.setText(modelList.get(i).getName());
        holder.tv_time.setText(modelList.get(i).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onClick(modelList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_message)
        TextView tv_message;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public OnClick onClick;
    public interface OnClick{
        void onClick(ChatModel model);
    }
}
