package com.example.test007;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SupervisorAdapter extends ArrayAdapter<Supervisor> {
    private Context context;
    private int resource2;
    List<Supervisor> supervisorr;

    public SupervisorAdapter(@NonNull Context context, int resource, List<Supervisor> supervisorr) {
        super(context, resource, supervisorr);
        this.context = context;
        this.resource2 = resource;
        this.supervisorr = supervisorr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource2, parent, false);

        TextView name = row.findViewById(R.id.NameW);
        TextView birth = row.findViewById(R.id.Age);
        TextView addres = row.findViewById(R.id.Address3);
        TextView usename = row.findViewById(R.id.Username);
        TextView password = row.findViewById(R.id.Password);
        TextView phone = row.findViewById(R.id.phnNS);
        TextView nic = row.findViewById(R.id.nicW);
        TextView email = row.findViewById(R.id.emailW);

        Supervisor supervisor = supervisorr.get(position);
        name.setText(supervisor.getName());
        birth.setText(supervisor.getBirth());
        addres.setText(supervisor.getAddress());
        usename.setText(supervisor.getUsername());
        password.setText(supervisor.getPassword());
        phone.setText(supervisor.getPhone());
        nic.setText(supervisor.getNic());
        email.setText(supervisor.getEmail());

        return row;
    }
}

