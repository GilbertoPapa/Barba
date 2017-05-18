package com.example.barba.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barba.R;
import com.example.barba.util.StatusVerification;

/**
 * Created by Gilbertopapa013 on 30/03/2017.
 */
public class FragmentLocalization extends Fragment {
    private StatusVerification _statusV = new StatusVerification();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(!_statusV.isOnline(FragmentLocalization.this.getContext())){
            Snackbar snackbar = Snackbar
                    .make(container, "Não há conexão com a internet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null);

            // Changing action button text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.RED);
            snackbar.show();
        }

        View _view = inflater.inflate(R.layout.fragment_localization,container,false);

        /**Inicialização do Spinner Distance**/
        Spinner _sDistance = (Spinner) _view.findViewById(R.id.spinnerDistance);
        _sDistance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FragmentLocalization.this.getContext(), "Procurando em um raio de: ".concat(parent.getSelectedItem().toString()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return _view;
    }
}
