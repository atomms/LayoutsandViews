package com.ramiro.ernesto.testing;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        //Actionbar setup
        //getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

//uncomment and set xml layout for list/grid/spinner
        listViewOn();
//        gridViewOn();
//        spinnerOn();

                   }

    private void spinnerOn() {
        final String[] datosspinner = new String[]{"item 1","item2","item3"};
        ArrayAdapter<String> adaptadorspinner = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datosspinner);

        final Spinner myspinner = (Spinner)findViewById(R.id.spinner);
        adaptadorspinner.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        myspinner.setAdapter(adaptadorspinner);

        //        eventos del spinner

        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
//                Toast.makeText(MainActivity.this, "You Clicked at " + myspinner.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "You Clicked at " + datosspinner[pos], Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });

    }

    private void gridViewOn() {
        //cast al grid y definimos y poblamos el adapter

        final String[] datosgrid = new String[12];
        ArrayAdapter<String> adaptadorgrid = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosgrid);
        final GridView myGrid = (GridView)findViewById(R.id.gridView);
        myGrid.setAdapter(adaptadorgrid);


        for (int i=1; i<=12; i++) {
            datosgrid[i - 1] = "item " + i;
            myGrid.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(MainActivity.this, "You Clicked at " + datosgrid[position], Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getApplicationContext(), "clicked item", Toast.LENGTH_SHORT).show();

                        }
                    }
            );

        }
    }

    private void listViewOn() {

        //cast al list y definimos y poblamos el adapter
        final String[] datoslist = new String[]{"item1","item2","item3"};

        ArrayAdapter<String> adaptadorlist =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datoslist);

        final ListView myList = (ListView)findViewById(R.id.listView);
        myList.setAdapter(adaptadorlist);

//        eventos del list

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + datoslist[position], Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

     return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
