package com.example.hackeru.volleymovies;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hackeru on 05/06/2016.
 */
public class PosterDialog extends DialogFragment {

    private Context context;
    private ImageView poster;
    private Drawable image;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_poster, null, false);
        poster = (ImageView) view.findViewById(R.id.dialog_poster_image_view);
        poster.setImageDrawable(image);
        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public void setImage(Drawable image){
        this.image = image;
    }
}
