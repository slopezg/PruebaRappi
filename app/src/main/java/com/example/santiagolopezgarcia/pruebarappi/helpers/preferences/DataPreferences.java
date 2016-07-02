package com.example.santiagolopezgarcia.pruebarappi.helpers.preferences;

import android.app.Activity;
import android.content.Context;
import com.example.santiagolopezgarcia.pruebarappi.model.Feed;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by ronaldgallegoduque on 2/07/16.
 */
public class DataPreferences {

    private Context context;

    public DataPreferences(Context context) {
        this.context = context;
    }

    public void saveFeedPreferences(Feed feed, String filename) {

        ObjectOutputStream objectOut = null;
        try {

            FileOutputStream fileOut = context.openFileOutput(filename, Activity.MODE_PRIVATE);
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(feed);
            fileOut.getFD().sync();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOut != null) {
                try {
                    objectOut.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public Feed readDataPreferences(String filename) {

        ObjectInputStream objectIn = null;
        Feed feed = null;
        try {

            FileInputStream fileIn = context.getApplicationContext().openFileInput(filename);
            objectIn = new ObjectInputStream(fileIn);
            feed = (Feed) objectIn.readObject();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectIn != null) {
                try {
                    objectIn.close();
                } catch (IOException e) {
                }
            }
        }

        return feed;
    }
}
