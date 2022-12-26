package com.example.testgooglebooks.ui.search;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDto;
import com.example.testgooglebooks.models.VolumeInfoDto;

import java.util.ArrayList;
import java.util.List;

public abstract class DtoMapper {

    public static String TAG = "MyBook";

    static public List<AdapterModel> mapModel(BookDto bookDto, PresenterService presenterService) {


        VolumeInfoDto volumeInfoDto;
        ArrayList<AdapterModel> adapterModels = new ArrayList<>();

        for (int i = 0; i < bookDto.getItems().size(); i++) {
            volumeInfoDto = bookDto.getItems().get(i).getVolumeInfo();

            boolean isExistBook = presenterService.isExistsBook(volumeInfoDto.getTitle());

            if (volumeInfoDto.getAuthors() != null) {
                if (volumeInfoDto.getImageLinks() != null) {
                    adapterModels.add(new AdapterModel(volumeInfoDto.getImageLinks().getSmallThumbnail(),
                            volumeInfoDto.getTitle(), volumeInfoDto.getAuthors(),isExistBook));
                } else {
                    adapterModels.add(new AdapterModel("",
                            volumeInfoDto.getTitle(), volumeInfoDto.getAuthors(),isExistBook));

                }
            } else {
                adapterModels.add(new AdapterModel(volumeInfoDto.getImageLinks().getThumbnail(),
                        volumeInfoDto.getTitle(), new ArrayList<>(),isExistBook));
            }


        }

        return adapterModels;
    }
}
