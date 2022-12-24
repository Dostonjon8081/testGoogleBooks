package com.example.testgooglebooks.search;

import android.util.Log;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDto;
import com.example.testgooglebooks.models.VolumeInfoDto;

import java.util.ArrayList;
import java.util.List;

public abstract class DtoMapper {

//    private static String TAG = "MyBook";

    static public List<AdapterModel> mapModel(BookDto bookDto) {


        VolumeInfoDto volumeInfoDto;
        ArrayList<AdapterModel> adapterModels = new ArrayList<>();

        for (int i = 0; i < bookDto.getItems().size(); i++) {
            volumeInfoDto = bookDto.getItems().get(i).getVolumeInfo();

            if (volumeInfoDto.getAuthors() != null) {
                adapterModels.add(new AdapterModel(volumeInfoDto.getImageLinks().getThumbnail(),
                        volumeInfoDto.getTitle(), volumeInfoDto.getAuthors()));
//                Log.d(TAG, "onSuccess: " + volumeInfoDto.getAuthors());

            } else {
                adapterModels.add(new AdapterModel(volumeInfoDto.getImageLinks().getThumbnail(),
                        volumeInfoDto.getTitle(), new ArrayList<>()));
//
//                Log.d(TAG, "onSuccess: " + volumeInfoDto.getAuthors());
            }


        }

        return adapterModels;
    }
}
