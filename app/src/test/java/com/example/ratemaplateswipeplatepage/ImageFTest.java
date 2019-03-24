package com.example.ratemaplateswipeplatepage;

import com.example.ratemaplateswipeplatepage.Model.ImageF;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ImageFTest {

    @Test
    public void imageGetTitle_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        assertEquals("Salmon", image1.getTitle());
    }

    @Test
    public void imageGetDescription_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        assertEquals("Some salmon", image1.getDescription());
    }

    @Test
    public void imageGetImageID_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        assertEquals(R.drawable.dish1, image1.getImageNumber());
    }

    @Test
    public void imageSetTitle_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        image1.setTitle("Test");
        assertEquals("Test", image1.getTitle());
    }

    @Test
    public void imageSetDescription_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        image1.setDescription("Test");
        assertEquals("Test", image1.getDescription());
    }

    @Test
    public void imageSetImageID_Test(){
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        image1.setImageNumber(123);
        assertEquals(123, image1.getImageNumber());
    }


}
