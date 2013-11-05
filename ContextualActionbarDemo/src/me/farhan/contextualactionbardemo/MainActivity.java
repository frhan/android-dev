package me.farhan.contextualactionbardemo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
 
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

 
public class MainActivity extends SherlockFragmentActivity implements
        OnItemClickListener {
 
    ListView laptopListView;
    LaptopListAdapter laptopListAdapter;
    List<Laptop> laptops = new ArrayList<Laptop>();
 
    Activity activity = this;
    private ActionMode mActionMode;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        laptopListView = (ListView) findViewById(R.id.laptopList);
 
        setLaptopList();
        laptopListAdapter = new LaptopListAdapter(this, R.layout.list_item,
                laptops);
        laptopListView.setAdapter(laptopListAdapter);
        laptopListView.setOnItemClickListener(this);
        laptopListView.setOnItemLongClickListener(new OnItemLongClickListener() {
 
                    public boolean onItemLongClick(AdapterView<?> parent,
                            View view, int position, long id) {
                        onListItemSelect(position);
                        return true;
                    }
                });
    }
 
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view,
            int position, long id) {
        if (mActionMode == null) {
            /*no items selected, so perform item click actions
             * like moving to next activity */
            Toast toast = Toast.makeText(getApplicationContext(), "Item "
                    + (position + 1) + ": " + laptops.get(position),
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
 
        } else
            // add or remove selection for current list item
            onListItemSelect(position);
    }
 
    private void onListItemSelect(int position) {
        laptopListAdapter.toggleSelection(position);
        boolean hasCheckedItems = laptopListAdapter.getSelectedCount() > 0;
 
        if (hasCheckedItems && mActionMode == null)
            // there are some selected items, start the actionMode
            mActionMode = startActionMode(new ActionModeCallback());
        else if (!hasCheckedItems && mActionMode != null)
            // there no selected items, finish the actionMode
            mActionMode.finish();
 
        if (mActionMode != null)
            mActionMode.setTitle(String.valueOf(laptopListAdapter
                    .getSelectedCount()) + " selected");
    }
 
    private void setLaptopList() {
        String[] blogs = getResources().getStringArray(R.array.laptops);
        for (String brand : blogs) {
            Laptop laptop = new Laptop(brand);
            laptops.add(laptop);
        }
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            // adds item to listview
        } else if (item.getItemId() == R.id.menu_share) {
            // share your application by using share intent
        } else if (item.getItemId() == R.id.menu_rate) {
            // add rate feature to your application by launching market
        }
        return true;
    }
 
    private class ActionModeCallback implements ActionMode.Callback {
 
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // inflate contextual menu
            mode.getMenuInflater().inflate(R.menu.context_menu, menu);
            return true;
        }
 
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }
 
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
 
            switch (item.getItemId()) {
            case R.id.menu_delete:
                // retrieve selected items and delete them out
                SparseBooleanArray selected = laptopListAdapter
                        .getSelectedIds();
                for (int i = (selected.size() - 1); i >= 0; i--) {
                    if (selected.valueAt(i)) {
                        Laptop selectedItem = laptopListAdapter
                                .getItem(selected.keyAt(i));
                        laptopListAdapter.remove(selectedItem);
                    }
                }
                mode.finish(); // Action picked, so close the CAB
                return true;
            default:
                return false;
            }
 
        }
 
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // remove selection
            laptopListAdapter.removeSelection();
            mActionMode = null;
        }
    }
}