
package fr.wcs.demo_expandable_listview;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatalogInsiteo implements Parcelable
{

    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("pois")
    @Expose
    private List<Poi> pois = null;
    public final static Creator<CatalogInsiteo> CREATOR = new Creator<CatalogInsiteo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CatalogInsiteo createFromParcel(Parcel in) {
            CatalogInsiteo instance = new CatalogInsiteo();
            instance.configuration = ((Configuration) in.readValue((Configuration.class.getClassLoader())));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            in.readList(instance.pois, (Poi.class.getClassLoader()));
            return instance;
        }

        public CatalogInsiteo[] newArray(int size) {
            return (new CatalogInsiteo[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CatalogInsiteo() {
    }

    /**
     * 
     * @param pois
     * @param categories
     * @param configuration
     */
    public CatalogInsiteo(Configuration configuration, List<Category> categories, List<Poi> pois) {
        super();
        this.configuration = configuration;
        this.categories = categories;
        this.pois = pois;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Poi> getPois() {
        return pois;
    }

    public void setPois(List<Poi> pois) {
        this.pois = pois;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(configuration);
        dest.writeList(categories);
        dest.writeList(pois);
    }

    public int describeContents() {
        return  0;
    }

}
