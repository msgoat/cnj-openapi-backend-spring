package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.TaskManagement;
import group.msg.at.cloud.cloudtrain.core.entity.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/tasks")
@CrossOrigin
@SecurityRequirement(name = "oidc", scopes = { "openid" ,"microprofile-jwt" })
public class TasksController {

    @Autowired
    TaskManagement boundary;

    @GetMapping("{taskId}")
    @Operation(summary = "returns the task with the given task ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "body contains the task with the given task ID",
                    content = @Content(schema = @Schema(ref = "#/components/schema/Task"))),
            @ApiResponse(responseCode = "400",
                    description = "unable to find a task with the given task ID; body is empty",
                    content = @Content)
    })
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "taskId") UUID taskId) {
        ResponseEntity result = null;
        Optional<Task> found = this.boundary.getTaskById(taskId);
        if (found.isPresent()) {
            result = ResponseEntity.ok(found.get());
        } else {
            result = ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping
    @Operation(summary = "returns all tasks")
    @ApiResponse(responseCode = "200",
            description = "body contains all available tasks",
            content = @Content(schema = @Schema(implementation = Task.class)))
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.boundary.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    @Operation(summary = "creates a new task based on the given task data and returns its location URI")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "task could be created successfully; header location contains URI of newly created task; body is empty",
                    content = @Content,
                    headers = {@Header(name = "Location", description = "URI of newly created task")}
            ),
            @ApiResponse(responseCode = "400",
                    description = "failed to create new task due to invalid task data",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "failed to create new task due to internal error",
                    content = @Content)
    })
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        UUID taskId = this.boundary.addTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}").buildAndExpand(taskId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{taskId}")
    @Operation(summary = "updates the given task")
    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    description = "task could be updated successfully; body is empty",
                    content = @Content
            ),
            @ApiResponse(responseCode = "400",
                    description = "failed to update task due to invalid task data",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "failed to create new task due to internal error",
                    content = @Content)
    })
    public ResponseEntity<Task> updateTask(@PathVariable(name = "taskId") UUID taskId, @RequestBody Task task) {
        this.boundary.modifyTask(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{taskId}")
    @Operation(summary = "deletes the given task")
    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    description = "task could be deleted successfully; body is empty",
                    content = @Content
            ),
            @ApiResponse(responseCode = "500",
                    description = "failed to delete task due to internal error",
                    content = @Content)
    })
    public ResponseEntity<Task> deleteTask(@PathVariable(name = "taskId") UUID taskId) {
        this.boundary.removeTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
