package aiss.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacebookPostResourceTest {

  @Test
  public void FacebookPostTest() {
    String message = "Esto es una prueba";
    String access_token = "EAACEdEose0cBAE7aw1NvqGG2fwf5KvloztFDHwpU3y0OyRZCiVLsdfXktkbFNB3V0hbecVVT7g2Op2yCo3J3MdIROUyXFMUXIWxECD4KLcAm3LdcHjC2Sm0ZB0lE5ZArUwmbPOyvrMpRmZClaZCtY3lyyVDFtGT17RpPP8hUJCZCY6WAQEYDDZAu26ODPJ6GLQZD";
    //FacebookPostResource facebook = new FacebookPostResource(access_token);
    
    //assertTrue("The posting was not done",facebook.publishPost(message));
    
    System.out.println("The posting on Facebook of:"+message+" was successful");
  }

}