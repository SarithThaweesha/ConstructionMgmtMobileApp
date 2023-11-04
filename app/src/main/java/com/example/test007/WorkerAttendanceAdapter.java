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

public class WorkerAttendanceAdapter extends ArrayAdapter<Worker> {
private Context context;
private int resource;
        List<Worker> workerr;

public WorkerAttendanceAdapter(@NonNull Context context, int resource, List<Worker> workerr) {
        super(context, resource, workerr);
        this.context = context;
        this.resource = resource;
        this.workerr = workerr;

        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView name = row.findViewById(R.id.NameW);
        TextView email = row.findViewById(R.id.emailW);

        Worker worker = workerr.get(position);
        name.setText(worker.getName());
        email.setText(worker.getEmail());

        return row;
        }
}
