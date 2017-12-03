package com.wakemeintime.dffc.wakemeintime.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.wakemeintime.dffc.wakemeintime.R;

import java.util.ArrayList;
import java.util.Objects;

import database.Calendar;
import database.DatabaseHelper;

/**
 * Created by Florian Christof on 29.11.2017.
 */

public class choose_calendar_adapter_java extends ArrayAdapter<Calendar> {
    private Context context;

    public choose_calendar_adapter_java(Context context, ArrayList<Calendar> calendars) {
        super(context, 0, calendars);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        final Calendar calendar = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.choose_calendar_listview_item, parent, false);
        }
        // Lookup view for data population
        CheckBox checkBox = convertView.findViewById(R.id.calendarCheckBox);

        // Populate the data into the template view using the data object
        if (calendar != null) {
            checkBox.setText(calendar.name);
            if (Objects.equals(calendar.isActive, "true")) {
                checkBox.setChecked(true);
            }
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    DatabaseHelper db = DatabaseHelper.getInstance(context);
                                                    if (calendar != null) {
                                                        if (isChecked) {
                                                            calendar.isActive = "true";
                                                            db.addOrUpdateCalendar(calendar);
                                                        } else {
                                                            calendar.isActive = "false";
                                                            db.addOrUpdateCalendar(calendar);
                                                        }
                                                    }
                                                }
                                            }
        );

        // Return the completed view to render on screen
        return convertView;
    }
}
