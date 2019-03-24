package com.example.ratemaplateswipeplatepage;

import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.Model.appImageCollection;

import org.junit.Test;

import static org.junit.Assert.*;

public class appImageCollectionTest {

    @Test
    public void AppImageCollectionAdd_Test(){
        appImageCollection testCollection = new appImageCollection();
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        testCollection.addImage(image1);
        assertEquals(1, testCollection.getAppCollection().size());
    }
}
