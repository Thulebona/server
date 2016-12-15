package service.content

import java.util.Date

import domain.content.{Media, RawContent}
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by user42 on 2016/09/06.
  */
class UploadFileTest extends FeatureSpec with GivenWhenThen{

  feature("Uploading file"){

    info("As a User")
    info("I want to upload a file")

    scenario("Test"){
      Given("")

      val articleContent = RawContent("HBC", "123", new Date(),
        "John Doe", "SRC", "Cancer",
        "Fighting the symptoms", "blah-blah-blah",
        "text", "pending edit", "")

      val attachedMedia = Media("123", "M123", "MediaDesc",
        "url", "mime", new Date(),
        "fresh")
    }


  }

}
