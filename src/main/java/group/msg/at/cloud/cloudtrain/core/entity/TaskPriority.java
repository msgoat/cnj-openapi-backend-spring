package group.msg.at.cloud.cloudtrain.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeration representing the priority of a {@link Task}.
 *
 * @author Michael Theis (mtheis@msg.group)
 * @version 1.0
 * @since release 1.0 31.10.2012 13:13:19
 */
@Schema(description = "represents the priority of a Task", enumAsRef = true)
public enum TaskPriority {

    UNDEFINED,
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}
