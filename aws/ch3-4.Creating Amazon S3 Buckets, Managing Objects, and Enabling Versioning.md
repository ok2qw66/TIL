# Creating Amazon S3 Buckets, Managing Objects, and Enabling Versioning

## Introduction

In this hands-on lab, we will create two S3 buckets and verify public vs. non-public access to the buckets. We will also enable and validate versioning based on uploaded objects.

## Solution

Use the provided credentials to log in to the AWS Management Console, and make sure you are in `us-east-1` throughout the lab.

Download the [files we'll upload later](https://github.com/tia-la/ccp) from GitHub.

### Create an Amazon S3 Bucket with Public Access Enabled

#### Create Public Bucket

1. Navigate to S3.
2. Click **+ Create bucket**.
3. For *Bucket name*, type "lapublic". (Since bucket names must be globally unique, add a series of random numbers at the end.) Click **Next**.
4. Leave the versioning settings as-is, and click **Next**.
5. On the configuration options screen, ensure that **Block all public access** *is* unchecked. Click **Next**.
6. On the permissions screen, ensure *none* of the checkmarks are selected — this includes individual ones and any group check mark.
7. Click **Create bucket**.

#### Create Private Bucket

1. Click **+ Create bucket**.
2. For *Bucket name*, type "laprivate". (Since bucket names must be globally unique, add a series of random numbers at the end.) Click **Next**.
3. Leave the versioning settings as-is, and click **Next**.
4. On the configuration options screen, make sure **Block all public access** *is* checked. Click **Next**.
5. On the permissions screen, verify the private bucket creation fields that we just set up.
6. Click **Create bucket**.

#### Create a Folder and Upload File in Public Bucket

1. Click the public bucket to open it.
2. Click **+ Create folder**
3. Give the folder a name of "images", and click **Save**.
4. Click the folder name, and then click **Upload**.
5. Click **Add files** to upload the *pinehead.jpg* file you downloaded at the start of the lab. Click **Next**.
6. Set *Manage public permissions* to **Grant public read access to this object(s)**, and click **Next**.
7. Click **Next** and **Upload**.

#### Upload File to Private Bucket

1. Head back to the S3 dashboard.
2. Click the private bucket to open it.
3. Click **Upload**.
4. Click **Add files** to upload the same *pinehead.jpg* file. Click **Next**.
5. Click **Next**, **Next**, and **Upload**.
6. Once it's uploaded, click the listed **Object URL**, which should result in an error.

### Enable Versioning on the Public Bucket and Validate Access to Different Versions of Files with the Same Name

- *Note*: Before taking the following steps, rename the *pineheadv2.jpg* file to *pinehead.jpg* to achieve the same versioning results as the lab video.

1. Head back to the S3 dashboard.
2. Click the public bucket to open it.
3. Click the *Properties* tab.
4. Click into the *Versioning* box.
5. Check the circle to *Enable versioning*, and click **Save**.
6. Back in the *Overview* tab, click to open the *images* folder.
7. Click **Upload**, **Add files**, and upload the *pinehead.jpg* file.
8. Click **Next**, **Next**, and **Upload**.
9. Once it's uploaded, click **Make public**.
10. Click the **Latest version** link at the top to see there are two versions listed: the previous one and the one we just uploaded.

## Conclusion

Congratulations on completing this hands-on lab!