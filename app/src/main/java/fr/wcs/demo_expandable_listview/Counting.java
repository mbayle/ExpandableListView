
package fr.wcs.demo_expandable_listview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counting implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("refreshInterval")
    @Expose
    private Integer refreshInterval;
    public final static Creator<Counting> CREATOR = new Creator<Counting>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Counting createFromParcel(Parcel in) {
            Counting instance = new Counting();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.refreshInterval = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Counting[] newArray(int size) {
            return (new Counting[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Counting() {
    }

    /**
     * 
     * @param refreshInterval
     * @param url
     */
    public Counting(String url, Integer refreshInterval) {
        super();
        this.url = url;
        this.refreshInterval = refreshInterval;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(Integer refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(refreshInterval);
    }

    public int describeContents() {
        return  0;
    }

}
