package com.dinobox.killscore.Adapters.Ligas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.dinobox.killscore.Entities.LigasEntity;
import com.dinobox.killscore.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Neimarulo on 3/16/14.
 */
public class LigasAdapter extends BaseAdapter{

    private Activity _activity;
    public List<LigasEntity> list;

    public LigasAdapter(List<LigasEntity> list_ligas, Activity activity){
      list = list_ligas;
       _activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)_activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_liga,null);

        LigasEntity obj_entity = new LigasEntity();

        obj_entity = list.get(i);

        ImageView vimg_liga = (ImageView)view.findViewById(R.id.img_liga);
        TextView vname_liga = (TextView)view.findViewById(R.id.name_liga);
        TextView vnum_team_liga = (TextView)view.findViewById(R.id.num_teams);

        vname_liga.setText(obj_entity.name);
        vnum_team_liga.setText(obj_entity.numberTeams + " Equipos");

        AQuery obj_aquery = new AQuery(view);

        obj_aquery.id(vimg_liga).image(obj_entity.logoUrl);


        return view;
    }
}
