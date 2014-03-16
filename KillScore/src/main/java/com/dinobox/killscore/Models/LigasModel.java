package com.dinobox.killscore.Models;

import android.app.Activity;
import android.view.View;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.dinobox.killscore.Entities.LigasEntity;
import com.dinobox.killscore.Listeners.ILigasListeners;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Neimarulo on 3/16/14.
 */
public class LigasModel {

    private static List<LigasEntity> list;

    public static void asyncJson(String url,Activity view,ILigasListeners iList){
        final ILigasListeners listLigas=iList;
        AQuery aq = new AQuery(view);
        aq.ajax(url,String.class,new AjaxCallback<String>(){
            @Override
            public void callback(String url, String json, AjaxStatus status) {
                Type listType = new TypeToken<List<LigasEntity>>(){}.getType();
                list = new Gson().fromJson(json, listType);
                listLigas.returnListLigas(list);
            }
        });
    }

}
