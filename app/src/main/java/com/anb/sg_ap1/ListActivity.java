package com.anb.sg_ap1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anb.sg_ap1.adapter.ListUserAdapter;
import com.anb.sg_ap1.database.UserRepo;
import com.anb.sg_ap1.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.rv_user)
    RecyclerView rv_user;

    ArrayList<User> listUser = new ArrayList<>();
    ListUserAdapter adapter;
    UserRepo repo = new UserRepo(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            User user = extras.getParcelable("user");
            repo.insert(user);
            listUser = repo.getUserList();
        }

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ListUserAdapter(listUser);
        rv_user.setAdapter(adapter);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(mLayoutManager);

    }
}
