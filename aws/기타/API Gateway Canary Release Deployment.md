# API Gateway Canary Release Deployment

## Introduction

In this hands-on lab, we will use API Gateway as a front-end to AWS Lambda, and configure API Gateway to perform a Canary deployment on a newer version of the API. The Canary deployment enables the gentle introduction of a new API version into our environment by sending a predetermined (usually small) amount of requests to the newer version of the API. As testing progresses, we can send a larger amount of requests, until the new API version can finally be put into production. We will create two Lambda functions, one of which will act as the candidate for Canary deployment. Then we'll continue on to API Gateway and configure API Gateway to perform the Canary deployment.

## Logging In

Log in to the AWS environment by using the `cloud_user` credentials provided on the hands-on lab overview page.

Once inside the AWS account, make sure you are using **us-east-1 (N. Virginia)** as the selected region.

Download the two Lambda functions used in this lab, `mathCeil.js` and `mathFloor.js`, from [this GitHub repository](https://github.com/natonic/DevOpsPro/tree/master/CanaryDeployment)

## Create First Lambda Function

1. Navigate to Lambda.

2. Click **Create function**.

3. Make sure the **Author from scratch** option at the top is selected, and give it a *Function name* of "mathCeil".

4. Expand

    

   Choose or create an execution role

   , and use the following settings:

   - *Execution role*: **Use an existing role**
   - *Existing role*: Choose the one starting with **cfst-**

5. Click **Create function**.

6. In the *Function code* section, delete the existing code and paste in the code in the `math.Ceil` function ([found on GitHub](https://raw.githubusercontent.com/natonic/DevOpsPro/master/CanaryDeployment/mathCeil.js)).

7. Click **Save** and then **Test**.

8. Give it an *Event name* of "testCeiling", and click **Create**.

9. Click **Test**, and we should get a response.

## Create Second Lambda Function

1. Click the **Functions** link.

2. Click **Create function**. . Make sure the **Author from scratch** option at the top is selected, and give it a *Function name* of "mathFloor".

3. Expand

    

   Choose or create an execution role

   , and use the following settings:

   - *Execution role*: **Use an existing role**
   - *Existing role*: Choose the one starting with **cfst-**

4. Click **Create function**.

5. In the *Function code* section, delete the existing code and paste in the code in the `math.Floor` function ([found on GitHub](https://raw.githubusercontent.com/natonic/DevOpsPro/master/CanaryDeployment/mathFloor.js)).

6. Click **Save** and then **Test**.

7. Give it an *Event name* of "testFloor", and click **Create**.

8. Click **Test**, and we should get a response.

## Create and Deploy Our API Within API Gateway

### Create the API

1. Navigate to API Gateway.

2. In the *REST API* card, click **Build**.

3. Set the following values:

   - *Create new API*: **New API**
   - *API name*: **devopsCanary**
   - *Description*: **API Gateway Canary Testing**
   - *Endpoint Type*: **Regional**.

4. Click **Create API**.

5. On the *Resources* page, click **Actions** and select **Create Method** from the dropdown.

6. In the blank dropdown, select **GET** and click the checkmark.

7. In the

    

   / - GET - Setup

    

   window, set the following values:

   - *Integration type*: **Lambda Function**
   - *Use Lambda Proxy integration*: Leave un-checked
   - *Lambda Region*: **us-east-1**
   - *Lambda Function*: **mathCeil**
   - *Use Default Timeout*: Check

8. Click **Save** and then **OK**.

9. Click **Test** and then the **Test** button.

### Deploy the First Function

1. Click **Actions** and select **Deploy API**.

2. In the

    

   Deploy API

    

   dialog, set the following values:

   - *Deployment stage*: **[New Stage](https://learn.acloud.guru/handson/7118edcf-32fc-4e67-9019-e0f1db5c848f/course/178db59b-70f1-4bd8-8d74-9ab9263f8f9a)**
   - *Stage name*: **test**
   - *Stage description*: **Test stage for Canary**
   - *Deployment description*: **Test stage for Canary**

3. Click **Deploy**.

4. Click the *Invoke URL* near the top of the screen. We should see the same message ("*this is the original function...*") as earlier.

5. Back in the API Gateway, click the **Canary** tab.

6. Click **Create Canary**.

7. Click the pencil icon in the *Stage's Request Distribution* section, set *Percentage of requests directed to Canary* to **10%**, and click the checkmark.

8. Click the link near the top of the screen that says *devopsCanary*.

9. Click **GET**, and then select **Integration Request**.

10. Change the *Lambda Function* (by clicking the pencil) to **mathFloor**.

11. Click the check, and then **OK**.

12. Click **Method Execution**.

13. Click **Test**, and then click **Test** again.

14. Click **Test** several times to make sure the response we're getting is *This is the new Canary Function (Math.Floor)*.

### Deploy the Second Function

1. In the *Actions* dropdown, select **Deploy API**.

2. In the

    

   Deploy API

    

   dialog, set the following values:

   - *Deployment stage*: **test (Canary Enabled)**
   - *Deployment description*: **Canary Test**

3. Click **Deploy**.

4. Click the *Invoke URL* (You can disregard any WAF2 errors). We should see the message we got last time.

5. Keep hitting refresh. We'll see the *other* message (*This is the new Canary Function (Math.Floor)*) show up every so often (about 10% of the time).

6. Back in the API Gateway, in the **Canary** tab, click the pencil icon in the *Stage's Request Distribution* section, and set *Percentage of requests directed to Canary* to **50%**. (Click the checkmark to save the change.)

7. Refresh the invoke URL tab multiple times, and we should see either message about half the time.

### Promote the Canary

1. Click **Promote Canary** in the API Gateway window, and click **Update**. We'll see the percentages change so that now *all* of our requests will be aimed at **test**.
2. Check **Invoke URL** again, and keep hitting refresh. We'll see that all the responses are *This is the new Canary Function (Math.Floor)*.

## Conclusion

Congratulations on successfully completing this hands-on lab!