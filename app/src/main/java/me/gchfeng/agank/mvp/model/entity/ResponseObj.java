package me.gchfeng.agank.mvp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Walker on 2017/2/6.
 */

public class ResponseObj implements Parcelable {
    private List<String> category;
    private boolean error;
    private List<DataObj> results;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<DataObj> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ResponseObj{" +
                "category=" + category +
                ", error=" + error +
                ", results=" + results +
                '}';
    }

    public void setResults(List<DataObj> results) {
        this.results = results;
    }

    public ResponseObj() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.category);
        dest.writeByte(this.error ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.results);
    }

    protected ResponseObj(Parcel in) {
        this.category = in.createStringArrayList();
        this.error = in.readByte() != 0;
        this.results = in.createTypedArrayList(DataObj.CREATOR);
    }

    public static final Creator<ResponseObj> CREATOR = new Creator<ResponseObj>() {
        @Override
        public ResponseObj createFromParcel(Parcel source) {
            return new ResponseObj(source);
        }

        @Override
        public ResponseObj[] newArray(int size) {
            return new ResponseObj[size];
        }
    };
}
