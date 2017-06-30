package fr.wcs.demo_expandable_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categories = loadFromJson();

        ExpandableListView l = (ExpandableListView) findViewById(R.id.listViewCat);
        l.setAdapter(new ExpandableListAdapter(this.getLayoutInflater(), categories));
    }

    private List<Category> loadFromJson(){
        String json = null;
        try {
            InputStream is = getAssets().open("catalog.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            Gson gson = new GsonBuilder().create();

            CatalogInsiteo catalog = gson.fromJson(json, CatalogInsiteo.class);
            mergeCatalogPoi(catalog);

            return catalog.getCategories();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void mergeCatalogPoi(CatalogInsiteo catalog){
        for (Category c : catalog.getCategories()) {
            for (Poi p : catalog.getPois()) {
                if (p.getCategoryId().equals(c.getId())) {
                    c.getPois().add(p);
                }
            }

        }
    }
}
