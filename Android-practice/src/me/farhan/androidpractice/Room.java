//package me.farhan.androidpractice;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.util.Log;
//
//
//public class Room extends Node implements Parcelable{
//
//	/*
//	  "id": 707,
//        "title": {
//            "title": "dlx 100"
//        },
//        "room_type_id": 116,
//        "house_keeping_status": "DIRTY",
//        "status": null
//	 * */
//
//	//private final int roomID;
//	private final int roomTypeID;
//	private String roomTypeTitle;
//	private final String title;
//	private String houseKeepingStatus;
//	private RoomStatus roomStatus; 
//	private int checkInId;
//	
//	public String getHouseKeepingStatus() {
//		return houseKeepingStatus;
//	}
//	public void setHouseKeepingStatus(String houseKeepingStatus) {
//		this.houseKeepingStatus = houseKeepingStatus;
//	}
////	public int getRoomID() {
////		return roomID;
////	}
//	
//	public int getRoomTypeID() {
//		return roomTypeID;
//	}
//	public String getTitle() {
//		return title;
//	}
//	
//
//	public String getRoomTypeTitle() {
//		return roomTypeTitle;
//	}
//	public void setRoomTypeTitle(String roomTypeTitle) {
//		this.roomTypeTitle = roomTypeTitle;
//	}
//	
//	public Room(final int roomID, final int roomTypeID, final String title){
//		super(roomID);		
//		this.roomTypeID = roomTypeID;
//		this.title = title;
//		roomStatus = null;
//	
//	}
//	
//	public Room(final int roomID, final String title){
//		this(roomID, -1, title);
//	}
//	
//	public Room(Parcel in) 
//	{
//		super(in);
//		roomTypeID = in.readInt();
//		roomTypeTitle = in.readString();
//		title = in.readString();
//		houseKeepingStatus = in.readString();	
//		roomStatus = in.readParcelable(com.tasawr.moteel.model.RoomStatus.class.getClassLoader());
//	}
//	public void setRoomStatus(RoomStatus roomStatus) {
//		this.roomStatus = roomStatus;
//	}
//	public RoomStatus getRoomStatus() {
//		return roomStatus;
//	}
//	
//	public int getCheckInId() {
//		return checkInId;
//	}
//	
//	public void setCheckInId(int checkInId) {
//		this.checkInId = checkInId;
//	}
//	
//	@Override
//	public int describeContents() {
//
//		return 0;
//	}
//	
//	@Override
//	public void writeToParcel(Parcel dest, int flags) 
//	{
//		Log.v("Room", "writeToParcel..." + flags);
//		super.writeToParcel(dest, flags);		
//		dest.writeInt(roomTypeID);
//		dest.writeString(roomTypeTitle);
//		dest.writeString(title);
//		dest.writeString(houseKeepingStatus);
//		dest.writeParcelable(roomStatus, flags);			
//	}
//	public static final Parcelable.Creator<Room> CREATOR = new Parcelable.Creator<Room>() {
//
//		@Override
//		public Room createFromParcel(Parcel source) {
//			
//			return new Room(source);
//		}
//
//		@Override
//		public Room[] newArray(int size) {
//		
//			return  new Room[size];
//		}
//			
//	};
//}
