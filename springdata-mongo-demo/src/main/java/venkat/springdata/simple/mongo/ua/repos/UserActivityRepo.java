package venkat.springdata.simple.mongo.ua.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import venkat.springdata.simple.mongo.ua.model.UserActivity;
import venkat.springdata.simple.mongo.ua.model.UserActivityByDay;

@Repository
public interface UserActivityRepo extends MongoRepository<UserActivity, UUID> {

	@Aggregation(pipeline = {
		"""
		{
		    $match: {
		        activityTime: {$gt: :#{#start}},
		        activityTime: {$lt: :#{#end}}
		    }
		}
	    """,
	    """
        {
            $sort: {
                userEmail: 1,
                activityTime: 1
            }
        }
        """,
        """
        {
            $group: {
                _id: {
                    userId: "$userEmail",
                    activityDate: { $dateToString: { format: "%Y-%m-%d", date: "$activityTime" } }
                },
                activities: { $push: "$$ROOT" },
                firstActivityTime: { $min: "$activityTime" }
                lastActivityTime: { $max: "$activityTime" }
            }
        }
        """,
        """
        {
            $project: {
                _id: 0,
                userId: "$_id.userId",
                activityDate: "$_id.activityDate",
                loginTime: "$firstActivityTime",
                logoutTime: "$lastActivityTime",
                activities: 1
            }
        }
        """
	})
	public List<UserActivityByDay> findBetweenDates(@Param("start") LocalDate start, @Param("end") LocalDate end);

}
