package fr.wcs.demo_expandable_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by eddy on 29/06/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private LayoutInflater inflater;
    private List<Category> categories;

    public ExpandableListAdapter(LayoutInflater inflater, List<Category> categories) {
        this.inflater = inflater;
        this.categories = categories;
    }

    @Override
    public int getGroupCount() {
        return this.categories.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.categories.get(groupPosition).getPois().size();
    }

    @Override
    public Category getGroup(int groupPosition) {
        return categories.get(groupPosition);
    }

    @Override
    public Poi getChild(int groupPosition, int childPosition) {
        return this.categories.get(groupPosition).getPois().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return this.categories.get(groupPosition).getId().hashCode();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return this.categories.get(groupPosition).getPois().get(childPosition).getName().hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_category, parent, false);
        }

        Category cat = this.getGroup(groupPosition);

        TextView t = (TextView) convertView.findViewById(R.id.textView);
        t.setText(cat.getDescription());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_item_category, parent, false);
        }

        Poi poi = this.getChild(groupPosition, childPosition);

        TextView t = (TextView) convertView.findViewById(R.id.textView2);
        t.setText(poi.getPoiId());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
