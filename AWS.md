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