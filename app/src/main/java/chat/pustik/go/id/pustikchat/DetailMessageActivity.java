package chat.pustik.go.id.pustikchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chat.pustik.go.id.pustikchat.Adapter.ChatRoomAdapter;
import chat.pustik.go.id.pustikchat.Helper.Helper;
import chat.pustik.go.id.pustikchat.Model.MessageModel;

public class DetailMessageActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ChatRoomAdapter adapter;
    List<MessageModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_message);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");


        SpeedyLinearLayoutManager lm = new SpeedyLinearLayoutManager(this, SpeedyLinearLayoutManager.VERTICAL, false);
        lm.setStackFromEnd(true);

        adapter = new ChatRoomAdapter(this, Helper.getMessage());
        recycler_view.setLayoutManager(lm);
        recycler_view.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
