package ke.co.mchama.www.m_chama;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ReinhardBonnke on 10/1/2017.
 */

public class  ProjectList extends ArrayAdapter<ProjectsHandler> {
    private Activity context;
    List<ProjectsHandler> projects;

    public ProjectList(Activity context, List<ProjectsHandler> projects) {
        super(context, R.layout.layout_projects_list, projects);
        this.context = context;
        this.projects = projects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_projects_list, null, true);
        TextView textViewProjects = (TextView) listViewItem.findViewById(R.id.textViewProjects);

        ProjectsHandler artist = projects.get(position);
        textViewProjects.setText(artist.getProjectProjets());


        return listViewItem;
    }
}
