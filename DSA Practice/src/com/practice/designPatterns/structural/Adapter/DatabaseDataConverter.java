package com.practice.designPatterns.structural.Adapter;

import java.util.List;

public interface DatabaseDataConverter {
    public List<DisplayData3rdParty> convertData(List<DatabaseData> data);

}