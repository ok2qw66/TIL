# Create a Linux EC2 Instance in AWS and Connect Using SSH

## Introduction

This hands-on lab will walk you through the process of configuring a Linux EC2 instance and connecting to that instance using SSH. In the lab, we will be using a Mac terminal to connect via SSH. If you are using Windows, please refer to the lesson on connecting to an EC2 instance using SSH from a Windows PC. It will provide information on how to connect to an EC2 instance using PuTTY.

## Solution

Log in to the AWS Management Console using the credentials provided. Make sure you're in the `us-east-1` region throughout the lab.

Also, open a terminal window. If you are connecting from a Windows computer, please see [these instructions](https://linuxacademy.com/blog/linux/connect-to-amazon-ec2-using-putty-private-key-on-windows/) on using PuTTY to connect via SSH.

### Configure the Security Group

1. In the AWS console, navigate to **VPC** > **Security Groups**.
2. Make sure the listed security group is selected, and click the **Inbound Rules** tab.
3. Click **Edit rules**.
4. Change the *Type* to **SSH**.
5. Change the *Source* to **0.0.0.0/0**.
6. Click **Add Rule**.
7. Set its *Type* to **HTTP**.
8. For its *Source*, enter **0.0.0.0/0**.
9. Click **Save rules**.

### Create and Connect to an EC2 Instance

#### Create the EC2 Instance

1. Navigate to EC2, and click **Launch Instance**.

2. On the AMI page, select the Amazon Linux AMI.

3. Leave *t2.micro* selected, and click **Next: Configure Instance Details**.

4. On the *Configure Instance Details* page:

   - *Network*: Leave default
   - *Subnet*: Leave default
   - *Auto-assign Public IP*: **Enable**

5. Expand the *Advanced Details* section.

6. In the user data box, enter:

   ```
   #!/bin/bash
   yum update -y
   yum install -y httpd
   service httpd start
   ```

7. Click **Next: Add Storage**, and then click **Next: Add Tags**.

8. On the *Add Tags* page, add the following tag:

   - *Key*: **Name**
   - *Value*: **Webserver**

9. Click **Next: Configure Security Group**.

10. Click to **Select an existing security group**.

11. Select our existing security group in the table.

12. Click **Review and Launch**, and then **Launch**.

13. In the key pair dialog, select **Create a new key pair**.

14. Give it a *Key pair name* of "ec2_linuxla".

15. Click **Download Key Pair**, and then **Launch Instances**.

16. Click **View Instances**, and give it a few minutes to enter the *running* state.

17. Copy its public IP address (listed at the bottom) and paste it into a text file, as we will need it a couple times during the rest of the lab..

#### Connect to the EC2 Instance

1. Open a terminal window.

   > **Note:** Windows users can connect to the instance using [this as a guide](https://linuxacademy.com/blog/linux/connect-to-amazon-ec2-using-putty-private-key-on-windows/).

2. Change to your downloads directory, where the key pair file is saved:

   ```
   cd Downloads
   ```

3. Change permissions on the key pair file:

   ```
   chmod 400 ec2_linuxla.pem
   ```

4. Connect to the instance (replacing `<PUBLIC IP ADDRESS>` with the one you copied a minute ago):

   ```bash
   ssh -i "ec2_linuxla.pem" ec2-user@<PUBLIC IP ADDRESS>
   ```

5. Enter `yes` at the prompt.

6. In a new browser tab, paste in the instance's public IP address. We should see the Amazon Linux AMI Test Page.

## Conclusion

Congratulations on successfully completing this hands-on lab!