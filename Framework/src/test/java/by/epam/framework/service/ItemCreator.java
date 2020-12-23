package by.epam.framework.service;

import by.epam.framework.model.Item;

public class ItemCreator {
    public static final String TESTDATA_ITEM_URL = "testdata.eyeshadow.url";
    public static final String TESTDATA_ITEM_NAME = "testdata.eyeshadow.name";

    public static Item withUrlFromProperty(){
        return new Item(TestDataReader.getTestData(TESTDATA_ITEM_URL),
                TestDataReader.getTestData(TESTDATA_ITEM_NAME));
}
}

