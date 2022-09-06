/*
 * Copyright 2022 Orkes, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.orkes.conductor.client.http.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

/** WorkflowTask */
public class WorkflowTask {
    @SerializedName("asyncComplete")
    private Boolean asyncComplete = null;

    @SerializedName("caseExpression")
    private String caseExpression = null;

    @SerializedName("caseValueParam")
    private String caseValueParam = null;

    @SerializedName("decisionCases")
    private Map<String, List<WorkflowTask>> decisionCases = null;

    @SerializedName("defaultCase")
    private List<WorkflowTask> defaultCase = null;

    @SerializedName("defaultExclusiveJoinTask")
    private List<String> defaultExclusiveJoinTask = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("dynamicForkJoinTasksParam")
    private String dynamicForkJoinTasksParam = null;

    @SerializedName("dynamicForkTasksInputParamName")
    private String dynamicForkTasksInputParamName = null;

    @SerializedName("dynamicForkTasksParam")
    private String dynamicForkTasksParam = null;

    @SerializedName("dynamicTaskNameParam")
    private String dynamicTaskNameParam = null;

    @SerializedName("evaluatorType")
    private String evaluatorType = null;

    @SerializedName("expression")
    private String expression = null;

    @SerializedName("forkTasks")
    private List<List<WorkflowTask>> forkTasks = null;

    @SerializedName("inputParameters")
    private Map<String, Object> inputParameters = null;

    @SerializedName("joinOn")
    private List<String> joinOn = null;

    @SerializedName("loopCondition")
    private String loopCondition = null;

    @SerializedName("loopOver")
    private List<WorkflowTask> loopOver = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("optional")
    private Boolean optional = null;

    @SerializedName("rateLimited")
    private Boolean rateLimited = null;

    @SerializedName("retryCount")
    private Integer retryCount = null;

    @SerializedName("scriptExpression")
    private String scriptExpression = null;

    @SerializedName("sink")
    private String sink = null;

    @SerializedName("startDelay")
    private Integer startDelay = null;

    @SerializedName("subWorkflowParam")
    private SubWorkflowParams subWorkflowParam = null;

    @SerializedName("taskDefinition")
    private TaskDef taskDefinition = null;

    @SerializedName("taskReferenceName")
    private String taskReferenceName = null;

    @SerializedName("type")
    private String type = null;

    /** Gets or Sets workflowTaskType */
    @JsonAdapter(WorkflowTaskTypeEnum.Adapter.class)
    public enum WorkflowTaskTypeEnum {
        SIMPLE("SIMPLE"),
        DYNAMIC("DYNAMIC"),
        FORK_JOIN("FORK_JOIN"),
        FORK_JOIN_DYNAMIC("FORK_JOIN_DYNAMIC"),
        DECISION("DECISION"),
        SWITCH("SWITCH"),
        JOIN("JOIN"),
        DO_WHILE("DO_WHILE"),
        SUB_WORKFLOW("SUB_WORKFLOW"),
        START_WORKFLOW("START_WORKFLOW"),
        EVENT("EVENT"),
        WAIT("WAIT"),
        HUMAN("HUMAN"),
        USER_DEFINED("USER_DEFINED"),
        HTTP("HTTP"),
        LAMBDA("LAMBDA"),
        INLINE("INLINE"),
        EXCLUSIVE_JOIN("EXCLUSIVE_JOIN"),
        TERMINATE("TERMINATE"),
        KAFKA_PUBLISH("KAFKA_PUBLISH"),
        JSON_JQ_TRANSFORM("JSON_JQ_TRANSFORM"),
        SET_VARIABLE("SET_VARIABLE");

        private String value;

        WorkflowTaskTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static WorkflowTaskTypeEnum fromValue(String input) {
            for (WorkflowTaskTypeEnum b : WorkflowTaskTypeEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<WorkflowTaskTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final WorkflowTaskTypeEnum enumeration)
                    throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public WorkflowTaskTypeEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return WorkflowTaskTypeEnum.fromValue((String) (value));
            }
        }
    }

    @SerializedName("workflowTaskType")
    private WorkflowTaskTypeEnum workflowTaskType = null;

    public WorkflowTask asyncComplete(Boolean asyncComplete) {
        this.asyncComplete = asyncComplete;
        return this;
    }

    /**
     * Get asyncComplete
     *
     * @return asyncComplete
     */
    @Schema(description = "")
    public Boolean isAsyncComplete() {
        return asyncComplete;
    }

    public void setAsyncComplete(Boolean asyncComplete) {
        this.asyncComplete = asyncComplete;
    }

    public WorkflowTask caseExpression(String caseExpression) {
        this.caseExpression = caseExpression;
        return this;
    }

    /**
     * Get caseExpression
     *
     * @return caseExpression
     */
    @Schema(description = "")
    public String getCaseExpression() {
        return caseExpression;
    }

    public void setCaseExpression(String caseExpression) {
        this.caseExpression = caseExpression;
    }

    public WorkflowTask caseValueParam(String caseValueParam) {
        this.caseValueParam = caseValueParam;
        return this;
    }

    /**
     * Get caseValueParam
     *
     * @return caseValueParam
     */
    @Schema(description = "")
    public String getCaseValueParam() {
        return caseValueParam;
    }

    public void setCaseValueParam(String caseValueParam) {
        this.caseValueParam = caseValueParam;
    }

    public WorkflowTask decisionCases(Map<String, List<WorkflowTask>> decisionCases) {
        this.decisionCases = decisionCases;
        return this;
    }

    public WorkflowTask putDecisionCasesItem(String key, List<WorkflowTask> decisionCasesItem) {
        if (this.decisionCases == null) {
            this.decisionCases = new HashMap<String, List<WorkflowTask>>();
        }
        this.decisionCases.put(key, decisionCasesItem);
        return this;
    }

    /**
     * Get decisionCases
     *
     * @return decisionCases
     */
    @Schema(description = "")
    public Map<String, List<WorkflowTask>> getDecisionCases() {
        return decisionCases;
    }

    public void setDecisionCases(Map<String, List<WorkflowTask>> decisionCases) {
        this.decisionCases = decisionCases;
    }

    public WorkflowTask defaultCase(List<WorkflowTask> defaultCase) {
        this.defaultCase = defaultCase;
        return this;
    }

    public WorkflowTask addDefaultCaseItem(WorkflowTask defaultCaseItem) {
        if (this.defaultCase == null) {
            this.defaultCase = new ArrayList<WorkflowTask>();
        }
        this.defaultCase.add(defaultCaseItem);
        return this;
    }

    /**
     * Get defaultCase
     *
     * @return defaultCase
     */
    @Schema(description = "")
    public List<WorkflowTask> getDefaultCase() {
        return defaultCase;
    }

    public void setDefaultCase(List<WorkflowTask> defaultCase) {
        this.defaultCase = defaultCase;
    }

    public WorkflowTask defaultExclusiveJoinTask(List<String> defaultExclusiveJoinTask) {
        this.defaultExclusiveJoinTask = defaultExclusiveJoinTask;
        return this;
    }

    public WorkflowTask addDefaultExclusiveJoinTaskItem(String defaultExclusiveJoinTaskItem) {
        if (this.defaultExclusiveJoinTask == null) {
            this.defaultExclusiveJoinTask = new ArrayList<String>();
        }
        this.defaultExclusiveJoinTask.add(defaultExclusiveJoinTaskItem);
        return this;
    }

    /**
     * Get defaultExclusiveJoinTask
     *
     * @return defaultExclusiveJoinTask
     */
    @Schema(description = "")
    public List<String> getDefaultExclusiveJoinTask() {
        return defaultExclusiveJoinTask;
    }

    public void setDefaultExclusiveJoinTask(List<String> defaultExclusiveJoinTask) {
        this.defaultExclusiveJoinTask = defaultExclusiveJoinTask;
    }

    public WorkflowTask description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @Schema(description = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkflowTask dynamicForkJoinTasksParam(String dynamicForkJoinTasksParam) {
        this.dynamicForkJoinTasksParam = dynamicForkJoinTasksParam;
        return this;
    }

    /**
     * Get dynamicForkJoinTasksParam
     *
     * @return dynamicForkJoinTasksParam
     */
    @Schema(description = "")
    public String getDynamicForkJoinTasksParam() {
        return dynamicForkJoinTasksParam;
    }

    public void setDynamicForkJoinTasksParam(String dynamicForkJoinTasksParam) {
        this.dynamicForkJoinTasksParam = dynamicForkJoinTasksParam;
    }

    public WorkflowTask dynamicForkTasksInputParamName(String dynamicForkTasksInputParamName) {
        this.dynamicForkTasksInputParamName = dynamicForkTasksInputParamName;
        return this;
    }

    /**
     * Get dynamicForkTasksInputParamName
     *
     * @return dynamicForkTasksInputParamName
     */
    @Schema(description = "")
    public String getDynamicForkTasksInputParamName() {
        return dynamicForkTasksInputParamName;
    }

    public void setDynamicForkTasksInputParamName(String dynamicForkTasksInputParamName) {
        this.dynamicForkTasksInputParamName = dynamicForkTasksInputParamName;
    }

    public WorkflowTask dynamicForkTasksParam(String dynamicForkTasksParam) {
        this.dynamicForkTasksParam = dynamicForkTasksParam;
        return this;
    }

    /**
     * Get dynamicForkTasksParam
     *
     * @return dynamicForkTasksParam
     */
    @Schema(description = "")
    public String getDynamicForkTasksParam() {
        return dynamicForkTasksParam;
    }

    public void setDynamicForkTasksParam(String dynamicForkTasksParam) {
        this.dynamicForkTasksParam = dynamicForkTasksParam;
    }

    public WorkflowTask dynamicTaskNameParam(String dynamicTaskNameParam) {
        this.dynamicTaskNameParam = dynamicTaskNameParam;
        return this;
    }

    /**
     * Get dynamicTaskNameParam
     *
     * @return dynamicTaskNameParam
     */
    @Schema(description = "")
    public String getDynamicTaskNameParam() {
        return dynamicTaskNameParam;
    }

    public void setDynamicTaskNameParam(String dynamicTaskNameParam) {
        this.dynamicTaskNameParam = dynamicTaskNameParam;
    }

    public WorkflowTask evaluatorType(String evaluatorType) {
        this.evaluatorType = evaluatorType;
        return this;
    }

    /**
     * Get evaluatorType
     *
     * @return evaluatorType
     */
    @Schema(description = "")
    public String getEvaluatorType() {
        return evaluatorType;
    }

    public void setEvaluatorType(String evaluatorType) {
        this.evaluatorType = evaluatorType;
    }

    public WorkflowTask expression(String expression) {
        this.expression = expression;
        return this;
    }

    /**
     * Get expression
     *
     * @return expression
     */
    @Schema(description = "")
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public WorkflowTask forkTasks(List<List<WorkflowTask>> forkTasks) {
        this.forkTasks = forkTasks;
        return this;
    }

    public WorkflowTask addForkTasksItem(List<WorkflowTask> forkTasksItem) {
        if (this.forkTasks == null) {
            this.forkTasks = new ArrayList<List<WorkflowTask>>();
        }
        this.forkTasks.add(forkTasksItem);
        return this;
    }

    /**
     * Get forkTasks
     *
     * @return forkTasks
     */
    @Schema(description = "")
    public List<List<WorkflowTask>> getForkTasks() {
        return forkTasks;
    }

    public void setForkTasks(List<List<WorkflowTask>> forkTasks) {
        this.forkTasks = forkTasks;
    }

    public WorkflowTask inputParameters(Map<String, Object> inputParameters) {
        this.inputParameters = inputParameters;
        return this;
    }

    public WorkflowTask putInputParametersItem(String key, Object inputParametersItem) {
        if (this.inputParameters == null) {
            this.inputParameters = new HashMap<String, Object>();
        }
        this.inputParameters.put(key, inputParametersItem);
        return this;
    }

    /**
     * Get inputParameters
     *
     * @return inputParameters
     */
    @Schema(description = "")
    public Map<String, Object> getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(Map<String, Object> inputParameters) {
        this.inputParameters = inputParameters;
    }

    public WorkflowTask joinOn(List<String> joinOn) {
        this.joinOn = joinOn;
        return this;
    }

    public WorkflowTask addJoinOnItem(String joinOnItem) {
        if (this.joinOn == null) {
            this.joinOn = new ArrayList<String>();
        }
        this.joinOn.add(joinOnItem);
        return this;
    }

    /**
     * Get joinOn
     *
     * @return joinOn
     */
    @Schema(description = "")
    public List<String> getJoinOn() {
        return joinOn;
    }

    public void setJoinOn(List<String> joinOn) {
        this.joinOn = joinOn;
    }

    public WorkflowTask loopCondition(String loopCondition) {
        this.loopCondition = loopCondition;
        return this;
    }

    /**
     * Get loopCondition
     *
     * @return loopCondition
     */
    @Schema(description = "")
    public String getLoopCondition() {
        return loopCondition;
    }

    public void setLoopCondition(String loopCondition) {
        this.loopCondition = loopCondition;
    }

    public WorkflowTask loopOver(List<WorkflowTask> loopOver) {
        this.loopOver = loopOver;
        return this;
    }

    public WorkflowTask addLoopOverItem(WorkflowTask loopOverItem) {
        if (this.loopOver == null) {
            this.loopOver = new ArrayList<WorkflowTask>();
        }
        this.loopOver.add(loopOverItem);
        return this;
    }

    /**
     * Get loopOver
     *
     * @return loopOver
     */
    @Schema(description = "")
    public List<WorkflowTask> getLoopOver() {
        return loopOver;
    }

    public void setLoopOver(List<WorkflowTask> loopOver) {
        this.loopOver = loopOver;
    }

    public WorkflowTask name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @Schema(required = true, description = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkflowTask optional(Boolean optional) {
        this.optional = optional;
        return this;
    }

    /**
     * Get optional
     *
     * @return optional
     */
    @Schema(description = "")
    public Boolean isOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public WorkflowTask rateLimited(Boolean rateLimited) {
        this.rateLimited = rateLimited;
        return this;
    }

    /**
     * Get rateLimited
     *
     * @return rateLimited
     */
    @Schema(description = "")
    public Boolean isRateLimited() {
        return rateLimited;
    }

    public void setRateLimited(Boolean rateLimited) {
        this.rateLimited = rateLimited;
    }

    public WorkflowTask retryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    /**
     * Get retryCount
     *
     * @return retryCount
     */
    @Schema(description = "")
    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public WorkflowTask scriptExpression(String scriptExpression) {
        this.scriptExpression = scriptExpression;
        return this;
    }

    /**
     * Get scriptExpression
     *
     * @return scriptExpression
     */
    @Schema(description = "")
    public String getScriptExpression() {
        return scriptExpression;
    }

    public void setScriptExpression(String scriptExpression) {
        this.scriptExpression = scriptExpression;
    }

    public WorkflowTask sink(String sink) {
        this.sink = sink;
        return this;
    }

    /**
     * Get sink
     *
     * @return sink
     */
    @Schema(description = "")
    public String getSink() {
        return sink;
    }

    public void setSink(String sink) {
        this.sink = sink;
    }

    public WorkflowTask startDelay(Integer startDelay) {
        this.startDelay = startDelay;
        return this;
    }

    /**
     * Get startDelay
     *
     * @return startDelay
     */
    @Schema(description = "")
    public Integer getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(Integer startDelay) {
        this.startDelay = startDelay;
    }

    public WorkflowTask subWorkflowParam(SubWorkflowParams subWorkflowParam) {
        this.subWorkflowParam = subWorkflowParam;
        return this;
    }

    /**
     * Get subWorkflowParam
     *
     * @return subWorkflowParam
     */
    @Schema(description = "")
    public SubWorkflowParams getSubWorkflowParam() {
        return subWorkflowParam;
    }

    public void setSubWorkflowParam(SubWorkflowParams subWorkflowParam) {
        this.subWorkflowParam = subWorkflowParam;
    }

    public WorkflowTask taskDefinition(TaskDef taskDefinition) {
        this.taskDefinition = taskDefinition;
        return this;
    }

    /**
     * Get taskDefinition
     *
     * @return taskDefinition
     */
    @Schema(description = "")
    public TaskDef getTaskDefinition() {
        return taskDefinition;
    }

    public void setTaskDefinition(TaskDef taskDefinition) {
        this.taskDefinition = taskDefinition;
    }

    public WorkflowTask taskReferenceName(String taskReferenceName) {
        this.taskReferenceName = taskReferenceName;
        return this;
    }

    /**
     * Get taskReferenceName
     *
     * @return taskReferenceName
     */
    @Schema(required = true, description = "")
    public String getTaskReferenceName() {
        return taskReferenceName;
    }

    public void setTaskReferenceName(String taskReferenceName) {
        this.taskReferenceName = taskReferenceName;
    }

    public WorkflowTask type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @Schema(description = "")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WorkflowTask workflowTaskType(WorkflowTaskTypeEnum workflowTaskType) {
        this.workflowTaskType = workflowTaskType;
        return this;
    }

    /**
     * Get workflowTaskType
     *
     * @return workflowTaskType
     */
    @Schema(description = "")
    public WorkflowTaskTypeEnum getWorkflowTaskType() {
        return workflowTaskType;
    }

    public void setWorkflowTaskType(WorkflowTaskTypeEnum workflowTaskType) {
        this.workflowTaskType = workflowTaskType;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkflowTask workflowTask = (WorkflowTask) o;
        return Objects.equals(this.asyncComplete, workflowTask.asyncComplete)
                && Objects.equals(this.caseExpression, workflowTask.caseExpression)
                && Objects.equals(this.caseValueParam, workflowTask.caseValueParam)
                && Objects.equals(this.decisionCases, workflowTask.decisionCases)
                && Objects.equals(this.defaultCase, workflowTask.defaultCase)
                && Objects.equals(
                        this.defaultExclusiveJoinTask, workflowTask.defaultExclusiveJoinTask)
                && Objects.equals(this.description, workflowTask.description)
                && Objects.equals(
                        this.dynamicForkJoinTasksParam, workflowTask.dynamicForkJoinTasksParam)
                && Objects.equals(
                        this.dynamicForkTasksInputParamName,
                        workflowTask.dynamicForkTasksInputParamName)
                && Objects.equals(this.dynamicForkTasksParam, workflowTask.dynamicForkTasksParam)
                && Objects.equals(this.dynamicTaskNameParam, workflowTask.dynamicTaskNameParam)
                && Objects.equals(this.evaluatorType, workflowTask.evaluatorType)
                && Objects.equals(this.expression, workflowTask.expression)
                && Objects.equals(this.forkTasks, workflowTask.forkTasks)
                && Objects.equals(this.inputParameters, workflowTask.inputParameters)
                && Objects.equals(this.joinOn, workflowTask.joinOn)
                && Objects.equals(this.loopCondition, workflowTask.loopCondition)
                && Objects.equals(this.loopOver, workflowTask.loopOver)
                && Objects.equals(this.name, workflowTask.name)
                && Objects.equals(this.optional, workflowTask.optional)
                && Objects.equals(this.rateLimited, workflowTask.rateLimited)
                && Objects.equals(this.retryCount, workflowTask.retryCount)
                && Objects.equals(this.scriptExpression, workflowTask.scriptExpression)
                && Objects.equals(this.sink, workflowTask.sink)
                && Objects.equals(this.startDelay, workflowTask.startDelay)
                && Objects.equals(this.subWorkflowParam, workflowTask.subWorkflowParam)
                && Objects.equals(this.taskDefinition, workflowTask.taskDefinition)
                && Objects.equals(this.taskReferenceName, workflowTask.taskReferenceName)
                && Objects.equals(this.type, workflowTask.type)
                && Objects.equals(this.workflowTaskType, workflowTask.workflowTaskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                asyncComplete,
                caseExpression,
                caseValueParam,
                decisionCases,
                defaultCase,
                defaultExclusiveJoinTask,
                description,
                dynamicForkJoinTasksParam,
                dynamicForkTasksInputParamName,
                dynamicForkTasksParam,
                dynamicTaskNameParam,
                evaluatorType,
                expression,
                forkTasks,
                inputParameters,
                joinOn,
                loopCondition,
                loopOver,
                name,
                optional,
                rateLimited,
                retryCount,
                scriptExpression,
                sink,
                startDelay,
                subWorkflowParam,
                taskDefinition,
                taskReferenceName,
                type,
                workflowTaskType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WorkflowTask {\n");

        sb.append("    asyncComplete: ").append(toIndentedString(asyncComplete)).append("\n");
        sb.append("    caseExpression: ").append(toIndentedString(caseExpression)).append("\n");
        sb.append("    caseValueParam: ").append(toIndentedString(caseValueParam)).append("\n");
        sb.append("    decisionCases: ").append(toIndentedString(decisionCases)).append("\n");
        sb.append("    defaultCase: ").append(toIndentedString(defaultCase)).append("\n");
        sb.append("    defaultExclusiveJoinTask: ")
                .append(toIndentedString(defaultExclusiveJoinTask))
                .append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    dynamicForkJoinTasksParam: ")
                .append(toIndentedString(dynamicForkJoinTasksParam))
                .append("\n");
        sb.append("    dynamicForkTasksInputParamName: ")
                .append(toIndentedString(dynamicForkTasksInputParamName))
                .append("\n");
        sb.append("    dynamicForkTasksParam: ")
                .append(toIndentedString(dynamicForkTasksParam))
                .append("\n");
        sb.append("    dynamicTaskNameParam: ")
                .append(toIndentedString(dynamicTaskNameParam))
                .append("\n");
        sb.append("    evaluatorType: ").append(toIndentedString(evaluatorType)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
        sb.append("    forkTasks: ").append(toIndentedString(forkTasks)).append("\n");
        sb.append("    inputParameters: ").append(toIndentedString(inputParameters)).append("\n");
        sb.append("    joinOn: ").append(toIndentedString(joinOn)).append("\n");
        sb.append("    loopCondition: ").append(toIndentedString(loopCondition)).append("\n");
        sb.append("    loopOver: ").append(toIndentedString(loopOver)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    optional: ").append(toIndentedString(optional)).append("\n");
        sb.append("    rateLimited: ").append(toIndentedString(rateLimited)).append("\n");
        sb.append("    retryCount: ").append(toIndentedString(retryCount)).append("\n");
        sb.append("    scriptExpression: ").append(toIndentedString(scriptExpression)).append("\n");
        sb.append("    sink: ").append(toIndentedString(sink)).append("\n");
        sb.append("    startDelay: ").append(toIndentedString(startDelay)).append("\n");
        sb.append("    subWorkflowParam: ").append(toIndentedString(subWorkflowParam)).append("\n");
        sb.append("    taskDefinition: ").append(toIndentedString(taskDefinition)).append("\n");
        sb.append("    taskReferenceName: ")
                .append(toIndentedString(taskReferenceName))
                .append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    workflowTaskType: ").append(toIndentedString(workflowTaskType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
