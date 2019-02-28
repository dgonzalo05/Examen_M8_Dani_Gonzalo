package org.dgonzalo.examen_m8_dani_gonzalo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlatosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView plato, ingredientes, precio;

    RecyclerView recyclerView;
    List<Plato> platos;
    PlatoAdapter miAdapter;

    private PlatoAdapter.PlatosFragmentListener mListener;

    public PlatosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlatosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlatosFragment newInstance(String param1, String param2) {
        PlatosFragment fragment = new PlatosFragment();
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
    }

    public class PlatoAdapter extends RecyclerView.Adapter<PlatoAdapter.PlatoHolder>{

        List<Plato> plato;

        public PlatoAdapter(List<Plato> plato) {
            this.plato = plato;
        }

        public PlatoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = getLayoutInflater();

            return new PlatoHolder(layoutInflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull PlatoHolder platoHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_platos, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        platos = mListener.mostrar_platos();
        miAdapter = new PlatoAdapter(platos);

        recyclerView.setAdapter(miAdapter);

        return view;
    }

    public class PlatoHolder extends RecyclerView.ViewHolder{

        TextView fecha, jugador, puntuacion;

        public PlatoHolder(LayoutInflater layoutInflater, ViewGroup parent) {
            super(layoutInflater.inflate(R.layout.platosholder, parent,false));

            fecha = itemView.findViewById(R.id.nombre);
            jugador = itemView.findViewById(R.id.ingredientes);
            puntuacion = itemView.findViewById(R.id.precio);
        }
    }

    @Override
    public void onAttach(Context context) {
        miAdapter.onAttach();
        if (context instanceof PlatosFragmentListener) {
            mListener = (PlatosFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        miAdapter.onDetach();
        mListener = null;
    }

    public interface PlatosFragmentListener {
        // TODO: Update argument type and name
        List<Plato> mostrar_platos();
    }
}
