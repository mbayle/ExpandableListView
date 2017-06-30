
package fr.wcs.demo_expandable_listview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Poi implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("poiId")
    @Expose
    private String poiId;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("capacity")
    @Expose
    private Integer capacity;
    @SerializedName("image")
    @Expose
    private String image;
    public final static Creator<Poi> CREATOR = new Creator<Poi>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Poi createFromParcel(Parcel in) {
            Poi instance = new Poi();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.subtitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.poiId = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryId = ((String) in.readValue((String.class.getClassLoader())));
            instance.capacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.image = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Poi[] newArray(int size) {
            return (new Poi[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Poi() {
    }

    /**
     * 
     * @param poiId
     * @param description
     * @param categoryId
     * @param name
     * @param subtitle
     * @param image
     * @param capacity
     */
    public Poi(String name, String subtitle, String description, String poiId, String categoryId, Integer capacity, String image) {
        super();
        this.name = name;
        this.subtitle = subtitle;
        this.description = description;
        this.poiId = poiId;
        this.categoryId = categoryId;
        this.capacity = capacity;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(subtitle);
        dest.writeValue(description);
        dest.writeValue(poiId);
        dest.writeValue(categoryId);
        dest.writeValue(capacity);
        dest.writeValue(image);
    }

    public int describeContents() {
        return  0;
    }

}
