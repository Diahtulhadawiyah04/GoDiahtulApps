package com.diah.godiahtulapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSSantaMaria extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[]{"Call Center", "SMS Center", "Driving Direction",
                "Website", "Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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
            if (pilihan.equals("Call Center")) {
                String nomortel = "tel:082281904489";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));
                startActivity(a);

            } else if (pilihan.equals("SMS Center")) {
                String smsText = "Diahtul Hadawiyah/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms: 082281904489"));
                a.putExtra("sms_body", smsText);
                startActivity(a);
            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://www.google.com/maps/dir//Rumah+Sakit+Santa+Maria,+Jl.+Jend.+Ahmad+Yani+No.68,+RT.%2FRW%2FRW.001%2F001,+Pulau+Karam,+Kec.+Sukajadi,+Kota+Pekanbaru,+Riau+28127/@-3.5933158,100.9167295,6z/data=!4m8!4m7!1m0!1m5!1m1!1s0x31d5ac0e5898027d:0x513117af9e29c4ef!2m2!1d101.4422225!2d0.5273899";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));
                startActivity(a);

            } else if (pilihan.equals("Website")) {
                String website = "http://www.rssantamariapekanbaru.com/home/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(a);

            } else if (pilihan.equals("Info di Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Santa Maria");


                startActivity(a);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}