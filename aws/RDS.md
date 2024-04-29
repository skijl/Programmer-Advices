# RDS
> RDS - Relational Database Service
- Automated provisioning / Auto Scaling / Maximum Storage Treshhold
- Backups
- Monitoring dashboards
## RDS Features
**RDS Read Replica**: used for read scalability (ASYNC Replication)
**RDS Multi AZ (Disaster Recovery)**: Data replication to other AZ and failover in case of AZ, loss of network, instance or storage failure
**RDS - From Single-AZ to Multi-AZ**: zero downtime operation (no need ot stop DB, done by snapshot)
### RDS vs RDS Custom
- **RDS:** entire DB and the OS are managed by AWS
- **RDS Custom:** full admin access to he underlying OS and the DB
## Amazon Aurora
> **Aurora is a proprietary technolody from AWS (not opensourced)**
- Aurora is *AWS Cloud Optimized* (5x performance over MySQL on RDS, 3x the Performance of the Postgres on RDS)
- Aurora storage automatically grows and increments of 10GB, up to 128TB
- Up to 15 replicas, replication faster than MySQL
- Failover is instantaneous
- Costs 20% more than RDS but is more efficient
- High Availability and Read Scaling (serverless)
- **Writer Endpoint** always points to the master BD and if needed redirects
- **Reader Endpoint** connects to all the read replicas with load balancing (at the connection level)
* You can define custom endpoint for Read Replicas *(Divide Read Endpoint)*. After this you lose access to the Reader Endpoint
## RDS & Aurora Security
- **At-rest encryption:**
    - Databse master & replicas encryption using AWS KMS - must be defined as launch time
    - If the master is not encrypeted, the read replicas cannot be encrypted
    - To encrypt an un-encrypted database, go through a DB snapshot & restore as encrypted
- **In-flight encryption:** TLS-ready by default, use the AWS TLS toot certificated client-side
- **IAM Authentication:** IAM roles to connect to your database (instead username/password)
- **Security Groups:** Control Network access to your RDS/Aurora DB
- **No SSH available** except on RDS Custom
- **Audit Logs can be enabled** and sent to CloudWatch Logs for longer retention
## Amazon RDS Proxy
> Improves efficiency by reducing the stress on database resources
- Serverless, autoscaling, highly available (multi-AZ)
- **Reduces RDS and Aurora failover time by 66%**
- **Enforce IAM Authentication for DB, and securely store credentials in AWS Secret Manager**
- **RDS Proxy is never publicly accessible (must be accessed from VPC)**
# Amazon ElasticCache
- ElasticCache is to get managed Redis or Memchached
- Chaches are in-memory databases with really high performance, low latency
- Helps reduct load off of databses for read intencive workloads
- ElasticCache supports **IAM Authentication for Redis** and/or you can set password/token when you create a Redis cluster - extra level of security for your cache
- ElasticCache supports SASL-based authentication fro Memcachesd
### Pattern s for ElasticCache
- **Lazy loading:** all the read data is cached, data can become stale in cache
- **Write Through:** adds or update sate in the cache when written to a DB (no stale data)
- **Session Store:** store temporary session date in a cache (using TTL features)
