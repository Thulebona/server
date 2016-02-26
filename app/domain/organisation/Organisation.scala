package domain.organisation

import java.util.Date

import play.api.libs.json.Json

/**
 * Created by hashcode on 2015/10/29.
 */
case class Organisation(
                    id: String,
                    name: String,
                    details:Map[String,String],
                    adminattached:String,
                    date:Date,
                    state:String
                    )

object Organisation {
  implicit val companyFmt = Json.format[Organisation]



}
