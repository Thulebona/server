package domain.content

import java.util.Date

import play.api.libs.json.Json

/**
  * Created by hashcode on 2016/02/11.
  */
case class RawContent(org: String,
                      id: String,
                      dateCreated: Date,
                      creator: String,
                      source: String,
                      category: String,
                      title: String,
                      content: String,
                      contentType: String,
                      status: String,
                      state: String) {

}

object RawContent {
  implicit val rawcontentFmt = Json.format[RawContent]

}