package com.example.jutom.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFunktionell#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFunktionell extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Fragment> uebungsFragments;
    private String[] titles= {"Unterer Rücken", "Bauch", "Tricep", "Bicep", "Schulter", "Oberer Rücken", "Rücken", "Beine", "Brust"};
    UebungFragment brustFragment = null;
    UebungFragment beinFragment = null;
    UebungFragment rueckenFragment= null;
    UebungFragment obererRueckenFragment= null;
    UebungFragment schulterFragment= null;
    UebungFragment bicepFragment= null;
    UebungFragment tricepFragment= null;
    UebungFragment bauchFragment= null;
    UebungFragment untererRueckenFragment= null;


    public FragmentFunktionell() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFunktionell.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFunktionell newInstance(String param1, String param2) {
        FragmentFunktionell fragment = new FragmentFunktionell();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Ruecken r= new Ruecken(); r.setName("Test");
        Bauch b= new Bauch();b.setName("Test");
        Tricep t= new Tricep();t.setName("Test");
        Bicep bb= new Bicep();bb.setName("Test");
        Schulter sch= new Schulter();sch.setName("Test");
        ObererRuecken oR= new ObererRuecken();oR.setName("Test");
        UntererRuecken uR= new UntererRuecken();uR.setName("Test");
        Beine bei= new Beine();bei.setName("Test");
        Brust br= new Brust();br.setName("Test");
        SQLHelper.getFunktionelluntererRueckens().add(uR);
        SQLHelper.getFunktionellbauches().add(b);
        SQLHelper.getFunktionelltriceps().add(t);
        SQLHelper.getFunktionellbiceps().add(bb);
        SQLHelper.getFunktionellschulters().add(sch);
        SQLHelper.getFunktionellobererRueckens().add(oR);
        SQLHelper.getFunktionellrueckens().add(r);
        SQLHelper.getFunktionellbeines().add(bei);
        SQLHelper.getFunktionellbrusts().add(br);
        uebungsFragments= new ArrayList<Fragment>();
        untererRueckenFragment= new UebungFragment(new UebungListAdapter(this.getContext(),SQLHelper.getFunktionelluntererRueckens()),"FunktionallUntererRuecken");
        bauchFragment = new UebungFragment(new ListAdapterBauch(this.getContext(),SQLHelper.getFunktionellbauches()),"FunktionellBauch");
        tricepFragment = new UebungFragment(new ListAdapterTricep(this.getContext(),SQLHelper.getFunktionelltriceps()),"FunktionellTricep");
        bicepFragment = new UebungFragment(new ListAdapterBicep(this.getContext(),SQLHelper.getFunktionellbiceps()),"FunktionellBicep");
        schulterFragment = new UebungFragment(new ListAdapterSchulter(this.getContext(),SQLHelper.getFunktionellschulters()),"FunktionellSchulter");
        obererRueckenFragment = new UebungFragment(new ListAdapterObererRuecken(this.getContext(),SQLHelper.getFunktionellobererRueckens()),"FunktionellObererRuecken");
        rueckenFragment = new UebungFragment(new ListAdapterRuecken(this.getContext(),SQLHelper.getFunktionellrueckens()),"FunktionellRuecken");
        beinFragment= new UebungFragment(new ListAdapterBeine(this.getContext(),SQLHelper.getFunktionellbeines()),"FunktionellBein");
        brustFragment = new UebungFragment(new ListAdapterBrust(this.getContext(),SQLHelper.getFunktionellbrusts()),"FunktionellBrust");
        uebungsFragments.add(untererRueckenFragment);
        uebungsFragments.add(bauchFragment);
        uebungsFragments.add(tricepFragment);
        uebungsFragments.add(bicepFragment);
        uebungsFragments.add(schulterFragment);
        uebungsFragments.add(obererRueckenFragment);
        uebungsFragments.add(rueckenFragment);
        uebungsFragments.add(beinFragment);
        uebungsFragments.add(brustFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_funktionell, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerFunktionell);

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),uebungsFragments,titles));
        return v;
    }

}
