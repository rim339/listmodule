package com.example.myapplication7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> modules= new ArrayList<String>();
    public ArrayAdapter<String> adapter;
    public ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modules.add("Applications Mobiles");
        modules.add("Rédaction Scientifiques");
        modules.add("Administration BDD");
        modules.add("Cryptographie");
        modules.add("Anglais");

        setContentView(R.layout.listmodules);
        Button b = (Button) findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final EditText et = new EditText(MainActivity.this);
                et.setHint("le nom du module");
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Ajouter un module");
                dialog.setView(et);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int idBtn) {
                        modules.add(et.getText().toString());
                        adapter.notifyDataSetChanged();

                    }
                });
                dialog.setNegativeButton("annuler", null);
                AlertDialog confirm = dialog.create();
                confirm.show();

            }


        });
        mListView = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_multiple_choice,modules);
        mListView.setAdapter(adapter);
    }
}