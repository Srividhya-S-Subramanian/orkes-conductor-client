# Conductor Java SDK

[Conductor](https://www.conductor-oss.org/) is the leading open-source orchestration platform allowing developers to build highly scalable distributed applications. 

Check out the [official documentation for Conductor](https://orkes.io/content).

This repository provides a Java client for the Orkes Conductor Server. 

## ⭐ Conductor OSS

Show support for the Conductor OSS.  Please help spread the awareness by starring Conductor repo.

[![GitHub stars](https://img.shields.io/github/stars/conductor-oss/conductor.svg?style=social&label=Star&maxAge=)](https://GitHub.com/conductor-oss/conductor/)

## Content

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
<!-- END doctoc generated TOC please keep comment here to allow auto update -->

- [Set Up Conductor Java SDK](#set-up-conductor-java-sdk)
  - [Gradle](#gradle)
  - [Maven](#maven)
- [Hello World Application Using Conductor](#hello-world-application-using-conductor)
  - [Step 1: Create Workflow](#step-1-create-workflow)
    - [Creating Workflows by Code](#creating-workflows-by-code)
    - [(Alternatively) Creating Workflows in JSON](#alternatively-creating-workflows-in-json)
  - [Step 2: Write Worker](#step-2-write-worker)
  - [Step 3: Write *Hello World* Application](#step-3-write-hello-world-application)
- [Running Workflows on Conductor Standalone (Installed Locally)](#running-workflows-on-conductor-standalone-installed-locally)
  - [Conductor Server Settings](#conductor-server-settings)
  - [Start Conductor Server](#start-conductor-server)
  - [Execute Hello World Application](#execute-hello-world-application)
- [Running Workflows on Orkes Conductor](#running-workflows-on-orkes-conductor)
- [Learn More about Conductor Java SDK](#learn-more-about-conductor-java-sdk)
  - [Create and Run Conductor Workers](#create-and-run-conductor-workers)
  - [Create Conductor Workflows](#create-conductor-workflows)
  - [Using Conductor in Your Application](#using-conductor-in-your-application)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Set Up Conductor Java SDK

Add `orkes-conductor-client` dependency to your project.

### Gradle

For Gradle-based projects, modify the `build.gradle` file in the project directory by adding the following line to the dependencies block in that file:

```
implementation 'io.orkes.conductor:orkes-conductor-client:2.0.1'
```

### Maven

For Maven-based projects, modify the `pom.xml` file in the project directory by adding the following XML snippet within the `dependencies` section:

```
<dependency>
  <groupId>io.orkes.conductor</groupId>
  <artifactId>orkes-conductor-client</artifactId>
  <version>1.1.14</version>
</dependency>
```

## Hello World Application Using Conductor

In this section, we will create a simple "Hello World" application that executes a "greetings" workflow managed by Conductor.

### Step 1: Create Workflow

#### Creating Workflows by Code

Create `workflow/GreetingsWorkflow.java` with the following:

```java
package io.orkes.conductor.sdk.examples.HelloWorld.workflow;

import com.netflix.conductor.sdk.workflow.def.ConductorWorkflow;
import com.netflix.conductor.sdk.workflow.def.tasks.SimpleTask;
import com.netflix.conductor.sdk.workflow.executor.WorkflowExecutor;

public class GreetingsWorkflow {
    private final WorkflowExecutor executor;
    public GreetingsWorkflow(WorkflowExecutor executor) {
        this.executor = executor;
    }
    public ConductorWorkflow<WorkflowInput> GreetingsWorkflow() {
        ConductorWorkflow<WorkflowInput> workflow = new ConductorWorkflow<>(executor);
        workflow.setName("greetings");
        workflow.setVersion(1);
        SimpleTask greetingsTask = new SimpleTask("greet", "greet_ref");
        greetingsTask.input("name", "${workflow.input.name}");
        workflow.add(greetingsTask);
        return workflow;
    }
}
```
Create `workflow/WorkflowInput.java` with the following:

```java
package io.orkes.conductor.sdk.examples.HelloWorld.workflow;

public class WorkflowInput {
    private String name;
    public WorkflowInput(String name) {
        this.name = name;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

#### (Alternatively) Creating Workflows in JSON

Create `workflow.json` with the following:

```json
{
  "name": "greetings",
  "description": "Sample greetings workflow",
  "version": 1,
  "tasks": [
    {
      "name": "greet",
      "taskReferenceName": "greet_ref",
      "type": "SIMPLE",
      "inputParameters": {
        "name": "${workflow.input.name}"
      }
    }
  ],
  "timeoutPolicy": "TIME_OUT_WF",
  "timeoutSeconds": 60
}
```

Workflows must be registered to the Conductor server. Use the API to register the greetings workflow from the JSON file above:


```shell
curl -X POST -H "Content-Type:application/json" \
http://localhost:8080/api/metadata/workflow -d @workflow.json
```

> [!note]
> To use the Conductor API, the Conductor server must be up and running (see [Running over Conductor standalone (installed locally)](#running-over-conductor-standalone-installed-locally))

### Step 2: Write Worker

Create `workers/ConductorWorkers.java` with a simple worker and workflow function.

> [!note]
> A single workflow can have task workers written in different languages and deployed anywhere, making your workflow polyglot and distributed!

```java
package io.orkes.conductor.sdk.examples.HelloWorld.worker;

import com.netflix.conductor.sdk.workflow.task.InputParam;
import com.netflix.conductor.sdk.workflow.task.WorkerTask;
  public class ConductorWorkers {
    @WorkerTask("greet")
    public String greet(@InputParam("name") String name) {
      return "Hello " + name;
    }
  }
```

Now, we are ready to write our main application, which will execute our workflow.

### Step 3: Write *Hello World* Application

Let's add `Main.java` with a `main` method:

```java
package io.orkes.conductor.sdk.examples.HelloWorld;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.base.Preconditions;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.run.Workflow;
import com.netflix.conductor.sdk.workflow.def.ConductorWorkflow;
import com.netflix.conductor.sdk.workflow.executor.WorkflowExecutor;

import io.orkes.conductor.client.ApiClient;
import io.orkes.conductor.client.MetadataClient;
import io.orkes.conductor.client.OrkesClients;
import io.orkes.conductor.client.TaskClient;
import io.orkes.conductor.client.WorkflowClient;
import io.orkes.conductor.client.automator.TaskRunnerConfigurer;
import io.orkes.conductor.sdk.examples.HelloWorld.workflow.GreetingsWorkflow;
import io.orkes.conductor.sdk.examples.HelloWorld.workflow.WorkflowInput;

public class Main {

    private static final String ENV_ROOT_URI = "CONDUCTOR_SERVER_URL";
    private static final String ENV_KEY_ID = "KEY";
    private static final String ENV_SECRET = "SECRET";

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //Initialise Conductor Client
        OrkesClients orkesClients = getApiClientWithCredentials();
        TaskClient taskClient = orkesClients.getTaskClient();
        WorkflowClient workflowClient = orkesClients.getWorkflowClient();
        MetadataClient metadataClient = orkesClients.getMetadataClient();

        //Initialise WorkflowExecutor and Conductor Workers
        WorkflowExecutor workflowExecutor = new WorkflowExecutor(taskClient, workflowClient, metadataClient, 10);
        workflowExecutor.initWorkers("io.orkes.conductor.sdk.examples.HelloWorld.workers");

        //Create the workflow with input
        GreetingsWorkflow workflowCreator = new GreetingsWorkflow(workflowExecutor);
        ConductorWorkflow<WorkflowInput> simpleWorkflow = workflowCreator.createWorkflow();
        WorkflowInput input = new WorkflowInput("Orkes");
        CompletableFuture<Workflow> workflowExecution = simpleWorkflow.executeDynamic(input);
        Workflow workflowRun = workflowExecution.get(10, TimeUnit.SECONDS);

        //Shutdown workflowClient and taskrunner
        workflowClient.shutdown();
        System.exit(0);
    }

    private static TaskRunnerConfigurer initWorkers(List<Worker> workers, TaskClient taskClient) {
        TaskRunnerConfigurer.Builder builder = new TaskRunnerConfigurer.Builder(taskClient, workers);
        TaskRunnerConfigurer taskRunner = builder.withThreadCount(1).withTaskPollTimeout(5).build();
        // Start Polling for tasks and execute them
        taskRunner.init();
        return taskRunner;
    }

    public static OrkesClients getApiClientWithCredentials() {
        ApiClient apiClient = new ApiClient(ENV_ROOT_URI,ENV_KEY_ID,ENV_SECRET);
        apiClient.setWriteTimeout(30_000);
        apiClient.setReadTimeout(30_000);
        apiClient.setConnectTimeout(30_000);
        return new OrkesClients(apiClient);
    }
}
```
Add the [ApiUtil.java](examples/java/io/orkes/conductor/sdk/ApiUtil.java) file to set the environment variables.
## Running Workflows on Conductor Standalone (Installed Locally)

### Conductor Server Settings

Everything related to server settings should be done within the `ApiClient` class by setting the required parameters when initializing an object, like this:

```java
ApiClient apiClient = new ApiClient("CONDUCTOR_SERVER_URL");
```

If you are using Spring Framework, you can initialize the above class as a bean that can be used across the project.

### Start Conductor Server

To start the Conductor server in a standalone mode from a Docker image, type the command below:

```
docker run --init -p 8080:8080 -p 5000:5000 conductoross/conductor-standalone:3.15.0
```

To ensure the server has started successfully, open Conductor UI on http://localhost:5000.

### Execute Hello World Application

Run the Java application now.

Now, the workflow is executed, and its execution status can be viewed from Conductor UI (http://localhost:5000).

Navigate to the **Executions** tab to view the workflow execution.

<img width="1431" alt="Screenshot 2024-04-01 at 15 53 02" src="https://github.com/RizaFarheen/orkes-conductor-client/assets/163816773/e413c828-5f47-4cdc-b113-bed3fefa63a4">

## Running Workflows on Orkes Conductor

For running the workflow in Orkes Conductor, 

- Update the Conductor server URL to your cluster name.

```java
 export CONDUCTOR_SERVER_URL="https://[your-cluster-name].orkesconductor.io/api"
```

- If you want to run the workflow on the Orkes Conductor Playground, set the Conductor Server variable as follows:

```java
export CONDUCTOR_SERVER_URL=https://play.orkes.io/api
```

- Orkes Conductor requires authentication. [Obtain the key and secret from the Conductor server](https://orkes.io/content/how-to-videos/access-key-and-secret) and set the following environment variables.

```
export KEY=your_key
export SECRET=your_secret
```
Run the application and view the execution status from Conductor's UI Console.

> [!NOTE]
> That's it - you just created and executed your first distributed Java app!
> 

## Learn More about Conductor Java SDK

There are three main ways you can use Conductor when building durable, resilient, distributed applications.

1. Write service workers that implement business logic to accomplish a specific goal - such as initiating payment transfer, getting user information from the database, etc.
2. Create Conductor workflows that implement application state - A typical workflow implements the saga pattern.
3. Use Conductor SDK and APIs to manage workflows from your application.

### [Create and Run Conductor Workers](docs/worker/README.md)

### [Create Conductor Workflows](docs/workflow/README.md)

### [Using Conductor in Your Application](docs/conductor_apps.md)
