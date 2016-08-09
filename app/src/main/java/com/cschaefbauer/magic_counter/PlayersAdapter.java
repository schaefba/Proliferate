package com.cschaefbauer.magic_counter;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by Chris Schaefbauer on 8/4/16.
 */
public class PlayersAdapter extends ArrayAdapter<Player> {

    public PlayersAdapter(Context context, List<Player> players) {
        super(context, 0, players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Player player = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_player, parent, false);
        }

        EditText etName = (EditText) convertView.findViewById(R.id.player_name);
        final EditText etLife = (EditText) convertView.findViewById(R.id.life_count);
        EditText etCommanderDamage = (EditText) convertView.findViewById(R.id.commander_damage);

        etName.setText(player.getName());
        etLife.setText(player.getLife().toString());
        etLife.setFilters(new InputFilter[]{new LifeCountRangeInputFilter(Player.MIN_LIFE,Player.MAX_LIFE)});
        etLife.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                Integer playerLifeValue;

                try{
                    playerLifeValue = Integer.parseInt(editable.toString());
                }catch(NumberFormatException e){
                    playerLifeValue = 0;
                }

                player.setLife(playerLifeValue);
            }
        });
        etCommanderDamage.setText(player.getCommanderDamage().toString());

        final Button buttonIncrLife = (Button) convertView.findViewById(R.id.life_count_incr);

        buttonIncrLife.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(player.getLife() < 9999)
                player.setLife(player.getLife()+1);
                etLife.setText(player.getLife().toString());

            }
        });

        final Button buttonDecrLife = (Button) convertView.findViewById(R.id.life_count_decr);

        buttonDecrLife.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(player.getLife() > -9999) {
                    player.setLife(player.getLife()-1);
                    etLife.setText(player.getLife().toString());
                }

            }
        });

        return convertView;
    }
}
