package ke.co.mchama.www.m_chama;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ReqForLoan extends Fragment {

    EditText mAmount;
    EditText mDuration;
    Button buttonSubmit;
    private DatabaseReference mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_req_for_loan, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Chamas").child("Loans");

        mAmount = (EditText) view.findViewById(R.id.Amount);
        mDuration = (EditText) view.findViewById(R.id.Duration);
        buttonSubmit = (Button)  view.findViewById(R.id.buttonSubmit);

        //adding an onclicklistener to button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addPayment();
            }
        });

        return view;
    }


    private void addPayment() {
        //getting the values to save
        String amount = mAmount.getText().toString().trim();
        String duration = mDuration.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(amount)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = mDatabase.push().getKey();

            //creating an Artist Object
            LoanHandler payment = new LoanHandler(id, amount,duration);

            //Saving the Artist
            mDatabase.child(id).setValue(payment);

            //setting edittext to blank again
            mAmount.setText("");
            mDuration.setText("");

            //displaying a success toast
            Toast.makeText(getContext(), "Success! Pending Approval", Toast.LENGTH_LONG).show();


        } else {

            //if the value is not given displaying a toast
            Toast.makeText(getContext(), "Please enter the details", Toast.LENGTH_LONG).show();
        }
    }


    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("Request for a Loan");

    }
}
