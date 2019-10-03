package com.example.appjoselito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private  int rId;
    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if (mView == null){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Item item = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNome);
        TextView textQtde = mView.findViewById(R.id.textQtde);

        textNome.setText(item.getNome());
        textQtde.setText(String.valueOf(item.getQtde()));

        return mView;
    }
}
