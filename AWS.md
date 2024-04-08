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
> AWS CLI - is a tool that enables  to interact with AWS services using commands in your command-line shell
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
> EC2 = Elastic Compute Cloud = Infrastructure as a Service =  Renting vitrual machine
After each start instance gets different IPv4 address
- CPU
- RAM
- Storage:
    - Network-attached (EBS & EFS)
    - Hardware (EC2 Instance Store)
- Key Pair: connect to EC2
- Network card
- Firewall (Security Group): 
    - Controls traffic TO or OUT of the EC2 instance.
    - Security groups only contain *allow* rules
    - Locked down to a particular region
    - *It's good to maintain one separate security group for SSH access*
- Bootstap script (config at launch): EC2 User Data (install updates, software, files from internet)
> ssh -i <file_name.pem> ec2-user@<public_ipv4>
### Ports
**22** = SSH (Secure Shell) - log into a Linux instance
**21** = FTP (File Transfert Protocol) - upload files into a file share
**22** = SFTP (Secure File Transfert Protocol) - upload files using SSH
**80** = HTTP - access unsecured websites
**443** = HTTPS - acces secured websites
**3389** = RDP (Remote Desktop Protocol) - log into a Windows instance
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