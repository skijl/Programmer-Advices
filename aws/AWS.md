# AWS
## Get started **IAM**
1) Log in
2) Create new IAM user with new group and assign to it AdminAccess 
    - You can add account alias for easier signing-in in the future.
    - Always use your IAM user, not Root user in AWS
    - Use alias, username and password to sign-in
### IAM Policies
- Denifes what the actions and resources are denied or allowed to use in this policy
- User can have multiple policies
- Policy is directly assigned to user
- In AWS you can set policy for passwords
- You can also set up MFA and singin using other device too
### Access AWS
> AWS CLI - is a tool that enables interaction with AWS services using commands in your command-line shell
> AWS SDK - enables you to access and manage AWS services programatically. Embedded in your application
- Access with AWS CLI
    - cmd: `aws --version`
    - IAM => User => Security Credentials => Create Access Key
    - cmd: `aws configure`
- Use Cloud Shell Terminal in AWS
* IAM => User => Access Advisor - see what the user can access
### IAM Best Practices
* Don't use the root account except AWS setup
* One physical user = One AWS User
* Assign users to groups and assign permissions to groups
* Create a strong password policy
* Use and enforce to use MFA
* Create and use **Roles** for giving permissions to AWS services
* **Never share IAM users & Access keys**
## Billing
- In root user: up-right corner => Accounts => IAM user and role access to Billing information => Activate to activate access for admins to see the billing
### Create Billing treshhold
- Budgets => Create Budget to create alert for some treshhold
## EC2
> EC2 = Elastic Compute Cloud = Infrastructure as a Service = Renting vitrual machine
> To attach Role to EC2 use EC2 => Actions => Modify IAM Role
After each start instance gets different IPv4 address
- CPU
- RAM
- Storage:
    - Network-attached (EBS & EFS)
    - Hardware (EC2 Instance Store)
- Key Pair: connect to EC2
- Network card: ENI
- Firewall (Security Group): 
    - Controls traffic TO or OUT of the EC2 instance.
    - Security groups only contain *allow* rules
    - Locked down to a particular region
    - *It's good to maintain one separate security group for SSH access*
- Bootstap script (config at launch): EC2 User Data (install updates, software, files from internet)
> Connect with ssh: ssh -i <file_name.pem> ec2-user@<public_ipv4>
> Copy file to ec2: scp -i <file_name.pem> <path_to_file> ec2-user@<public_ipv4>:<path_on_ec2>
### Ports
- **22** = SSH (Secure Shell) - log into a Linux instance
- **21** = FTP (File Transfert Protocol) - upload files into a file share
- **22** = SFTP (Secure File Transfert Protocol) - upload files using SSH
- **80** = HTTP - access unsecured websites
- **443** = HTTPS - acces secured websites
- **3389** = RDP (Remote Desktop Protocol) - log into a Windows instance
### EC2 Instance Types
> https://instances.vantage.sh/
- **General Purpose** (T, M)
    - Great for diversity of workloads such as web servers or code repositories
    - Balance between: compute, memory, networking
- **Compute Optimized** (C)
    - Great for compute-intensive tasks that require high performance processors
- **Memory Optimized** (R, X, High Memory, z1d)
    - Fast performance for workloads that process large data sets in memory
- **Storage Optimized**
    - Great for storage-intensive tasks that require high, sequential read and write access to large data sets on local storage
### EC2 Instances Purchasing Options
- **On-Demand Instances** - short workload, predictable pricing, pay by second (expensive)
- **Reserved** (1 & 3 years)
    - Reserved Instances - long workloads
    - Convertible Reserved instances - long workloads with flexible instances
- **Saving Plans** (1 & 3 years) - commitment to an amount of usage, long workload
- **Spot Instances** - short workloads, can lose instances (less reliable, the cheapest). 
    - Cancel Spot Request before Terminating
    - **Spot Fleets** = set of Spot Instances + (optional) On-Demand. They allow us to automatically request Spot Instances with the lowest price
    - Strategies to allocate Spot Instances:
        - **lowestPrice** (cost optimization, short workload)
        - **diversified:** distributed across pools (availability, long workloads)
        - **capacityOptimized:** pool with the optimal capacity for the number of instances
        - **priceCapacityOptimized (recommended):** pools with highest capacity available, then select the pool with the lowest price (best choise for most workloads)
- **Dedicated Hosts** - book an entire physical server; control instance placement (the most expensive)
- **Dedicated Instances** - no other customers will share your hardware
- **Capacity Reservation** - reserve capacity in a specific AZ for any duration in your region (Charged even if Instance is stopped)
### Elastic IP
> Elastic IP attaches an IP for certain Instance *(only 5 in AWS account, uncommon to use)*
Create: Elastic IPs => Associate Elastic IP sddress
Delete: Elastic IPs => Disassociate Elastic IP sddress => Release Elastic IP addresses
### Placement Groups
> Control over EC2 placement strategy
When you create a placement group, you specify one of the following strategies for the group:
* **Cluster** - clusters instances into a low-latency group in a single Availability Zone 
    + Low latency
    - If the AZ fails, all the instances fail at the same time
* **Spread** - spreads instances across underlying hardware (max 7 instances per group per AZ) - critical application
    + Reduced risk of simultaneous failure(All instances located on different hardware)
    + Span across multiple AZ
    - Limited to 7 instances per AZ per placement group
* **Partition** - spreads instances across many different partitions (which rely on different sets of racks) within an AZ. Scales to 100s of EC2 instances per group (Hadoop, Cassandra, Kafka)
    + Span across multiple AZ 
    + Up to 100s of EC2 instances
    + A partition failure can affect many EC2 but won't affect other partitions (Instances in partition do not share racks with the instances in the other partitions)
### Elastic Network Interfaces (ENI)
> ENI represents a **virtual network card**
- You can move ENI to another instance and attach private IP to it
- Bound to a specific AZ
### EBS Volume
> An **EBS (Elastic Block Store) Volume** is a **network** drive you can attach to your instances while they run
- It allows instances to persist data, even after their termination
- Can be mounted to one instance at a time (at the CCP level)
- Bounded to a specific AZ
- Using *EBS Snapshot* you can copy EBS across AZ or Region
    - EBS Snapshot Archive: 24-72 hours to restore, cheap
    - Recycle Bin for EBS Snapshots: rules to retain deleted shapshots so you can recover them after accidental deletion
    - Fast Snapshot Restore (FSR): no latency, expensive
### AMI
> AMI = Amazon Machine Image - a *customization* of an EC2 Instance
- For specific region
### EC2 Instance store
> If you need high performance hardware disk, use EC2 Instance Store 
+ Good for buffer / cache / scratch data / temporary content
- You lose the storage if the Instance is stopped
- Backups and Replication are your responsibility
* EBS Volumes come in 6 types:
    * gp2 / gp3 (SSD): balance between price and performance
    * io / io2 Block Express (SSD): highest-performance SSD volume, *multi-attach feature - up to 16 instances at a time*
    * st I (HDD): Low cost, frequently accessed
    * sc I (HDD): Lowest cost HDD volume designed for less frequently accessed workloads
> EBS Volumes are charecterized in Size | Throughput | IOPS (I/O - operations per second)
- If you have doubts, always use AWS documentation
### Elastic File System (EFS)
- Can be mount on many EC2 in multi-AZ
- Highly available, sclable, expernisive (3x gp2)
- Uses NFSv4.1 protocol
- **Compatible only with Linux based AMIs**
- Scales automatically, pay-per-use, no capacity planning
## Scalability & High Availability
- Scalability means that an application / system can handle greater loads by adapting
    - Verical Scalability (increasing the size of the instance)
    - Horizontal Scalability (=elasticity, increasing number of instances)
- High availability means running the app / system in at least 2 data centers (== Availability Zones)
### Elastic Load Balancer
> Load Balancers are servers that forwarrd traffic to muliple servers (eg EC2 Instances) downstreams
- Spread  load across muliple downstream instances
- Expose a single point of access (DNS) to your application
- Seamlessly handle failures of downstream instances (healthchecks)
* **Application Load Balancer**
* **Netword Load Balancer**
* **Gateway Load Balancer** *(GENEVE protocol 6081)*
- **Sticky session (Session Affinity):**
    - The same client always redirected to the same instance
    - Used 'cookie' for stickness, has an expiration date you control
    - Application-based Cookies & Duration-based Cookies
> **Cross Zone Load Balancing:** distribute evenly between the instances in the availabilaty zones in all the LBs
- Available in ALB by default, no charges (can be changed in target group)
- Not available in NLB by default, charges for inter AZ if enabled
> **Without Cross Zone Load Balancing:** distribute evenly between the LBs and then instances in the availabilaty zones
### Deregistration Delay (Connection draining)
- Time to Complete 'in-flight requests' while the instance is de-registering or unhealthy
- Stops sending new requests to the EC2 isntance which is de-registering
### SSL/TLS Basics
- SSL (Secure Sockets Layer) used to encrypt connections
- TLS (Transport Layer Security), which is a newer version
- Nowadays, TLS certificate are mainly used, but people still refer as SSL
- SNI (Server Name Indication) solves the problem of loading multiple SSL setificates onto one web server (to serve multiple websites)
### Auto Scaling Group (ASG)
The goal of ASG:
- Scale out (add EC3 instances) to match an increased load
- Scale in (remove EC2 instances) to match a decresed load
- Enshure we have a minimum and a maximum number of EC2 instances running
- Automatically register new instances to load balancer
- Re-create an EC2 instance in case a previous one is terminated (ex: if unhealthy)
- CloudWatch Alarms used for autoscaling using metrics
> ASG are free (you only pay for the underlying EC2 instances)
- **A Launch Template:**
    - AMI + Instance Type
    - EC2 User Data
    - EBS Volumes
    - Security Groups
    - SSH Key Pair
    - IAM Roles for your EC2 Instances
    - Network + Subnets Information
    - Load Balancer Information
- Min Size / Max Size / Initial Capacity
- Scaling Policies
* **Autoscaling Groups:**
    * Dynamic Scaling (Scale when the CloudWatch is triggered)
    * Scheduled Scaling (Anticapate scaling using known patterns)
    * Predictive Scaling (Schedule using forecast)
