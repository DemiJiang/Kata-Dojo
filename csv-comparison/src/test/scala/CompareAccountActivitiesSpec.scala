import helpers.Specification
import scripts.CompareAccountActivities

class CompareAccountActivitiesSpec extends Specification{

  private val compareActivities = new CompareAccountActivities()

  "Compare Account Activities" should {
    "list the differences between the two files" in {
      val (archieDBAccountDifference, bsDBAccountDifference) = compareActivities.compareData("archieAccount.csv", "bsAccount.csv")

      archieDBAccountDifference.length should equal(0)
      bsDBAccountDifference.length should equal(0)
    }
  }

}
