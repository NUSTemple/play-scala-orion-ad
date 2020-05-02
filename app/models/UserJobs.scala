package models

import java.sql.Date

/**
 * This model is to record down metadata of jobs user submitted.
 *
 *
 *
 *
 */

case class Job(fab: Int, userName: String, jobId: Long, jobSubmitDatetime: Date, jobName: String = "")

class UserJobs {

}
