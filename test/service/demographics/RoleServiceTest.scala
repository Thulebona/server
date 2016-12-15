package service.demographics

import domain.demographics.Role
import org.scalatestplus.play.PlaySpec

/**
  * Created by Ethon on 2016/12/15.
  */
class RoleServiceTest extends PlaySpec {

  "RoleService # GetRoleByID" should{
    "retrieved a role based on ID given" in {


      val role1 = Role ("1","Ethon","It is good ","Healthy")

      val roleService = RoleService
      roleService.saveOrUpdate(role1)

      val retrievedRole = roleService.get("1")

      retrievedRole map{
        o => o match {
          case Some(x) =>{
            assert(x.name === "Ethon")
          }
        }
      }
    }
  }

}
