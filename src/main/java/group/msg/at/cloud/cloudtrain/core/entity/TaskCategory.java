package group.msg.at.cloud.cloudtrain.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeration representing the various categories of a {@link Task}.
 *
 * @author Michael Theis (mtheis@msg.group)
 * @version 1.0
 * @since release 1.0 31.10.2012 13:17:48
 */
@Schema(description = "represents the various categories of a Task", enumAsRef = true)
public enum TaskCategory {

    UNDEFINED,
    BUGFIX,
    REFACTORING,
    NEW_FEATURE,
    PERFORMANCE_IMPROVEMENT,
    RELEASE_MANAGEMENT,
    QUALITY_ASSURANCE,
    BUILD_FAILURE,
    COMMUNICATION
}
