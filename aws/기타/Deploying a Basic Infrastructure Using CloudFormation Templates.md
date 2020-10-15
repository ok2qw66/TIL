# Deploying a Basic Infrastructure Using CloudFormation Templates

## Introduction

In this hands-on lab, we will use CloudFormation to provision a basic infrastructure environment with an EC2 instance. There are many different basic infrastructures you could build with CloudFormation, and this lab is just one example. We will complete several objectives throughout this lab, including creating an EC2 key pair, using a CloudFormation template to deploy a basic infrastructure with an EC2 instance, and finally logging in to the instance via SSH to demonstrate the CloudFormation stack provisioned and deployed the environment correctly.

## Solution

Log in to the live AWS environment using the credentials provided. Make sure you are in the `us-east-1` (N. Virginia) region throughout the lab.

Use [this link](https://raw.githubusercontent.com/julielkinsfembotit/CFtemplates/master/AWSVPCEC2LAtemplate) for the CloudFormation template to provision an EC2 instance.

Open your terminal or use the Linux Academy Cloud Playground terminal; select the Instant Terminal tab.

### Create an EC2 Key Pair and Use the Provided CloudFormation Template to Provision an EC2 Instance

1. Navigate to EC2.
2. On the left-hand menu, click **Key Pairs**.
3. Click **Create Key Pair**.
4. Give it a name (e.g., "EC2keypairCFtemplate"), and click **Create**.
5. Navigate to CloudFormation.
6. Click **Create stack**.
7. Select **Create template in Designer**.
8. Click **Create template in designer**.
9. Select the *Template* tab.
10. Delete the existing code.
11. Copy the provided [CloudFormation template](https://raw.githubusercontent.com/julielkinsfembotit/CFtemplates/master/AWSVPCEC2LAtemplate) and paste it into the template section.
12. Click the checkbox at the top to validate the template, and then click the cloud icon with the up arrow to create the stack.
13. Click **Next**.
14. On the stack details page, set the following values:
    - *Stack name*: **EC2CFTemplate**
    - *KeyName*: Select your key pair in the dropdown
15. Click **Next**.
16. Leave the defaults on the stack options page, and click **Next**.
17. Click **Create stack**.
18. Navigate to VPC and verify the template provisioned and deployed our basic networking infrastructure.

### Use the EC2 Public IP Address and the Terminal to Ping the Instance

1. Navigate to **EC2** > **Instances**.

2. With the running instance selected, click **Connect**.

3. In the terminal window, navigate to the directory where you saved your key pair (most likely your downloads folder):

   ```
   cd Downloads
   ```

4. Copy the `chmod` command in the *Connect To Your Instance* window and paste it into the terminal to set permissions on your key pair.

5. Copy and paste the `ssh - i` connection string into your terminal window to connect to the instance.

## Conclusion

Congratulations on successfully completing this hands-on lab!