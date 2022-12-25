package com.example.testgooglebooks.ui.favBooks;

import com.example.testgooglebooks.models.AdapterModel;
import com.example.testgooglebooks.models.BookDBEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper {
    static public List<AdapterModel> mapperFromEntityToModel(List<BookDBEntity> entities) {
        ArrayList<AdapterModel> adapterModels = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {

            authors.clear();
            if (entities.get(i).getAuthor() != null) authors.add(entities.get(i).getAuthor());
            else authors.add("");
            adapterModels.add(new AdapterModel(entities.get(i).getImage(),
                    entities.get(i).getName(), authors,true));
        }

        return adapterModels;

    }

    static public BookDBEntity mapperFromModelToEntity(AdapterModel model){
        return new BookDBEntity(model.getName(),model.getImage(),model.getAuthors().toString(), model.isFav());
    }


}
