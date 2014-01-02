package me.farhan.androidpractice;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelB implements Parcelable{

	String stra;
	String strb;
	List<ModelA> listModels;
	
	public ModelB() 
	{
		listModels = new ArrayList<ModelA>();
	}
	
	public ModelB(Parcel in) 
	{
		this();
		this.stra = in.readString();
		this.strb = in.readString();
		in.readTypedList(this.listModels, ModelA.CREATOR);
	}
	@Override
	public int describeContents() {
		
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(stra);
		dest.writeString(strb);
		dest.writeTypedList(this.listModels);
		
	}
	public static final Parcelable.Creator<ModelB> CREATOR = new Parcelable.Creator<ModelB>() {

		@Override
		public ModelB createFromParcel(Parcel source) {

			return new ModelB(source);
		}

		@Override
		public ModelB[] newArray(int size) {

			return  new ModelB[size];
		}

	};
}
