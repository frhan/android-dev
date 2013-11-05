package me.farhan.contextualactionbardemo;


import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
 
public class LaptopListAdapter extends ArrayAdapter<Laptop> {
 
    Activity context;
    List<Laptop> laptops;
    private SparseBooleanArray mSelectedItemsIds;
 
    public LaptopListAdapter(Activity context, int resId, List<Laptop> laptops) {
        super(context, resId, laptops);
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.laptops = laptops;
    }
 
    private class ViewHolder {
        TextView laptopTxt;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.laptopTxt = (TextView) convertView
                    .findViewById(R.id.laptop_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        Laptop laptop = getItem(position);
        holder.laptopTxt.setText(laptop.toString());
        convertView
                .setBackgroundColor(mSelectedItemsIds.get(position) ? 0x9934B5E4
                        : Color.TRANSPARENT);
 
        return convertView;
    }
 
    @Override
    public void add(Laptop laptop) {
        laptops.add(laptop);
        notifyDataSetChanged();
        Toast.makeText(context, laptops.toString(), Toast.LENGTH_LONG).show();
    }
 
    @Override
    public void remove(Laptop object) {
        // super.remove(object);
        laptops.remove(object);
        notifyDataSetChanged();
    }
 
    public List<Laptop> getLaptops() {
        return laptops;
    }
 
    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }
 
    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }
 
    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
 
        notifyDataSetChanged();
    }
 
    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }
 
    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}