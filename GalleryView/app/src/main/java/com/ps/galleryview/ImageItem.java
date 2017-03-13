package com.ps.galleryview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class ImageItem {
    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage(Context context) {

        return scaleDownBitmap(this.image, 400, context);

        //return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Source from
    // http://stackoverflow.com/questions/3528735/failed-binder-transaction-when-putting-an-bitmap-dynamically-in-a-widget
    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {

        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        int h = (int) (newHeight * densityMultiplier);
        int w = (int) (h * photo.getWidth() / ((double) photo.getHeight()));

        photo = Bitmap.createScaledBitmap(photo, w, h, true);

        Log.e("TAG", "Image pixel resolution is : " + "densityMultipler is : " + densityMultiplier
                + "\t height & weight is : " + h + " & " + w);

        return photo;
    }
}
