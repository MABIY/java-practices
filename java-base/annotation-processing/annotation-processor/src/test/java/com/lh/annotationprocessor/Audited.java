package com.lh.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.annotation.Views;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.Instant;

@MappedSuperclass
@Data
public abstract class Audited {

    @JsonView({Views.Value.class})
    protected Long createdBy;

    protected Instant createdDate;

    protected Long lastModifiedBy;

    protected Instant lastModifiedDate;
}
