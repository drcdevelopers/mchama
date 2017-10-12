package ke.co.mchama.www.m_chama;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ChamaProjects extends Fragment {

    private static final String TAG = "ChamaProject";

    //we will use these constants later to pass the artist name and id to another activity
    public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
    public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";

    ListView listViewProjects;

    //a list to store all the artist from firebase database
    List<ProjectsHandler> projects;

    //our database reference object
    DatabaseReference mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chama_projects, container, false);

        //getting the reference of artists node
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Chamas").child("Projects");

        listViewProjects = (ListView) view.findViewById(R.id.listViewProjects);


        //list to store artists
        projects = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //attaching value event listener
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                projects.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    ProjectsHandler artist = postSnapshot.getValue(ProjectsHandler.class);
                    //adding artist to the list
                    projects.add(artist);
                }

                //creating adapter
                ProjectList artistAdapter = new ProjectList(getActivity(), projects);
                //attaching adapter to the listview
                listViewProjects.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Chama Projects");

    }

}