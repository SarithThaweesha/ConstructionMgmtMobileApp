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

public class ConstructionAdapter extends ArrayAdapter<Construction> {
    private Context context;
    private int resource;
    List<Construction> construc;

    public ConstructionAdapter(@NonNull Context context, int resource, List<Construction> construc) {
        super(context, resource, construc);
        this.context = context;
        this.resource = resource;
        this.construc = construc;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView name = row.findViewById(R.id.NameW);
        TextView addres = row.findViewById(R.id.Address3);
        TextView supervisor = row.findViewById(R.id.birthW);
        TextView workerC = row.findViewById(R.id.phnNS);
        TextView budget = row.findViewById(R.id.nicW);
        TextView duration = row.findViewById(R.id.emailW);

        Construction construction = construc.get(position);
        name.setText(construction.getNameC());
        supervisor.setText(construction.getSupervisorN());
        addres.setText(construction.getAddressC());
        workerC.setText(construction.getWorkers());
        budget.setText(construction.getBudget());
        duration.setText(construction.getDuration());

        return row;
    }
}
