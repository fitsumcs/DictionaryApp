package com.example.dictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class DictonrayFragment extends Fragment {


    private  ItemListener itemListener;

    String testText = "Hello Text Test from Dict Fragametn !!";

    public DictonrayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ListView dicList = view.findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,getListofWords());

        dicList.setAdapter(adapter);

        //item click
        dicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemListener!=null)
                {
                    itemListener.onItemClick(getListofWords()[i]);
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dictonray, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //item Listener
    public  void  setItemListener(ItemListener listener)
    {
        this.itemListener = listener;
    }

    //get List item
    public  String[] getListofWords()
    {
        String[] array = new String[]{
                "a","b","c","d","e",
                "a","b","c","d","e",
                "a","b","c","d","e",
                "a","b","c","d","e",
                "a","b","c","d","e"



        };

        return  array;

    }

}