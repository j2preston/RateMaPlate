package com.example.ratemaplateswipeplatepage;

import com.example.ratemaplateswipeplatepage.Model.ImageF;
import com.example.ratemaplateswipeplatepage.Model.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserTest {

    @Test
    public void setUsername_Test(){
        User user1 = new User("sampleUser");
        user1.setUsername("Test");
        assertEquals("Test", user1.getUsername());
    }

    //test the addition of an image to the users liked plates list
    @Test
    public void likedListAdd_Test() {
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToLiked(image1);
        assertEquals(1, user1.getLikedImages().size());
    }

    @Test
    public void likedListAddTitle_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToLiked(image1);
        assertEquals("Salmon", user1.getLikedImages().get(0).getTitle());
    }

    @Test
    public void likeListAddDescription_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToLiked(image1);
        assertEquals("Some salmon", user1.getLikedImages().get(0).getDescription());
    }

    @Test
    public void likedListAddImage_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToFavourite(image1);
        assertEquals(R.drawable.dish1, user1.getFavouriteImages().get(0).getImageNumber());
    }


    @Test
    public void favouriteListAdd_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToFavourite(image1);
        assertEquals(1, user1.getFavouriteImages().size());
    }

    @Test
    public void favouriteListAddTitle_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToFavourite(image1);
        assertEquals("Salmon", user1.getFavouriteImages().get(0).getTitle());
    }

    @Test
    public void favouriteListAddDescription_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToFavourite(image1);
        assertEquals("Some salmon", user1.getFavouriteImages().get(0).getDescription());
    }

    @Test
    public void favouriteListAddImage_Test(){
        User user1 = new User("sampleUser");
        ImageF image1 = new ImageF(R.drawable.dish1, "Salmon", "Some salmon" );
        user1.addToFavourite(image1);
        assertEquals(R.drawable.dish1, user1.getFavouriteImages().get(0).getImageNumber());
    }


}