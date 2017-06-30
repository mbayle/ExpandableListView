
package fr.wcs.demo_expandable_listview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuration implements Parcelable
{

    @SerializedName("counting")
    @Expose
    private Counting counting;
    public final static Creator<Configuration> CREATOR = new Creator<Configuration>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Configuration createFromParcel(Parcel in) {
            Configuration instance = new Configuration();
            instance.counting = ((Counting) in.readValue((Counting.class.getClassLoader())));
            return instance;
        }

        public Configuration[] newArray(int size) {
            return (new Configuration[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Configuration() {
    }

    /**
     * 
     * @param counting
     */
    public Configuration(Counting counting) {
        super();
        this.counting = counting;
    }

    public Counting getCounting() {
        return counting;
    }

    public void setCounting(Counting counting) {
        this.counting = counting;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(counting);
    }

    public int describeContents() {
        return  0;
    }

}
