package com.cschaefbauer.magic_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final Integer defaultPlayerCount = 2;
    private static final Integer minPlayerCount = 2;
    private static final Integer maxPlayerCount = 4;

    private List<Player> players;
    private PlayersAdapter adapter;
    //private Integer playerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //playerCount = defaultPlayerCount;

        players = new ArrayList<>();
        adapter = new PlayersAdapter(this, players);

        ListView playersListView = (ListView) findViewById(R.id.player_list);
        playersListView.setAdapter(adapter);

        for (int i = 1; i<=defaultPlayerCount; i++) {

            players.add(new Player("Player "+i));
        }


    }

    public void incrementPlayerCount(View v) {

        if (players.size() < maxPlayerCount) {
            players.add(new Player("Player "+(players.size()+1)));
        }

        TextView etPlayerCount = (TextView) findViewById(R.id.player_count);
        etPlayerCount.setText(String.valueOf(players.size()));

        adapter.notifyDataSetChanged();
    }


    public void decrementPlayerCount(View v) {

        if(players.size()>minPlayerCount) {
            players.remove(players.size()-1);
        }

        TextView etPlayerCount = (TextView) findViewById(R.id.player_count);
        etPlayerCount.setText(String.valueOf(players.size()));

        adapter.notifyDataSetChanged();
    }
//    public void updatePlayerCount(View v) {
//
//        if(v.getId() == R.id.player_count_incr) {
//            if()
//        }
//        else {
//
//        }
//    }

    @Override
    protected void onResume() {

        super.onResume();
        TextView etPlayerCount = (TextView) findViewById(R.id.player_count);
        etPlayerCount.setText(String.valueOf(players.size()));

    }




}
