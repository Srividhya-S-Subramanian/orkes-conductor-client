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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/** RerunWorkflowRequest */
public class RerunWorkflowRequest {
    @SerializedName("correlationId")
    private String correlationId = null;

    @SerializedName("reRunFromTaskId")
    private String reRunFromTaskId = null;

    @SerializedName("reRunFromWorkflowId")
    private String reRunFromWorkflowId = null;

    @SerializedName("taskInput")
    private Map<String, Object> taskInput = null;

    @SerializedName("workflowInput")
    private Map<String, Object> workflowInput = null;

    public RerunWorkflowRequest correlationId(String correlationId) {
        this.correlationId = correlationId;
        return this;
    }

    /**
     * Get correlationId
     *
     * @return correlationId
     */
    @Schema(description = "")
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public RerunWorkflowRequest reRunFromTaskId(String reRunFromTaskId) {
        this.reRunFromTaskId = reRunFromTaskId;
        return this;
    }

    /**
     * Get reRunFromTaskId
     *
     * @return reRunFromTaskId
     */
    @Schema(description = "")
    public String getReRunFromTaskId() {
        return reRunFromTaskId;
    }

    public void setReRunFromTaskId(String reRunFromTaskId) {
        this.reRunFromTaskId = reRunFromTaskId;
    }

    public RerunWorkflowRequest reRunFromWorkflowId(String reRunFromWorkflowId) {
        this.reRunFromWorkflowId = reRunFromWorkflowId;
        return this;
    }

    /**
     * Get reRunFromWorkflowId
     *
     * @return reRunFromWorkflowId
     */
    @Schema(description = "")
    public String getReRunFromWorkflowId() {
        return reRunFromWorkflowId;
    }

    public void setReRunFromWorkflowId(String reRunFromWorkflowId) {
        this.reRunFromWorkflowId = reRunFromWorkflowId;
    }

    public RerunWorkflowRequest taskInput(Map<String, Object> taskInput) {
        this.taskInput = taskInput;
        return this;
    }

    public RerunWorkflowRequest putTaskInputItem(String key, Object taskInputItem) {
        if (this.taskInput == null) {
            this.taskInput = new HashMap<String, Object>();
        }
        this.taskInput.put(key, taskInputItem);
        return this;
    }

    /**
     * Get taskInput
     *
     * @return taskInput
     */
    @Schema(description = "")
    public Map<String, Object> getTaskInput() {
        return taskInput;
    }

    public void setTaskInput(Map<String, Object> taskInput) {
        this.taskInput = taskInput;
    }

    public RerunWorkflowRequest workflowInput(Map<String, Object> workflowInput) {
        this.workflowInput = workflowInput;
        return this;
    }

    public RerunWorkflowRequest putWorkflowInputItem(String key, Object workflowInputItem) {
        if (this.workflowInput == null) {
            this.workflowInput = new HashMap<String, Object>();
        }
        this.workflowInput.put(key, workflowInputItem);
        return this;
    }

    /**
     * Get workflowInput
     *
     * @return workflowInput
     */
    @Schema(description = "")
    public Map<String, Object> getWorkflowInput() {
        return workflowInput;
    }

    public void setWorkflowInput(Map<String, Object> workflowInput) {
        this.workflowInput = workflowInput;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RerunWorkflowRequest rerunWorkflowRequest = (RerunWorkflowRequest) o;
        return Objects.equals(this.correlationId, rerunWorkflowRequest.correlationId)
                && Objects.equals(this.reRunFromTaskId, rerunWorkflowRequest.reRunFromTaskId)
                && Objects.equals(
                        this.reRunFromWorkflowId, rerunWorkflowRequest.reRunFromWorkflowId)
                && Objects.equals(this.taskInput, rerunWorkflowRequest.taskInput)
                && Objects.equals(this.workflowInput, rerunWorkflowRequest.workflowInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                correlationId, reRunFromTaskId, reRunFromWorkflowId, taskInput, workflowInput);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RerunWorkflowRequest {\n");

        sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
        sb.append("    reRunFromTaskId: ").append(toIndentedString(reRunFromTaskId)).append("\n");
        sb.append("    reRunFromWorkflowId: ")
                .append(toIndentedString(reRunFromWorkflowId))
                .append("\n");
        sb.append("    taskInput: ").append(toIndentedString(taskInput)).append("\n");
        sb.append("    workflowInput: ").append(toIndentedString(workflowInput)).append("\n");
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
