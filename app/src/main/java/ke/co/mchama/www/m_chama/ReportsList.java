package ke.co.mchama.www.m_chama;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by ReinhardBonnke on 10/1/2017.
 */

public class  ReportsList extends ArrayAdapter<ReportHandler> {
    private Activity context;
    List<ReportHandler> reports;

    public ReportsList(Activity context, List<ReportHandler> reports) {
        super(context, R.layout.layout_reports_list, reports);
        this.context = context;
        this.reports = reports;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_reports_list, null, true);
        TextView projectsField = (TextView) listViewItem.findViewById(R.id.projectsField);
        TextView projectsReport = (TextView) listViewItem.findViewById(R.id.projectsReport);

        ReportHandler artist = reports.get(position);
        projectsField.setText(artist.getProjectProjets());
        projectsReport.setText(artist.getProjectReports());


        return listViewItem;
    }
}
