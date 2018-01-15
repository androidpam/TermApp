package com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsomeclub.krzysztofwycislo.termapp.R;

import java.util.List;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class NavigatorListAdapter extends BaseAdapter {

    private final Context context;

    private final List<NavigatorItemModel> menuHeaders;

    public NavigatorListAdapter(Context context, List<NavigatorItemModel> menuHeaders) {
        this.context = context;
        this.menuHeaders = menuHeaders;
    }

    @Override
    public int getCount() {
        return menuHeaders.size();
    }

    @Override
    public Object getItem(int position) {
        return menuHeaders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NavigatorItemModel headerTitle = (NavigatorItemModel) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_list_item, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.item);
        ImageView headerIcon = convertView.findViewById(R.id.iconimage);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getName());

        if (headerTitle.getIconImg() == -1) {
            headerIcon.setVisibility(View.GONE);
        } else {
            headerIcon.setImageResource(headerTitle.getIconImg());
        }

        return convertView;
    }
}
