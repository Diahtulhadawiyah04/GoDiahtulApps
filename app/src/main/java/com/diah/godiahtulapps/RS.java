package com.diah.godiahtulapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[]{"Rumah Sakit Santa Maria", "RS Syafira", "RS Eka Hospital",
                "RS Tabrani" };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listRS));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilankanpilihan(pilihan);
    }

    private void tampilankanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Rumah Sakit Santa Maria")) {
                a = new Intent(this, RSSantaMaria.class);
                startActivity(a);

            } else if (pilihan.equals("RS Eka Hospital")) {
            // RS Eka Hospital
                //a = new Intent(this, RSSantaMaria.class);
               // startActivity(a);

            }
        }catch (Exception e)
            {

                e.printStackTrace();
        }
    }
}