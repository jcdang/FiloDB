package filodb.core.cassandra

import com.typesafe.config.Config

import filodb.core.datastore.Datastore
import filodb.core.ConcurrentLimiter

class CassandraDatastore(config: Config) extends Datastore {
  val dataApi = DataTable
  val datasetApi = DatasetTableOps
  val columnApi = ColumnTable
  val partitionApi = PartitionTable

  val limiter = new ConcurrentLimiter(config.getInt("max-outstanding-futures"))
}