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