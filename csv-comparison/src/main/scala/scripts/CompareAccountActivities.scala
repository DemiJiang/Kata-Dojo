package scripts

import scala.io.Source

class CompareAccountActivities() extends Helper {

  private def loadArchieAccountFile(archieAccountLocation: String): List[OneAccount] = loadFile(
    archieAccountLocation,
    values => OneAccount(getValue(values, 0), getValue(values, 1), getValue(values, 2))

  )

  private def loadBSAccountFile(bsAccountLocation: String): List[TwoAccount] = loadFile(
    bsAccountLocation,
    values => TwoAccount(getValue(values, 0), getValue(values, 1), getValue(values, 2))

  )

  def compareData(archieAccountLocation: String, bsAccountLocation: String) : (List[OneAccount], List[TwoAccount]) = {
    val archieAccounts : List[OneAccount] = loadArchieAccountFile(archieAccountLocation)
    val bsAccounts: List[TwoAccount] = loadBSAccountFile(bsAccountLocation)
    val archieAccountDifference = archieAccounts.filter(item => !bsAccounts.exists(isArchieAccountAndBSAccountTheSame(_, item)))
    val bsAccountDifference = bsAccounts.filter(item => !archieAccounts.exists(isArchieAccountAndBSAccountTheSame(item, _)))
    println(s"Unique one Account: ${archieAccountDifference.length}")
    println(archieAccountDifference)
    println(s"Unique Two Account: ${bsAccountDifference.length}")
    println(bsAccountDifference)
    (archieAccountDifference, bsAccountDifference)
  }

  private def isArchieAccountAndBSAccountTheSame(twoAccount: TwoAccount, oneAccount: OneAccount):Boolean = (twoAccount.row_id == oneAccount.ROW_ID
    && twoAccount.name == oneAccount.NAME
    && twoAccount.region == oneAccount.REGION)

  case class OneAccount(ROW_ID: String,
                        NAME: String,
                        REGION: String,
                       )

  case class TwoAccount(
                         row_id: String,
                         name: String,
                         region: String
                    )

}
