package me.farhan.androidpractice;


import android.os.Parcel;
import android.os.Parcelable;

public class ModelA implements Parcelable {

	int a;
	int b;
	public ModelA(int a,int b) 
	{
		this.a = a;
		this.b = b;
		
	}
	public ModelA(Parcel in) {

		a = in.readInt();
		b = in.readInt();
	}
	@Override
	public int describeContents() {
		return 0 ;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(a);
		dest.writeInt(b);
	}

	public static final Parcelable.Creator<ModelA> CREATOR = new Parcelable.Creator<ModelA>() {

		@Override
		public ModelA createFromParcel(Parcel source) {

			return new ModelA(source);
		}

		@Override
		public ModelA[] newArray(int size) {

			return  new ModelA[size];
		}

	};
}
