package com.example.mainsafetynet.SettingsStuff;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class PSECadapter extends RecyclerView.Adapter<PSECadapter.ViewHolder>{

    List<String> phone;

    String countryCode = Locale.getDefault().getCountry();

    public PSECadapter(List<String> phone){
        this.phone = phone;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = phone.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return phone.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvitem =  itemView.findViewById(android.R.id.text1);
        }

        public void bind(String item) {
            tvitem.setText(PhoneNumberUtils.formatNumber(item, countryCode));
        }
    }
}
