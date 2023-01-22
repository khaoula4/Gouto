package com.example.gouto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Adab2 extends RecyclerView.Adapter<Adab2.MyViewHolder> {

    Context context;

    ArrayList<Forage> list;
    DatabaseReference database;





    public Adab2(Context context, ArrayList<Forage> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_infos,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Forage forage = list.get(position);
        holder.X.setText(forage.getX());
        holder.Y.setText(forage.getY());
        holder.code.setText(forage.getCode());
        holder.Commune1.setText(forage.getCommune());
        holder.Province1.setText(forage.getProvince());
        holder.Pos_neg.setText(forage.getPos_neg());
        holder.Profendeur.setText(forage.getProfendeur());
        holder.Debit.setText(forage.getDebit());
        holder.ex_rec.setText(forage.getExp_rec());
        holder.Date.setText(forage.getDate_Realisation());



        database = FirebaseDatabase.getInstance().getReference("Forage");




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName ;
        TextView X,Y,code,Debit,Profendeur,Province1,Commune1,Date,Pos_neg,ex_rec,g2;
        ImageView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            X = itemView.findViewById(R.id.X);
            Y = itemView.findViewById(R.id.Y);
            code = itemView.findViewById(R.id.code);
            Pos_neg = itemView.findViewById(R.id.p_n);
            Profendeur = itemView.findViewById(R.id.prof);
            ex_rec =itemView.findViewById(R.id.ex);
            Commune1 = itemView.findViewById(R.id.com);
            Province1 = itemView.findViewById(R.id.prov);
            Date = itemView.findViewById(R.id.da);
            Debit=itemView.findViewById(R.id.debit);


        }
    }

    private AlertDialog AskOption(User user)
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(context)
                // set message, title, and icon
                .setTitle("Supprimer")
                .setMessage("Etes vous sûr de vouloir supprimer cet utilisateur?")
                .setIcon(R.drawable.ic_baseline_delete_24)
                .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {


                        database.child(user.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void unused) {

                                Intent intent= new Intent(context, List.class);
                                context.startActivity(intent);
                                ((Activity)context).finish();
                                Toast.makeText(context, "Utilisateur supprimé", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context, "deleted failed", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;

    }

}